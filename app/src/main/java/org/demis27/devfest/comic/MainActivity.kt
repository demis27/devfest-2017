package org.demis27.devfest.comic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.demis27.devfest.comic.model.ComicBook
import org.demis27.devfest.comic.model.ComicBookDAO
import org.demis27.devfest.comic.model.Person


class MainActivity : AppCompatActivity() {

    var currentComicBookPosition: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val comicBookDAO = ComicBookDAO()
        addElements(comicBookDAO)

        this.list.adapter = ComicBookAdapter(data = comicBookDAO, context = this)


    }

    fun addElements(comicBookDAO: ComicBookDAO) {
        val writer = Person("Stan", "Lee")
        val artist = Person("Jack", "Kirby")
        val writer2 = Person("Len", "Wein")
        val artist2 = Person("Dave", "Cockrum")
        val comicBook = ComicBook("Uncanny X-Men", 1, writer, artist)
        val comicBook2 = ComicBook("Uncanny X-Men", 2, writer, artist)
        val comicBook94 = ComicBook("Uncanny X-Men", 94, writer2, artist2)

        comicBookDAO.create(comicBook)
        comicBookDAO.create(comicBook2)
        comicBookDAO.create(comicBook94)
    }


}
