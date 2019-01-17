package com.asn1.gui;

import com.asn1.AntAsn1;
import com.asn1.gui.custom.IconButton;
import com.asn1.gui.custom.Worker;
import com.asn1.services.IWorker;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileSystemView;

/**
 * Interfaz visual que permite procesar y compilar un esquema .asn
 * @author Efrain.Blanco
 * @version 1.0
 */
public class AntFrame extends javax.swing.JFrame {

    private JFileChooser fileChooser;
    private static final String DIALOG_TITTLE_SELECT_FILE = "Seleccione esquema asn1";
    
    /**
     * Incializa frame y todos sus componentes
     */
     public AntFrame() {
        applyLookAndFeel();
        initComponents();
        setWindowLocation();
        initFileChooser();
        initProgressBar();
        addEventToScrollBar();
    }

    /**
     * Agrega evento a scrollbar del area de texto para que siempre muestre la ultima linea
     */
    private void addEventToScrollBar() {
        scrollPaneOutput.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                e.getAdjustable().setValue(e.getAdjustable().getMaximum());
            }
        });
    }
    
    /**
     * Asigna apariencia visual del Sistema operativo
     */
    private void applyLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Configura barra de progreso para que sea indeterminada y oculta
     */
    private void initProgressBar() {
        progressBar.setIndeterminate(true);
        progressBar.setVisible(false);
    }
    
    /**
     * Ubica frame en el centro de la pantalla
     */
    private void setWindowLocation(){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
    }
    
    /**
     * Inicializa y configura selector de archivos
     */
    private void initFileChooser(){
        fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fileChooser.setDialogTitle(DIALOG_TITTLE_SELECT_FILE);        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblArchivo = new javax.swing.JLabel();
        txtArchivo = new javax.swing.JTextField();
        btnArchivo = new IconButton("open-folder.png");
        btnCompilar = new IconButton("play.png");
        progressBar = new javax.swing.JProgressBar();
        scrollPaneOutput = new javax.swing.JScrollPane();
        txtPaneOutput = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Compilar esquema ASN1");
        setMinimumSize(new java.awt.Dimension(575, 390));
        setResizable(false);
        getContentPane().setLayout(null);

        lblArchivo.setText("Seleccione archivo:");
        getContentPane().add(lblArchivo);
        lblArchivo.setBounds(30, 30, 120, 14);

        txtArchivo.setEditable(false);
        getContentPane().add(txtArchivo);
        txtArchivo.setBounds(155, 20, 350, 35);

        btnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoshowFileChooser(evt);
            }
        });
        getContentPane().add(btnArchivo);
        btnArchivo.setBounds(505, 20, 40, 35);

        btnCompilar.setText("Compilar esquema");
        btnCompilar.setActionCommand("Compilar esquema");
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarAsn1Schema(evt);
            }
        });
        getContentPane().add(btnCompilar);
        btnCompilar.setBounds(376, 60, 170, 30);
        getContentPane().add(progressBar);
        progressBar.setBounds(-3, 340, 582, 15);

        txtPaneOutput.setEditable(false);
        txtPaneOutput.setEnabled(false);
        txtPaneOutput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPaneOutputMouseClicked(evt);
            }
        });
        scrollPaneOutput.setViewportView(txtPaneOutput);

        getContentPane().add(scrollPaneOutput);
        scrollPaneOutput.setBounds(10, 100, 537, 238);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Asigna ruta de archivo a caja de texto <code>txtArchivo</code>
     * @param evt -
     */
    private void btnArchivoshowFileChooser(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoshowFileChooser
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            txtArchivo.setText(fileChooser.getSelectedFile().getPath());
        }
    }//GEN-LAST:event_btnArchivoshowFileChooser

    /**
     * Crea una instancia de <code>AntAsn1</code> e inicia la ejecución
     * @see AntAsn1
     * @see AntAsn1#run() 
     * @see Worker
     * @param evt -
     */
    private void btnCompilarAsn1Schema(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarAsn1Schema
        
        if( txtArchivo.getText().isEmpty() ){
            JOptionPane.showMessageDialog(null, "Seleccione esquema",
                    "Alerta", JOptionPane.WARNING_MESSAGE);
            return;
        }
        addEventToScrollBar();
        
        IWorker iWorker = () -> {
            txtPaneOutput.setText("");
            String asnDirectory = txtArchivo.getText().trim();
            AntAsn1 ant = new AntAsn1(asnDirectory);            
            ant.setTxtPaneOutput(txtPaneOutput);
            ant.setScrollPaneOutput(scrollPaneOutput);
            ant.run();
        };        
        Worker worker = new Worker();
        worker.setiWorker(iWorker);        
        worker.setProgressBar(progressBar);
        worker.setFrame(this);
        worker.ejecutar();
    }//GEN-LAST:event_btnCompilarAsn1Schema

    /**
     * @see #removeScrollListener() 
     * @param evt -
     */
    private void txtPaneOutputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPaneOutputMouseClicked
        removeScrollListener();
    }//GEN-LAST:event_txtPaneOutputMouseClicked

    /**
     * Elimina evento de scroll del area de texto
     */
    private void removeScrollListener(){
        Arrays.asList( scrollPaneOutput.getVerticalScrollBar().getAdjustmentListeners() ).
                forEach( listener -> scrollPaneOutput.getVerticalScrollBar().removeAdjustmentListener(listener) );
    }
    
    /**
     * Visualiza frame
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AntFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AntFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AntFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AntFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
            
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AntFrame().setVisible(true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArchivo;
    private javax.swing.JButton btnCompilar;
    private javax.swing.JLabel lblArchivo;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JScrollPane scrollPaneOutput;
    private javax.swing.JTextField txtArchivo;
    private javax.swing.JTextPane txtPaneOutput;
    // End of variables declaration//GEN-END:variables
}
