package com.example.comercio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.comercio.fragments.ConfiguracaoFragment
import com.example.comercio.fragments.InicioFragment
import com.example.comercio.fragments.SobreFragment
import kotlinx.android.synthetic.main.activity_principal.*


class Principal : AppCompatActivity() {

    private val inicioFragment = InicioFragment()
    private val configuracaoFragment = ConfiguracaoFragment()
    private val sobreFragment = SobreFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        trocarFragments(inicioFragment)
        bottom_navigation.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.ic_inicio -> trocarFragments(inicioFragment)
                R.id.ic_configuracao -> trocarFragments(configuracaoFragment)
                R.id.ic_informacao -> trocarFragments(sobreFragment)
            }
        }
    }

    private fun trocarFragments(fragment: Fragment){
        if(fragment != null){
            val transacao = supportFragmentManager.beginTransaction()
            transacao.replace(R.id.fragment_container,fragment)
            transacao.commit()


        }

    }
}