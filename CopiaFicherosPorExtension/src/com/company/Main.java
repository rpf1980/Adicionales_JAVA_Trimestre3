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
            String rutaFicheroOrigen = "";
            String nombreFichero = "";
            List<String> listaNombresFicheros = new ArrayList<>();
            int i, j;

            //Primer for que nos copia los nombres de ficheros válidos en una lista
            for(i = 0; i < listado.length; i++)
            {
                if(listado[i].isFile())
                {
                    nombreFichero = listado[i].getName();

                    if(nombreFichero.endsWith(extension))
                    {
                        listaNombresFicheros.add(nombreFichero); //Lista con los nombres de ficheros válidos que quiero copiar
                    }
                }
            }

            //Volvemos a recorrer el listado de archivos en su directorio original
            for(i = 0; i < listado.length; i++)
            {
                //También iteramos en la lista
                for(j = 0; j < listaNombresFicheros.size(); j++)
                {
                    //Variable que sirve para ir tomando los nombres del listado
                    //Como la creamos y damos valor dentro... siempre irá machacando con el útlimo valor introducido
                    String nombreFich = listado[i].getName();

                    //Comparamos los nombres, y si son iguales los copiamos con la función copiaFichero
                    if(listado[i].getName().equals(listaNombresFicheros.get(j)))
                    {
                        copiaFichero(listado[i].getAbsolutePath(), rutaFicheroCopia + nombreFich + "-copia.txt");
                        //Vamos borrando el nombre de la lista para que no lo vuelva a considerar
                        listaNombresFicheros.remove(j);
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
        copiaFichero("D:\\ComandosGit.txt", "D:\\varios\\copialoYa.txt");
        //copiaFicherosPorExtension("D:\\","D:\\varios\\", ".txt");
    }
}
