package com.leejihun.watcha.assignment.data.di

import com.leejihun.watcha.assignment.data.service.TrackSearchService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object ServiceModule {

  @Singleton
  @Provides
  internal fun provideTrackSearchService(retrofit: Retrofit): TrackSearchService {
    return retrofit.create(TrackSearchService::class.java)
  }
}
