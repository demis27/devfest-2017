package org.demis27.devfest.comic

import android.os.Bundle
import android.support.v7.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    var currentComicBookPosition: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
