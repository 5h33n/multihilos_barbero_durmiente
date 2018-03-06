/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package peluquero;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;

/**
 *
 * @author Oscar Eduardo López Guzmán (Sheen)
 * 01/11/2017
 */
public class Cliente implements Runnable{
    Bandera m;
    Barbero barbero;
    Barbero barbero1;
    JLabel stateBarBer;
    JLabel stateBarBer1;
    DefaultListModel waitingList;
    int posInList;
    
    public Cliente(Bandera m, Barbero b, Barbero b1, DefaultListModel waitingList, JLabel statusBarber, JLabel statusBarber1,int numCliente){
        
        barbero = b;
        barbero1 = b1;
        this.m = m;
        this.waitingList = waitingList;
        this.stateBarBer = statusBarber;
        this.stateBarBer1 = statusBarber1;
        posInList = numCliente;
        waitingList.addElement("Cliente Numero "+numCliente);
        
    }
    
    @Override
    public void run() {
        
        if(barbero.duerme){
            despertar();
        }
        while(true){
            if(Thread.currentThread().isAlive()){
                if(!m.masterChair){
                    m.cortarPelo(this.m.c.eliminar().posInList);
                    break;
                }
            }
        }
    }
    
    public void despertar(){
        
        stateBarBer.setText("Despertando al barbero");
        synchronized(barbero){
            barbero.notify();
        }
    }
    public void despertar1(){
        
        stateBarBer1.setText("Despertando al barbero");
        synchronized(barbero1){
            barbero1.notify();
        }
    }
    
    
}
