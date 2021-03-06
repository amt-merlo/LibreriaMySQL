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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import libreria.Book;
import libreria.BorrowedBook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Allison
 */
public class EstadisticasClasificacionPrestados extends javax.swing.JFrame {
public Map<String, Integer> cantidades;
public ArrayList<BorrowedBook> libros;
    /**
     * Creates new form EstadisticasClasificacionPrestados
     */
    public EstadisticasClasificacionPrestados() {
        initComponents();
        
        //Color del JFrame
        this.getContentPane().setBackground(Color.decode("#ECD189")); //F5CC7E o F5D28E o F3CC89 | Azul 0a043c
        
        //Centrar ventana
        this.setLocationRelativeTo(null);
        
        //Icono del JFrame
        ImageIcon img = new ImageIcon("C:\\Users\\Allison\\Documents\\GitHub\\Libreria\\LOGO.png");
        this.setIconImage(img.getImage());
        
        cantidades = new HashMap<String, Integer>();
        libros = new ArrayList();
        try {
            cantidades = ConnectDB.get_ClasificationCantidadesPrestados();
            libros = ConnectDB.get_BorrowedBooks();
            
            int total = libros.size();
            llenarTabla(cantidades, total);
            
        } catch (SQLException ex) {
            Logger.getLogger(EstadisticasClasificacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private float calcularPorcentaje(int cantidad, int total){
        float fCantidad = cantidad;
        float fTotal = total;
        
        float porcentaje = (fCantidad/fTotal)*100;
        return porcentaje;
    }
    
    private void llenarTabla(Map<String, Integer> cantidades, int total){
        DefaultTableModel model = new DefaultTableModel(){
            //Para hacer que las celdas no puedan editarse pero si seleccionarse
            @Override
            public boolean isCellEditable(int filas, int columnas){
                return false;
            }
        };
          //Columnas
        model.addColumn("Clasification");
        model.addColumn("Quantity");
        model.addColumn("Percentaje");
        
        Iterator it = cantidades.keySet().iterator();
        while(it.hasNext()){
            String key = (String) it.next();
            int cant = cantidades.get(key);
            float porcentaje = calcularPorcentaje(cant, total);
            
            
            //Se agrega a la tabla
            model.addRow(new Object[]{key, Integer.toString(cant), Float.toString(porcentaje)});
            tableDatos.setModel(model);
        }
   
    }
    
      private void graficar(){
        DefaultPieDataset dataset  = new DefaultPieDataset();
        Iterator it = cantidades.keySet().iterator();
        int total = libros.size();
        
        while(it.hasNext()){
            String key = (String) it.next();
            int cant = cantidades.get(key);
            float porcentaje = calcularPorcentaje(cant, total);
            
            dataset.setValue(key+" = "+(int)porcentaje+"%", porcentaje);
        }
        
        
        
        
        JFreeChart chart = ChartFactory.createPieChart(
                    "Statistics", //Titulo
                     dataset, 
                     true,
                     true, false
        
        );
        
        ChartPanel panel = new ChartPanel(chart);
        
        JFrame ventana = new JFrame("Book Clasification Statistics");
        ventana.setVisible(true);
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        ventana.add(panel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDatos = new javax.swing.JTable();
        btnGraficar = new javax.swing.JButton();

        lblTitulo.setFont(new java.awt.Font("Segoe Script", 0, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Clasification Statistics On Borrowed ");

        tableDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Clasification", "Quantity", "Percentaje"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableDatos);

        btnGraficar.setBackground(new java.awt.Color(242, 180, 118));
        btnGraficar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGraficar.setForeground(new java.awt.Color(255, 255, 255));
        btnGraficar.setText("See Graphics");
        btnGraficar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGraficarMouseClicked(evt);
            }
        });
        btnGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(btnGraficar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(lblTitulo)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(btnGraficar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGraficarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGraficarMouseClicked
        // TODO add your handling code here:
        graficar();
    }//GEN-LAST:event_btnGraficarMouseClicked

    private void btnGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGraficarActionPerformed

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
            java.util.logging.Logger.getLogger(EstadisticasClasificacionPrestados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EstadisticasClasificacionPrestados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EstadisticasClasificacionPrestados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EstadisticasClasificacionPrestados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EstadisticasClasificacionPrestados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGraficar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tableDatos;
    // End of variables declaration//GEN-END:variables
}
