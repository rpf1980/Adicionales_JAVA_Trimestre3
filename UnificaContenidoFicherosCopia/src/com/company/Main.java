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

        nombreFicheroDestino="C.txt";
        try
        {
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

            for (i=0;i<lista.size();i++)
            {
                bw.write(lista.get(i));
                bw.newLine();
            }

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
        copiarDosFicheroEnUno("D:\\DAW_1\\fichero1.txt","D:\\fichero2.txt","D:\\DESTINO\\");
    }
}

