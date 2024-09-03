package com.api.v1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerDeletionTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testSuccessfulAllCustomersDeletion() {
        webTestClient
                .delete()
                .uri("api/v1/customers")
                .exchange()
                .expectStatus()
                .is2xxSuccessful();

    }

    @Test
    void testUnsuccessfulAllCustomersDeletion() {
        webTestClient
                .delete()
                .uri("api/v1/customers")
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

}
