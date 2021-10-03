package com.mvettosi.loltraining.core.data

import com.mvettosi.loltraining.core.domain.Name

interface RemoteNameDataSource {
  suspend fun getNameFromNetwork(): Name
}
