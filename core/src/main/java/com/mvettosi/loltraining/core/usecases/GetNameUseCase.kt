package com.mvettosi.loltraining.core.usecases

import com.mvettosi.loltraining.core.data.NameRepository
import javax.inject.Inject

class GetNameUseCase @Inject constructor(private val nameRepository: NameRepository) {
  suspend operator fun invoke() = nameRepository.getName()
}
