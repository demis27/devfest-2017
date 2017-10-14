package org.demis27.devfest.comic.model

interface ComicBookDAOInterface {

    fun create(comicBook: ComicBook): ComicBook

    fun get(id: Int): ComicBook?

    fun getElementAt(id: Int): ComicBook?

    fun getAll(): Collection<ComicBook>

    fun delete(comicBook: ComicBook)

    fun update(comicBook: ComicBook): ComicBook

    fun count(): Int
}