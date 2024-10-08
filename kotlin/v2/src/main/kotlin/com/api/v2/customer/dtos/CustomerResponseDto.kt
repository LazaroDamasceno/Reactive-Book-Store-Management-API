package com.api.v2.customer.dtos

import java.time.LocalDate

data class CustomerResponseDto(
    val fullName: String,
    val ssn: String,
    val birthDate: LocalDate,
    val email: String,
    val gender: String,
    val phoneNumber: String
)