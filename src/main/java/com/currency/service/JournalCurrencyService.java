package com.currency.service;

import com.currency.connectionBank.ConnectionMono;
import com.currency.dto.CreateCurrency;
import com.currency.entity.DirectoryCurrency;
import com.currency.entity.JournalCurrency;
import com.currency.exception.AlreadyAvailableException;
import com.currency.exception.NotFoundException;
import com.currency.repository.JournalCurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
public class JournalCurrencyService {

    @Autowired
    private DirectoryCurrencyService directoryCurrencyService;

    @Autowired
    private JournalCurrencyRepository journalCurrencyRepository;

    @Autowired
    private ConnectionMono connectionMono;


    public JournalCurrency getByCurrency(String mnemonic, LocalDate date) {
        int code = this.checkMnemonicGetCode(mnemonic);
        JournalCurrency currency = journalCurrencyRepository.getByCurrencyByCodeAndDate(date, code);
        if (currency == null) {
            throw new NotFoundException(String.format("Currency with date %s and mnemonic %s not found", date, mnemonic));
        }
        return currency;
    }

    public void createCurrency(CreateCurrency createCurrency) throws IOException {
        JournalCurrency currency = journalCurrencyRepository.getByCurrencyByCodeAndDate(createCurrency.getDateRecord(), createCurrency.getCurrency());
        if (currency != null) {
            throw new AlreadyAvailableException("Ошибка, такая дата уже есть" + createCurrency.getDateRecord());
        }
        journalCurrencyRepository.save(new JournalCurrency(createCurrency.getCurrency(), createCurrency.getDateRecord(), createCurrency.getRateBuy(), createCurrency.getRateSell()));
    }

    public JournalCurrency getByCurrency(String mnemonic) throws IOException {
        int code = this.checkMnemonicGetCode(mnemonic);
        JournalCurrency currency = journalCurrencyRepository.getByCurrencyByCodeAndDate(LocalDate.now(), code);
        if (currency == null) {
            List<JournalCurrency> currencies = connectionMono.connection();
            currency = currencies.stream()
                    .filter(f -> f.getCurrency() == code)
                    .findFirst().orElse(null);
            if (currency != null) {
                currency.setDateRecord(LocalDate.now());
                journalCurrencyRepository.save(currency);
            }
        }
        return currency;
    }

    private int checkMnemonicGetCode(String mnemonic) {
        DirectoryCurrency directoryCurrency = directoryCurrencyService.getByMnemonic(mnemonic);
        if (directoryCurrency == null) {
            throw new NotFoundException("Mnemonic " + mnemonic + " not found.");
        }
        return directoryCurrency.getCode();
    }
}
