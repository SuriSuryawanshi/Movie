package com.suraj.movie.di

import android.content.Context
import com.suraj.movie.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class,DatabaseModule::class])
interface AppliationComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context) : AppliationComponent
    }

}