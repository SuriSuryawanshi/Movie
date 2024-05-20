package com.suraj.movie.retrofit

import com.suraj.movie.models.Movies
import com.suraj.movie.models.ResponseMovie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface MovieAPI {

    @GET("3/search/movie") //7636f6e7bd3956b30ac73db3649ec739
    suspend fun getMovies(@Query("api_key") api_key:String, @Query("query") query:String,@Query("include_adult") include_adult:Boolean,@Query("language") language:String,@Query("page") page:Int) : Response<ResponseMovie>

    @GET("3/trending/movie/day")
    suspend fun getTrendingMovies(@Query("api_key") api_key:String):  Response<ResponseMovie>
}