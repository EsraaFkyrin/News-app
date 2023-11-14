package com.example.new_app.ui.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.new_app.R
import com.example.new_app.databinding.FragmentCategoryBinding


class CategoryFragment : Fragment() {

    lateinit var viewBinding: FragmentCategoryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = FragmentCategoryBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var adapter = CategoryAdapter(CategoryDataClass.getCategoryList())
        viewBinding.categoryRecycler.adapter = adapter
        adapter.onItemClickListener = object : CategoryAdapter.OnItemClickListener {
            override fun onItemCkick(pos: Int, item: CategoryDataClass) {
                onCategoryClickListener?.onCategoryClick(item)

            }

        }
    }
    var onCategoryClickListener:OnCategoryClickListener ?=null
    interface OnCategoryClickListener
    {
        fun onCategoryClick(category: CategoryDataClass)
    }


}