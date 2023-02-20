package com.codepath.articlesearch

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

private const val TAG = "DetailActivity"

class DetailActivity : AppCompatActivity() {
    private lateinit var mediaImageView: ImageView
    private lateinit var titleTextView: TextView
    private lateinit var bylineTextView: TextView
    private lateinit var abstractTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // TODO: Find the views for the screen
        mediaImageView = findViewById(R.id.moviePoster)
        titleTextView = findViewById(R.id.movieTitle)
        bylineTextView = findViewById(R.id.releaseDate)
        abstractTextView = findViewById(R.id.movieOverview)


        val article = intent.getSerializableExtra(ARTICLE_EXTRA) as Article


        titleTextView.text = article.title
        bylineTextView.text = article.releaseDate
        abstractTextView.text = article.overview

        Glide.with(this)
            .load(article.mediaImageUrl)
            .into(mediaImageView)
    }
}