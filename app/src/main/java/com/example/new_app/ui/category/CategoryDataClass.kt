package com.example.new_app.ui.category

import com.example.new_app.R

data class CategoryDataClass(
    var id: String,
    var name: String,
    var imageId: Int,
    var backgroundColorId: Int
) {
    companion object {
        fun getCategoryList(): List<CategoryDataClass> {
            return listOf(
                CategoryDataClass(
                    "Sports",
                    "Sports", R.drawable.sports,
                    R.color.red
                ),

                CategoryDataClass(
                    "entertainment",
                    "Entertainment", R.drawable.entertainment,
                    R.color.blue
                ),

                CategoryDataClass(
                    "health",
                    "Health", R.drawable.health,
                    R.color.bink
                ),

                CategoryDataClass(
                    "business",
                    "Business ", R.drawable.bussines,
                    R.color.gold
                ),

                CategoryDataClass(
                    "technology",
                    "Technology", R.drawable.technology,
                    R.color.babyBlue
                ),

                CategoryDataClass(
                    "science",
                    "Science", R.drawable.science,
                    R.color.yellow
                )
            )


        }
    }
}