package api;

import com.google.gson.Gson;
import modelos.Moneda;
import modelos.MonedaExchangeRate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsultaMoneda {

    public String convertirMonedita(String MonedaBase, String MonedaConv) throws IOException, InterruptedException {
        //double MontoBase
        String Token="3b5e93b1e70d3fa866a33de3";
        String url="https://v6.exchangerate-api.com/v6/"+Token+"/pair/"+MonedaBase+"/"+MonedaConv;//  +"/"+MontoBase

        URI direccion = URI.create(url);
        HttpClient client=HttpClient.newHttpClient();
        HttpRequest request=  HttpRequest.newBuilder().uri(direccion).build();
        HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
        //System.out.println(request.body());
        //System.out.println(response.body());

        //CONVERTIR GSON A LA CLASE
        Gson gson=new Gson();
        String json=response.body();
        MonedaExchangeRate monedaExchangeRate= gson.fromJson(json, MonedaExchangeRate.class);

        //OBTENGO EL MONTO
        double MontoBase=0;
        System.out.println("Ingrese el valor que desea convertir");
        Scanner valor=new Scanner(System.in);
        MontoBase = valor.nextDouble();

        //USO LA CONVERSION
        Moneda monedita=new Moneda(MonedaBase,MonedaConv,MontoBase);
        monedita.setTipoCambio(monedaExchangeRate.conversion_rate()); //TIPO DE CAMBIO
        /*
        System.out.println("TITULO: "+monedita.getTipoCambio());
        System.out.println("*********************");
        System.out.println(monedita.getAbreviatura()); //EUR
        System.out.println(monedita.getMontoBase()); //2.0
        System.out.println(monedita.CalculaMontoConversion());
        System.out.println("*********************");
        */
        System.out.println(monedita.toString());
        return "El valor "+monedita.getAbreviatura()+" "+MonedaBase+" corresponde al valor final de ==>>> "+monedita.CalculaMontoConversion() +"+MonedaConv";

    }


}
