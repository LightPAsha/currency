package com.currency.repository;

import com.currency.entity.DirectoryCurrency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface DirectoryCurrencyRepository extends JpaRepository<DirectoryCurrency, Long> {

    @Query("select count(id) from DirectoryCurrency")
    Long countAll();

    @Query("select mn from DirectoryCurrency mn where mn.mnemonic =:mnemonic")
    DirectoryCurrency getByMnemonic(String mnemonic);

}
