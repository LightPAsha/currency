package com.currency.repository;


import com.currency.entity.JournalCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface JournalCurrencyRepository extends JpaRepository <JournalCurrency, Long >{
    @Query("select count(id) from JournalCurrency")
    Long countAll();

    @Query("select c from JournalCurrency c  where c.dateRecord =:date and c.currencyA =:code")
    JournalCurrency getByCurrencyByCodeAndDate(LocalDate date, int code);

    @Query("select c from JournalCurrency c where c.currencyA =:codeA and c.currencyB =:codeB")
    JournalCurrency getByCurrencyCodeAndB(int codeA, int codeB);
}