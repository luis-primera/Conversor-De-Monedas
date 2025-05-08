package modelo;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class ObtenerDatosApi {
    private static final String API_KEY = "74b28bdb8c86cf1b6dd6ab44";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";
    String fechaActualizacion ="" ;

    public Double obtenerTasa (String base, String destino) {
        String url = BASE_URL + API_KEY + "/latest/" + base; // latest es para indicar que es la versión más reciente
        URI direccion = URI.create(url);

        HttpClient client = HttpClient.newHttpClient();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();
            HttpResponse<String> response=client.send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();

            TasasApi listaTasas = gson.fromJson(response.body(), TasasApi.class);
            fechaActualizacion = listaTasas.time_last_update_utc();
            Map<String,Double> tasas = listaTasas.conversion_rates();
            return tasas.get(destino);
        } catch (IOException | InterruptedException | NullPointerException e){
            throw new RuntimeException("Error al obtener los datos de la API. " + e);
        }
    }
    public String obtenerFechaActualizacion (){
        return fechaActualizacion;
    }

}


