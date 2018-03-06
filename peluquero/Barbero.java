/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package peluquero;

import java.awt.Image;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 * @author Oscar Eduardo López Guzmán (Sheen)
 * 01/11/2017
 */
public class Barbero implements Runnable {
    boolean duerme;
    Random r;
    Bandera m;
    JLabel stateBarBer;
    JLabel chairStatus;
    JLabel barbero;
    JLabel silla;
    JProgressBar progress;
    JLabel stateBarBer1;
    JLabel chairStatus1;
    JLabel barbero1;
    JLabel silla1;
    JProgressBar progress1;
            
   
    ImageIcon d = new ImageIcon(getClass().getResource("/img/durmiendo.png"));
    ImageIcon durmiendo = new ImageIcon(d.getImage().getScaledInstance(120, 100, Image.SCALE_DEFAULT));
    ImageIcon des = new ImageIcon(getClass().getResource("/img/barbero.png"));
    ImageIcon despierto = new ImageIcon(des.getImage().getScaledInstance(120, 100, Image.SCALE_DEFAULT));
    ImageIcon o = new ImageIcon(getClass().getResource("/img/ocupado.png"));
    ImageIcon ocupado = new ImageIcon(o.getImage().getScaledInstance(120, 100, Image.SCALE_DEFAULT));
    public Barbero(Bandera m, JLabel stateBarber, JLabel chairStatus, JProgressBar progress, JLabel barbero, JLabel silla,JLabel stateBarber1, JLabel chairStatus1, JProgressBar progress1, JLabel barbero1, JLabel silla1){
        duerme = false;
        r = new Random();
        this.m = m;
        this.stateBarBer = stateBarber;
        this.chairStatus = chairStatus;
        this.barbero = barbero;
        this.silla = silla;
        this.silla.setSize(120,100);
        this.barbero.setSize(120,100);
        this.progress = progress;
        this.stateBarBer1 = stateBarber;
        this.chairStatus1 = chairStatus;
        this.barbero1 = barbero;
        this.silla1 = silla;
        this.silla1.setSize(120,100);
        this.barbero1.setSize(120,100);
        this.progress1 = progress;
    }
    
    public void dormir(){
        try{                
            barbero.setIcon(durmiendo);
            duerme = true;
            m.masterChair = true;
            progress.setValue(0);
            chairStatus.setText("Barbero durmiendo en la silla");
            barbero1.setIcon(durmiendo);
            duerme = true;
            m.masterChair = true;
            m.masterChair1 = true;
            progress1.setValue(0);
            chairStatus1.setText("Barbero durmiendo en la silla");
            synchronized(this){
                wait();
            }
            this.stateBarBer.setText("Desperto el barbero");
            chairStatus.setText("desocupado");
            barbero.setIcon(despierto);
            silla.setIcon(ocupado);
            this.stateBarBer1.setText("Desperto el barbero");
            chairStatus1.setText("desocupado");
            barbero1.setIcon(despierto);
            silla1.setIcon(ocupado);
            duerme = false;
            m.masterChair = false;
            m.masterChair1 = false;
        } catch (InterruptedException ex) {
            Logger.getLogger(Barbero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        while(true){
            if(!m.masterChair && m.getCuantosClientes()==0 && !duerme){
                dormir();
            }
        }
    }
    
}
