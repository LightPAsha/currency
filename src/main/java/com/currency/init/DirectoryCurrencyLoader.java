package com.currency.init;

import com.currency.entity.DirectoryCurrency;
import com.currency.repository.DirectoryCurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(1)
@Component
public class DirectoryCurrencyLoader implements CommandLineRunner {

    @Autowired
    private DirectoryCurrencyRepository currencyRepository;

    @Override
    public void run(String... args) throws Exception {
    Long count = currencyRepository.countAll();
        if (count < 1) {
            DirectoryCurrency currencyUSD = new DirectoryCurrency("USD", 840, "Долар");
            DirectoryCurrency currencyEUR = new DirectoryCurrency("EUR", 978, "Евро");
            DirectoryCurrency currencyUAH = new DirectoryCurrency("UAH", 980, "Гривна");

            currencyRepository.saveAll(List.of(currencyEUR, currencyUSD, currencyUAH));

        }
    }
}
