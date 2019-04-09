package com.company;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class Main
{

    public static void copiaFichero(String ficheroOrigen, String ficheroDestino)
    {
        try
        {
            Files.copy(Path.of(ficheroOrigen), Path.of(ficheroDestino));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void copiaFicherosPorExtension(String directorioOrigen, String rutaFicheroCopia, String extension)
    {
        try
        {
            File dir = new File(directorioOrigen);
            File[] listado = dir.listFiles();
            String nombreFichero = "";
            String rutaCompletaFichero = "";
            List<String> listaNombresValidos = new ArrayList<>();
            int i, j;

            //Este for copia los archivos del listado en una lista
            for(i = 0; i < listado.length; i++)
            {
                if(listado[i].isFile())
                {
                    nombreFichero = listado[i].getName();

                    listaNombresValidos.add(nombreFichero);
                }
                else
                {
                    if(listado[i].isDirectory())
                    {
                        copiaFicherosPorExtension(listado[i].getAbsolutePath(), rutaFicheroCopia, extension);
                    }
                }

                for(j = 0; j < listaNombresValidos.size(); j++)
                {
                    String nomFich = listado[i].getName();

                    if(listado[i].getName().equals(listaNombresValidos.get(j)))
                    {
                        copiaFichero(listado[i].getAbsolutePath(), rutaFicheroCopia + nomFich + "-COPIA" + extension);
                    }
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
        //copiaFichero("D:\\ACER.txt", "D:\\varios\\mayo.txt");
        copiaFicherosPorExtension("D:\\ORIGEN\\", "D:\\DESTINO\\", ".txt");
    }
}
