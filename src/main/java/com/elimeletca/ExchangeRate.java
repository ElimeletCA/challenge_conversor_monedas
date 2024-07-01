package com.elimeletca;

import java.util.HashMap;

public record ExchangeRate(
        String base_code,
        HashMap<String, Double> conversion_rates
) {}
