package com.company;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Dado d = new Dado(20);

        Scanner sc = new Scanner(System.in);
        System.out.println("==============");
        System.out.println("JUEGO DE DADOS");
        System.out.println("==============");
        System.out.println("[1] TIRA DADO");
        System.out.println("[2] SUMA TIRADAS");
        System.out.println("[3] DAME NÚMERO DEL DADO");
        System.out.println("[4] TIRADA ESPECIAL");
        System.out.println("===================");
        System.out.println();
        System.out.print("Elige una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion)
        {
            case 1:
            {
                int n = d.tirada();
                System.out.println("TIRADA = " + n);
            }
            break;

            case 2:
            {
                System.out.print("Escribe número de tiradas = ");
                int tiradas = sc.nextInt();

                int suma = d.sumaTiradas(tiradas);
                System.out.println("TOTAL PUNTOS = " + suma);
            }
            break;

            case 3:
            {

                int n = d.getNumeroCaras();

                System.out.println("Juegas con un dado de " + n + " caras.");
            }
            break;

            case 4:
            {
                System.out.print("Escribe número de tiradas = ");
                int tiradas = sc.nextInt();
                System.out.print("Escribe valor tope = ");
                int valorTope = sc.nextInt();

                d.tiradaMultipleEspecial(tiradas, valorTope);
            }
            break;
        }
    }
}
