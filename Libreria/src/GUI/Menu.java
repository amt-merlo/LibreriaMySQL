/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.Consultas.ConsultaBitacora;
import GUI.Registro.RegistrarPersona;
import GUI.Registro.RegistrarLibro;
import GUI.Consultas.ConsultaLibros;
import GUI.Consultas.ConsultaLibrosNoPrestados;
import GUI.Consultas.ConsultaLibrosPrestados;
import GUI.Consultas.ConsultaPrestamos;
import GUI.Consultas.ConsultarPrestatarios;
import GUI.Consultas.Estadisticas;
import GUI.Registro.RegistrarPrestamo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import libreria.Book;


/**
 *
 * @author Allison
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        setFrame();
        
    }
    public void setFrame(){
        //Tamaño del JFrame
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        pack();
        setSize(screenSize.width,screenSize.height);
        //Color del JFrame
        this.getContentPane().setBackground(Color.decode("#588C7E")); //F5CC7E o F5D28E o F3CC89 | Azul 0a043c
        //Imagen en el JFrame
        scaleImage();
        //Icono del JFrame
        ImageIcon img = new ImageIcon("C:\\Users\\Allison\\Documents\\GitHub\\Libreria\\LOGO.png");
        this.setIconImage(img.getImage());
    }
    public void scaleImage(){
        ImageIcon imagen1 = new ImageIcon(getClass().getResource("/Images/LOGO.PNG"));
        Icon fondo1 = new ImageIcon(imagen1.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(), Image.SCALE_SMOOTH));
        lblFondo.setIcon(fondo1);
        this.repaint();   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFondo = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblLinea = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnRegistrarPersona = new javax.swing.JButton();
        btnRegistrarLibro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnRegisterLoan = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnLoans = new javax.swing.JButton();
        btnBorrowers = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnStatistics = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnEditBooks = new javax.swing.JButton();
        btnEditPerson = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFondo.setText("jLabel1");
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 180, 510, 500));

        lblTitulo.setFont(new java.awt.Font("Bernard MT Condensed", 0, 60)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Personal Collection");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        lblLinea.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblLinea.setForeground(new java.awt.Color(255, 255, 255));
        lblLinea.setText("---------------------------------------------------------");
        getContentPane().add(lblLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, -1));

        jPanel1.setBackground(new java.awt.Color(242, 180, 118));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 4));

        btnRegistrarPersona.setBackground(new java.awt.Color(187, 187, 187));
        btnRegistrarPersona.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnRegistrarPersona.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrarPersona.setText("Register People");
        btnRegistrarPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarPersonaMouseClicked(evt);
            }
        });
        btnRegistrarPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPersonaActionPerformed(evt);
            }
        });

        btnRegistrarLibro.setBackground(new java.awt.Color(187, 187, 187));
        btnRegistrarLibro.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnRegistrarLibro.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrarLibro.setText("Register Book");
        btnRegistrarLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarLibroMouseClicked(evt);
            }
        });
        btnRegistrarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarLibroActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe Script", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Register");

        btnRegisterLoan.setBackground(new java.awt.Color(187, 187, 187));
        btnRegisterLoan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegisterLoan.setForeground(new java.awt.Color(0, 0, 0));
        btnRegisterLoan.setText("Register Loan");
        btnRegisterLoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegisterLoanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegisterLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRegistrarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegistrarPersona)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistrarPersona)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegistrarLibro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegisterLoan)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 310, 170));

        jPanel2.setBackground(new java.awt.Color(236, 209, 137));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 4));

        jLabel2.setFont(new java.awt.Font("Segoe Script", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Consulting Services");

        jButton1.setBackground(new java.awt.Color(187, 187, 187));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Books");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        btnLoans.setBackground(new java.awt.Color(186, 186, 186));
        btnLoans.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLoans.setForeground(new java.awt.Color(0, 0, 0));
        btnLoans.setText("Loans");
        btnLoans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLoansMouseClicked(evt);
            }
        });

        btnBorrowers.setBackground(new java.awt.Color(187, 187, 187));
        btnBorrowers.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBorrowers.setForeground(new java.awt.Color(0, 0, 0));
        btnBorrowers.setText("Borrowers");
        btnBorrowers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBorrowersMouseClicked(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(187, 187, 187));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("LogBook");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        btnStatistics.setBackground(new java.awt.Color(187, 187, 187));
        btnStatistics.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnStatistics.setForeground(new java.awt.Color(0, 0, 0));
        btnStatistics.setText("Statistics");
        btnStatistics.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStatisticsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLoans, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBorrowers, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLoans)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(btnBorrowers)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(btnStatistics)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 310, 290));

        jPanel3.setBackground(new java.awt.Color(172, 188, 138));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 4));

        jLabel3.setFont(new java.awt.Font("Segoe Script", 2, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Editing Services");

        btnEditBooks.setBackground(new java.awt.Color(186, 186, 186));
        btnEditBooks.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditBooks.setForeground(new java.awt.Color(0, 0, 0));
        btnEditBooks.setText("Edit Book");
        btnEditBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditBooksMouseClicked(evt);
            }
        });

        btnEditPerson.setBackground(new java.awt.Color(186, 186, 186));
        btnEditPerson.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditPerson.setForeground(new java.awt.Color(0, 0, 0));
        btnEditPerson.setText("Edit Person");
        btnEditPerson.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditPersonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnEditBooks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditPerson, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                        .addGap(90, 90, 90))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditBooks)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditPerson)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 610, 310, 150));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarLibroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarLibroMouseClicked
        // TODO add your handling code here:
        RegistrarLibro registrar = new RegistrarLibro();
        registrar.setVisible(true);
    }//GEN-LAST:event_btnRegistrarLibroMouseClicked

    private void btnRegistrarPersonaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarPersonaMouseClicked
        // TODO add your handling code here:
        RegistrarPersona registrar = new RegistrarPersona();
        registrar.setVisible(true);
    }//GEN-LAST:event_btnRegistrarPersonaMouseClicked

    private void btnRegistrarPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarPersonaActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        BooksSubMenu menu = new BooksSubMenu();
        menu.setVisible(true);
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void btnLoansMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoansMouseClicked
        // TODO add your handling code here:
        ConsultaPrestamos consulta = new ConsultaPrestamos();
        consulta.setVisible(true);
    }//GEN-LAST:event_btnLoansMouseClicked

    private void btnRegistrarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRegistrarLibroActionPerformed

    private void btnEditPersonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditPersonMouseClicked
        // TODO add your handling code here:
        EditarPersonas editar = new EditarPersonas();
        editar.setVisible(true);
    }//GEN-LAST:event_btnEditPersonMouseClicked

    private void btnBorrowersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBorrowersMouseClicked
        // TODO add your handling code here:
        ConsultarPrestatarios consulta = new ConsultarPrestatarios();
        consulta.setVisible(true);
    }//GEN-LAST:event_btnBorrowersMouseClicked

    private void btnEditBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditBooksMouseClicked
        // TODO add your handling code here:
        EditarLibros editar = new EditarLibros();
        editar.setVisible(true);
    }//GEN-LAST:event_btnEditBooksMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        ConsultaBitacora ventana = new ConsultaBitacora();
        ventana.setVisible(true);
    }//GEN-LAST:event_jButton2MouseClicked

    private void btnStatisticsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStatisticsMouseClicked
        // TODO add your handling code here:
        SubMenuE ventana = new SubMenuE();
        ventana.setVisible(true);
    }//GEN-LAST:event_btnStatisticsMouseClicked

    private void btnRegisterLoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterLoanMouseClicked
        RegistrarPrestamo ventana = new RegistrarPrestamo();
        ventana.setVisible(true);
    }//GEN-LAST:event_btnRegisterLoanMouseClicked

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrowers;
    private javax.swing.JButton btnEditBooks;
    private javax.swing.JButton btnEditPerson;
    private javax.swing.JButton btnLoans;
    private javax.swing.JButton btnRegisterLoan;
    private javax.swing.JButton btnRegistrarLibro;
    private javax.swing.JButton btnRegistrarPersona;
    private javax.swing.JButton btnStatistics;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblLinea;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
