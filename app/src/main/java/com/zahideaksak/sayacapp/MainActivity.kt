package com.zahideaksak.sayacapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.zahideaksak.sayacapp.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var  binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i( "onCreate Çağırıldı")
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val varsayilanDeger = 0

        binding.apply {
            textViewCounter.text = varsayilanDeger.toString()

            buttonCounter.setOnClickListener {
                val gelenDeger = textViewCounter.text.toString().toInt()
                textViewCounter.text = (gelenDeger + 1).toString()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Timber.i("onStart Çağırıldı")
    }

    override fun onRestart() {
        super.onRestart()
        Timber.i("onRestart Çağırıldı")
    }

    override fun onResume() {
        super.onResume()
        Timber.i("onResume Çağırıldı")
    }

    override fun onPause() {
        super.onPause()
        Timber.i("onPause Çağırıldı")
    }

    override fun onStop() {
        super.onStop()
        Timber.i("onStop Çağırıldı")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.i("onDestroy Çağırıldı")
    }
    //bir kere cagirilmali olunca onCreate, tamamen kapatilirken onDestroy
    //onCreate ve onDestroy lifecycle boyunca sadece bir kere calisiyor.
    //onCreate - ilk activity olusturuldugunda, onDestroy - activity kapatildiginda
    //onStart calistirildiginda activity gorunur oluyor, onStop calistirildiginda gorunurlugunu kaybediyor
    //onResume calistiginda activity odak noktasında, onPause calistiktan sonra odak noktasından cikiyor fakat arka tarafta hala gorunur durumda.

    private fun onShare() {
        val share = Intent.createChooser(Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, binding.textViewCounter.text.toString())
        }, null)
        startActivity(share)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.share_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_share -> onShare()
        }
        return super.onOptionsItemSelected(item)
    }
}