package com.example.tv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tv.main.model.All
import com.example.tv.main.model.ModelMovie
import kotlinx.android.synthetic.main.img_card.*

class AdapterF(private val dataSet: List<ModelMovie>, val context : AppCompatActivity) : RecyclerView.Adapter<AdapterF.HolderOp>() {
    inner class HolderOp(itemView: View) : RecyclerView.ViewHolder(itemView){
        protected val img1 : ImageView = context.img_card_img

        fun bind(oiop : ModelMovie){
            Glide.with(context).load(oiop.images).into(img1) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderOp {
        val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.img_card, parent, false)

                return HolderOp(view)
    }

    override fun onBindViewHolder(holder: HolderOp, position: Int) {
        holder.bind(dataSet[position])

    }

    override fun getItemCount(): Int = dataSet.size
}