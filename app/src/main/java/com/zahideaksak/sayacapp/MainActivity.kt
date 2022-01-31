package com.zahideaksak.sayacapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.zahideaksak.sayacapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var  binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("MainActivity", "onCreate Çağırıldı")
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
        Log.i("MainActivity", "onStart Çağırıldı")
    }

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