/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficos.so;

import java.util.ArrayList;

/**
 *
 * @author moiseslaris
 */
public class Ajustes {
    private int MemoriaT,CuantosT,MemoriaP,CuantoEj,Tiempo;
    private int index,vamos,id,tpc;
    private boolean h,e,entro;
    private ArrayList<Procesos> v; //= new ArrayList<Procesos>();
    private  ArrayList<Integer> c; //= new ArrayList<Integer>();
    private  ArrayList<Integer> t;// = new ArrayList<Integer>();
    private int Atendidos,Procesos,Memoria,Tcuantos,Porcentaje,cont,auxi,TiempoTotal; //Variables para las estadisticas

    public Ajustes() {
        this.MemoriaT = 0;
        this.CuantosT = 0;
        this.MemoriaP = 0;
        this.CuantoEj = 0;
        this.Tiempo = 0;
        this.index = 0;
        this.vamos = 0;
        this.id = 0;
        this.tpc = 0;
        this.h = true;
        this.e = true;
        this.v = new ArrayList<Procesos>();
        this.c = new ArrayList<Integer>();
        this.t = new ArrayList<Integer>();
        this.Atendidos = 0;
        this.Procesos = 0;
        this.Memoria = 0;
        this.Tcuantos = 0;
        this.Porcentaje = 0;
        this.cont = 0;
        this.auxi = 0;
        this.TiempoTotal = 0;
        entro=false;
    }

    public void setMemoriaT(int MemoriaT) {
        this.MemoriaT = MemoriaT;
    }

    public void setCuantosT(int CuantosT) {
        this.CuantosT = CuantosT;
    }

    public void setMemoriaP(int MemoriaP) {
        this.MemoriaP = MemoriaP;
    }

    public void setCuantoEj(int CuantoEj) {
        this.CuantoEj = CuantoEj;
    }

    public void setTiempo(int Tiempo) {
        this.Tiempo = Tiempo;
    }

    public int getTiempo() {
        return Tiempo;
    }

    public int getMemoriaT() {
        return MemoriaT;
    }

    public int getCuantosT() {
        return CuantosT;
    }

    public int getMemoriaP() {
        return MemoriaP;
    }

    public int getCuantoEj() {
        return CuantoEj;
    }

    public ArrayList<Procesos> getV() {
        return v;
    }

    public ArrayList<Integer> getT() {
        return t;
    }

    public int getPorcentaje() {
        return Porcentaje;
    }

    public int getCont() {
        return cont;
    }
    

    public int getVamos() {
        for(int i=0;i<v.size()-1;i++)
            if(v.get(i).getId()==c.get(0)&&c.isEmpty()==false)
                vamos=i;
            else
                vamos=-1;
         
        return vamos;
    }

    
    
    
    
    
    
    public void agregar3(int a,int b){
        entro=false;
        
        boolean bo=true;
        int u=0;
        int menor=0;
        if(h==true){
            Procesos aux=new Procesos();
            aux.setId(id);
            aux.setMemoria(MemoriaT);        
            aux.setCuantos(0);
            v.add(aux);
            id++;  
            h=false;
            imprimir();
        }else{
            for(int i=0;i<v.size();i++){ //Checar si no hay mas nodos
                if(v.get(i).getId()==0&&a<v.get(i).getMemoria()){
                        u=i;
                        bo=false;    
                        menor=v.get(i).getMemoria();
                        break;
                }
            }
            if(bo==false){
                Procesos++;
                Memoria+=a;
                if(menor==a){ 
                    v.get(u).setMemoria(a);
                    v.get(u).setCuantos(b);
                    v.get(u).setId(id);
                }else{
                    Procesos e=new Procesos();
                    v.add(e);
                    for(int i=v.size()-1;i>u;i--){
                        v.set(i, v.get(i-1)); //Recorremos el vector y despues asignamos memoria
                    }
                    Procesos aux=new Procesos();
                    aux.setId(id);
                    aux.setMemoria(a);        
                    aux.setCuantos(b);
                    
                    v.set(u, aux);
                    v.get(u+1).setMemoria((menor-a));
                    id++;
                   
                    entro=true;
                    cola(v.get(u).getId());
                    //imprimir();
        
                }
            }
        }
    }
    
    
    public void agregar2(int a,int b){
        entro=false;
        int menor;
        menor = 0;
        boolean bo=true;
        int u=0;
        if(h==true){
            Procesos aux=new Procesos();
            aux.setId(id);
            aux.setMemoria(MemoriaT);        
            aux.setCuantos(0);
            v.add(aux);
            id++;  
            h=false;
            imprimir();

        }else{
            for(int i=0;i<v.size();i++){ //Checar si no hay mas nodos
                if(v.get(i).getId()==0&&a<v.get(i).getMemoria()){
                    if(menor<v.get(i).getMemoria()){
                        menor=v.get(i).getMemoria();
                        u=i;
                        bo=false;
                    }
                }
            }
            if(bo==false){
                 Procesos++;
                 Memoria+=a;
                if(menor==a){ 
                    v.get(u).setMemoria(a);
                    v.get(u).setCuantos(b);
                    v.get(u).setId(id);
                }else{
                    Procesos e=new Procesos();
                    v.add(e);
                    for(int i=v.size()-1;i>u;i--){
                        v.set(i, v.get(i-1)); //Recorremos el vector y despues asignamos memoria
                    }
                    Procesos aux=new Procesos();
                    aux.setId(id);
                    aux.setMemoria(a);        
                    aux.setCuantos(b);
                    
                    v.set(u, aux);
                    v.get(u+1).setMemoria((menor-a));
                    id++;
                    //System.out.println("Entra proceso ["+v.get(u).getId()+" , "+v.get(u).getMemoria()+" , "+v.get(u).getCuantos()+"]");
                    
                    entro=true;
                    cola(v.get(u).getId());                    
                  
            //Ejecuta
                }
            }
        }
    }
    
    
    public void agregar(int a,int b){
        entro = false;
        
        int menor;
        menor = 99999999;
        boolean bo=true;
        int u=0;
        if(h==true){
            Procesos aux=new Procesos();
            aux.setId(id);
            aux.setMemoria(MemoriaT);        
            aux.setCuantos(0);
            v.add(aux);
            id++;  
            h=false;
            
            
        }else{
            for(int i=0;i<v.size();i++){ //Checar si no hay mas nodos
                if(v.get(i).getId()==0&&a<v.get(i).getMemoria()){
                    if(menor>v.get(i).getMemoria()){
                        menor=v.get(i).getMemoria();
                        u=i;
                        bo=false;
                    }
                }
            }
            if(bo==false){
                Procesos++;
                Memoria+=a;
                
                e=true;
                if(menor==a){ 
                    v.get(u).setMemoria(a);
                    v.get(u).setCuantos(b);
                    v.get(u).setId(id);
                }else{
                    Procesos e=new Procesos();
                    v.add(e);
                    for(int i=v.size()-1;i>u;i--){
                        v.set(i, v.get(i-1)); //Recorremos el vector y despues asignamos memoria
                    }
                    Procesos aux=new Procesos();
                    aux.setId(id);
                    aux.setMemoria(a);        
                    aux.setCuantos(b);
                    
                   
                    v.set(u, aux);
                    v.get(u+1).setMemoria((menor-a));
                    id++;
                    
                    entro=true;
                    System.out.println("Entra proceso ["+v.get(u).getId()+" , "+v.get(u).getMemoria()+" , "+v.get(u).getCuantos()+"]");
                    imprimir();
                    
                              
                    cola(v.get(u).getId());
        
                }
            }
        }
    }
    
   
    
    
    public void cola(int n){    
        c.add(n);  
    }
    
    public boolean in(){
        return entro;
    }
    
    
    public void checar(){
        if(index>=v.size()-1)
            index=0;
        if(v.get(index).getCuantos()==0){
            index++;
            if(index>=v.size()-2)
                index=0;
        }
            
    }
    
    public void moverCola(){
        int aux;
        aux=c.get(0);
                
        for(int i=0;i<c.size()-1;i++){
            c.set(i, c.get(i+1)); //Recorremos el vector y despues asignamos memoria
        }
        c.set(c.size()-1, aux);
    }
    
    public void ejecutar(){
        int punt;
        
        //System.out.println(c); //Imprimir cola.......
        for(int i=0;i<v.size()-1;i++){
            if(v.get(i).getId()==c.get(0)&&c.isEmpty()==false){
                System.out.println("Cargando...");
                System.out.println("Ejecutando [ "+v.get(i).getId()+" , "+v.get(i).getMemoria()+" , "+v.get(i).getCuantos()+" ]");            
                System.out.println("Descargando...");
                
             
                tpc+=CuantoEj+4;
                v.get(i).decrementar(CuantoEj);
                //imprimir();
                if(v.get(i).getCuantos()==0){
                    tpc++;
                    Atendidos++;
                    EndProc(i); //Manda a un vector el tiempo por cada proceso y cuanto tardo en acabar 
                    c.remove(0);
                    //Tiempo--;
                    v.get(i).setId(0);   
                    imprimir();
                    juntar();
                    
                }
                else
                    moverCola();
                break;
            }
            
        }
        //System.out.println(c);
        
        
    }
    
   
    
    public void juntar(){
        boolean b=true;
        int total=0,juntos=0;
        int pointer=0,pointer2=0;
        

        
        for(int i=0;i<v.size();i++){
            if(v.get(i).getCuantos()==0&&b==true){
                pointer=i;
                b=false;
                juntos++;
            }else if(v.get(i).getCuantos()==0){
                juntos++;  
                if(juntos==v.size())
                    pointer2=i;
                else if(juntos>1&&i==v.size()-1)
                    pointer2=i;
            }else if(v.get(i).getCuantos()!=0){
                if(juntos>1){
                    pointer2=i-1;
                    break;
                }else{
                    juntos=0;
                    b=true;
                }
            }
                        
        }
            if(juntos>1){ //Significa que se va a juntar
                for(int j=pointer;j<=pointer2;j++){ //Checar codigo de juntar
                    total+=v.get(j).getMemoria();
                }
                //System.out.println(total); //****************** imprmir total de memoria
                v.get(pointer).setMemoria(total);
                for(int i=pointer2;i>pointer;i--)
                    v.remove(i);  
               //imprimir();
               //Tiempo--;
               tpc++;           
            }
    }
    
    public void imprimir(){
        for(int i=0;i<v.size();i++)
            System.out.print("["+v.get(i).getId()+" , "+v.get(i).getMemoria()+" , "+v.get(i).getCuantos()+"]");
        System.out.println();
    }
    
    public void porcentaje(){
        cont++;
                    auxi=0;
                    for(int i=0;i<v.size();i++)
                        if(v.get(i).getId()!=0)
                        auxi+=v.get(i).getMemoria();
               auxi=auxi*100/MemoriaT;
               Porcentaje+=auxi;
    }
    
    public void time(){
        Tiempo-=tpc;
        for(int i=0;i<v.size();i++){
           v.get(i).at(tpc);
        }
        tpc=0;
    }
    
    public void EndProc(int i){
        v.get(i).at(tpc);
        t.add(v.get(i).getTiempo());
    }
    
    public float TM(){
        int suma=0;
        for(int i=0;i<t.size();i++)
            suma+=t.get(i);
        return suma/t.size();
    }
}
