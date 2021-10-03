package com.mvettosi.loltraining.framework.database

import com.mvettosi.loltraining.core.data.LocalNameDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DatabaseBindings {
  @Binds
  abstract fun bindLocalNameDataSource(
      inMemoryNameDataSource: InMemoryNameDataSource
  ): LocalNameDataSource
}
