@file:Suppress("DEPRECATION")

package com.example.threading

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_load_data.setOnClickListener {
            launchAsyncTask()
        }
    }

    fun showData(astros: List<AstrosPeople>?) {
        textview_data.text = ""
        astros?.forEach { people ->
            textview_data.append("${people.name} - ${people.craft} \n\n\n")
        }
    }

    fun showLoadingIndicator(){
        progressbar_load_indicator.visibility = View.VISIBLE
    }

    fun hideLoadingIndicator() {
        progressbar_load_indicator.visibility = View.GONE
    }

    fun launchAsyncTask() {
        AstrosTask().execute()
    }

    inner class AstrosTask() : AsyncTask<Void, Void, List<AstrosPeople>?>() {
        private val repository = AstrosRepository()

        override fun onPreExecute() {
            super.onPreExecute()
            showLoadingIndicator()
        }

        override fun doInBackground(vararg params: Void?): List<AstrosPeople>? {
            val result = repository.loadAstros()
            return result?.people
        }

        override fun onPostExecute(result: List<AstrosPeople>?) {
            super.onPostExecute(result)
            hideLoadingIndicator()
            showData(result)
        }
    }
}
