package com.api.v2.customer.exceptions

class DuplicatedSsnException(ssn: String): RuntimeException("The SSN $ssn is already registered.")