package com.company;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void idenficadorTiposFicheros(String fichero)
    {
        String tipoEXE = "4D5A9000";
        String tipoTXT = "68747470";
        String tipoM3U = "23455854";
        String tipoRar = "52617221";
        String tipoZip = "504B0304";
        String tipoExel = "504B0304";
        String tipoPowerPoint = "504B0304";
        String tipoDocTexto = "504B0304";
        String tipoIml = "3C3F786D";
        int n;

        try
        {
            FileInputStream fis = new FileInputStream(fichero);
            DataInputStream dis = new DataInputStream(fis);

            n = dis.readInt();

            String hexa = Integer.toHexString(n);
            hexa = hexa.toUpperCase();

            if(tipoEXE.equals(hexa))
            {
                System.out.println("Fichero tipo = .exe");
            }
            else
            {
                if(tipoTXT.equals(hexa))
                {
                    System.out.println("Fichero tipo = .txt");
                }
                else
                {
                    if(tipoM3U.equals(hexa))
                    {
                        System.out.println("Fichero tipo = .m3u");
                    }
                    else
                    {
                        if(tipoRar.equals(hexa))
                        {
                            System.out.println("Fichero tipo = .rar");
                        }
                        else
                        {
                            if(tipoZip.equals(hexa))
                            {
                                System.out.println("Fichero tipo = .zip");
                                System.out.println("Fichero tipo = .xlsx");
                                System.out.println("Fichero tipo = .pptx");
                                System.out.println("Fichero tipo = .odt");
                            }
                            else
                            {
                                if(tipoIml.equals(hexa))
                                {
                                    System.out.println("Fichero tipo = .iml");
                                }
                            }
                        }

                    }
                }
            }

            dis.close();
            fis.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        idenficadorTiposFicheros("identificaTipoFichero.iml");
    }
}

