package com.company;

import java.security.InvalidParameterException;
import java.util.Random;

public class Dado
{
    //Atributos
    private int numeroCaras;

    //Constructor
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
                System.out.println("Número de caras no válido");
                break;
        }
    }

    //Propiedad
    public int getNumeroCaras()
    {
        return this.numeroCaras;
    }

    //Métodos
    public int tirada()
    {
        Random rd = new Random();
        int n;

        n = rd.nextInt(this.numeroCaras)+1;

        return n;
    }

    public int sumaTiradas(int n)
    {
        int tirada;
        int i, suma;
        suma=0;

        for (i = 1; i <= n ;i++)
        {
            tirada = tirada();
            System.out.println("TIRADA " + i + " = " + tirada);

            suma=suma+tirada;
        }

        return suma;
    }

    public int tiradaMultiple(int n, int tope)
    {
        int aciertos = 0;
        int tirada;
        int i;

        for(i = 1; i <= n; i++)
        {
            tirada = tirada();
            System.out.println("Tirada " + i + " = " + tirada);

            if(tirada >= tope)
            {
                aciertos++;
            }
        }

        return aciertos;
    }

    public void tiradaMultipleEspecial(int n, int tope)
    {
        int aciertos = 0;
        int tirada;
        int i;

        for(i = 1; i <= n; i++)
        {
            tirada = tirada();
            System.out.println("Tirada " + i + " = " + tirada);

            if(tirada >= tope && (tirada != 1 && tirada != this.numeroCaras))
            {
                aciertos++;
            }
            else
            {
                if(tirada == 1)
                {
                    aciertos = aciertos - 1;
                }
                else
                {
                    if(tirada == 10)
                    {
                        aciertos = aciertos + 1;
                        tirada = tirada();
                    }
                }
            }
        }

        System.out.println("ACIERTOS = " + aciertos);
    }
}

