package com.proof.between.repository;

import com.proof.between.entities.Prices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class SearchPricesRepositoryTest {

    @Autowired
    private SearchPricesRepository searchPricesRepository;

    @Test
    void returnOneSavedPriceLine() {
        Optional<Prices> prices2 = this.searchPricesRepository.findById(1L);
        Assertions.assertTrue(prices2.isPresent());
    }
}
