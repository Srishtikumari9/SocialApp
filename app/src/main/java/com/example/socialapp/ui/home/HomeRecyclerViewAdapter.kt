package com.example.socialapp.ui.home
import com.example.socialapp.models.Post
import androidx.recyclerview.widget.RecyclerView
import com.example.socialapp.ui.home.HomeRecyclerViewAdapter.PostViewHolder
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.example.socialapp.R
import android.widget.TextView

class HomeRecyclerViewAdapter(var posts: MutableList<Post>) :
    RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.name.text = posts[position].name
    }
    override fun getItemCount(): Int {
        return posts.size
    }
    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.tv1)
    }
    fun update(posts: List<Post>) {
        if (!posts.isEmpty()) {
            this.posts.clear()
        }
        this.posts.addAll(posts)
        notifyDataSetChanged()
    }
}