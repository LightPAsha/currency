package com.currency.http;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.fluent.Request;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConnectionCheckApiKey {

    public boolean checkApiKey(String apiKey) throws IOException {
        boolean isCorrectApiKe = false;
        HttpResponse resp = Request.Get("http://localhost:8081/checkApiKey?apiKey="+apiKey)
                .execute()
                .returnResponse();
        //разбираем ответ
        if (resp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
         isCorrectApiKe= true;
        }
        return isCorrectApiKe;
    }
}
