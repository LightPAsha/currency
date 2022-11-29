package com.currency.service;

import com.currency.entity.DirectoryCurrency;
import com.currency.repository.DirectoryCurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectoryCurrencyService {

    @Autowired
    private DirectoryCurrencyRepository directoryCurrencyRepository;

    public DirectoryCurrency getByMnemonic(String mnemonic) {
        return directoryCurrencyRepository.getByMnemonic(mnemonic);
    }

}
