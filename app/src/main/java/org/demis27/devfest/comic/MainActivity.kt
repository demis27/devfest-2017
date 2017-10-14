package org.demis27.devfest.comic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.AdapterView
import android.widget.ViewFlipper
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
            cleanForm()
        }

        save_button.setOnClickListener {
            if (this.currentComicBookPosition == -1) {
                val writer = Person(writer_firstname.text.toString(), writer_lastname.text.toString())
                val artist = Person(artist_firstname.text.toString(), artist_lastname.text.toString())
                val comicBook = ComicBook(comic_title.text.toString(), comic_issue.text.toString().toInt(), writer, artist)
                comicBookDAO.create(comicBook)
            } else {
                val comicBook = comicBookDAO.getElementAt(this.currentComicBookPosition)
                comicBook?.title = comic_title.text.toString()
                comicBook?.number = comic_issue.text.toString().toInt()
                comicBook?.writer?.firstName = writer_firstname.text.toString()
                comicBook?.writer?.lastName = writer_lastname.text.toString()
                comicBook?.artist?.firstName = artist_firstname.text.toString()
                comicBook?.artist?.lastName = artist_lastname.text.toString()
                if (comicBook != null) {
                    comicBookDAO.update(comicBook)
                }
                this.list.invalidateViews()
            }
            this.currentComicBookPosition = -1
            viewFlipper.displayedChild = 0
        }

        cancel_button.setOnClickListener {
            this.currentComicBookPosition = -1
            viewFlipper.displayedChild = 0
        }

        delete_button.setOnClickListener {
            comicBookDAO.delete(comicBookDAO.getElementAt(this.currentComicBookPosition)!!)
            this.currentComicBookPosition = -1
            viewFlipper.displayedChild = 0
            this.list.invalidateViews()
        }

        quit_button.setOnClickListener {
            this.finish();
        }
    }

    private fun cleanForm() {
        comic_title.setText("")
        comic_issue.setText("")
        writer_firstname.setText("")
        writer_lastname.setText("")
        artist_firstname.setText("")
        artist_lastname.setText("")
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
