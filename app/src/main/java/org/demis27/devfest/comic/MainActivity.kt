package org.demis27.devfest.comic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_main.*
import org.demis27.devfest.comic.adapter.ComicBookAdapter
import org.demis27.devfest.comic.model.ComicBook
import org.demis27.devfest.comic.model.ComicBookDAO
import org.demis27.devfest.comic.model.Person
import android.widget.ViewFlipper


class MainActivity : AppCompatActivity() {

    var currentComicBookPosition: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val comicBookDAO = ComicBookDAO()
        addElements(comicBookDAO)

        this.list.adapter = ComicBookAdapter(data = comicBookDAO, context = this)
        
        val viewFlipper = findViewById(R.id.flip) as ViewFlipper
        this.list.onItemClickListener = AdapterView.OnItemClickListener { parent, _, position, id ->
            val item = parent.getItemAtPosition(position) as ComicBook
            comic_title.setText(item.title)
            comic_issue.setText("" + item.number)
            writer_firstname.setText(item.writer?.firstName)
            writer_lastname.setText(item.writer?.lastName)
            artist_firstname.setText(item.artist?.firstName)
            artist_lastname.setText(item.artist?.lastName)

            this.currentComicBookPosition = position

            viewFlipper.displayedChild = 1

        }

        new_button.setOnClickListener {
            this.currentComicBookPosition = -1
            viewFlipper.displayedChild = 1
        }

        save_button.setOnClickListener {
            if (this.currentComicBookPosition == -1) {
                val comicBook = ComicBook()
                comicBook.title = comic_title.text.toString()
                comicBook.number = comic_issue.inputType
                val writer = Person(writer_firstname.text.toString(), writer_lastname.text.toString())
                val artist = Person(artist_firstname.text.toString(), artist_lastname.text.toString())
                comicBook.writer = writer;
                comicBook.artist = artist;
                comicBookDAO.create(comicBook)
            } else {
                val comicBook = comicBookDAO.get(this.currentComicBookPosition)
                comicBook.title = comic_title.text.toString()
                comicBook.number = comic_issue.text.toString().toInt()
                comicBook.writer?.firstName = writer_firstname.text.toString()
                comicBook.writer?.lastName = writer_lastname.text.toString()
                comicBook.artist?.firstName = artist_firstname.text.toString()
                comicBook.artist?.lastName = artist_lastname.text.toString()
                comicBookDAO.update(comicBook)
                this.list.invalidateViews()
//                this.list.adapter.
            }
            this.currentComicBookPosition = -1
            viewFlipper.displayedChild = 0
        }

        cancel_button.setOnClickListener {
            this.currentComicBookPosition = -1
            viewFlipper.displayedChild = 0
        }

        delete_button.setOnClickListener {
            comicBookDAO.delete(comicBookDAO.get(this.currentComicBookPosition))
            this.currentComicBookPosition = -1
            viewFlipper.displayedChild = 0
        }

        quit_button.setOnClickListener {
            this.finish();
        }
    }

    fun addElements(repository: ComicBookDAO) {
        val comicBook = ComicBook()
        comicBook.title = "Uncanny X-Men"
        comicBook.number = 1
        val comicBook2 = ComicBook()
        comicBook2.title = "Uncanny X-Men"
        comicBook2.number = 2
        val comicBook7 = ComicBook()
        comicBook7.title = "Uncanny X-Men"
        comicBook7.number = 7
        repository.create(comicBook)
        repository.create(comicBook2)
        repository.create(comicBook7)
        println(comicBook.id)
        println(comicBook7.id)

        val writer = Person("Stan", "Lee")
        comicBook.writer = writer
        comicBook2.writer = writer
        comicBook7.writer = writer
        val artist = Person("Jack", "Kirby")
        comicBook.artist = artist
        comicBook2.artist = artist
    }
}
