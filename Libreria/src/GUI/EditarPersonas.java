/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DBCommands.ConnectDB;
import GUI.Consultas.ConsultarPrestatarios;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import libreria.Loan;
import libreria.Person;

/**
 *
 * @author Allison
 */
public class EditarPersonas extends javax.swing.JFrame {

    /**
     * Creates new form EditarPersonas
     */
    public EditarPersonas() {
        initComponents();
        //Color del JFrame
        this.getContentPane().setBackground(Color.decode("#ECD189")); //F5CC7E o F5D28E o F3CC89 | Azul 0a043c
        
        //Centrar ventana
        this.setLocationRelativeTo(null);
        
        //Icono del JFrame
        ImageIcon img = new ImageIcon("C:\\Users\\Allison\\Documents\\GitHub\\Libreria\\LOGO.png");
        this.setIconImage(img.getImage());
        
        //Declarar la lista de personas
        ArrayList<Person> personas = new ArrayList();
        
        //Inicializar la lista de personas
        try {
            personas = ConnectDB.get_People();
            llenarTabla(personas);
        } catch (SQLException ex) {
            Logger.getLogger(EditarPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Obtener los tipos de persona
        ArrayList<String> tipos = new ArrayList();
        try {
            tipos = ConnectDB.get_PersonType();
            
            //Set de los tipos de persona en el comboBox
            for(int i = 0; i<tipos.size(); i++){
                comboBoxRelationship.addItem(tipos.get(i));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditarPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Obtener los prestatarios
        int borrowers = get_Borrowers();
        lblBorrowers.setText(String.valueOf(borrowers));
    }
    
    private void llenarTabla(ArrayList<Person> personas){
        DefaultTableModel model = new DefaultTableModel();
        int cantidadPersonas = personas.size();
       
        //Columnas
        model.addColumn("ID");
        model.addColumn("Relationship");
        model.addColumn("Firstname");
        model.addColumn("Lastname");
        model.addColumn("Birthdate");
        System.out.println(cantidadPersonas);
        if(cantidadPersonas>0){
            for(int i=0; i<cantidadPersonas; i++){
                Person actual = personas.get(i);
                System.out.println(actual.getID());
                model.addRow(new Object[]{actual.getID(),
                                          actual.getID_PersonType(),
                                          actual.getFirstname(), 
                                          actual.getLastname(),
                                          actual.getBirthdate().substring(0,10)});
                tablePeople.setModel(model);
                //lblCantidad.setText(Integer.toString(cantidadPrestamos));
            }
        }else{
            tablePeople.setModel(new DefaultTableModel());
            //lblCantidad.setText("0");
            JOptionPane.showMessageDialog(null,"No hay coincidencias.");
        }
    }
    
    private int get_Borrowers(){
        ArrayList<Loan> loans = new ArrayList();
        ArrayList<Person> personas = new ArrayList();
        ArrayList<Person> borrowers = new ArrayList();
        ArrayList cedulas = new ArrayList();
        
        try {
            loans = ConnectDB.get_Loans();
            personas = ConnectDB.get_People();
            
            //Obtenemos las cedulas de los prestatarios
            for(int i = 0; i<loans.size(); i++){
                if(!cedulas.contains(loans.get(i).getID_Person())) cedulas.add(loans.get(i).getID_Person());
            }
            
            //Hacemos el arreglo de los prestatarios
            for(int j = 0; j<personas.size(); j++){
                if(cedulas.contains(personas.get(j).getID())) borrowers.add(personas.get(j));
            }
            
            System.out.println(borrowers.size());
        } catch (SQLException ex) {
            Logger.getLogger(EditarPersonas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return borrowers.size();
       
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
        tablePeople = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        lblPersonType = new javax.swing.JLabel();
        lblFirstname = new javax.swing.JLabel();
        lblLastname = new javax.swing.JLabel();
        lblBirthdate = new javax.swing.JLabel();
        comboBoxRelationship = new javax.swing.JComboBox<>();
        txtFieldFirstname = new javax.swing.JTextField();
        txtFieldLastname = new javax.swing.JTextField();
        btnGuardarCambios = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtFieldBirthdate = new javax.swing.JTextField();
        lblSetID = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblTitulo2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblBorrowers = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe Script", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Editing People");

        tablePeople.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Relationship", "Firstname", "Lastname", "Birthdate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePeople.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePeopleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePeople);

        jPanel1.setBackground(new java.awt.Color(242, 180, 118));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        lblID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblID.setForeground(new java.awt.Color(255, 255, 255));
        lblID.setText("ID:");

        lblPersonType.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPersonType.setForeground(new java.awt.Color(255, 255, 255));
        lblPersonType.setText("Relationship:");

        lblFirstname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblFirstname.setForeground(new java.awt.Color(255, 255, 255));
        lblFirstname.setText("Firstname: ");

        lblLastname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblLastname.setForeground(new java.awt.Color(255, 255, 255));
        lblLastname.setText("Lastname: ");

        lblBirthdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblBirthdate.setForeground(new java.awt.Color(255, 255, 255));
        lblBirthdate.setText("Birthdate: ");

        comboBoxRelationship.setForeground(new java.awt.Color(255, 255, 255));

        txtFieldFirstname.setForeground(new java.awt.Color(0, 0, 0));

        txtFieldLastname.setForeground(new java.awt.Color(0, 0, 0));

        btnGuardarCambios.setBackground(new java.awt.Color(187, 187, 187));
        btnGuardarCambios.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardarCambios.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardarCambios.setText("Save Changes");
        btnGuardarCambios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarCambiosMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Modify Values");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPersonType, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLastname, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(lblFirstname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(162, 162, 162))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtFieldBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblSetID, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(158, 158, 158)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtFieldLastname, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                .addComponent(txtFieldFirstname)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(95, 95, 95)
                            .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(comboBoxRelationship, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(92, 92, 92))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(lblSetID))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPersonType)
                    .addComponent(comboBoxRelationship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFirstname)
                    .addComponent(txtFieldFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLastname)
                    .addComponent(txtFieldLastname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFieldBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardarCambios, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jPanel2.setBackground(new java.awt.Color(219, 107, 92));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        lblTitulo2.setBackground(new java.awt.Color(255, 255, 255));
        lblTitulo2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTitulo2.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo2.setText("People with borrowed books:");

        jButton1.setBackground(new java.awt.Color(172, 188, 138));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("VIEW");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        lblBorrowers.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblBorrowers.setForeground(new java.awt.Color(255, 255, 255));
        lblBorrowers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lblBorrowers, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo2)
                .addGap(18, 18, 18)
                .addComponent(lblBorrowers)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(44, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(37, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablePeopleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePeopleMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tablePeople.getModel();
        int row = tablePeople.getSelectedRow();
        
        lblSetID.setText(model.getValueAt(row, 0).toString());
        txtFieldFirstname.setText(model.getValueAt(row, 2).toString());
        txtFieldLastname.setText(model.getValueAt(row, 3).toString());
        txtFieldBirthdate.setText(model.getValueAt(row, 4).toString().substring(0,10));
        
        comboBoxRelationship.setSelectedItem(model.getValueAt(row, 1).toString());
    }//GEN-LAST:event_tablePeopleMouseClicked

    private void btnGuardarCambiosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarCambiosMouseClicked
        // TODO add your handling code here:
        int ID, ID_PersonType;
        String Firstname, Lastname, Birthdate, PersonType;
        
        //Primero sacamos los datos
        ID = Integer.parseInt(lblSetID.getText());
        Firstname = txtFieldFirstname.getText();
        Lastname = txtFieldLastname.getText();
        Birthdate = txtFieldBirthdate.getText().toString();
        Birthdate = Birthdate.replace("-", ",");
        PersonType = comboBoxRelationship.getSelectedItem().toString();
        
        //Luego consultamos el numero de id de la relacion
        try {
            ID_PersonType = ConnectDB.get_PersonTypeID(PersonType);
            
            //Hacemos el update
            ConnectDB.update_Person(ID, ID_PersonType, Firstname, Lastname, Birthdate);
            
            //volvemos a llenar la tabla
            ArrayList<Person> personas = new ArrayList();
            personas = ConnectDB.get_People();
            JOptionPane.showMessageDialog(null, "Data Succesfully Updated");
            llenarTabla(personas);
        } catch (SQLException ex) {
            Logger.getLogger(EditarPersonas.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al realizar el update");
        }
        
        
    }//GEN-LAST:event_btnGuardarCambiosMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        ConsultarPrestatarios consulta = new ConsultarPrestatarios();
        consulta.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(EditarPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarPersonas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarPersonas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.JComboBox<String> comboBoxRelationship;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBirthdate;
    private javax.swing.JLabel lblBorrowers;
    private javax.swing.JLabel lblFirstname;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblLastname;
    private javax.swing.JLabel lblPersonType;
    private javax.swing.JLabel lblSetID;
    private javax.swing.JLabel lblTitulo2;
    private javax.swing.JTable tablePeople;
    private javax.swing.JTextField txtFieldBirthdate;
    private javax.swing.JTextField txtFieldFirstname;
    private javax.swing.JTextField txtFieldLastname;
    // End of variables declaration//GEN-END:variables
}
