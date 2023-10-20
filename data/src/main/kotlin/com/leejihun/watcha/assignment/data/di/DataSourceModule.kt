package com.leejihun.watcha.assignment.data.di

import com.leejihun.watcha.assignment.data.datasource.TrackSearchDataSource
import com.leejihun.watcha.assignment.data.datasource.TrackSearchDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

  @Singleton
  @Binds
  abstract fun bindTrackSearchDataSource(trackSearchDataSourceImpl: TrackSearchDataSourceImpl): TrackSearchDataSource
}
