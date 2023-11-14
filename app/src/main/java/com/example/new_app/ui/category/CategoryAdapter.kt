package com.example.new_app.ui.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.new_app.databinding.CategoryItemRecyclerBinding

class CategoryAdapter(var item: List<CategoryDataClass>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {


    class ViewHolder(var viewBinding: CategoryItemRecyclerBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(categoryDataClass: CategoryDataClass?) {
            viewBinding.category = categoryDataClass
            viewBinding.invalidateAll()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var viewBinding = CategoryItemRecyclerBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //here >  but data on the view > (category -item-xml )
        // by the data class > item :List<CategoryDataClass>
        var items = item?.get(position)
        holder.bind(items)

        //it > if-- true >
        onItemClickListener?.let {
            holder.viewBinding.layoutItem.setOnClickListener(View.OnClickListener {
                onItemClickListener?.onItemCkick(position, item[position])
            })
        }


    }

    var onItemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemCkick(pos: Int, item: CategoryDataClass)

    }

    override fun getItemCount(): Int = item.size ?: 0


}