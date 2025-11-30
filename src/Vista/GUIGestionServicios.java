
package Vista;
import Datos.*;
import Modelo.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GUIGestionServicios extends javax.swing.JFrame {
    // ====== Atributos ======= //
    private GestionServicios gestionServicios;
    private DefaultTableModel modeloTabla;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GUIGestionServicios.class.getName());

    public GUIGestionServicios() {
        initComponents();
    }
    public GUIGestionServicios(GestionServicios gs) {
        initComponents();
        this.gestionServicios = gs;
        
        //Configurar tabla
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Precio");
        
        //Pasar datos
        taServicios.setModel(modeloTabla);
        
        //Cargat datos
        actualizarTabla();
    }
    // Otros Metodos
    private void actualizarTabla(){
        modeloTabla.setRowCount(0); // limpiara la tabla visual
        if (gestionServicios == null) return;
        
        //Creacion del Arreglo
        ServicioAdicional[] misServicios = gestionServicios.listarTodos();
        for (int i = 0; i < misServicios.length; i++) {
            Object[] fila = {
                misServicios[i].getIdServicio(),
                misServicios[i].getNombre(),
                misServicios[i].getPrecio(),
            };
            modeloTabla.addRow(fila);
        }
        
    }
    private void limpiarCampos() {
        txtIDService.setText("");
        txtNameService.setText("");
        txtPriceService.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        taServicios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIDService = new javax.swing.JTextField();
        txtNameService = new javax.swing.JTextField();
        txtPriceService = new javax.swing.JTextField();
        btnAddService = new javax.swing.JButton();
        btnEditService = new javax.swing.JButton();
        btnDeleteService = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        taServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Precio"
            }
        ));
        jScrollPane1.setViewportView(taServicios);

        jLabel1.setText("PANEL DATOS");

        jLabel2.setText("TABLA");

        jLabel3.setText("GESTION SERVICIOS");

        jLabel4.setText("ID Servicio");

        jLabel5.setText("Nombre");

        jLabel6.setText("Precio");

        txtPriceService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceServiceActionPerformed(evt);
            }
        });

        btnAddService.setText("Agregar");
        btnAddService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddServiceActionPerformed(evt);
            }
        });

        btnEditService.setText("Editar");
        btnEditService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditServiceActionPerformed(evt);
            }
        });

        btnDeleteService.setText(" Eliminar");
        btnDeleteService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteServiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(398, 398, 398)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAddService)
                            .addComponent(txtIDService, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNameService, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPriceService, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(175, 175, 175)
                        .addComponent(btnEditService)
                        .addGap(165, 165, 165)
                        .addComponent(btnDeleteService)))
                .addContainerGap(229, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIDService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNameService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPriceService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddService)
                    .addComponent(btnEditService)
                    .addComponent(btnDeleteService))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPriceServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceServiceActionPerformed
         // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceServiceActionPerformed

    private void btnAddServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddServiceActionPerformed
        // TODO add your handling code here:
        //validamos si hay vacios
        if (txtIDService.getText().isEmpty() || txtNameService.getText().isEmpty() || txtPriceService.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos.");
            return;
        }
        
        try {
            int id = Integer.parseInt(txtIDService.getText());
            double precio = Double.parseDouble(txtPriceService.getText());
            String nombre = txtNameService.getText();
            
            ServicioAdicional nuevo = new ServicioAdicional(id, nombre, precio);

            if (gestionServicios.crear(nuevo)) {
                JOptionPane.showMessageDialog(this, "Servicio Agregado");
                actualizarTabla();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error: Arreglo lleno.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID y Precio deben ser números.");
        }
    }//GEN-LAST:event_btnAddServiceActionPerformed

    private void btnEditServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditServiceActionPerformed
        // TODO add your handling code here:
        // Lógica manual: El usuario debe escribir el ID que quiere modificar
        if (txtIDService.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Escriba el ID del servicio que desea modificar.");
            return;
        }
        
        try {
            int id = Integer.parseInt(txtIDService.getText());
            double precio = Double.parseDouble(txtPriceService.getText());
            String nombre = txtNameService.getText();
            
            ServicioAdicional modif = new ServicioAdicional(id, nombre, precio);

            // TU CÓDIGO de GestionServicios recibe un Objeto, lo cual está bien.
            if (gestionServicios.modificar(modif)) {
                JOptionPane.showMessageDialog(this, "Servicio Modificado correctamente");
                actualizarTabla();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error: No se encontró un servicio con ese ID.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Revise que los datos numéricos sean correctos.");
        }
    }//GEN-LAST:event_btnEditServiceActionPerformed

    private void btnDeleteServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteServiceActionPerformed
        // TODO add your handling code here:
        // Lógica manual: El usuario escribe el ID a eliminar
       if (txtIDService.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Escriba el ID del servicio a eliminar.");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar el servicio ID: " + txtIDService.getText() + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // --- CAMBIO IMPORTANTE ---
                // Tu método eliminar(String id) pide String.
                // Obtenemos el texto directo de la caja y lo mandamos.
                String idString = txtIDService.getText();
                
                if (gestionServicios.eliminar(idString)) {
                    JOptionPane.showMessageDialog(this, "Eliminado correctamente");
                    actualizarTabla();
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "Error: ID no encontrado.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar.");
            }
        }
    }//GEN-LAST:event_btnDeleteServiceActionPerformed

    
    // --- MAIN DE PRUEBA ---
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) { }

        java.awt.EventQueue.invokeLater(() -> {
            GestionServicios gs = new GestionServicios(); // Esto carga datos automáticamente
            new GUIGestionServicios(gs).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddService;
    private javax.swing.JButton btnDeleteService;
    private javax.swing.JButton btnEditService;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable taServicios;
    private javax.swing.JTextField txtIDService;
    private javax.swing.JTextField txtNameService;
    private javax.swing.JTextField txtPriceService;
    // End of variables declaration//GEN-END:variables
    // --- MAIN DE PRUEBA ---
    public static void main2(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) { logger.log(java.util.logging.Level.SEVERE, null, ex); }

        java.awt.EventQueue.invokeLater(() -> {
            GestionServicios gs = new GestionServicios(); 
            new GUIGestionServicios(gs).setVisible(true);
        });
    }
}