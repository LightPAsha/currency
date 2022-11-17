package com.currency.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "currency")
public class JournalCurrency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mnemonic;
    private int code;
    private String description;

    public JournalCurrency(String mnemonic, int code, String description) {
        this.mnemonic = mnemonic;
        this.code = code;
        this.description = description;
    }
}
