class PersonManager {
    private val personList = mutableListOf<Person>()

    fun addPerson(person: Person) {
        personList.add(person)
    }

    fun getPersonList(): List<Person> {
        return personList
    }
}