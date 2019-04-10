package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{
    public static void copiarDosFicheroEnUno (String rutaFichero1, String rutaFichero2, String rutaDestino)
    {
        String linea, linea2, nombreFicheroDestino;
        List <String> lista = new ArrayList<>();
        int i;

        String[] arrayRutaFichero1 = rutaFichero1.split("\\\\");
        String[] arrayRutaFichero2 = rutaFichero2.split("\\\\");
        String nombreFichero1 = arrayRutaFichero1[arrayRutaFichero1.length-1]; //Guardamos nombre completo del fichero1 (fichero1.txt)
        String nombreFichero2 = arrayRutaFichero2[arrayRutaFichero2.length-1]; //Guardamos nombre completo del fichero2 (fichero2.txt)

        int pos = nombreFichero1.indexOf('.');

        String soloNombre1 = nombreFichero1.substring(0, pos); //Gurdamos solo el nombre sin extensión (fichero1)
        String soloNombre2 = nombreFichero2.substring(0, pos); //Gurdamos solo el nombre sin extensión (fichero2)


        nombreFicheroDestino=soloNombre1 + "_" + soloNombre2 + ".txt"; //Nombre completo de nuestro fichero copia
        try
        {
            //Leemos primer fichero y copiamos contenido en una lista
            FileReader fr = new FileReader(rutaFichero1);
            BufferedReader br = new BufferedReader(fr);

            linea=br.readLine();

            while (linea!=null)
            {
                lista.add(linea);
                linea=br.readLine();
            }

            br.close();
            fr.close();

            //Leemos segundo fichero y guardamos contenido en la lista
            FileReader fr2 = new FileReader(rutaFichero2);
            BufferedReader br2 = new BufferedReader(fr2);

            linea2=br2.readLine();

            while (linea2!=null)
            {
                lista.add(linea2);
                linea2=br2.readLine();
            }

            br2.close();
            fr2.close();

            FileWriter fw = new FileWriter(rutaDestino+nombreFicheroDestino);
            BufferedWriter bw = new BufferedWriter(fw);

            //Recorremos la lista que contiene los datos de los dos ficheros y lo copiamos en el fichero de destino
            for(String s:lista)
            {
                bw.write(s);
                bw.newLine();
            }
            /*for (i=0;i<lista.size();i++)
            {
                bw.write(lista.get(i));
                bw.newLine();
            }*/

            bw.close();
            fw.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        copiarDosFicheroEnUno("D:\\varios\\fichero1.txt","D:\\videos\\fichero2.txt","D:\\destinoCOPIA\\");
    }
}
