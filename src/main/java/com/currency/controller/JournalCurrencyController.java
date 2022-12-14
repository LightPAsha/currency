package com.currency.controller;

import com.currency.dto.CreateCurrency;
import com.currency.entity.JournalCurrency;
import com.currency.service.JournalCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;

@RestController
public class JournalCurrencyController {

    @Autowired
    JournalCurrencyService journalCurrencyService;

    @RequestMapping(method = RequestMethod.GET, value = ("/currency"))
    public JournalCurrency getCurrency(@RequestParam String mnemonic,
                                       @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date) throws IOException {
        if (date == null) {
            return journalCurrencyService.getByCurrency(mnemonic);
        }
        return journalCurrencyService.getByCurrency(mnemonic, date);
    }

    @RequestMapping(method = RequestMethod.POST, value = ("/createcurrency"))
    public void getCurrency(@RequestBody CreateCurrency createCurrency) throws IOException {
         journalCurrencyService.createCurrency(createCurrency);
    }
}
