package com.proof.between.repository;

import com.proof.between.entities.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SearchPricesRepository extends JpaRepository<Prices, Long> {

    @Query(value = "from PRICES p where :startDate >= p.startDate and :startDate < p.endDate and p.productId = :productId and p.brandId = :brandId")
    List<Prices> findPrices(@Param("startDate") Date startDate, @Param("productId") Integer productId, @Param("brandId") Integer brandId);
}
