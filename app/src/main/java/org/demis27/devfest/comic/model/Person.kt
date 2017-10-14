package org.demis27.devfest.comic.model


class Person(var firstName: String, var lastName: String) {
    override fun toString(): String {
        return "Person(firstName='$firstName', lastName='$lastName')"
    }
}