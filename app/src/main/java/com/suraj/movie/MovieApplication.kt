package com.suraj.movie

import android.app.Application
import com.suraj.movie.di.AppliationComponent
import com.suraj.movie.di.DaggerAppliationComponent


class MovieApplication : Application() {
    lateinit var appliationComponent: AppliationComponent
    override fun onCreate() {
        super.onCreate()
       //initialize()
        appliationComponent = DaggerAppliationComponent.factory().create(this)
    }
}