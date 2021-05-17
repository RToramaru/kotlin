package com.example.listacontatos

interface TypeToken<T> {
    abstract val type: Any

    fun clickItemContact(contact: Contato)
}
