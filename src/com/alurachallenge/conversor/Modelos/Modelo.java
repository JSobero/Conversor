package com.alurachallenge.conversor.Modelos;

import java.util.Map;

public record Modelo(String base_code, Map<String, Double> conversion_rates) {

}
