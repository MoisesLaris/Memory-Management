/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos.so;

/**
 *
 * @author moiseslaris
 */
public class Lista {
    private int memoria,cuantos;

    public Lista(int a, int b){
        this.memoria=a;
        this.cuantos=b;
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public int getCuantos() {
        return cuantos;
    }

    public void setCuantos(int cuantos) {
        this.cuantos = cuantos;
    }
    
    
}
