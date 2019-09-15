package com.example.daftarhewanpunah

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListAnimalAdapter(val context: Context,val listAnimal:ArrayList<Animal>): RecyclerView.Adapter<ListAnimalAdapter.ListViewHolder>() {

   private lateinit var onItemClickCallback: OnItemClickcallback

    override fun onCreateViewHolder(viewGroup: ViewGroup, i : Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_animal,viewGroup,false)
        return ListViewHolder(view)

    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val animal = listAnimal[position]

        Glide.with(holder.itemView.context)
            .load(animal.photo)
            .apply(RequestOptions().override(55,55))
            .into(holder.imagePhoto)

        holder.tvName.text= animal.name
        holder.tvDescription.text=animal.description

        holder.itemView.setOnClickListener{onItemClickCallback.onItemClicked(listAnimal[holder.adapterPosition])}

        holder.itemView.setOnClickListener {
            val detailIntent = Intent(holder.itemView.context, DetailActivity::class.java)
            detailIntent.putExtra(DetailActivity.EXTRA_ANIMAL, listAnimal[position])
           context. startActivity(detailIntent)
        }



    }
    override fun getItemCount(): Int {
        return listAnimal.size

    }

    inner class ListViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var tvName: TextView =itemView.findViewById(R.id.tv_item_name)
        var tvDescription: TextView =itemView.findViewById(R.id.tv_item_description)
        var imagePhoto: ImageView =itemView.findViewById(R.id.img_item_photo)

    }

        interface OnItemClickcallback {
            fun onItemClicked(data:Animal)


        }

    }







