import api.ConsultaMoneda;
import modelos.Moneda;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        ConsultaMoneda cm=new ConsultaMoneda();


        String solicitarMonto="Ingrese el valor que desea convertir";

        Moneda monedita=new Moneda("null","null",0);

        int opcion=0;
        double montito=0;
        String menu = MenuPrincipal();

        while(opcion != 7){
            //IMPRIMO EL MENU
            System.out.println(menu);
            //SOLICITO LA OPCION
            Scanner lectura=new Scanner(System.in);
            opcion=lectura.nextInt();
            //INGRESA EL CASO DEPENDIENDO DE LA OPCION
            switch (opcion){
                case 1:
                    //System.out.println(solicitarMonto);
                    //Scanner valor=new Scanner(System.in);
                    //montito=valor.nextDouble();
                    cm.convertirMonedita("USD","ARS");
                    break;
                case 2:
                    cm.convertirMonedita("ARS","USD");
                    break;
                case 3:
                    cm.convertirMonedita("USD","BRL");
                    break;
                case 4:
                    cm.convertirMonedita("BRL","USD");
                    break;
                case 5:
                    cm.convertirMonedita("USD","COP");
                    break;
                case 6:
                    cm.convertirMonedita("COP","USD");
                    break;
            }
        }


    }

    public static String MenuPrincipal(){

        String lista_menu= """
                ****************************************************
                Sea bienvenido/a al Converso de Moneda =]
                
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Salir
                Elija una opción válida:
                ****************************************************
                """;
        return lista_menu;
    }

}