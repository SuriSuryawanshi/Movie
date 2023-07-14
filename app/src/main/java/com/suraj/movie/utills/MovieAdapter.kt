package com.suraj.movie.utills

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.suraj.movie.R
import com.suraj.movie.models.Movies

class MovieAdapter(val context: Context) : RecyclerView.Adapter<MovieAdapter.viewholder>() {

    private val allUsers = ArrayList<Movies>()

    inner class viewholder(itemview : View) : RecyclerView.ViewHolder(itemview) {
        val nameTV = itemView.findViewById<TextView>(R.id.MovieName)
        val descriptionTV = itemView.findViewById<TextView>(R.id.description)
        val profileIV = itemView.findViewById<ImageView>(R.id.movieImage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.movie_list_item,
            parent, false
        )
        return viewholder(itemView)
    }

    override fun getItemCount(): Int {
        return allUsers.size
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.nameTV.text = allUsers.get(position).original_title
        holder.descriptionTV.text = allUsers.get(position).overview
        Picasso.get()
            .load("https://image.tmdb.org/t/p/w500"+allUsers.get(position).poster_path)
            .placeholder(R.drawable.noimageplaceholder)
            .tag(context)
            .into(holder.profileIV)

    }

    fun updateList(newList: List<Movies>) {
        allUsers.clear()
        allUsers.addAll(newList)
        notifyDataSetChanged()
    }

}