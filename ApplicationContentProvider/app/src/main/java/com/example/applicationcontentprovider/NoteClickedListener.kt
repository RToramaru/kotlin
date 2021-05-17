package com.example.applicationcontentprovider

import android.database.Cursor

interface NoteClickedListener {
    fun noteClickdItem(cursor: Cursor)
    fun noteRemoveItem(cursor: Cursor?)
}