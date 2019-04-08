package com.company;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("====================================================");
        System.out.println("CONVERSOR DECIMAL A HEXADECIMAL || DECIMAL A BINARIO");
        System.out.println("====================================================");
        System.out.println("[1] BINARIO");
        System.out.println("[2] HEXADECIMAL");
        System.out.println("===========");
        System.out.println();
        System.out.print("Elige una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        System.out.println();

        switch (opcion)
        {
            case 1:
            {
                System.out.print("Escribe nº: ");
                int n = sc.nextInt();

                System.out.print("Binario de " + n + " = ");
                System.out.println(Integer.toBinaryString(n));
            }
            break;

            case 2:
            {
                System.out.print("Escribe nº: ");
                int n = sc.nextInt();

                System.out.print("Hexadecimal de " + n + " = ");
                System.out.println(Integer.toHexString(n));
            }
            break;

        }

    }
}

