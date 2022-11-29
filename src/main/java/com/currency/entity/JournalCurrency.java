package com.currency.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class  JournalCurrency{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @JsonProperty("currencyCodeA")
    private int currency;
    private LocalDate dateRecord;
    private BigDecimal rateBuy;
    private BigDecimal rateSell;
//    {"currencyCodeA":840,"currencyCodeB":980,"date":1667945410,"rateBuy":36.65,"rateSell":37.4406}


    public JournalCurrency(int currency, LocalDate dateRecord, BigDecimal rateBuy, BigDecimal rateSell) {
        this.currency = currency;
        this.dateRecord = dateRecord;
        this.rateBuy = rateBuy;
        this.rateSell = rateSell;
    }
}
