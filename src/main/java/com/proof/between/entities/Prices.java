package com.proof.between.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Entity(name = "PRICES")
public class Prices implements Serializable {

    private static final long serialVersionUID = -3509852455917437764L;
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "BRAND_ID")
    private Integer brandId;

    @Column(name = "PRODUCT_ID")
    private Integer productId;

    @Column(name = "PRICE_LIST")
    private Integer priceList;

    @Column(name = "PRIORITY")
    private Integer priority;

    @Column(name = "START_DATE")
    @Basic
    private Date startDate;

    @Column(name = "END_DATE")
    @Basic
    private Date endDate;

    @Column(name = "PRICE")
    private Double finalPrice;

    @Column(name = "CURR")
    private String currency;
}
