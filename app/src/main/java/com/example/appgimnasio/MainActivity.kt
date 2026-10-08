package com.example.appgimnasio

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appgimnasio.Fragmentos.FragmentProductos
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
                R.id.Item_Productos->{
                    verFragmentProductos()
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
        binding.BottomNV.selectedItemId = savedInstanceState?.getInt("seccion", R.id.Item_Inicio) ?: R.id.Item_Inicio
    }


    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("seccion", binding.BottomNV.selectedItemId)
        super.onSaveInstanceState(outState)
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
    private fun verFragmentProductos(){
        binding.TituloRL.text = getString(R.string.Item_Productos)
        if (supportFragmentManager.findFragmentById(binding.FragmentL1.id) is FragmentProductos) return
        val fragment = FragmentProductos()
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(binding.FragmentL1.id, fragment, "FragmentProductos")
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
