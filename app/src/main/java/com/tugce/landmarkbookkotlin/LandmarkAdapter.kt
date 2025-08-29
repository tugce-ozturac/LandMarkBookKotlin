package com.tugce.landmarkbookkotlin

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tugce.landmarkbookkotlin.databinding.RecyclerRowBinding

class LandmarkAdapter(val LandmarkList : ArrayList<Landmark>) : RecyclerView.Adapter<LandmarkAdapter.LandmarHolder>() {
    class LandmarHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LandmarHolder {
       val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LandmarHolder(binding)
    }

    override fun onBindViewHolder(
        holder: LandmarHolder,
        position: Int
    ) {
        holder.binding.recyclerViewTextView.text= LandmarkList[position].name

        holder.itemView.setOnClickListener { 
            val intent = Intent(holder.itemView.context, DetailsActivity::class.java)
            intent.putExtra("landmark",LandmarkList[position])
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return LandmarkList.size
    }
}