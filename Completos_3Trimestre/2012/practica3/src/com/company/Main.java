package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main
{
    //Con esta función obtenemos el trozo que tenemos que hacer subtring
    //para hacer poder copiar en limpio (backup_0008, backup_0022, backup_0123)
    public static int recortaConSubtring(int incremento)
    {
        int subtring = 0;

        if(incremento >= 0 && incremento <= 9)
        {
            subtring = 1;
        }
        else
        {
            if(incremento >= 10 && incremento <= 99)
            {
                subtring = 2;
            }
            else
            {
                if(incremento >= 100 && incremento <= 999)
                {
                    subtring = 3;
                }
                else
                {
                    if(incremento >= 1000 && incremento <= 9999)
                    {
                        subtring = 4;
                    }
                }
            }
        }

        return subtring;
    }

    public static void autoBacKup(String fichero)
    {
        //Variables
        String copia = "backup_000";
        int incremento = 1;
        int i;
        String castingIncremento = "";  //usaremos para almacenar la conversión del valor entero del incremento a string
        int subtring; //variable que devuleve dato entero del método recortaConSubtring
        String subtring999 = ""; //almacenará trozo generado en copia con el valor "backup"

        try
        {
            //Listado de ficheros en actual
            File dir = new File(".");
            File[] listado = dir.listFiles();

            //Primero si existe o no el fichero en el directorio actual
            if(Files.exists(Path.of(fichero)))
            {

                copia = copia + String.valueOf(incremento);
                subtring999 = copia.substring(0, 6); //obtenemos un substring desde 0 hasta encontrar el caracter '_'

                while(Files.exists(Path.of(copia)))
                {
                    incremento++; //incremento aquí es un entero

                    if(incremento == 9999) //Si el incremento llega a 9999 se resetea y vuelve a empezar en 1
                    {
                        incremento = 1;
                    }
                    else
                    {
                        castingIncremento = String.valueOf(incremento); //incremento aquí es un string

                        subtring = recortaConSubtring(incremento);

                        copia = copia.substring(0, copia.length()-subtring);
                        copia = copia + String.valueOf(incremento);
                    }
                }

                Files.copy(Path.of(fichero), Path.of(copia));
            }
            else
            {
                if(!Files.exists(Path.of(subtring999)))
                {
                    System.out.println("No se encontró el archivo buscado, ni alguno con nombre backup");
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        autoBacKup("survival_1.txt");
    }
}
