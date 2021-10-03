package com.mvettosi.loltraining.framework.network

import com.mvettosi.loltraining.core.data.RemoteNameDataSource
import com.mvettosi.loltraining.core.domain.Name
import javax.inject.Inject
import kotlinx.coroutines.delay

class FakeNetworkNameDataSource @Inject constructor() : RemoteNameDataSource {
  override suspend fun getNameFromNetwork(): Name {
    delay(2000)
    return Name(first = "Some", last = "Template")
  }
}
