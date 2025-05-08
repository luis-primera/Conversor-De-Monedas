package controlador;

import modelo.ObtenerDatosApi;

public class Conversor {
    public void convertirMoneda(int opcion, double cantidad)  {
        double resultadoConversion;
        double factorConversion = 1;
        String monedaConvertida = "";
        String simboloMonedaOrigen = "";
        String simboloMonedaDestino = "";
        ObtenerDatosApi obtenerDatosApi = new ObtenerDatosApi();

        switch (opcion){
            case 1:
                monedaConvertida = "Monedas convertidas: Dólar (USD) → Peso Chileno (CLP)";
                simboloMonedaOrigen = " USD";
                simboloMonedaDestino = " CLP";
                factorConversion = obtenerDatosApi.obtenerTasa("USD","CLP");

                break;
            case 2:
                monedaConvertida = "Monedas convertidas: Peso Chileno (CLP) → Dólar (USD)";
                simboloMonedaOrigen = " CLP";
                simboloMonedaDestino = " USD";
                factorConversion = obtenerDatosApi.obtenerTasa("CLP", "USD");
                break;
            case 3:
                monedaConvertida = "Monedas convertidas: Dólar (USD) → Bolívar (VES)";
                simboloMonedaOrigen = " USD";
                simboloMonedaDestino = " VES";
                factorConversion = obtenerDatosApi.obtenerTasa("USD", "VES");
                break;
            case 4:
                monedaConvertida = "Monedas convertidas: Bolívar (VES) → Dólar (USD)";
                simboloMonedaOrigen = " VES";
                simboloMonedaDestino = " USD";
                factorConversion = obtenerDatosApi.obtenerTasa("VES", "USD");
                break;
            case 5:
                monedaConvertida = "Monedas convertidas: Dólar (USD) → Real Brasileño (BRL)";
                simboloMonedaOrigen = " USD";
                simboloMonedaDestino = " BRL";
                factorConversion = obtenerDatosApi.obtenerTasa("USD","BRL");
                break;
            case 6:
                monedaConvertida = "Monedas convertidas: Real Brasileño (BRL) → Dólar (USD)";
                simboloMonedaOrigen = " BRL";
                simboloMonedaDestino = " USD";
                factorConversion = obtenerDatosApi.obtenerTasa("BRL","USD");
                break;
            default:
                System.out.println("INGRESE UNA OPCIÓN VALIDA");
        }

        resultadoConversion = cantidad * factorConversion;
        resultadoConversion = redondeo(resultadoConversion);
        System.out.println("--------------------------------------------------------------");
        System.out.println(monedaConvertida);
        System.out.println("--------------------------------------------------------------");
        System.out.println("Fecha de actualización: "+ obtenerDatosApi.obtenerFechaActualizacion());
        System.out.println("--------------------------------------------------------------");
        System.out.println("Tasa del día: " +factorConversion);
        System.out.println("--------------------------------------------------------------");
        System.out.println("El cambio total de "+ cantidad+simboloMonedaOrigen+" es igual a: " +resultadoConversion+simboloMonedaDestino);
        System.out.println("--------------------------------------------------------------");

    }
    public static double redondeo(double valor){
        return Math.round(valor * 100.0) / 100.0;
    }

}
