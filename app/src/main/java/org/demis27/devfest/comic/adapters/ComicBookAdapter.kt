package org.demis27.devfest.comic.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import org.demis27.devfest.comic.R
import org.demis27.devfest.comic.model.ComicBook
import org.demis27.devfest.comic.model.ComicBookDAO

class ComicBookAdapter(data: ComicBookDAO, context: Context) : BaseAdapter() {

    val mInflater: LayoutInflater
    var comicBookDAO = data

    init {
        mInflater = LayoutInflater.from(context);
    }

    override fun getCount(): Int {
        return comicBookDAO.count()
    }

    override fun getItem(position: Int): ComicBook {
        return comicBookDAO.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val view: View?
        val vh: ListRowHolder
        view = mInflater.inflate(R.layout.row_item, parent, false)
        vh = ListRowHolder(view)
        view?.tag = vh
        vh.title.text = comicBookDAO.get(id = position).title
        vh.issue.text = comicBookDAO.get(id = position).number.toString()



        return view
    }

    private class ListRowHolder(row: View?) {

        val title: TextView
        val issue: TextView

        init {
            this.title = row?.findViewById(R.id.title) as TextView
            this.issue = row?.findViewById(R.id.issue) as TextView
        }
    }


}