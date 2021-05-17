package com.example.contatolista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.TaskStackBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.contact_item.*

class ContactDetail : AppCompatActivity() {

    private var contact:Contact? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)

        initToolbar()
        getExtras()
        bindViews()
    }

    companion object{
        const val EXTRA_CONTACT: String = "EXTRA_CONTACT"
    }

    private fun getExtras(){
        contact = intent.getParcelableExtra(EXTRA_CONTACT)
    }

    private fun bindViews(){
        tv_name.text = contact?.nome
        tv_phone.text = contact?.telefone
    }

    private fun initToolbar(){
        val toobar1 = toolbar
        setSupportActionBar(toobar1)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}