package com.proof.between.controller;

import com.proof.between.repository.SearchPricesRepository;
import com.proof.between.service.SearchPricesService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

@SpringBootTest
@AutoConfigureMockMvc
class SearchPricesControllerTest {

    private static final String BRAND_ID = "1";
    private static final String PRODUCT_ID = "35455";
    private static final String VALUE_DATE = "2020-06-12-15.00.00";
    private static final String PARAM_VALUE_DATE_NAME = "startDate";
    private static final String PARAM_VALUE_PRODUCT_ID = "productId";
    private static final String PARAM_VALUE_BRAND_ID = "brandId";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SearchPricesRepository searchPricesRepository;

    @MockBean
    private SearchPricesService searchPricesService;

    @Test
    void returnAllPricesByDateAndBrandIdAndProductId() throws Exception {
        Mockito.when(this.searchPricesService.getPrices(VALUE_DATE, PRODUCT_ID, BRAND_ID)).thenReturn(Collections.singletonList(this.searchPricesRepository.findById(1L).orElse(null)));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/search-by-date-product-brand/{"
                .concat(PARAM_VALUE_DATE_NAME).concat("}/{").concat(PARAM_VALUE_PRODUCT_ID).concat("}/{").concat(PARAM_VALUE_BRAND_ID).concat("}"), VALUE_DATE, PRODUCT_ID, BRAND_ID))
                .andDo(MockMvcResultHandlers
                        .print())
                .andExpect(MockMvcResultMatchers
                        .status().isOk())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.allPrices")
                        .exists())
                .andReturn();

        Mockito.verify(this.searchPricesService, Mockito.times(1)).getPrices(VALUE_DATE,PRODUCT_ID,BRAND_ID);
    }
}
