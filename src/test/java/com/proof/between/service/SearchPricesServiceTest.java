package com.proof.between.service;

import com.proof.between.BetweenTechnicalProofApplication;
import com.proof.between.entities.Prices;
import com.proof.between.repository.SearchPricesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.text.ParseException;
import java.util.Collections;
import java.util.Optional;

import static org.mockito.BDDMockito.given;

@SpringBootTest(classes = {BetweenTechnicalProofApplication.class})
class SearchPricesServiceTest {

    @MockBean
    private SearchPricesService searchPricesService;

    @Autowired
    private SearchPricesRepository searchPricesRepository;

    @Test
    void returnFinalPricesAt1000Day14ByProductAndBrand() throws ParseException {
        final Optional<Prices> prices = this.searchPricesRepository.findById(1L);
        given(this.searchPricesService.getPrices("2020-06-14-10.00.00","1","35455"))
                .willReturn(Collections.singletonList(prices.orElse(new Prices())));

        Assertions.assertTrue(prices.isPresent());
        Assertions.assertFalse(prices.get().getFinalPrice().isNaN());
        Assertions.assertEquals(35.50, prices.get().getFinalPrice());
    }

    @Test
    void returnFinalPricesAt1600Day14ByProductAndBrand() throws ParseException {
        final Optional<Prices> prices = this.searchPricesRepository.findById(2L);
        given(this.searchPricesService.getPrices("2020-06-14-16.00.00","1","35455"))
                .willReturn(Collections.singletonList(prices.orElse(new Prices())));

        Assertions.assertTrue(prices.isPresent());
        Assertions.assertFalse(prices.get().getFinalPrice().isNaN());
        Assertions.assertEquals(25.45, prices.get().getFinalPrice());
    }

    @Test
    void returnFinalPricesAt2100Day14ByProductAndBrand() throws ParseException {
        final Optional<Prices> prices = this.searchPricesRepository.findById(5L);
        given(this.searchPricesService.getPrices("2020-06-14-21.00.00","1","35455"))
                .willReturn(Collections.singletonList(prices.orElse(new Prices())));

        Assertions.assertFalse(prices.isPresent());
    }

    @Test
    void returnFinalPricesAt1000Day15ByProductAndBrand() throws ParseException {
        final Optional<Prices> prices = this.searchPricesRepository.findById(3L);
        given(this.searchPricesService.getPrices("2020-06-15-10.00.00","1","35455"))
                .willReturn(Collections.singletonList(prices.orElse(new Prices())));

        Assertions.assertTrue(prices.isPresent());
        Assertions.assertFalse(prices.get().getFinalPrice().isNaN());
        Assertions.assertEquals(30.50, prices.get().getFinalPrice());
    }

    @Test
    void returnFinalPricesAt2100Day15ByProductAndBrand() throws ParseException {
        final Optional<Prices> prices = this.searchPricesRepository.findById(4L);
        given(this.searchPricesService.getPrices("2020-06-15-21.00.00","1","35455"))
                .willReturn(Collections.singletonList(prices.orElse(new Prices())));

        Assertions.assertTrue(prices.isPresent());
        Assertions.assertFalse(prices.get().getFinalPrice().isNaN());
        Assertions.assertEquals(38.95, prices.get().getFinalPrice());
    }
}
