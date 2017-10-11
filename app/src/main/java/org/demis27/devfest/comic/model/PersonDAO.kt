package org.demis27.devfest.comic.model

class PersonDAO: PersonDAOInterface {

    var persons: MutableMap<Int, Person> = HashMap()

    var count: Int = 0

    override fun create(person: Person): Person {
        person.id = count++
        persons.put(person.id, person)
        return person
    }

    override fun get(id: Int): Person {
        return persons.get(id) as Person
    }

    override fun getAll(): Collection<Person> {
        return persons.values
    }

    override fun delete(person: Person) {
        persons.remove(person.id)
    }

    override fun update(person: Person): Person {
        return person
    }
    
}