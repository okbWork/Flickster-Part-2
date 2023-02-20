package com.codepath.articlesearch

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.w3c.dom.Text
import kotlin.math.roundToLong

const val ARTICLE_EXTRA = "ARTICLE_EXTRA"
private const val TAG = "ArticleAdapter"

class ArticleAdapter(private val context: Context, private val articles: List<Article>) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_article, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articles[position]
        holder.bind(article)
    }



    override fun getItemCount() = articles.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val mediaImageView = itemView.findViewById<ImageView>(R.id.moviePoster)
        private val titleTextView = itemView.findViewById<TextView>(R.id.movieTitle)
        /*
        private val abstractTextView = itemView.findViewById<TextView>(R.id.movieOverview)
        private val languageTextView = itemView.findViewById<TextView>(R.id.movieLanguage)
        private val voteCountTextView = itemView.findViewById<TextView>(R.id.voteCount)
        */
        private val voteAverageTextView = itemView.findViewById<TextView>(R.id.voteAverage)

        init {
            itemView.setOnClickListener(this)
        }

        // TODO: Write a helper method to help set up the onBindViewHolder method
        fun bind(article: Article) {
            titleTextView.text = article.title
            /*
            abstractTextView.text = article.overview
            languageTextView.text = article.language
            voteCountTextView.text = "Based off of " + article.voteCount.toString() + " Votes"
            */
            voteAverageTextView.text = String.format("%.2f",article.voteAverage) + "/10"


            Glide.with(context)
                .load(article.mediaImageUrl)
                .into(mediaImageView)
        }


        override fun onClick(v: View?) {
            // Get selected article
            val article = articles[absoluteAdapterPosition]

            //  Navigate to Details screen and pass selected article
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(ARTICLE_EXTRA, article)
            context.startActivity(intent)
        }


    }
}