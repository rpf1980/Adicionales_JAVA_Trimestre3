package com.company;

public class Main
{
    // Vamos a hacer el juego de la ruleta rusa en Java.
    //Como muchos sabéis, se trata de un número de jugadores que con un revolver con un sola bala en el tambor se dispara en la cabeza.
    //El número de jugadores será decidido por el usuario, pero debe ser entre 1 y 6. Si no está en este rango, por defecto será 6.
    //En cada turno uno de los jugadores, dispara el revólver, si este tiene la bala  el jugador muere y el juego termina.
    //Aunque no lo haya comentado, recuerda usar una clase ejecutable para probarlo.
    public static void main(String[] args)
    {
        Juego juego = new Juego(2);

        while( !juego.finJuego() ){
            juego.ronda();
            //juego.rondaV2();
        }

        System.out.println("El juego ha terminado");

    }
}

