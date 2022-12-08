package com.globe.gapps.parking

import android.annotation.SuppressLint
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.globe.textviewgetapi.CourseDataModalMain
import com.globe.textviewgetapi.OnItemClickListener
import com.globe.textviewgetapi.R

class ParkingSlotAdapter() : RecyclerView.Adapter<ParkingSlotAdapter.ViewHolder>() {
    private var selectedItemPosition: Int = 0

    var slots:ArrayList<CourseDataModalMain> = ArrayList()
        set(value){
            field = value
            notifyDataSetChanged()
        }
    var onItemClickListener: OnItemClickListener? = null
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_parking_slot, parent, false)
        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {

        val slotsViewModel = slots[position]
        holder.textView.text =  slotsViewModel.parkingArea
        holder.cardholder.setOnClickListener{
                onItemClickListener?.onItemClicked(holder.adapterPosition)
                selectedItemPosition = position
                notifyDataSetChanged()

            }
            if(selectedItemPosition == position){
                holder.cardholder.setBackgroundResource(R.drawable.round_corner_blue)
                holder.textView.setTextColor(Color.parseColor("#FFFFFF"))

            }
            else{
                holder.cardholder.setBackgroundResource(R.drawable.round_corner_white)
                holder.textView.setTextColor(Color.parseColor("#0064D8"))
            }

    }



    // return the number of the items in the list
    override fun getItemCount(): Int {
        return slots.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView: TextView = itemView.findViewById(R.id.tvShowSlot)
        val cardholder: FrameLayout = itemView.findViewById(R.id.frame)
    }


}


