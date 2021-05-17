package com.example.listacontatos

import android.content.SharedPreferences
import android.provider.ContactsContract

class ContactHelper(private val sharedPreferences:SharedPreferences){
    fun getListaContato():List<Contato>{
        val list = sharedPreferences.getString("contacts","[]")
        val turasType = object : TypeToken<List<Contato>> {}.type
    }

    fun setListaContato(list: List<Contato>){

    }
}