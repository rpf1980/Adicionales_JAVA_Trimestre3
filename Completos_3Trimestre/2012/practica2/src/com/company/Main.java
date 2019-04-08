package com.company;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Dado d = new Dado();

        Scanner sc = new Scanner(System.in);
        System.out.println("============");
        System.out.println("MÉTODOS DADO");
        System.out.println("============");
        System.out.println("[1] TIRADA");
        System.out.println("[2] SUMA TIRADAS");
        System.out.println("[3] TIRADA MÚLTIPLE");
        System.out.println("[4] TIRADA MÚLTIPLE ESPECIAL");
        System.out.println("============================");
        System.out.println();
        System.out.print("Elige una opción: ");
        int opcion = sc.nextInt();

        switch (opcion)
        {
            case 1:
            {
                //tirada

                int tirada = d.tirada();

                System.out.print("TIRADA = " + tirada);
            }
            break;

            case 2:
            {
                //sumaTiradas

                d.sumaTiradas(10);
            }
            break;

            case 3:
            {
                //tiradaMultiple

                int aciertos = d.tiradaMultiple(20, 9);

                System.out.println("Número de aciertos = " + aciertos);
            }
            break;

            case 4:
            {
                //tiradaMultipleEspecial

                int aciertos = d.tiradaMultipleEspecial(20, 9);

                System.out.println("Nº aciertos especiales = " + aciertos);
            }
            break;
        }
    }
}

