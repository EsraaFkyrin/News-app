package com.example.new_app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle

import androidx.databinding.DataBindingUtil
import com.example.new_app.R
import com.example.new_app.databinding.ActivityMainBinding
import com.example.new_app.ui.category.CategoryDataClass
import com.example.new_app.ui.category.CategoryFragment
import com.example.new_app.ui.categoryDetils.CategoryDetailsFragment
import com.example.new_app.ui.setting.SettingsFragment

class MainActivity : AppCompatActivity(), CategoryFragment.OnCategoryClickListener {
    override fun onCategoryClick(category: CategoryDataClass) {
        showCategoryDetilsFragment(category)
    }

    lateinit var viewBinding: ActivityMainBinding
    var categoryFragment = CategoryFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        //viewBinding = ActivityMainBinding.inflate(layoutInflater)
       //setContentView(viewBinding.root)


        categoryFragment.onCategoryClickListener = this

        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, categoryFragment)
            .commit()
        //fun show navDrawer
        showToggleNavDrawer()


    }


    fun showCategoryDetilsFragment(category: CategoryDataClass) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, CategoryDetailsFragment.getInstance(category))
            .addToBackStack(null)
            .commit()

    }

    fun showToggleNavDrawer() {
        var toggle = ActionBarDrawerToggle(
            this, viewBinding.myDrawerLayout, viewBinding.toolbar,
            R.string.nav_open, R.string.nav_close
        )
        viewBinding.myDrawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        viewBinding.navView.setNavigationItemSelectedListener { items ->
            when (items.itemId) {
                R.id.nav_category -> {
                    showCategoryFragment()
                }
                R.id.nav_setting -> {
                    showSettingsFragment()

                }
            }

            viewBinding.myDrawerLayout.closeDrawers()

            return@setNavigationItemSelectedListener true

        }

    }

    fun showCategoryFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, categoryFragment)
            .addToBackStack(null)
            .commit()
        viewBinding.txtTollbar.text = "News App"
    }

    fun showSettingsFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, SettingsFragment())
            .addToBackStack(null)
            .commit()
        viewBinding.txtTollbar.text = "Settings"

    }


}