/* 
 * Copyright 2019 Oscar G.4 - oscargimenez4@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.main;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Oscar G.4 - oscargimenez4@gmail.com
 */
public class Main {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH)
                    .useDelimiter("\\s+");

    public static void main(String[] args) {
        //constantes
        final double VALOR_IVA = 0.21;
        final int BOLSA_ENTERA = 100;
        final double PRECIO_BOLSA = 5.0;
        final double PRECIO_CARAMELO = 0.07;
        //variables
        int cantCaramelos;
        int cantBolsas = 0;
        int caramSueltos = 0;
        double importeBolsas;
        double importeCaramelo;
        double importeTotal;
        double importeIva;
        double importePvp;
        //Mensaje de encabezado
        System.out.println("CARAMELOS PARA BAUTIZOS");
        System.out.printf("=======================%n%n");
        //Entrada de datos
        try {
            System.out.print("Cantidad de caramelos ...: ");
            cantCaramelos = SCN.nextInt();
            SCN.nextLine();
            //Calculo de bolsas y caramelos sueltos
            cantBolsas = cantCaramelos / BOLSA_ENTERA;
            caramSueltos = cantCaramelos % BOLSA_ENTERA;
            //Mensaje de cantidad de bolsas y caramelos
            System.out.printf("%nBolsas completas ........: %d%n", cantBolsas);
            System.out.printf("Caramelos sueltos .......: %d%n%n", caramSueltos);

        } catch (Exception e) {
            System.out.println(">>> Entrada errónea");
        } finally {
            SCN.nextLine();
        }
        //Calculo de importes
        importeBolsas = cantBolsas * PRECIO_BOLSA;
        importeCaramelo = caramSueltos * PRECIO_CARAMELO;
        importeTotal = importeBolsas + importeCaramelo;
        //Mensajes de importes
        System.out.printf(Locale.ENGLISH, "Importe bolsas ..........: %.2f €%n", importeBolsas);
        System.out.printf(Locale.ENGLISH, "Importe caramelos .......: %.2f €%n%n", importeCaramelo);
        System.out.printf(Locale.ENGLISH, "Importe previo ..........: %.2f €%n%n", importeTotal);
        //Calculo de IVA
        importeIva = importeTotal * VALOR_IVA;
        //Mensaje de cantidad de IVA
        System.out.printf(Locale.ENGLISH, "IVA (21%%)................: %.2f €%n%n", importeIva);
        //Calculo de PVP
        importePvp = importeTotal + importeIva;
        //Mensaje de cantidad de PVP
        System.out.printf(Locale.ENGLISH, "Importe PVP .............: %.2f €%n", importePvp);
    }
}
