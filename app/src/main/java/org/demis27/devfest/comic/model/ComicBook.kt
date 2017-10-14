package org.demis27.devfest.comic.model

class ComicBook (var title: String, var number: Int, var writer: Person, var artist: Person) {

    var id: Int = -1

    override fun toString(): String {
        return "ComicBook(title='$title', number=$number, writer=$writer, artist=$artist)"
    }

}