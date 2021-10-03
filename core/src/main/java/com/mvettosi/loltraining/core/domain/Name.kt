package com.mvettosi.loltraining.core.domain

data class Name(val first: String, val last: String) {
  override fun toString() = "$first $last"
}
