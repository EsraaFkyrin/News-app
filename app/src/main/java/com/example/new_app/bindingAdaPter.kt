package com.example.new_app

import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
@BindingAdapter("imageUrl")
fun loadImageByTheUrlGlide(imageView: ImageView,url:String)
{
    Glide.with(imageView)
        .load(url)
        .placeholder(R.drawable.ic_wifi)
        .into(imageView)
}
@BindingAdapter("imageId")
fun loadImageByIdDrawable(imageView: ImageView,image:Int)
    {
    imageView.setImageResource(image)
}
@BindingAdapter("backgroundColor")
fun changCardViewBackground(cardView: CardView,color:Int){
    cardView.setCardBackgroundColor(ContextCompat.getColor(cardView.context,color))
}
@BindingAdapter("launchUrl")
fun clickLauncUrl(view:View,url: String)
{
    view.setOnClickListener{
        val intent=Intent(Intent.ACTION_VIEW, Uri.parse(url))
        view.context.startActivity(intent)
    }
}

