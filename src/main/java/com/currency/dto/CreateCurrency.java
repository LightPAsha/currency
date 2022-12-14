package com.currency.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CreateCurrency {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateRecord;
    private int currency;
    private BigDecimal rateBuy;
    private BigDecimal rateSell;

}
