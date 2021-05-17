package com.example.contatos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class ContactsAdapter(val contacsList: ArrayList<Contact>):
    RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = contacsList.size

    override fun onBindViewHolder(holder: ContactsAdapter.ViewHolder, position: Int) =
        holder.bindItem(contacsList[position])


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindItem(contact:Contact){
            val textName = itemView.findViewById<TextView>(R.id.contact_name)
            val textPhone = itemView.findViewById<TextView>(R.id.contact_phone_number)

            textName.text = contact.name
            textPhone.text = contact.phoneNumber
        }

    }

}