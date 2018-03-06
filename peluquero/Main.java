/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peluquero;

import javax.swing.JOptionPane;

/**
 *
 * @author Oscar Eduardo López Guzmán (Sheen)
 * Clase Main, inicializa la aplicación.
 */
public class Main {
    
    public static void main(String[] args){
		Integer a;
                try {
                    a = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántas sillas hay en la barbería?"));
                    while(a>6 || a<1){
                        if (a>6){
                            a = Integer.parseInt(JOptionPane.showInputDialog("¿Estás seguro? esas son muchas sillas, prueba con un poco menos:")); 
                        }
                        if (a<1){
                            a = Integer.parseInt(JOptionPane.showInputDialog("¿Qué? Pero por lo menos debe tener una silla de espera la barbería, intenta de nuevo;"));
                        }
                    }
		new Peluqueria(a).setVisible(true);
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Solamente debe introducir números");
                    String[] arg = new String[1];
                    main(arg);
                }
	}
    
}
