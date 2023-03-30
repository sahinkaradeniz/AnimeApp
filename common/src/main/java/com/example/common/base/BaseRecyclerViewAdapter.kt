package com.example.common.base
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter <T :Any , VH:BaseViewHolder<T>>:RecyclerView.Adapter<VH>(){

    private val items = mutableListOf<T>()

    fun submitList(newItems:List<T>) {
        items.apply {
            notifyItemRangeRemoved(0,itemCount)
            clear()
            addAll(newItems)
            notifyItemRangeInserted(0,items.count())
        }
    }
    fun getItem(position:Int)=items[position]

    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(items[position])
    }

    override fun getItemCount(): Int =items.size
}