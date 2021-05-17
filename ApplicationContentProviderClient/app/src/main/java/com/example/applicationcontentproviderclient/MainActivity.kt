package com.example.applicationcontentproviderclient

import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var notesRecycler: RecyclerView
    lateinit var noteRefreshButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noteRefreshButton = findViewById(R.id.client_buttom_refresh)
        notesRecycler = findViewById(R.id.client_list)

        getContentProvider()
        notesRecycler.setOnClickListener{
            getContentProvider()
        }
    }

    private fun getContentProvider(){
        try{
            val url = "content://com.example.applicationTentProvider.provider/notes"
            val data = Uri.parse(url)
            val cursor:Cursor? = contentResolver.query(data, null, null, null, "title")
            notesRecycler.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = ClientAdapter(cursor as Cursor)
            }
        } catch (ex: Exception){
            ex.printStackTrace()
        }
    }
}