/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package peluquero;

import java.awt.Image;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author Oscar Eduardo López Guzmán (Sheen)
 * 01/11/2017
 */
public class Bandera implements Runnable{
    
    int nSillas;
    boolean masterChair;
    boolean masterChair1;
    DefaultListModel listModel;
    int clientesEspera;
    JLabel stateBarBer;
    JLabel stateBarBer1;
    Cola<Cliente> c;
    JLabel chairStatus,silla,tijeras;
    JLabel chairStatus1,silla1,tijeras1;
    JProgressBar progress;
    JProgressBar progress1;
    JLabel[] clientesE;
 
    ImageIcon da = new ImageIcon(getClass().getResource("/img/desocupado.png"));
    ImageIcon desocupado = new ImageIcon(da.getImage().getScaledInstance(120, 100, Image.SCALE_DEFAULT));
    ImageIcon o = new ImageIcon(getClass().getResource("/img/ocupado.png"));
    ImageIcon ocupado = new ImageIcon(o.getImage().getScaledInstance(120, 100, Image.SCALE_DEFAULT));
    ImageIcon t = new ImageIcon(getClass().getResource("/img/cortando.gif"));
    ImageIcon cortando = new ImageIcon(t.getImage().getScaledInstance(70, 50, Image.SCALE_DEFAULT));
    //constructor de la clase
    Bandera(int num, JLabel stateBarBer, DefaultListModel defaultList,JLabel chairStatus, JProgressBar progress,JLabel[] clientesE, JLabel silla,JLabel tijeras, JLabel stateBarBer1,JLabel chairStatus1, JProgressBar progress1, JLabel silla1,JLabel tijeras1 )
    {
        nSillas = num;
        masterChair = false;
        clientesEspera = 0;
        this.stateBarBer = stateBarBer;
        this.listModel = defaultList;
        this.c = new Cola<Cliente>();
        this.chairStatus = chairStatus;
        this.silla = silla;
        this.tijeras = tijeras;
        this.clientesE = clientesE;
        this.progress = progress;
        
        this.stateBarBer1 = stateBarBer1;
        masterChair1 = false;
        this.chairStatus1 = chairStatus1;
        this.silla1 = silla1;
        this.tijeras1 = tijeras1;
        this.progress1 = progress1;
    }
    
    public synchronized void cortarPelo(int posInList){
        try {
            if (!stateBarBer.getText().equals("Barbero cortando el pelo...")){
                masterChair = true;
            clientesEspera--;
            clientesE[clientesEspera].setVisible(false);
            clientesE[clientesEspera+1].setVisible(false);
            listModel.removeElement("Cliente Numero "+posInList);
            chairStatus.setText("Silla ocupada por el cliente "+posInList);
            stateBarBer.setText("Barbero cortando el pelo...");
            silla.setIcon(ocupado);
            tijeras.setIcon(cortando);
             masterChair1 = true;
            stateBarBer1.setText("Barbero cortando el pelo...");
            silla1.setIcon(ocupado);
            tijeras1.setIcon(cortando);
            
            int i = 0;
            progress.setMaximum(8000);
            progress1.setMaximum(8000);
            while(i<5000){
                Thread.sleep(1);
                progress.setValue(i);
                progress1.setValue(i);
                i++;
            }
            
            //Una ves que termina desocupa su silla de peluquero
            masterChair = false;
            stateBarBer.setText("Barbero esperando clientes, ya le está dando sueño...");
            chairStatus.setText("desocupado");
            silla.setIcon(desocupado);
            tijeras.setIcon(null);
            masterChair1 = false;
            stateBarBer1.setText("Barbero esperando clientes, ya le está dando sueño...");
            chairStatus1.setText("desocupado");
            silla1.setIcon(desocupado);
            tijeras1.setIcon(null);
            }else{
                
            
            
            }
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Barbero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getCuantosClientes(){
        return clientesEspera;
    }

    @Override
    public void run() {
        
    }
    
    
}
