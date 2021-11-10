package com.albertymacedo.MyFirstApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.albertymacedo.MyFirstApp.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val arrayList = listOf("Sim", "Talvez", "Não conte com isso!")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

       /* binding.bvResponder.setOnClickListener {
            Toast.makeText(
                this,
                "texto",
                Toast.LENGTH_LONG
            ).show()
        }*/


        binding.bvResponder.setOnClickListener {
            val animation = AnimationUtils.loadAnimation(this, R.anim.button_anim)
            binding.bvResponder.startAnimation(animation)

            val index = Random().nextInt(3)
            Log.i("Teste", "O index é ${index}")
            binding.txtResponse.text = arrayList[index]
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.sobre -> {
                Log.i("Teste", "Sobre Clicado")
                Toast.makeText(
                    this,
                    "App sendo Hackeado",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}