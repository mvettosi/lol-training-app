package com.mvettosi.loltraining.core.data

import com.mvettosi.loltraining.core.domain.Name

interface LocalNameDataSource {
  suspend fun getPersistedName(): Name?
  suspend fun storeName(name: Name)
}
