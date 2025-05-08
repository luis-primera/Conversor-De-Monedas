package modelo;

import java.util.Map;

public record TasasApi(String time_last_update_utc,
        Map<String,Double> conversion_rates) {
}
