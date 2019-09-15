package com.example.daftarhewanpunah

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.detail_activity.*
import android.content.Intent



class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val animal = intent.getParcelableExtra<Animal>(EXTRA_ANIMAL)
        name_animal.text = animal.name
        description_animal.text = animal.description
        Glide.with(this)
            .load(animal.photo)
            .into(photo_animal)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    companion object {
        const val EXTRA_ANIMAL ="extra animal"
    }
}