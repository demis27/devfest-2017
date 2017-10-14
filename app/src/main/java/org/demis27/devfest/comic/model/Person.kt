package org.demis27.devfest.comic.model


class Person(val firstName: String, val lastName: String) {
    override fun toString(): String {
        return "Person(firstName='$firstName', lastName='$lastName')"
    }
}