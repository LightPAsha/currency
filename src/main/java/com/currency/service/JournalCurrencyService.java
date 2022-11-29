package com.currency.service;

import com.currency.connectionBank.ConnectionMono;
import com.currency.entity.DirectoryCurrency;
import com.currency.entity.JournalCurrency;
import com.currency.exception.NotFoundException;
import com.currency.repository.JournalCurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class JournalCurrencyService {

    @Autowired
    private DirectoryCurrencyService directoryCurrencyService;

    @Autowired
    private JournalCurrencyRepository journalCurrencyRepository;

    @Autowired
    private ConnectionMono connectionMono;

    public JournalCurrency getByCurrency(String mnemonic) throws IOException {
        DirectoryCurrency directoryCurrency = directoryCurrencyService.getByMnemonic(mnemonic);
        if (directoryCurrency == null) {
            throw new NotFoundException("Mnemonic " + mnemonic + " not found.");
        }
        JournalCurrency currency = journalCurrencyRepository.getByCurrencyByCodeAndDate(LocalDate.now(), directoryCurrency.getCode());
        if (currency == null) {
            List<JournalCurrency> currencies = connectionMono.connection();
            currency = currencies.stream()
                    .filter(f -> f.getCurrency() == directoryCurrency.getCode())
                    .findFirst().orElse(null);
            if (currency != null){
                currency.setDateRecord(LocalDate.now());
                  journalCurrencyRepository.save(currency);
            }

        }
        return currency;

    }


}

//    HistoryCurrency historyCurrency = historyCurrencyRepository.findByCodeAndDateCreate(LocalDate.now(), code);
//        if (historyCurrency == null) {
//                List<CurrencyDto> currencyDtoList = getCurrencyFromBank.getCurrency();
//        CurrencyDto currencyDto = currencyDtoList.stream()
//        .filter(f -> f.getCurrencyCodeA().equals(getCode(mnemonic)))
//        .findFirst().orElse(null);
//        historyCurrencyRepository.save(currencyDtoToHistoryCurrency.convert(currencyDto));
