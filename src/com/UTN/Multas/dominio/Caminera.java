/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.UTN.Multas.dominio;

import java.util.ArrayList;

/**
 *
 * @author Fabricio
 */
public class Caminera {

    //private Multa multas[]; //Reemplazo el vector por un ArrayList (Lista dinamica de geometria variable)
   private ArrayList<Multa> multas;
    private int ultimaCarga;

    //public Caminera(int cantidad) {
        public Caminera() { //El parametro no es mas necesario
        //multas = new Multa[cantidad];
        multas = new ArrayList<>(); //Entre los parentesis puedo agregar una cantidad inicial para que trabaje, en principio, como un vector y alcanzado ese maximo comienza a ampliar capacidad. En este caso inicio con una lista vacia
        //ultimaCarga = 0; //Al ser dinamico no es necesario chequear la ultima carga
    }

//    public boolean registrarMulta(Multa multa) { 
//        if (ultimaCarga < multas.length) {
//            multas[ultimaCarga] = multa;
//            return true;
//        }
//        return false;
//}
     
    public boolean registrarMulta(Multa multa) { //idem metodo anterior evitando (por buena practica) colocar dos return
//        boolean aux = false;
//        if (ultimaCarga < multas.length) {
//            multas[ultimaCarga] = multa;
//            ultimaCarga++;
//            aux = true;
//        }
        //return aux;
        if (multas.contains(multa)) {
            return false;
        }
        return multas.add(multa);
    }

    public float calcularTotal() {
        float aux = 0;
        //for each (sirve para vectores y arrays indistintamente, en el caso del for comun se reemplaso el length por el size)
        //En el caso de (por ejemplo) multas[i] se coloca multas.getu(i)
        for (Multa multa : multas) { 
            if (multa != null) {
                aux += multa.calcularMonto();
            }
        }
        return aux;
    }
    
    public int[] contabilizarCodigosMulta() {
        int conteo[] = new int[20];
        for (Multa multa : multas) {
            conteo[multa.getCodigo() - 1]++;
        }        
        return conteo;
    }
    
    public String mostrarMayorCodigo() {
        String aux = null;
        int mayor;
        int conteo[] = this.contabilizarCodigosMulta();
        int codigoMayor;
        
        mayor = conteo[0];
        codigoMayor = 1;
        for (int i = 1; i < conteo.length; i++) {
            if (conteo[i] > mayor) {
                codigoMayor = i + 1;
            }
        }     
        aux = "El codigo de infraccion mas frecuente es: " + codigoMayor 
                + " con: " + mayor + " actas labradas.";
        return aux;
    }
    
    public String mostrarMultas(){
        //String aux = ""; //Utilizamos la clase StringBuilder para evitar ocupar memoria innecesariamente con cadenas que se desreferencian y deben ser eliminadas por el garbadge collector
        StringBuilder aux = new StringBuilder("");
        for (Multa multa : multas) {
            if (multa != null) {
               //aux += multa.toString() + "\n";
               aux.append(multa.toString()).append("\n");
            }            
        }        
        //return aux;
        return aux.toString();
    }

}
