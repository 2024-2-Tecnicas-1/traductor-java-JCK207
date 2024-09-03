package com.mycompany.traductorjava;

import java.util.Scanner;
import java.util.HashMap;
public class TraductorJava {

    public static HashMap<Integer, String> ObtenerTextos(String idioma) {
        HashMap<Integer, String> ESP = new HashMap<>();
        ESP.put(0, "cero");
        ESP.put(1, "uno");
        ESP.put(2, "dos");
        ESP.put(3, "tres");
        ESP.put(4, "cuatro");
        ESP.put(5, "cinco");
        ESP.put(6, "seis");
        ESP.put(7, "siete");
        ESP.put(8, "ocho");
        ESP.put(9, "nueve");
        ESP.put(10, "diez");
        ESP.put(11, "once");
        ESP.put(12, "doce");
        ESP.put(13, "trece");
        ESP.put(14, "catorce");
        ESP.put(15, "quince");
        ESP.put(20, "veinte");
        ESP.put(30, "treinta");
        ESP.put(40, "cuarenta");
        ESP.put(50, "cincuenta");
        ESP.put(60, "sesenta");
        ESP.put(70, "setenta");
        ESP.put(80, "ochenta");
        ESP.put(90, "noventa");
        ESP.put(100, "cien");
       
        HashMap<Integer, String> ENG = new HashMap<>();
        ENG.put(0, "zero");
        ENG.put(1, "one");
        ENG.put(2, "two");
        ENG.put(3, "three");
        ENG.put(4, "four");
        ENG.put(5, "five");
        ENG.put(6, "six");
        ENG.put(7, "seven");
        ENG.put(8, "eight");
        ENG.put(9, "nine");
        ENG.put(10, "ten");
        ENG.put(11, "eleven");
        ENG.put(12, "twelve");
        ENG.put(13, "thirteen");
        ENG.put(14, "fourteen");
        ENG.put(15, "fifteen");
        ENG.put(20, "twenty");
        ENG.put(30, "thirty");
        ENG.put(40, "forty");
        ENG.put(50, "fifty");
        ENG.put(60, "sixty");
        ENG.put(70, "seventy");
        ENG.put(80, "eighty");
        ENG.put(90, "ninety");
        ENG.put(100, "one hundred");
       
        switch(idioma) {
            case "ESP":
                return ESP;
            case "ENG":
                return ENG;
        }
        
        return null;
    }
    
    
    public static String ConvertirNum(int n, String idioma, HashMap<Integer, String> textos) {
        String num;
        String decena = "";
        String conector = "";
        
        if (n<=15 || n%10==0) num = textos.get(n);
        else {
            decena = textos.get(n-n%10);
            num = textos.get(n%10);
            
            switch (idioma) {
                case "ESP":
                    switch (decena) {
                        case "diez":
                            decena = "dieci";
                        break;
                        case "veinte":
                            decena = "veinti";
                        break;
                        default:
                        conector = " y ";
                    }
                break;
                case "ENG":
                    switch (decena) {
                        case "ten":
                            if (num.equals("eight")) num = "eigh";
                            decena = num;
                            num = "teen";
                        break;
                        default:
                        conector = " ";
                    }
            }
            
        }
        
        return  decena+conector+num;
    }
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("SUMA MENOR A 100 DE NUMEROS NATURALES");
        System.out.println("SUM LESS THAN 100 OF NATURAL NUMBERS");
        System.out.println();
        
        System.out.println("Ingrese un numero menor o igual que 100 / Enter a number less than or equal to 100");
        int n1;
        do {
            System.out.print("num1: ");
           n1 = sc.nextInt();
        } while (n1<0 || n1>100 );
        
        int hasta100 = 100-n1;
        System.out.println("Ingrese un numero menor o igual que "+hasta100+" / Enter a number less than or equal to "+hasta100);
        int n2;
        do {
            System.out.print("num2: ");
            n2 = sc.nextInt();
        } while (n2<0 || n2>hasta100);
        
        int sum = n1+n2;
        
        String idioma = "ESP";
        System.out.println(ConvertirNum(n1, idioma, ObtenerTextos(idioma))+" mas "+ConvertirNum(n2, idioma, ObtenerTextos(idioma))+" es igual a "+ConvertirNum(sum, idioma, ObtenerTextos(idioma)));
        
        idioma = "ENG";
        System.out.println(ConvertirNum(n1, idioma, ObtenerTextos(idioma))+" plus "+ConvertirNum(n2, idioma, ObtenerTextos(idioma))+" equals "+ConvertirNum(sum, idioma, ObtenerTextos(idioma)));
        
        
    }
    
}