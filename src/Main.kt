import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

data class Person(val name: String, val salary: Double)

fun generatePassword(): Int {
    return Random.nextInt(100000, 999999)
}

fun main() = runBlocking {
    val manager = PersonManager()
    val resultList = mutableMapOf<Person, Int>()

    println("Программа работы с базой данных сотрудников")

    delay(1000L)
    println("Добавить сотрудника?\n1. Да\n2. Нет")
    var choise = readln()
    while (true) {
        when (choise) {
            "1" -> {
                println("Введите имя сотрудника:")
                val name = readln().trim()
                println("Введите зарплату сотрудника:")
                val salary = readln().toDoubleOrNull() ?: continue
                val person = Person(name, salary)
                manager.addPerson(person)
                println("Сотрудник добавлен: $person")

                delay(1000L)
                println("Добавить сотрудника?\n1. Да\n2. Прочитать базу данных")
                choise = readln()
                when (choise) {
                    "2" -> println(manager.getPersonList())
                }
            }
            "2" -> break
            else -> println("Неверный ввод")
        }
    }
    val job = launch { addPassword(resultList, manager.getPersonList()) }
    val cancelJob = launch {
        while (true) {
            if (readln().trim() == "0") {
                job.cancel()
                break
            }
        }
    }
    cancelJob.join()
}

suspend fun addPassword(resultList: MutableMap<Person, Int>, personList: List<Person>) {
    for (person in personList) {
        delay(500L)
        val password = generatePassword()
        resultList[person] = password
        println("Пароль для сотрудника ${person.name} добавлен: $password")
    }
    delay(1000L)
    readDataPersonList(resultList)
}

suspend fun readDataPersonList(resultList: Map<Person, Int>) {
    for (entry in resultList.entries) {
        delay(100L)
        println("Сотрудник: ${entry.key}; пароль: ${entry.value}")
    }
}