package com.codepath.articlesearch
import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class BaseResponse(
    @SerialName("results")
    val docs: List<Article>?
)



@Keep
@Serializable
data class Article(
    @SerialName("overview")
    val overview: String?,
    @SerialName("release_date")
    val releaseDate: String?,
    @SerialName("title")
    val title: String?,
    @SerialName("poster_path")
    val multimedia: String?,
    @SerialName("original_language")
    val language: String?,
    @SerialName("vote_average")
    val voteAverage: Double?,
    @SerialName("vote_count")
    val voteCount: Int?,

    ): java.io.Serializable {
    val mediaImageUrl = "https://image.tmdb.org/t/p/w500${multimedia}"
}





