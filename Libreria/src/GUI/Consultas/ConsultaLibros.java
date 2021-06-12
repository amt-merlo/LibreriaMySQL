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

/**
 *
 * @author Allison
 */
public class ConsultaLibros extends javax.swing.JFrame {

    /**
     * Creates new form ConsultaLibros
     */
    public ConsultaLibros() {
        initComponents();
        
        //Se crea el arreglo que guardará los libros
        ArrayList<Book> libros = new ArrayList();
        
        //Se llena el arreglo con los libros registrados en la DB
        
        try {
            System.out.println("Entra a try");
            libros = ConnectDB.getBooks();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaLibros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Se llena la jTable con los datos
        llenarTabla(libros);
        
        //Ubicarlo en el centro
        this.setLocationRelativeTo(null);
        //Color del JFrame
        this.getContentPane().setBackground(Color.decode("#DB6B5C")); //F5CC7E o F5D28E o F3CC89
        
        //Icono del JFrame
        ImageIcon img = new ImageIcon("C:\\Users\\Allison\\Documents\\GitHub\\Libreria\\LOGO.png");
        this.setIconImage(img.getImage());
    }
    
    private void llenarTabla(ArrayList<Book> libros){
        DefaultTableModel model = new DefaultTableModel(){
            //Para hacer que las celdas no puedan editarse pero si seleccionarse
            @Override
            public boolean isCellEditable(int filas, int columnas){
                return false;
            }
        };
        
        int cantidadLibros = libros.size();
        
        //Columnas
        model.addColumn("ID");
        model.addColumn("Title");
        model.addColumn("Clasification");
        model.addColumn("Author");
        model.addColumn("Edition");
        model.addColumn("PublishingHouse");
        model.addColumn("Score");
       
        if(cantidadLibros>0){
            for(int i=0; i<cantidadLibros; i++){
                Book actual = libros.get(i);
                System.out.println(actual.getTitle());
                model.addRow(new Object[]{actual.getID(),
                                          actual.getTitle(),
                                          actual.getClasification(), 
                                          actual.getAuthor(), 
                                          actual.getEdition(), 
                                          actual.getPublishingHouse(), 
                                          actual.getScore()});
                tableBooks.setModel(model);
                lblCantidad.setText(Integer.toString(cantidadLibros));
            }
        }else{
            tableBooks.setModel(new DefaultTableModel());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tableBooks = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        panelPortada = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtFieldTitle = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        lblAutor = new javax.swing.JLabel();
        txtFieldAuthor = new javax.swing.JTextField();
        lblEditorial = new javax.swing.JLabel();
        txtFieldPHouse = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblFilteredTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblCantidad = new javax.swing.JLabel();
        lblCantTitulo = new javax.swing.JLabel();
        btnRestart = new javax.swing.JButton();

        tableBooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Clasification", "Title ", "Author", "Edition", "Publishing House", "Score"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableBooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableBooksMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableBooks);

        lblTitle.setFont(new java.awt.Font("Segoe Script", 0, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Consulting Books on Personal Collection");

        panelPortada.setBackground(new java.awt.Color(255, 204, 153));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout panelPortadaLayout = new javax.swing.GroupLayout(panelPortada);
        panelPortada.setLayout(panelPortadaLayout);
        panelPortadaLayout.setHorizontalGroup(
            panelPortadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPortadaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPortadaLayout.setVerticalGroup(
            panelPortadaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPortadaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTitulo.setText("Title:");

        lblAutor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblAutor.setText("Author:");

        lblEditorial.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEditorial.setText("Publishing House:");

        jButton1.setBackground(new java.awt.Color(186, 186, 186));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Filter");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        lblFilteredTitle.setFont(new java.awt.Font("Segoe Script", 0, 18)); // NOI18N
        lblFilteredTitle.setText("Filtered Search");

        jPanel1.setBackground(new java.awt.Color(236, 209, 137));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));

        lblCantidad.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblCantidad.setForeground(new java.awt.Color(255, 255, 255));
        lblCantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblCantTitulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCantTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCantTitulo.setText("Total Books Consulted:");

        btnRestart.setBackground(new java.awt.Color(172, 188, 138));
        btnRestart.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRestart.setForeground(new java.awt.Color(0, 0, 0));
        btnRestart.setText("Restart Search");
        btnRestart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRestartMouseClicked(evt);
            }
        });
        btnRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(lblFilteredTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 27, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 849, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(panelPortada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(148, 148, 148)
                                        .addComponent(lblCantTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(13, 13, 13)))))
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFieldTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblAutor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFieldAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(lblEditorial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFieldPHouse, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRestart)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblFilteredTitle)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFieldTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAutor)
                            .addComponent(txtFieldAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEditorial)
                            .addComponent(lblTitulo)
                            .addComponent(txtFieldPHouse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRestart)
                            .addComponent(jButton1))
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(lblCantTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelPortada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
       
        ArrayList<Book> libros = new ArrayList<Book>();
        String Author = txtFieldAuthor.getText();
        String Title = txtFieldTitle.getText();
        String PHouse = txtFieldPHouse.getText();
        
        //Se filtra el tipo de consulta primero
        try{
            //Cuando se aplican los tres filtros YA
            if (Title.length()>0 && Author.length()>0 && PHouse.length()>0 ){
                
                libros = ConnectDB.get_BooksFiltered1(Title, Author, PHouse);
                llenarTabla(libros);
            }else{
                //Cuando se aplica filtro de Título y Autor YA
                if(Title.length()>0 && Author.length()>0 && PHouse.length()<1){
                    
                    libros = ConnectDB.get_BooksFiltered2(Title, Author);
                    llenarTabla(libros);
                }else{
                    //Cuando se aplica filtro de Titulo y Editorial YA
                    if(Title.length()>0 && Author.length()<1 && PHouse.length()>0){
                    
                        libros = ConnectDB.get_BooksFiltered3(Title, PHouse);
                        llenarTabla(libros);
                    }else{
                        //Cuando se aplica filtro de autor y editorial YA
                        if(Title.length()<1 && Author.length()>0 && PHouse.length()>0){

                            libros = ConnectDB.get_BooksFiltered4(Author, PHouse);
                            llenarTabla(libros);
                        }else{
                            //Cuando se aplica filtro de titulo
                            if(Title.length()>0 && Author.length()<1 && PHouse.length()<1){

                                libros = ConnectDB.get_BooksFiltered5(Title);
                                llenarTabla(libros);
                            }
                            else{
                                //Cuando se aplica filtro de autor
                                if(Title.length()<1 && Author.length()>0 && PHouse.length()<1){

                                    libros = ConnectDB.get_BooksFiltered6(Author);
                                    llenarTabla(libros);

                                }else{
                                    //Cuando se aplica filtro de editorial
                                    if(Title.length()<1 && Author.length()<1 && PHouse.length()>0){
                                        libros = ConnectDB.get_BooksFiltered7(PHouse);
                                        llenarTabla(libros);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            
        }catch(SQLException ex){
            Logger.getLogger(ConsultaLibros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void btnRestartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRestartMouseClicked
        //Se crea un arreglo 
        ArrayList<Book> libros = new ArrayList<Book>();
        try {
            libros = ConnectDB.getBooks();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaLibros.class.getName()).log(Level.SEVERE, null, ex);
        }
        jLabel2.setIcon(null);
        llenarTabla(libros);
    }//GEN-LAST:event_btnRestartMouseClicked

    private void tableBooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableBooksMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableBooks.getModel();
        int row = tableBooks.getSelectedRow();
        
        int ID = (int) model.getValueAt(row, 0);
        try {
            //Sacamos el coverpage
            
            String coverPage = ConnectDB.get_BookCoverPage(ID);
         
            this.jLabel2.setIcon((new ImageIcon(coverPage)));
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaLibros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_tableBooksMouseClicked

    private void btnRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRestartActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultaLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaLibros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaLibros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRestart;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAutor;
    private javax.swing.JLabel lblCantTitulo;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblEditorial;
    private javax.swing.JLabel lblFilteredTitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelPortada;
    private javax.swing.JTable tableBooks;
    private javax.swing.JTextField txtFieldAuthor;
    private javax.swing.JTextField txtFieldPHouse;
    private javax.swing.JTextField txtFieldTitle;
    // End of variables declaration//GEN-END:variables
}
