package com.currency.controller;

import com.currency.entity.JournalCurrency;
import com.currency.repository.JournalCurrencyRepository;
import com.currency.service.JournalCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;

@RestController
@RequestMapping("/currency")
public class JournalCurrencyController {

    @Autowired
    JournalCurrencyService journalCurrencyService;
    @RequestMapping(method = RequestMethod.GET, value = ("/currency"))
    public JournalCurrency getCurrency(@RequestParam String mnemonic) throws IOException {

        return journalCurrencyService.getByCurrency(mnemonic);
    }


}
