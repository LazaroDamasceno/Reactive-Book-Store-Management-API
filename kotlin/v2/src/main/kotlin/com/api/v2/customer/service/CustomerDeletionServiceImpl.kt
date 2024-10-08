package com.api.v2.customer.service

import com.api.v2.customer.anotations.SSN
import com.api.v2.customer.domain.CustomerRepository
import com.api.v2.customer.utils.CustomerFinderUtil
import com.api.v2.exceptions.EmptyEntityException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.withContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
private class CustomerDeletionServiceImpl: CustomerDeletionService {

    @Autowired
    lateinit var customerFinderUtil: CustomerFinderUtil

    @Autowired
    lateinit var customerRepository: CustomerRepository

    override suspend fun deleteAll() {
        return withContext(Dispatchers.IO) {
            if (customerRepository.findAll().count() == 0) {
                throw EmptyEntityException()
            }
            customerRepository.deleteAll()
        }
    }

    override suspend fun deleteBySsn(ssn: @SSN String) {
        return withContext(Dispatchers.IO) {
            val customers = customerFinderUtil.findMany(ssn)
            customerRepository.deleteAll(customers)
        }
    }

}