package com.company;
////Jugador:
//    //Atributos
//    //id (representa el número del jugador, empieza en 1)
//    //nombre (Empezara con Jugador más su ID, “Jugador 1” por ejemplo)
//    //vivo (indica si está vivo o no el jugador)
//    //Funciones:
//    //disparar(Revolver r): el jugador se apunta y se dispara, si la bala se dispara, el jugador muere.
public class Jugador
{
    //Atributos
    private int idJugador;
    private String nombre;
    private boolean vivo;

    //Constructor
    public Jugador (int idJugador)
    {
        this.idJugador=idJugador;
        this.nombre="Jugador"+this.idJugador;
        this.vivo=true;
    }
    //Metodos
    public void dispara (Revolver r)
    {
        System.out.println("El " + this.nombre + " se apunta con la pistola");

        //El jugador se pone el revolver y...
        if (r.dispara())
        {
            this.vivo=false;
            System.out.println("El " + nombre + " ha muerto..."); //muere
        }
        else
        {
            System.out.println("El " + nombre + " se ha librado..."); //No muere
        }
    }

    public boolean estaVivo()
    {
        return vivo;
    }

}
