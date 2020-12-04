package com.alfred0ga.moviedbapp.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.alfred0ga.moviedbapp.data.remote.responses.Movie

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    val diffCallback = object: DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            TODO("Not yet implemented")
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            TODO("Not yet implemented")
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) { }
}