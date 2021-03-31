package com.gmail.lesson6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ArticleDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_detail)
        if(intent != null){
            findViewById<TextView>(R.id.titleTV).text = intent.getStringExtra("title")
            findViewById<TextView>(R.id.articleDesc).text = intent.getStringExtra("desc")
            val imgView = findViewById<ImageView>(R.id.articleImage)
            Picasso.get().load(intent.getStringExtra("imgURL")).into(imgView)
        }
    }
}