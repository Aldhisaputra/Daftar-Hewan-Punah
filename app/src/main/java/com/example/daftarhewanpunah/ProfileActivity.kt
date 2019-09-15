package com.example.daftarhewanpunah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        Glide.with(this)
            .load("https://media.licdn.com/dms/image/C5103AQHitXW6X-iW6w/profile-displayphoto-shrink_200_200/0?e=1573689600&v=beta&t=A6pxKxTd5tC3PhDazZ09LV7MYAngLBpULq4TR8ltQm4")
            .into(img_item_photo)
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
}
