
package Vista;

import Modelo.*;
import Datos.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class GUIGestionHabitaciones extends javax.swing.JFrame {
    // ======== Atributos ======= //
    private GestionHabitaciones gestionHabitaciones;
    private DefaultTableModel modeloTabla;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GUIGestionHabitaciones.class.getName());

    //====== CONSTRUCTORES ======//
    public GUIGestionHabitaciones(GestionHabitaciones gh) {
        initComponents();
        this.gestionHabitaciones = gh;
        
        // Configuracion de la tabla
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Numero");
        modeloTabla.addColumn("Capacidad");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Tipo");
        modeloTabla.addColumn("Estado");
        // vincualar tablas
        taHabitaciones.setModel(modeloTabla);
        // Panel Datos
        configurarPanelDatos();
        // Carga de Datos
        actualizarTabla();
    }
    
    public GUIGestionHabitaciones() {
        initComponents();
    }
    
    //configurar Panel de Datos
    private void configurarPanelDatos(){
        javax.swing.JTable tablaInfo = new javax.swing.JTable();
        tablaInfo.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},new String [] { "Numero", "Capacidad Max", "Precio por noche", "Tipo", "Estado" }
        ));
        pnlDatos.setViewportView(tablaInfo);
    }
    
    // Otros metodos
    private void limpiarTabla(){
        modeloTabla.setRowCount(0);
    }
    
    private void actualizarTabla(){
        limpiarTabla();
        // Arreglo
        Habitacion[] arregloHabitaciones = gestionHabitaciones.listarTodos();
        // recorremos el arreglo
        for (int i = 0; i < arregloHabitaciones.length; i++) {
            if (arregloHabitaciones[i] !=null) {
                Object[] fila = {
                    arregloHabitaciones[i].getNumero(),
                    arregloHabitaciones[i].getCapacidadMaxima(),
                    arregloHabitaciones[i].getPrecioPorNoche(),
                    arregloHabitaciones[i].getTipo(),
                    arregloHabitaciones[i].getEstado(),
                };
                modeloTabla.addRow(fila);
            }
        }
    }
    
    private void limpiarCampos(){
        txtNumber.setText("");
        txtCapacity.setText("");
        txtPrice.setText("");
        cmbTipe.setSelectedIndex(0);
        cmbEstate.setSelectedIndex(0);
        txtNumber.setEnabled(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnCreateRoom = new javax.swing.JButton();
        btnMidifiRoom = new javax.swing.JButton();
        btnDeleteRoom = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taHabitaciones = new javax.swing.JTable();
        txtNumber = new javax.swing.JTextField();
        txtCapacity = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        cmbTipe = new javax.swing.JComboBox<>();
        cmbEstate = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        pnlDatos = new javax.swing.JScrollPane();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 553, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 113, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Numero");

        jLabel2.setText("Capacidad");

        jLabel3.setText("Precio");

        jLabel4.setText("Tipo");

        jLabel5.setText("Estado");

        btnCreateRoom.setText("Crear");
        btnCreateRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateRoomActionPerformed(evt);
            }
        });

        btnMidifiRoom.setText("Modificar");
        btnMidifiRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMidifiRoomActionPerformed(evt);
            }
        });

        btnDeleteRoom.setText("Eliminar");
        btnDeleteRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteRoomActionPerformed(evt);
            }
        });

        taHabitaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Numero", "Capacidad", "Precio", "Tipo", "Estado"
            }
        ));
        taHabitaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taHabitacionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(taHabitaciones);

        cmbTipe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Simple", "Doble", "Suit", " " }));

        cmbEstate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Limpia", "Sucia", "En Limpieza", "Ocupada", " " }));

        jLabel6.setText("GESTION DE HABITACIONES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCreateRoom)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMidifiRoom)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteRoom))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cmbEstate, javax.swing.GroupLayout.Alignment.LEADING, 0, 140, Short.MAX_VALUE)
                        .addComponent(cmbTipe, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtCapacity, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNumber, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                    .addComponent(pnlDatos))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(375, 375, 375)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbTipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cmbEstate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCreateRoom)
                            .addComponent(btnMidifiRoom)
                            .addComponent(btnDeleteRoom))
                        .addContainerGap(145, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateRoomActionPerformed
        // TODO add your handling code here:
        if (txtNumber.getText().isEmpty()|| txtCapacity.getText().isEmpty()|| txtPrice.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Complete todos los campos porfavor");
            return;
        }
        try {
            int numero = Integer.parseInt(txtNumber.getText());
            int capacidad = Integer.parseInt(txtCapacity.getText());
            double precio = Double.parseDouble(txtPrice.getText());
            String tipo = cmbTipe.getSelectedItem().toString();
            String estado = cmbEstate.getSelectedItem().toString();
            
            Habitacion nueva = new Habitacion(numero, capacidad, precio, tipo, estado);
            
            if (gestionHabitaciones != null && gestionHabitaciones.crear(nueva)) {
                JOptionPane.showMessageDialog(this, "Habitación creada.");
                actualizarTabla();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error: Duplicado o lleno.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: Ingrese números válidos.");
        }
    }//GEN-LAST:event_btnCreateRoomActionPerformed

    private void btnMidifiRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMidifiRoomActionPerformed
        // TODO add your handling code here:
        if (txtNumber.isEnabled()) {
            JOptionPane.showMessageDialog(this,"Seleccione una habitacion de la tabla");
            return;
        }
        try {
            int numero = Integer.parseInt(txtNumber.getText()); 
            int capacidad = Integer.parseInt(txtCapacity.getText());
            double precio = Double.parseDouble(txtPrice.getText());
            String tipo = cmbTipe.getSelectedItem().toString();
            String estado = cmbEstate.getSelectedItem().toString();
            
            Habitacion modif = new Habitacion(numero, capacidad, precio, tipo, estado);
            
            if (gestionHabitaciones.modificar(modif)) {
                JOptionPane.showMessageDialog(this, "Modificado correctamente.");
                actualizarTabla();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al modificar.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en números.");
        }
    }//GEN-LAST:event_btnMidifiRoomActionPerformed

    private void btnDeleteRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRoomActionPerformed
        // TODO add your handling code here:
        if (txtNumber.isEnabled()) {
            JOptionPane.showMessageDialog(this, "Seleccione una habitación.");
            return;
        }
        try {
            int numero = Integer.parseInt(txtNumber.getText());
            if (gestionHabitaciones.eliminar(numero)) {
                JOptionPane.showMessageDialog(this, "Eliminado correctamente.");
                actualizarTabla();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar.");
            }
        } catch (Exception e) {}
    }//GEN-LAST:event_btnDeleteRoomActionPerformed

    private void taHabitacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taHabitacionesMouseClicked
        // TODO add your handling code here:
        int fila = taHabitaciones.getSelectedRow();
        if (fila >= 0) {
            // Pasamos los valores numéricos convirtiéndolos a String para las cajas de texto
            txtNumber.setText(modeloTabla.getValueAt(fila, 0).toString());
            txtCapacity.setText(modeloTabla.getValueAt(fila, 1).toString());
            txtPrice.setText(modeloTabla.getValueAt(fila, 2).toString());
            cmbTipe.setSelectedItem(modeloTabla.getValueAt(fila, 3).toString());
            cmbEstate.setSelectedItem(modeloTabla.getValueAt(fila, 4).toString());
            
            txtNumber.setEnabled(false); // Bloquear ID
        }
    }//GEN-LAST:event_taHabitacionesMouseClicked

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new GUIGestionHabitaciones().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateRoom;
    private javax.swing.JButton btnDeleteRoom;
    private javax.swing.JButton btnMidifiRoom;
    private javax.swing.JComboBox<String> cmbEstate;
    private javax.swing.JComboBox<String> cmbTipe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane pnlDatos;
    private javax.swing.JTable taHabitaciones;
    private javax.swing.JTextField txtCapacity;
    private javax.swing.JTextField txtNumber;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
