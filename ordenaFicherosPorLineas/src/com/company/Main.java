package com.company;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static int digitosDeUnNumero(int n)
    {
        int i, numeroIntroducido;
        int numeroDigitos = 1;
        numeroIntroducido = n;

        i = numeroIntroducido;
        while (i > 10)
        {
            i /= 10;
            numeroDigitos++;
        }
        return numeroDigitos;
    }

    public static String PadLeft(String c, int longitud)
    {
        String cadena = c;
        int cantidadEspacios = longitud - c.length();
        int i;

        for (i = 0; i < cantidadEspacios; i++)
        {
            cadena = " " + cadena;
        }
        return cadena;
    }

    public static String PadRight(String c, int longitud)
    {
        String cadena = c;
        int cantidadEsapcios = longitud - c.length();
        int i;

        for (i = 0; i < cantidadEsapcios; i++)
        {
            cadena = cadena + " ";
        }
        return cadena;
    }

    public static int maxLista(List<Integer> lista)
    {
        int max = lista.get(0);
        int i;

        for(i = 0; i < lista.size(); i++)
        {
            if(lista.get(i) > max)
            {
                max = lista.get(i);
            }
        }

        return max;
    }

    public static int maxListaString(List<String> lista)
    {
        String elemento = lista.get(0);
        int max = elemento.length();
        int i;
        for(i = 0; i < lista.size(); i++)
        {
            if(lista.get(i).length() > max)
            {
                max = lista.get(i).length();
            }
        }

        return max;
    }

    public static int cuentaLineasFichero(String fichero)
    {
        String linea;
        int contador = 0;

        try
        {
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);

            linea = br.readLine();
            while(linea != null)
            {
                linea = br.readLine();
                contador++;
            }
            linea = br.readLine();

            br.close();
            fr.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return contador;
    }

    public static void printListadoBonito(List<String> listaNombres, List<Integer> listaEnteros)
    {
        for(int i = 0; i < listaEnteros.size(); i++)
        {
            System.out.println(PadRight(listaNombres.get(i), 12) + PadLeft(listaEnteros.get(i).toString(), 3));
        }
    }

    public static void ordenaFicheroPorLineas()
    {
        //Get.Directory(".",".txt"); en C#

        File dir = new File(".");
        File[] listado = dir.listFiles();
        String nombreFichero = "";
        int entero;
        int mayorDeLaLista;
        List<Integer> listaEnteros = new ArrayList<>();
        List<String> listaNombres = new ArrayList<>();
        List<Integer> listaEnterosOrdenada = new ArrayList<>();
        List<String> listaNombresOrdenada = new ArrayList<>();
        int i;

        for(i = 0; i < listado.length; i++)
        {
            nombreFichero = listado[i].getName();

            if(nombreFichero.endsWith(".txt"))
            {
                entero = cuentaLineasFichero(nombreFichero);
                listaEnteros.add(entero);
                listaNombres.add(nombreFichero);
            }
        }

        //Añadimos elementos de las dos lista originales a las listas ordenadas
        for(int j = 0; j < listaEnteros.size(); j++)
        {
            mayorDeLaLista = maxLista(listaEnteros); //Aquí se obtiene el mayor de la lista
            int pos = listaEnteros.indexOf(mayorDeLaLista);

            listaEnterosOrdenada.add(mayorDeLaLista);
            listaNombresOrdenada.add(listaNombres.get(pos));

            listaEnteros.remove(pos);
            listaNombres.remove(pos);
            j--;
        }

        printListadoBonito(listaNombresOrdenada, listaEnterosOrdenada);

    }


    public static void main(String[] args)
    {
        ordenaFicheroPorLineas();
    }
}
