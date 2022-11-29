package com.currency.init;


import com.currency.entity.DirectoryCurrency;
import com.currency.entity.JournalCurrency;
import com.currency.repository.JournalCurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

@Order
@Component

public class JournalCurrencyLoader implements CommandLineRunner {

    @Autowired
    private JournalCurrencyRepository journalCurrencyRepository;


    @Override
    public void run(String... args) throws Exception {
        Long count = journalCurrencyRepository.countAll();

            if (count < 1){

                JournalCurrency currencyUSD= new JournalCurrency();


            }
    }
}