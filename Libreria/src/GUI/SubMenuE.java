/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.Consultas.Estadisticas;
import GUI.Consultas.EstadisticasClasificacion;
import GUI.Consultas.EstadisticasClasificacionPrestados;
import GUI.Consultas.Top10;
import java.awt.Color;
import javax.swing.ImageIcon;

/**
 *
 * @author Allison
 */
public class SubMenuE extends javax.swing.JFrame {

    /**
     * Creates new form SubMenuE
     */
    public SubMenuE() {
        initComponents();
        
        initComponents();
        //Color del JFrame
        this.getContentPane().setBackground(Color.decode("#ACBC8A")); //F5CC7E o F5D28E o F3CC89 | Azul 0a043c
        //Centrar
        this.setLocationRelativeTo(null);
        
        //Icono del JFrame
        ImageIcon img = new ImageIcon("C:\\Users\\Allison\\Documents\\GitHub\\Libreria\\LOGO.png");
        this.setIconImage(img.getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnTotales = new javax.swing.JButton();
        btnClas = new javax.swing.JButton();
        btnClasBorrowd = new javax.swing.JButton();
        btnTop10 = new javax.swing.JButton();

        btnTotales.setBackground(new java.awt.Color(219, 107, 92));
        btnTotales.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTotales.setForeground(new java.awt.Color(255, 255, 255));
        btnTotales.setText("General");
        btnTotales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTotalesMouseClicked(evt);
            }
        });

        btnClas.setBackground(new java.awt.Color(219, 107, 92));
        btnClas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClas.setForeground(new java.awt.Color(255, 255, 255));
        btnClas.setText("Clasification");
        btnClas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClasMouseClicked(evt);
            }
        });

        btnClasBorrowd.setBackground(new java.awt.Color(219, 107, 92));
        btnClasBorrowd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClasBorrowd.setForeground(new java.awt.Color(255, 255, 255));
        btnClasBorrowd.setText("Clasification on Borrowed");
        btnClasBorrowd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClasBorrowdMouseClicked(evt);
            }
        });

        btnTop10.setBackground(new java.awt.Color(219, 107, 92));
        btnTop10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTop10.setForeground(new java.awt.Color(255, 255, 255));
        btnTop10.setText("Top 10");
        btnTop10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTop10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTop10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnClas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTotales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClasBorrowd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(116, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnTotales, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnClas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnClasBorrowd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnTop10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTotalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTotalesMouseClicked
        // TODO add your handling code here:
        Estadisticas ventana = new Estadisticas();
        ventana.setVisible(true);
    }//GEN-LAST:event_btnTotalesMouseClicked

    private void btnClasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClasMouseClicked
        // TODO add your handling code here:
        EstadisticasClasificacion ventana = new EstadisticasClasificacion();
        ventana.setVisible(true);
    }//GEN-LAST:event_btnClasMouseClicked

    private void btnClasBorrowdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClasBorrowdMouseClicked
        // TODO add your handling code here:
        EstadisticasClasificacionPrestados ventana = new EstadisticasClasificacionPrestados();
        ventana.setVisible(true);
    }//GEN-LAST:event_btnClasBorrowdMouseClicked

    private void btnTop10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTop10MouseClicked
        // TODO add your handling code here:
        Top10 ventana = new Top10();
        ventana.setVisible(true);
    }//GEN-LAST:event_btnTop10MouseClicked

    /**
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
            java.util.logging.Logger.getLogger(SubMenuE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SubMenuE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SubMenuE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubMenuE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SubMenuE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClas;
    private javax.swing.JButton btnClasBorrowd;
    private javax.swing.JButton btnTop10;
    private javax.swing.JButton btnTotales;
    // End of variables declaration//GEN-END:variables
}
