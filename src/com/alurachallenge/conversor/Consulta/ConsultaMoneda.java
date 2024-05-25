package com.alurachallenge.conversor.Consulta;

import com.alurachallenge.conversor.Modelos.Modelo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public Modelo buscarMoneda(String idMoneda){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/1d6842bd766a791e9443b773/latest/"+idMoneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();



        try {
            HttpResponse<String> response = null;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Modelo.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontre esa moneda" + idMoneda, e);
        }
    }


}
