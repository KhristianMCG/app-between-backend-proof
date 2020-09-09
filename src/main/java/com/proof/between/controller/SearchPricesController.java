package com.proof.between.controller;

import com.proof.between.entities.Prices;
import com.proof.between.model.SearchPricesResponse;
import com.proof.between.service.SearchPricesService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class SearchPricesController {

    private final SearchPricesService searchPricesService;

    public SearchPricesController(final SearchPricesService searchPricesService) {
        this.searchPricesService = searchPricesService;
    }

    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Error date should have this format 'yyyy-MM-dd-HH.mm.ss' also Product Id and Brand Id must numbers.")
    })
    @GetMapping(path = "/search-by-date-product-brand/{startDate}/{productId}/{brandId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SearchPricesResponse> searchPricesByDateProductAndBrand(@PathVariable final String startDate,@PathVariable final String productId,@PathVariable final String brandId) throws ParseException {
        final List<Prices> prices = this.searchPricesService.getPrices(startDate, productId, brandId);

        return ResponseEntity.ok(SearchPricesResponse.builder()
                .allPrices(prices)
                .build());
    }
}
