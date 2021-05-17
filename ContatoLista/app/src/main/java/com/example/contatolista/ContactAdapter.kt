package com.example.contatolista

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.contact_item.view.*

class ContactAdapter(var listener: ClickItemContactListener):
    RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>(){

    private val list: MutableList<Contact> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactAdapterViewHolder(view,list,listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun updateList(list:List<Contact>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class ContactAdapterViewHolder(itemView: View, var list:List<Contact>, var listener: ClickItemContactListener) :
        RecyclerView.ViewHolder(itemView){
        private val tvName:TextView = itemView.tv_name
        private val tvPhone:TextView = itemView.tv_phone
        private val ivPhotograph:ImageView = itemView.iv_photograph

        init {
            itemView.setOnClickListener{
                listener.clickIntemContact(list[adapterPosition])
            }
        }
        fun bind(contact:Contact){
            tvName.text = contact.nome
            tvPhone.text = contact.telefone
        }
    }
}