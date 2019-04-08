package com.company;

import java.security.InvalidParameterException;
import java.util.Random;

public class Dado
{
    //Atributos
    private int numeroCaras;

    //Constructores
    public Dado()
    {
        this.numeroCaras = 10;
    }

    public Dado(int n)
    {
        switch (n)
        {
            case 2:
            case 4:
            case 6:
            case 8:
            case 10:
            case 12:
            case 20:
            case 100:
                this.numeroCaras = n;
                break;
            default:
                n = -1;
                System.out.println("El número de caras no es válido");
                break;
        }
    }

    //Propiedades
    public int getNumeroCaras()
    {
        return this.numeroCaras;
    }

    //Métodos
    public int tirada()
    {
        Random rd = new Random();
        int lanzada;

        lanzada = rd.nextInt(this.numeroCaras)+1;

        return lanzada;
    }

    public void sumaTiradas(int n)
    {
        int resultado = 0;
        int sumaResultados = 0;
        int i;

        for(i = 1; i <= n; i++)
        {
            resultado = tirada();
            System.out.println("Tirada " + i +" = "+ resultado);
            sumaResultados += resultado;
        }
        System.out.print("PUNTUACIÓN = " + sumaResultados);
    }

    public int tiradaMultiple(int n, int tope)
    {
        int tiradasValidas = 0;
        Random rd = new Random();
        int tirada;
        int i;

        for(i = 1; i <= n; i++)
        {
            tirada = tirada();
            System.out.println("TIRADA " + i + " = " + tirada);

            if(tirada >= tope)
            {
                tiradasValidas++;
            }

        }

        return tiradasValidas;
    }

    /*public int tiradaMultipleEspecial(int n, int tope)
    {
        int tiradasValidas = 0;
        Random rd = new Random();
        int tirada;
        int contadorMin = 0;
        int contadorMax = 0;
        int i;

        for(i = 1; i <= n; i++)
        {
            tirada = tirada();

            System.out.println("TIRADA " + i + " = " + tirada);
            if(tirada >= tope)
            {
                tiradasValidas++;
            }
            else
            {
                if(tirada == 1)
                {
                    contadorMin++;
                    tiradasValidas = tiradasValidas - contadorMin;
                }
                else
                {
                    if(tirada == this.numeroCaras)
                    {
                        contadorMax++;
                        tiradasValidas = tiradasValidas + contadorMax;

                        tirada = tirada(); //Si la tirada es el valor máximo (this.numeroCaras), volvemos a tirar el dado
                    }
                }
            }

        }

        return tiradasValidas;
    }*/

    public int tiradaMultipleEspecial(int n, int tope)
    {
        int tiradasValidas = 0;
        Random rd = new Random();
        int tirada;
        int i;

        for(i = 1; i <= n; i++)
        {
            tirada = tirada();
            System.out.println("Tirada " + i + " = " + tirada);

            if(tirada >= tope && (tirada != 1 || tirada != this.numeroCaras))
            {
                tiradasValidas++;
            }
            else
            {
                if(tirada == 1)
                {
                    tiradasValidas = tiradasValidas - 1;
                }
                else
                {
                    if(tirada == this.numeroCaras)
                    {
                        tiradasValidas = tiradasValidas + 1;

                        tirada = tirada();
                    }
                }
            }
        }
        return tiradasValidas;
    }
}


