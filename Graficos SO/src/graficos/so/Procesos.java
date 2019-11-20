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
public class Procesos {
    private int memoria,id,cuantos,tiempo;

    public Procesos() {
        this.cuantos=0;
        this.id=0;
        this.memoria=0;
        this.tiempo=0;
    }

    public Procesos(int memoria, int id, int cuantos) {
        this.memoria = memoria;
        this.id = id;
        this.cuantos = cuantos;
    }
    
    public void decrementar(){
        this.cuantos--;
    }
    
    public void decrementar(int n){
        this.cuantos-=n;
        if(this.cuantos<0)
            this.cuantos=0;    
    }
    
    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCuantos() {
        return cuantos;
    }

    public void setCuantos(int cuantos) {
        this.cuantos = cuantos;
    }
    
    public void at(int t){ //agregar tiempo
        this.tiempo+=t;
    }

    public int getTiempo() {
        return tiempo;
    }
    
    
}
