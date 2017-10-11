package org.demis27.devfest.comic.model


interface PersonDAOInterface {

    fun create(person: Person): Person

    fun get(id: Int): Person

    fun getAll(): Collection<Person>

    fun delete(person: Person)

    fun update(person: Person): Person

}