package com.currency.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    @Column(name = "currency_A")
    private int currencyA;
    @JsonProperty("currencyCodeB")
    @Column(name = "currency_B")
    private int currencyB;
    private LocalDate dateRecord;
    private BigDecimal rateBuy;
    private BigDecimal rateSell;
//    {"currencyCodeA":840,"currencyCodeB":980,"date":1667945410,"rateBuy":36.65,"rateSell":37.4406}

    public JournalCurrency(int currencyA, LocalDate dateRecord, BigDecimal rateBuy, BigDecimal rateSell) {
        this.currencyA = currencyA;
        this.dateRecord = dateRecord;
        this.rateBuy = rateBuy;
        this.rateSell = rateSell;
    }
}
