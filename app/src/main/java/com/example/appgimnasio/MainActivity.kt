package com.example.appgimnasio

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appgimnasio.Fragmentos.FragmentGestion
import com.example.appgimnasio.Fragmentos.FragmentCuenta
import com.example.appgimnasio.Fragmentos.FragmentInicio
import com.example.appgimnasio.Fragmentos.FragmentMiembros
import com.example.appgimnasio.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        comprobarSesion()

        binding.BottomNV.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.Item_Miembros->{
                    verFragmentMiembros()
                    true
                }
                R.id.Item_Gestion->{
                    verFragmentGestion()
                    true
                }
                R.id.Item_Inicio->{
                    verFragmentInicio()
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
        binding.BottomNV.selectedItemId = R.id.Item_Inicio
    }


    private fun comprobarSesion(){
        if (firebaseAuth.currentUser == null){
            startActivity(Intent(this, OpcionesLogin::class.java))
            finishAffinity()
        }
    }
    private fun verFragmentInicio(){
        binding.TituloRL.text = getString(R.string.Item_Inicio)
        val fragment = FragmentInicio()
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(binding.FragmentL1.id, fragment, "FragmentInicio")
        fragmentTransition.commit()
    }
    private fun verFragmentMiembros(){
        binding.TituloRL.text = getString(R.string.Item_Miembros)
        val fragment = FragmentMiembros()
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(binding.FragmentL1.id, fragment, "FragmentMiembros")
        fragmentTransition.commit()
    }
    private fun verFragmentGestion(){
        binding.TituloRL.text = getString(R.string.Item_Gestion)
        val fragment = FragmentGestion()
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(binding.FragmentL1.id, fragment, "FragmentGestion")
        fragmentTransition.commit()
    }
    private fun verFragmentCuenta(){
        binding.TituloRL.text = getString(R.string.Item_Cuenta)
        val fragment = FragmentCuenta()
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(binding.FragmentL1.id, fragment, "FragmentCuenta")
        fragmentTransition.commit()
    }
}
