package com.currency.repository;

import com.currency.entity.JournalCurrency;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface JournalCurrencyRepository extends JpaRepository<JournalCurrency, Long> {

    @Query("select count(id) from JournalCurrency ")
    Long countAll();
}
