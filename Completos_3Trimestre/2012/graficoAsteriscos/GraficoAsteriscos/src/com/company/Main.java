package com.company;

import java.io.BufferedReader;
import java.io.FileReader;

public class Main
{
    public static void pintaCaracteres(char c, int n)
    {
        for(int i = 0; i < n; i++)
        {
            System.out.print(c);
        }
    }

    public static void graficoAsteriscos(String fichero)
    {
        String linea;
        String[] trozos;
        int[] arrayEnteros;
        int[] contador = new int[10];
        String[] rangos = {"00-09: ", "10-19: ", "20-29: ", "30-39: ", "40-49: ", "50-59: ", "60-69: ", "70-79: ", "80-89: ", "90-99: "};
        int i;

        try
        {
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);

            linea = br.readLine();

            while(linea != null)
            {
                //Pasamos la línea del fichero(contiene todos los nº's
                //en esa única línea) a un array de String
                trozos = linea.split(" ");
                arrayEnteros = new int[trozos.length];

                //Con el for hacemos toda la conversión de tipos de datos (String a int)
                for(i = 0; i < trozos.length; i++)
                {
                    arrayEnteros[i] = Integer.parseInt(trozos[i]);
                }

                linea = br.readLine();

                //Con este for tenemos el arrayContador con todas las veces que se cumplen las condiciones de los nº's
                for(i = 0; i < arrayEnteros.length; i++)
                {
                    if(arrayEnteros[i] >= 0 && arrayEnteros[i]<= 9)
                    {
                        contador[0]++;
                    }
                    else
                    {
                        if(arrayEnteros[i] >= 10 && arrayEnteros[i] <= 19)
                        {
                            contador[1]++;
                        }
                        else
                        {
                            if(arrayEnteros[i] >= 20 && arrayEnteros[i] <= 29)
                            {
                                contador[2]++;
                            }
                            else
                            {
                                if(arrayEnteros[i] >= 30 && arrayEnteros[i] <= 39)
                                {
                                    contador[3]++;
                                }
                                else
                                {
                                    if(arrayEnteros[i] >= 40 && arrayEnteros[i] <= 49)
                                    {
                                        contador[4]++;
                                    }
                                    else
                                    {
                                        if(arrayEnteros[i] >= 50 && arrayEnteros[i] <= 59)
                                        {
                                            contador[5]++;
                                        }
                                        else
                                        {
                                            if(arrayEnteros[i] >= 60 && arrayEnteros[i] <= 69)
                                            {
                                                contador[6]++;
                                            }
                                            else
                                            {
                                                if(arrayEnteros[i] >= 70 && arrayEnteros[i] <= 79)
                                                {
                                                    contador[7]++;
                                                }
                                                else
                                                {
                                                    if(arrayEnteros[i] >= 80 && arrayEnteros[i] <= 89)
                                                    {
                                                        contador[8]++;
                                                    }
                                                    else
                                                    {
                                                        if(arrayEnteros[i] >= 90 && arrayEnteros[i] <= 99)
                                                        {
                                                            contador[9]++;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }

                        }
                    }
                }

                for(i = 0; i < contador.length; i++)
                {
                    System.out.print(rangos[i]);
                    pintaCaracteres('*', contador[i]);
                    System.out.println();
                }

            }

            br.close();
            fr.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        graficoAsteriscos("numeros.txt");
    }
}

