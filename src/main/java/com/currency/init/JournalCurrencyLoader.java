package com.currency.init;

import com.currency.entity.JournalCurrency;
import com.currency.repository.JournalCurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Order(1)
@Component
public class JournalCurrencyLoader implements CommandLineRunner {

    @Autowired
    private JournalCurrencyRepository currencyRepository;

    @Override
    public void run(String... args) throws Exception {
    Long count = currencyRepository.countAll();
        if (count < 1) {
            JournalCurrency currencyUSD = new JournalCurrency("USD", 840, "Долар");
            JournalCurrency currencyEUR = new JournalCurrency("EUR", 978, "Евро");
            JournalCurrency currencyUAH = new JournalCurrency("UAH", 980, "Гривна");

            currencyRepository.saveAll(List.of(currencyEUR, currencyUSD, currencyUAH));

        }
    }
}
