package com.suraj.movie

import android.app.Application
import com.suraj.movie.db.MovieDB
import com.suraj.movie.di.AppliationComponent
import com.suraj.movie.di.DaggerAppliationComponent
import com.suraj.movie.repository.MovieRepository
import com.suraj.movie.retrofit.MovieAPI
import com.suraj.movie.retrofit.RetrofitHelper
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent


class MovieApplication : Application() {
    lateinit var appliationComponent: AppliationComponent
    override fun onCreate() {
        super.onCreate()
       // initialize()
        appliationComponent = DaggerAppliationComponent.factory().create(this)
    }
}