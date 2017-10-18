package org.demis27.devfest.comic

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.row_item.view.*
import org.demis27.devfest.comic.model.ComicBook
import org.demis27.devfest.comic.model.ComicBookDAO

class ComicBookAdapter(var data: ComicBookDAO, context: Context) : BaseAdapter() {

    val mInflater: LayoutInflater
    init {
        mInflater = LayoutInflater.from(context);
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View?
        val vh: ListRowHolder
        view = mInflater.inflate(R.layout.row_item, parent, false)
        vh = ListRowHolder(view)
        view?.tag = vh
        vh.title.text = data.getElementAt(position)?.title
        vh.issue.text = data.getElementAt(position)?.number.toString()

        return view
    }

    override fun getItem(p0: Int): ComicBook {
        return data.getElementAt(p0) as ComicBook
    }

    override fun getItemId(p0: Int): Long {
        return data.getElementAt(p0)!!.id.toLong()
    }

    override fun getCount(): Int {
        return data.count()
    }

}

class ListRowHolder(row: View?) {
    val title: TextView
    val issue: TextView

    init {
        this.title = (row as LinearLayout)?.title as TextView
        this.issue = (row as LinearLayout)?.issue as TextView
    }

}
