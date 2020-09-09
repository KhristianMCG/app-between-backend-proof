package com.proof.between.service;

import com.proof.between.entities.Prices;
import com.proof.between.repository.SearchPricesRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class SearchPricesService {

    private final SearchPricesRepository searchPricesRepository;
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");

    public SearchPricesService(final SearchPricesRepository searchPricesRepository) {
        this.searchPricesRepository = searchPricesRepository;
    }

    public List<Prices> getPrices(String valueDate, String productId, String brandId) throws ParseException {
       return this.searchPricesRepository.findPrices(this.simpleDateFormat.parse(valueDate), Integer.parseInt(productId), Integer.parseInt(brandId));
    }
}
