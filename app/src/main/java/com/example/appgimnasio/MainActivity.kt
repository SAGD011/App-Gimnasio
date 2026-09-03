package com.example.appgimnasio

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appgimnasio.Fragmentos.FragmentChats
import com.example.appgimnasio.Fragmentos.FragmentCuenta
import com.example.appgimnasio.Fragmentos.FragmentInicio
import com.example.appgimnasio.Fragmentos.FragmentMisAnuncios
import com.example.appgimnasio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        verFragmentInicio()

        binding.BottomNV.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.Item_Inicio->{
                    verFragmentInicio()
                    true
                }
                R.id.Item_Chats->{
                    verFragmentChats()
                    true
                }
                R.id.Item_Mis_Anuncios->{
                    verFragmentMisAnuncios()
                    true
                }
                R.id.Item_Cuenta->{
                    verFragmentCuenta()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun verFragmentInicio(){
    binding.TituloRL.text="Inicio"
        val fragment = FragmentInicio()
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(binding.FragmentL1.id, fragment, "FragmentInicio")
    }
    private fun verFragmentChats(){
        binding.TituloRL.text="Chats"
        val fragment = FragmentChats()
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(binding.FragmentL1.id, fragment, "FragmentChats")
    }
    private fun verFragmentMisAnuncios(){
        binding.TituloRL.text="Mis anuncios"
        val fragment = FragmentMisAnuncios()
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(binding.FragmentL1.id, fragment, "FragmentMisAnuncios")
    }
    private fun verFragmentCuenta(){
        binding.TituloRL.text="Cuenta"
        val fragment = FragmentCuenta()
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(binding.FragmentL1.id, fragment, "FragmentCuenta")
    }
}
