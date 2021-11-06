package com.ruben.mycustomcalendar.di

import com.ruben.mycustomcalendar.ui.CalendarRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideCalendarRepo() = CalendarRepo()
}