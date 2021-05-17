package com.example.contatolista

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.edit
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contatolista.ContactDetail.Companion.EXTRA_CONTACT
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.drawer_menu.*

class MainActivity : AppCompatActivity(), ClickItemContactListener{

    private val rvList : RecyclerView by lazy {
        rv_list
    }

    private val adapter = ContactAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_menu)

        initDrawer()
        fetchListContact()
        bindViews()
    }

    private fun fetchListContact(){
        val list = arrayListOf(
            Contact(
                "nome 1",
                "Telefone 1",
                "Img 1"
            ),
            Contact(
                "nome 1",
                "Telefone 1",
                "Img 1"
            )
        )

        getInstanceSharedPreferences().edit {
            putString("contacts", Gson().toJson(list))
        }
    }

    private fun getInstanceSharedPreferences(): SharedPreferences{
        return getSharedPreferences("com.example.contatolista.PREFERENCES", Context.MODE_PRIVATE )
    }

    private fun initDrawer(){
        val drawerLayout = drawer_layout as DrawerLayout
        val toobar1 = toolbar
        setSupportActionBar(toobar1)
        val toggle = ActionBarDrawerToggle(this, drawerLayout, toobar1,R.string.open_drawer,R.string.close_drawer)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }


    private fun bindViews(){
        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
        updateList()
    }


    private fun getListContacts(): List<Contact>{
        val list = getInstanceSharedPreferences().getString("contacts", "[]")
        val turnsType = object: TypeToken<List<Contact>>(){}.type
        return Gson().fromJson(list, turnsType)
    }


    private fun updateList(){
        adapter.updateList(getListContacts())
    }

    private fun showToast(mensagem:String){
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu:Menu?):Boolean{
        val inflater:MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.item_menu_1 -> {
                showToast("Exbindo item de menu 1")
                return true
            }
            R.id.item_menu_2 -> {
                showToast("Exibindo item de menu 2")
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    override fun clickIntemContact(contact: Contact) {
        val intent = Intent(this, ContactDetail::class.java)
        intent.putExtra(EXTRA_CONTACT, contact)
        startActivity(intent)
    }


}