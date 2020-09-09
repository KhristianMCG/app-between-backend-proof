package com.proof.between.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.proof.between.entities.Prices;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY,
        creatorVisibility = JsonAutoDetect.Visibility.ANY
)
public class SearchPricesResponse implements Serializable {

    private static final long serialVersionUID = -6847380843218177810L;

    List<Prices> allPrices;
}
