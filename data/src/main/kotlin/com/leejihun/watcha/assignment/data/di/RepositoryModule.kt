package com.leejihun.watcha.assignment.data.di

import com.leejihun.watcha.assignment.data.repository.TrackSearchRepositoryImpl
import com.leejihun.watcha.assignment.domain.repository.TrackSearchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

  @Binds
  @Singleton
  abstract fun bindTrackSearchRepository(trackSearchRepositoryImpl: TrackSearchRepositoryImpl): TrackSearchRepository
}
