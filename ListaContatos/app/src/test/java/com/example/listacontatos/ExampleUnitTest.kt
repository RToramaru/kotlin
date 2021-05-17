package com.example.listacontatos

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
class ExampleUnitTest {
    private val context = ApplicationProvider.getApplicationContext<Context>()
    private val sharedPreferences = context.getSharedPreferences("com.example.listacontatos." +
            "PREFERENCES", Context.MODE_PRIVATE)
    private val contactHelper = ContactHelper(sharedPreferences)
    @Test
    fun addition_isCorrect() {
        // Prepara
        mockListaDoisContatos()

        //Valida
        val list = contactHelper.getListaContato()
        assertEquals(2, list.size)

    }
    private fun mockListaDoisContatos(){
        contactHelper.setListaContato(
            arrayListOf(
                Contato(
                    "Nome 1",
                    "Telefone 1"
                ),
                Contato(
                    "Nome 2",
                    "Telefone 2"
                )
            )
        )
    }
}