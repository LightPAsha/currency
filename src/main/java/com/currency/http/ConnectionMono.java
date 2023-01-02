package com.currency.http;

import com.currency.entity.JournalCurrency;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConnectionMono {

    //    {"currencyCodeA":840,"currencyCodeB":980,"date":1667945410,"rateBuy":36.65,"rateSell":37.4406}
    public List<JournalCurrency> connection() throws IOException {
        List<JournalCurrency> rates = new ArrayList<>();
        HttpResponse resp = Request.Get("https://api.monobank.ua/bank/currency")
                .execute()
                .returnResponse();
        String jsonInput = EntityUtils.toString(resp.getEntity(), "UTF-8");
        //разбираем ответ
        if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            rates  = new ObjectMapper().readValue(jsonInput,
                    new TypeReference<List<JournalCurrency>>() {
                    });
        }

        return rates;
    }

}
