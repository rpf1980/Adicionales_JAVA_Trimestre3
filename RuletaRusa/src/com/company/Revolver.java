package com.company;

import java.util.Random;

//Revolver:
//    //Atributos:
//    //posición actual (posición del tambor donde se dispara, puede que esté la bala o no)
//    //posición bala (la posición del tambor donde se encuentra la bala)
//    //Estas dos posiciones, se generaran aleatoriamente.
//    //
//    //Metodos:
//    //disparar(): devuelve true si la bala coincide con la posición actual
//    //siguienteBala(): cambia a la siguiente posición del tambor
//    //toString(): muestra información del revolver (posición actual y donde está la bala)

public class Revolver
{
    //Atributos
    private int posicionActual;
    private int posicionBala;

    //Constructor
    public Revolver ()
    {
        Random rd = new Random();
        this.posicionActual=rd.nextInt(6)+1;
        this.posicionBala=rd.nextInt(6)+1;
    }

    //Metodos
    public boolean dispara()
    {
        boolean respuesta=false;
        //Dispara el revolver
        if (this.posicionBala==this.posicionActual)
        {
            respuesta= true; //Alguien va a morir
        }
        siguienteBala();

        return respuesta;
    }
    public void  siguienteBala ()
    { //Cambia a la siguiente posición
        if (this.posicionActual==6)
        {
            this.posicionActual=1;
        }
        else
        {
            this.posicionActual=this.posicionActual+1;
        }
    }

    public String toString ()
    {
        return "La posición del tambor donde se dispara es "+this.posicionActual+ " la posición del tambor donde se encuentra la bala es "+this.posicionBala+".";
    }

}
