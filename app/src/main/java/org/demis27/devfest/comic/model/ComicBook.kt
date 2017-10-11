package org.demis27.devfest.comic.model

class ComicBook {

    var id: Int = -1

    var writer: Person? = null

    var artist: Person? = null

    var title: String? = null

    var number: Int? = null

    override fun toString(): String {
        return "ComicBook(title='$title', number=$number, writer=$writer, artist=$artist)"
    }

}