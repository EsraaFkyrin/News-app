package com.example.new_app.ui.categoryDetils

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.new_app.R
import com.example.new_app.api.model.sourcesResponse.Source
import com.example.new_app.databinding.FragmentCategoryDetilsBinding
import com.example.new_app.ui.category.CategoryDataClass
import com.example.new_app.ui.news.NewsFragment
import com.google.android.material.tabs.TabLayout


class CategoryDetailsFragment : Fragment() {
    lateinit var viewBinding: FragmentCategoryDetilsBinding
    lateinit var viewModel: CategoryDetailsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[CategoryDetailsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentCategoryDetilsBinding.inflate(inflater, container, false)

        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //load api
        viewModel.loadApi(category.id)
        subscribeToLiveData()
    }

    fun subscribeToLiveData() {
        viewModel.sourceLiveData.observe(viewLifecycleOwner) {
            bindSourcesInTabLayout(it)
        }
        viewModel.showLoading.observe(viewLifecycleOwner) { show ->
            if (show) {
                showLoading()
            } else {
                hideLoading()
            }

        }
        viewModel.showErrorLayout.observe(viewLifecycleOwner) {
            showErrorLayout(it)
        }
        viewModel.showTabLayout.observe(viewLifecycleOwner) {
            if (it)
                showTabLayout()
        }
    }

    //show data on the frame layout >> another fragment
    fun changeFragment(source: Source) {
        childFragmentManager
            .beginTransaction()
            .replace(R.id.container_news, NewsFragment.getInstance(source))
            .commit()
    }


    fun bindSourcesInTabLayout(sourcesList: List<Source?>?) {
        // TODO: انا جاي لي ليست من نوع سورز , في نعمل عليها لوب
        sourcesList?.forEach { source ->
            //new tab
            var tab = viewBinding.tabLayout.newTab()
            tab.text = source?.name
            tab.tag = source
            viewBinding.tabLayout.addTab(tab)
            var layoutParams = LinearLayout.LayoutParams(tab.view.layoutParams)
            layoutParams.marginEnd = 12
            layoutParams.marginStart = 12
            layoutParams.topMargin = 18
            tab.view.layoutParams = layoutParams
        }
        viewBinding.tabLayout
            .addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    var source = tab?.tag as Source
                    changeFragment(source)

                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {

                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                    var source = tab?.tag as Source
                    changeFragment(source)

                }

            })

        //select tab num0
        viewBinding.tabLayout.getTabAt(0)?.select()

    }

    fun showTabLayout() {
        viewBinding.tabLayout.isVisible = true
    }

    fun showLoading() {
        viewBinding.loadingBar.isVisible = true
        viewBinding.layoutError.isVisible = false
        viewBinding.tabLayout.isVisible = false
    }

    fun hideLoading() {
        viewBinding.loadingBar.isVisible = false
        viewBinding.layoutError.isVisible = false
        viewBinding.tabLayout.isVisible = true
    }


    fun showErrorLayout(message: String?) {
        viewBinding.loadingBar.isVisible = false
        viewBinding.layoutError.isVisible = true
        viewBinding.txtError.text = message
    }

    lateinit var category: CategoryDataClass

    companion object {
        fun getInstance(category: CategoryDataClass): CategoryDetailsFragment {
            var fragment = CategoryDetailsFragment()
            fragment.category = category
            return fragment
        }
    }

}