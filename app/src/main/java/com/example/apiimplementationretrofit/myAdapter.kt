package com.example.apiimplementationretrofit

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso


class myAdapter(val context : Activity, val productArrayList: List<Product>):
    RecyclerView.Adapter<myAdapter.myViewholder>(){








    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewholder {
         val itemView=LayoutInflater.from(context).inflate(R.layout.eachrow,parent,false)
        return myViewholder(itemView)
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    override fun onBindViewHolder(holder: myViewholder, position: Int) {
        val currentItem = productArrayList[position]
        holder.title.text = currentItem.title
        holder.rating.text= currentItem.rating.toString()
        // image view , how to show image in image view if the image is in form of url, 3rd Party Library
        // Picasso
        Picasso.get().load(currentItem.thumbnail).into(holder.image);

    }


    class myViewholder(itemView:View):RecyclerView.ViewHolder(itemView){


        var title : TextView
        var image : ShapeableImageView
        var rating: TextView


        init {
            title=itemView.findViewById(R.id.productTitle)
            image=itemView.findViewById(R.id.productImage)
            rating=itemView.findViewById(R.id.ratings)
        }
    }


}