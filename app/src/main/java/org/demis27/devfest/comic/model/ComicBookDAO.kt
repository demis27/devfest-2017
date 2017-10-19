package org.demis27.devfest.comic.model

class ComicBookDAO: ComicBookDAOInterface {

    var comics: MutableList<ComicBook> = mutableListOf()

    var sequence: Int = 0;

    override fun create(comicBook: ComicBook): ComicBook {
        comicBook.id = sequence++
        comics.add(comicBook)
        return comicBook
    }

    override fun getElementAt(position: Int): ComicBook? {
        return comics[position]
    }

    override operator fun get(id: Int): ComicBook? {
        for (comic: ComicBook in comics) {
            if (comic.id.equals(id)) {
                return comic
            }
        }
        return null
    }

    override fun getAll(): Collection<ComicBook> {
        return comics
    }

    override fun delete(comicBook: ComicBook) {
        comics.remove(comicBook)
    }

    override fun update(comicBook: ComicBook): ComicBook {
        return comicBook
    }

    override fun count(): Int {
        return comics.size
    }
}