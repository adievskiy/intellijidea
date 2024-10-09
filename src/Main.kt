data class Employee(val name: String, val age: Int, val salary: Double)

fun main() {
    val employees = listOf(
        Employee("Иван", 30, 60000.0),
        Employee("Сергей", 24, 50000.0),
        Employee("Петр", 29, 70000.0),
        Employee("Алексей", 35, 40000.0),
        Employee("Василий", 28, 80000.0)
    )

    val sortedByName = employees.sortedBy { it.name }
    println("Сотрудники, отсортированные по имени:")
    sortedByName.forEach { println(it) }

    val sortedByAge = employees.sortedBy { it.age }
    println("\nСотрудники, отсортированные по возрасту:")
    sortedByAge.forEach { println(it) }

    val sortedBySalary = employees.sortedBy { it.salary }
    println("\nСотрудники, отсортированные по зарплате:")
    sortedBySalary.forEach { println(it) }

    val matrix = arrayOf(
        intArrayOf(4, 2, 1, 3),
        intArrayOf(8, 7, 6, 5),
        intArrayOf(12, 11, 10, 9)
    )

    for (i in matrix.indices) {
        matrix[i].sort()
    }

    println("Отсортированные строки матрицы:")
    for (row in matrix) {
        println(row.joinToString(" "))
    }

    val matrixTwo = arrayOf(
        intArrayOf(1, 3, 2, 4),
        intArrayOf(5, 10, 15, 20),
        intArrayOf(7, 6, 8, 5)
    )
    var count = 0
    val zigzagRows = mutableListOf<IntArray>()

    for (row in matrixTwo) {
        if (isZigzag(row)) {
            count++
            zigzagRows.add(row)
        }
    }

    println("Количество пилообразных массивов: $count")
    if (count > 0) {
        println("Пилообразные массивы:")
        for (zigzagRow in zigzagRows) {
            println(zigzagRow.joinToString(" "))
        }
    } else {
        println("Пилообразных массивов не найдено.")
    }
}

fun isZigzag(array: IntArray): Boolean {
    for (i in 1 until array.size - 1) {
        if (!((array[i] > array[i - 1] && array[i] > array[i + 1]) ||
                    (array[i] < array[i - 1] && array[i] < array[i + 1]))) {
            return false
        }
    }
    return true
}