package com.company;
////Juego:
//    //Atributos:
//    //Jugadores (conjunto de Jugadores)
//    //Revolver
//    //Metodos:
//    //finJuego(): cuando un jugador muere, devuelve true
//    //ronda(): cada jugador se apunta y se dispara, se informara del estado de la partida (El jugador se dispara, no ha muerto en esa ronda, etc.)
public class Juego
{
    //Atributos
    private Jugador [] jugadores;
    private Revolver revolver;

    //Constructor
    public Juego (int nJugadores)
    {
        this.jugadores= new Jugador[comprobarJugadores(nJugadores)];
        crearJugadores();
        this.revolver = new Revolver();
    }

    //Metodos Privado
    private int comprobarJugadores(int nJugadores)
    {
        //Sino esta en el rango correcto se pone a 6
        if (!(nJugadores >= 1 && nJugadores <= 6))
        {
            nJugadores = 6;
        }

        return nJugadores;
    }

    //Crea los jugadores
    private void crearJugadores()
    {
        for (int i = 0; i < this.jugadores.length; i++)
        {
            this.jugadores[i] = new Jugador(i + 1);
        }
    }

    //Metodos
    public boolean finJuego ()
    {
        boolean respuesta= false; //sigue el juego
        int i;

        for (i=0;i<this.jugadores.length;i++)
        {
            if (!this.jugadores[i].estaVivo())
            {
                respuesta = true; //termina el juego
            }

        }
        return respuesta;
    }

    public void ronda()
    {
        for (int i = 0; i < this.jugadores.length; i++) {
            //El jugador se dispara
            this.jugadores[i].dispara(this.revolver);
        }

    }

    //Realiza una ronda (si muere algun jugador, los siguientes no participan)
    public void rondaV2() {

        for (int i = 0; i < this.jugadores.length; i++)
        {
            this.jugadores[i].dispara(this.revolver);
            //Si muere, terminamos
            if(!this.jugadores[i].estaVivo())
            {
                return;
            }
        }

    }
}
