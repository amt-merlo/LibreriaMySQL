/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Consultas;

import DBCommands.ConnectDB;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import libreria.Book;
import libreria.Cambio;

/**
 *
 * @author Allison
 */
public class ConsultaBitacora extends javax.swing.JFrame {

    /**
     * Creates new form ConsultaBitacora
     */
    public ConsultaBitacora() {
        initComponents();
        
        //Ubicarlo en el centro
        this.setLocationRelativeTo(null);
        //Color del JFrame
        this.getContentPane().setBackground(Color.decode("#DB6B5C")); //F5CC7E o F5D28E o F3CC89
        
        //Icono del JFrame
        ImageIcon img = new ImageIcon("C:\\Users\\Allison\\Documents\\GitHub\\Libreria\\LOGO.png");
        this.setIconImage(img.getImage());
        
        //Se consulta la bitácora
        ArrayList<Cambio> LogBook = new ArrayList();
        try {
            LogBook = ConnectDB.get_LogBook();
            llenarTabla(LogBook);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaBitacora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public boolean isCellEditable(int row, int column) {
        return false;
    }
    private void llenarTabla(ArrayList<Cambio> LogBook){
        DefaultTableModel model = new DefaultTableModel(){
            //Para hacer que las celdas no puedan editarse pero si seleccionarse
            @Override
            public boolean isCellEditable(int filas, int columnas){
                return false;
            }
        };
        
        int cantBitacora = LogBook.size();
        //Columnas
        model.addColumn("ID");
        model.addColumn("Date");
        model.addColumn("Hour");
        model.addColumn("Type");
        model.addColumn("Object");
        model.addColumn("Description");
        model.addColumn("User");
       
        if(cantBitacora>0){
            for(int i=0; i<cantBitacora; i++){
                Cambio actual = LogBook.get(i);
                model.addRow(new Object[]{actual.getID(),
                                          actual.getDate(),
                                          actual.getHour(), 
                                          actual.getType(), 
                                          actual.getObject(), 
                                          actual.getDescription(), 
                                          actual.getUsername()});
                tableLog.setModel(model);
                lblCantidad.setText(Integer.toString(cantBitacora));
            }
        }else{
            tableLog.setModel(new DefaultTableModel());
            lblCantidad.setText("0");
            JOptionPane.showMessageDialog(null,"No hay coincidencias.");   
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLog = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblCantidad = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblObject = new javax.swing.JLabel();
        txtFieldObject = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtFieldUser = new javax.swing.JTextField();
        txtFieldType = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblRanges = new javax.swing.JLabel();
        txtFieldHour2 = new javax.swing.JTextField();
        btnFilter = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtFieldDate1 = new javax.swing.JTextField();
        txtFieldDate2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtFieldHour1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe Script", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Consulting LogBook");

        tableLog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Date", "Hour", "User"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableLog);

        jPanel1.setBackground(new java.awt.Color(242, 180, 118));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        lblCantidad.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCantidad.setForeground(new java.awt.Color(255, 255, 255));
        lblCantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Total Changes");

        jPanel2.setBackground(new java.awt.Color(172, 188, 138));

        lblObject.setForeground(new java.awt.Color(255, 255, 255));
        lblObject.setText("Object: ");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("User: ");

        txtFieldType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldTypeActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Type:");

        lblRanges.setFont(new java.awt.Font("Segoe Script", 1, 14)); // NOI18N
        lblRanges.setForeground(new java.awt.Color(255, 255, 255));
        lblRanges.setText("Type date and hour ranges");

        btnFilter.setBackground(new java.awt.Color(236, 209, 137));
        btnFilter.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnFilter.setForeground(new java.awt.Color(255, 255, 255));
        btnFilter.setText("Filter");
        btnFilter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFilterMouseClicked(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Date");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Hour");

        jLabel2.setFont(new java.awt.Font("Segoe Script", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Filtered Seach");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtFieldType, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(lblObject, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtFieldObject, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(73, 73, 73)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(73, 73, 73)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(txtFieldHour1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtFieldHour2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(txtFieldDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(37, 37, 37)
                                            .addComponent(txtFieldDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(btnFilter))))
                            .addComponent(lblRanges))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFieldType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtFieldObject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblObject))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(34, 34, 34)
                .addComponent(lblRanges)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFieldDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFieldDate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFieldHour1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFieldHour2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnFilter)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(398, 398, 398)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(381, 381, 381)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFilterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFilterMouseClicked
        // TODO add your handling code here:
        //Tomamos los datos
        String tipo, objeto, usuario, date1, date2, hour1, hour2;
        
        tipo = txtFieldType.getText();
        objeto = txtFieldObject.getText();
        usuario = txtFieldUser.getText();
        date1 = txtFieldDate1.getText();
        date2 = txtFieldDate2.getText();
        hour1 = txtFieldHour1.getText();
        hour2 = txtFieldHour2.getText();
        
        ArrayList<Cambio> filtrados = new ArrayList();
        try {
            filtrados = ConnectDB.get_LogBookFiltered(tipo, objeto, usuario, date1, date2, hour1, hour2);
            llenarTabla(filtrados);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaBitacora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnFilterMouseClicked

    private void txtFieldTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldTypeActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultaBitacora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaBitacora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaBitacora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaBitacora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaBitacora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFilter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblObject;
    private javax.swing.JLabel lblRanges;
    private javax.swing.JTable tableLog;
    private javax.swing.JTextField txtFieldDate1;
    private javax.swing.JTextField txtFieldDate2;
    private javax.swing.JTextField txtFieldHour1;
    private javax.swing.JTextField txtFieldHour2;
    private javax.swing.JTextField txtFieldObject;
    private javax.swing.JTextField txtFieldType;
    private javax.swing.JTextField txtFieldUser;
    // End of variables declaration//GEN-END:variables
}
