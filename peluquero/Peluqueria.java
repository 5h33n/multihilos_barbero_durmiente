/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package peluquero;

import java.awt.Image;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author Oscar Eduardo López Guzmán (Sheen)
 * 01/11/2017
 */
public class Peluqueria extends javax.swing.JFrame {
    private Thread m;
    private int numeroSillas;
    private Bandera b;
    private Barbero barbero;
    private Barbero barbero1;
    private JLabel[] sillas;
    private JLabel[] clientesE;
    private Lock lock;
    static Calendar horai = new GregorianCalendar();
    static int[] hinicio = new int[3];
    int[] hfinal = new int[3];
    ImageIcon d = new ImageIcon(getClass().getResource("/img/durmiendo.png"));
    ImageIcon durmiendo = new ImageIcon(d.getImage().getScaledInstance(120, 100, Image.SCALE_DEFAULT));
    ImageIcon sc = new ImageIcon(getClass().getResource("/img/sillaespera.png"));
    ImageIcon sillaC = new ImageIcon(sc.getImage().getScaledInstance(100,80, Image.SCALE_DEFAULT));
    ImageIcon c = new ImageIcon(getClass().getResource("/img/cliente.png"));
    ImageIcon cliente = new ImageIcon(c.getImage().getScaledInstance(100,80, Image.SCALE_DEFAULT));
    ImageIcon din = new ImageIcon(getClass().getResource("/img/dinero.png"));
    ImageIcon dinero = new ImageIcon(din.getImage().getScaledInstance(100,80, Image.SCALE_DEFAULT));
    ImageIcon se = new ImageIcon(getClass().getResource("/img/irse.png"));
    ImageIcon sef = new ImageIcon(se.getImage().getScaledInstance(80,60, Image.SCALE_DEFAULT));
    public Peluqueria(int n) {
        this.setResizable(false);
        sillas = new JLabel[n];
        clientesE = new JLabel[n];
        initComponents();
        this.setLocationRelativeTo(null);
        this.numeroSillas = n;
        barberoLabel.setSize(120,100);
        barberoLabel.setText("");
        estadoB.setText("");
        sillaLabel.setText("");
        sillaText.setText("");
        tijeras.setText("");
        barberoLabel1.setSize(120,100);
        barberoLabel1.setText("");
        estadoB1.setText("");
        sillaLabel1.setText("");
        sillaText1.setText("");
        tijeras1.setText("");
        sefueI.setText("");
        sefue.setText("<html>Un cliente llegó y se tuvo que ir</html>");
        sefueI.setIcon(sef);
        
        ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/img/fondo.jpg"));
        JLabel fondo= new JLabel();
        fondo.setIcon(uno);
        getLayeredPane().add(fondo,JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
        
        barberoLabel.setIcon(durmiendo);
        barberoLabel1.setIcon(durmiendo);
        titulo.setText("<html><body><h2>El BARBERO DORMILÓN</h2></body></html>");
        desc.setText("<html><body align=center>El barbero permanecerá dormido hasta que un"
                + "cliente llegue a despertarlo, si un cliente llega y está<br> ocupado, tendrá "
                + "que esperar en una de las "+n+" sillas disponibles.<br> Si un cliente llega"
                        + " y no hay sillas disponibles se tendrá que marchar. <BR>PRESIONE 'INICIAR'"
                        + "PARA COMENZAR LA SIMULACIÓN<BR></body></html>");
        iniciar.setEnabled(true);
        finalizar.setEnabled(false);
        for (int i=0;i<n;i++){
            sillas[i] = new JLabel();
            sillas[i].setSize(120,100);
            sillas[i].setIcon(sillaC);
            sillas[i].setLocation((40+(i*100)),40);
            clientesE[i] = new JLabel();
            clientesE[i].setSize(120,100);
            clientesE[i].setIcon(cliente);
            clientesE[i].setLocation((40+(i*100)),60);
            clientesE[i].setVisible(false);
            container.add(clientesE[i]);
            container.add(sillas[i]);
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        progreso = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        waitingList = new javax.swing.JList();
        espera = new javax.swing.JLabel();
        barberoLabel = new javax.swing.JLabel();
        estadoB = new javax.swing.JLabel();
        sillaLabel = new javax.swing.JLabel();
        sillaText = new javax.swing.JLabel();
        iniciar = new javax.swing.JButton();
        finalizar = new javax.swing.JButton();
        tijeras = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        resultados = new javax.swing.JLabel();
        inicio = new javax.swing.JLabel();
        fin = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        sefue = new javax.swing.JLabel();
        sefueI = new javax.swing.JLabel();
        barberoLabel1 = new javax.swing.JLabel();
        tijeras1 = new javax.swing.JLabel();
        sillaLabel1 = new javax.swing.JLabel();
        estadoB1 = new javax.swing.JLabel();
        sillaText1 = new javax.swing.JLabel();
        progreso1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        desc = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 153));

        container.setBackground(new java.awt.Color(214, 234, 248));

        waitingList.setModel(model);
        jScrollPane1.setViewportView(waitingList);

        espera.setText("Clientes en espera:");

        barberoLabel.setText("...");

        estadoB.setText("...");

        sillaLabel.setText("...");

        sillaText.setText("...");

        iniciar.setText("Iniciar simulación");
        iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarActionPerformed(evt);
            }
        });

        finalizar.setText("Detener simulación");
        finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarActionPerformed(evt);
            }
        });

        tijeras.setText("...");

        jLabel1.setText("Registro de clientes en espera:");

        resultados.setText("Resultados:");
        resultados.setVisible(false);

        inicio.setText("jLabel3");
        inicio.setVisible(false);

        fin.setText("fc");
        fin.setVisible(false);

        total.setText("jLabel5");
        total.setVisible(false);

        sefue.setText("jLabel2");
        sefue.setVisible(false);

        sefueI.setText("jLabel3");
        sefueI.setVisible(false);

        barberoLabel1.setText("...");

        tijeras1.setText("...");

        sillaLabel1.setText("...");

        estadoB1.setText("...");

        sillaText1.setText("...");

        org.jdesktop.layout.GroupLayout containerLayout = new org.jdesktop.layout.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(containerLayout.createSequentialGroup()
                .add(42, 42, 42)
                .add(containerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(containerLayout.createSequentialGroup()
                        .add(132, 132, 132)
                        .add(espera)
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, containerLayout.createSequentialGroup()
                        .add(containerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(containerLayout.createSequentialGroup()
                                .add(containerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, containerLayout.createSequentialGroup()
                                        .add(barberoLabel1)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(tijeras1)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(sillaLabel1))
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, sillaText1)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, progreso1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, estadoB1))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(containerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(inicio)
                                    .add(resultados)
                                    .add(fin)
                                    .add(total))
                                .add(122, 122, 122))
                            .add(containerLayout.createSequentialGroup()
                                .add(containerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, containerLayout.createSequentialGroup()
                                        .add(barberoLabel)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(tijeras)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(sillaLabel))
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, sillaText)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, progreso, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(org.jdesktop.layout.GroupLayout.LEADING, estadoB))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 311, Short.MAX_VALUE)
                                .add(containerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(sefueI)
                                    .add(sefue))
                                .add(33, 33, 33)))
                        .add(containerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, iniciar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, finalizar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .add(56, 56, 56))))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(containerLayout.createSequentialGroup()
                .add(containerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(containerLayout.createSequentialGroup()
                        .add(16, 16, 16)
                        .add(espera)
                        .add(130, 130, 130)
                        .add(containerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(barberoLabel)
                            .add(sillaLabel)
                            .add(tijeras)))
                    .add(containerLayout.createSequentialGroup()
                        .add(31, 31, 31)
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)))
                .add(containerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(containerLayout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(estadoB)
                        .add(18, 18, 18)
                        .add(sillaText)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(progreso, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 24, Short.MAX_VALUE)
                        .add(containerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(barberoLabel1)
                            .add(sillaLabel1)
                            .add(tijeras1))
                        .add(18, 18, 18)
                        .add(estadoB1)
                        .add(18, 18, 18)
                        .add(sillaText1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(progreso1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(containerLayout.createSequentialGroup()
                        .add(24, 24, 24)
                        .add(iniciar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 55, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(containerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(finalizar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 55, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(containerLayout.createSequentialGroup()
                                .add(resultados)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(inicio)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(fin)))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(total)))
                .add(70, 70, 70))
            .add(containerLayout.createSequentialGroup()
                .add(137, 137, 137)
                .add(sefue)
                .add(18, 18, 18)
                .add(sefueI)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        titulo.setText("EL BARBERO DORMILÓN");
        titulo.setName("titulo"); // NOI18N

        desc.setText("jLabel2");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(270, 270, 270)
                        .add(titulo))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(76, 76, 76)
                        .add(desc)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(titulo)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(desc)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(container, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(container, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarActionPerformed

        
        hinicio[0] = horai.get(Calendar.HOUR_OF_DAY);
		hinicio[1] = horai.get(Calendar.MINUTE);
		hinicio[2] = horai.get(Calendar.SECOND);
		inicio.setText("El barbero abrió a las:  " +hinicio[0] +":"+hinicio[1]+":"+hinicio[2]);
        b = new Bandera(numeroSillas, estadoB,model, sillaText, progreso, clientesE,sillaLabel,tijeras,estadoB1, sillaText1, progreso1,sillaLabel1,tijeras1);

        barbero = new Barbero(b, estadoB, sillaText, progreso,barberoLabel,sillaLabel,estadoB1, sillaText1, progreso1,barberoLabel1,sillaLabel1);
        new Thread(barbero).start();
        new Thread(b).start();
        iniciar.setEnabled(false);
        finalizar.setEnabled(true);
        m = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    int numCliente=0;
                    Random r = new Random();
                    while(true){
                        Thread.sleep(r.nextInt(9000));
                        if(b.clientesEspera<numeroSillas){
                            clientesE[b.clientesEspera].setVisible(true);
                            clientesE[b.clientesEspera+1].setVisible(true);
                            Cliente nuevo = new Cliente(b, barbero,barbero1, model, estadoB,estadoB1, ++numCliente);
                            b.c.insertar(nuevo);
                            b.clientesEspera++;
                            Thread t = new Thread(nuevo);
                            t.start();
                        }else{
                            sefue.setVisible(true);
                            sefueI.setVisible(true);
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException ex) {
                                
                            }
                            sefue.setVisible(false);
                            sefueI.setVisible(false);
                        }
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Peluqueria.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        m.start();
    }//GEN-LAST:event_iniciarActionPerformed
    public void parar(){
            m.stop();
    }
    private void finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarActionPerformed

        Calendar horaf = new GregorianCalendar();
        container.remove(estadoB);
        container.remove(sillaText);
        container.remove(tijeras);
        sillaLabel.setIcon(dinero);
        for (int a=0;a<clientesE.length;a++){
            container.remove(clientesE[a]);
        }
        hfinal[0] = horaf.get(Calendar.HOUR_OF_DAY);
	hfinal[1] = horaf.get(Calendar.MINUTE);
	hfinal[2] = horaf.get(Calendar.SECOND);
        resultados.setVisible(true);
        inicio.setVisible(true);
        fin.setVisible(true);
        total.setVisible(true);
        resultados.setText("<html><body><h4 style='color:red'>RESULTADOS:</h4></body></html>");
        fin.setText("El barbero cerró a las:  " +hfinal[0] +":"+hfinal[1]+":"+hfinal[2]);
        total.setText("En total se tardó: "+calculart(hfinal));
        progreso.setVisible(false);
        progreso1.setVisible(false);
        finalizar.setEnabled(false);
        parar();
    }//GEN-LAST:event_finalizarActionPerformed
    public String calculart(int[] hf){
            String t = "";
            if (hf[0]==hinicio[0]){
                if (hf[1]==hinicio[1]){
                    t = (hf[2]-hinicio[2]) + " segundos en terminar.";
                } else if (hf[1]>hinicio[1]){
                    t =  (hf[2]+(60-hinicio[2]))*(60*(hf[1]-hinicio[1])) + " segundos en terminar.";
                }
            } else if (hf[1]>hinicio[1]){
                    t = ((hf[2]+(60-hinicio[2]))*(60*(hf[1]-hinicio[1]))) * (60*(hf[2]-hinicio[2])) + " segundos en terminar.";
            }
            return t;
    }
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barberoLabel;
    private javax.swing.JLabel barberoLabel1;
    private javax.swing.JPanel container;
    private javax.swing.JLabel desc;
    private javax.swing.JLabel espera;
    private javax.swing.JLabel estadoB;
    private javax.swing.JLabel estadoB1;
    private javax.swing.JLabel fin;
    private javax.swing.JButton finalizar;
    private javax.swing.JButton iniciar;
    private javax.swing.JLabel inicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JProgressBar progreso;
    private javax.swing.JProgressBar progreso1;
    private javax.swing.JLabel resultados;
    private javax.swing.JLabel sefue;
    private javax.swing.JLabel sefueI;
    private javax.swing.JLabel sillaLabel;
    private javax.swing.JLabel sillaLabel1;
    private javax.swing.JLabel sillaText;
    private javax.swing.JLabel sillaText1;
    private javax.swing.JLabel tijeras;
    private javax.swing.JLabel tijeras1;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel total;
    private javax.swing.JList waitingList;
    private DefaultListModel model = new DefaultListModel();
    // End of variables declaration//GEN-END:variables
}
