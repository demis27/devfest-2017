package org.demis27.devfest.comic.model


class ComicBookDAO : ComicBookDAOInterface {

    var comics: MutableList<ComicBook> = mutableListOf()

    var count: Int = -1

    constructor()

    override fun create(comicBook: ComicBook): ComicBook {
        comicBook.id = this.count++
        this.comics.add(comicBook)
        return comicBook
    }

    override fun get(id: Int): ComicBook {
        return this.comics.get(id) as ComicBook
    }

    override fun getAll(): Collection<ComicBook> {
        return this.comics
    }

    override fun delete(comicBook: ComicBook) {
        this.comics.removeAt(comicBook.id)
    }

    override fun update(comicBook: ComicBook): ComicBook {
        return comicBook
    }

    override fun count(): Int {
        return this.comics.size
    }
}