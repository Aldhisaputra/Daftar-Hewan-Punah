package com.example.daftarhewanpunah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvAnimal: RecyclerView
    private var list: ArrayList<Animal> = arrayListOf()
    private var title: String = "Mode List"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        rvAnimal=findViewById(R.id.rv_animal)
        rvAnimal.setHasFixedSize(true)


        list.addAll(AnimalData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList(){
        rvAnimal.layoutManager=LinearLayoutManager(this)
        val listAnimalAdapter=ListAnimalAdapter(this,list)
        rvAnimal.adapter=listAnimalAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_profile -> {
                val profileIntent = Intent(this, ProfileActivity::class.java)
                startActivity(profileIntent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
