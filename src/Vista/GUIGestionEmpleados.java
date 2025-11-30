package Vista;
import Modelo.*;
import Datos.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class GUIGestionEmpleados extends javax.swing.JFrame {
    //======== ATRIBUTOS ====== //
    private GestionEmpleados gestionEmpleados;
    private DefaultTableModel modeloTablaEmpleados;
    
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GUIGestionEmpleados.class.getName());
    
    // ====== CONSTRUCTORES ======//
    public GUIGestionEmpleados(GestionEmpleados ge) {
        initComponents(); //Carga los componentes Visuales
        this.gestionEmpleados = ge; //Recibe los datos del sistema
        
        //inicializacion de la tabla
        modeloTablaEmpleados = new DefaultTableModel();
        
        // Configuracion del modelo de la tabla
        modeloTablaEmpleados.addColumn("DNI");
        modeloTablaEmpleados.addColumn("Nombre");
        modeloTablaEmpleados.addColumn("Apellido");
        modeloTablaEmpleados.addColumn("Rol");
        modeloTablaEmpleados.addColumn("Usuario");
        // enlazar las tablas
        taEmpleados.setModel(modeloTablaEmpleados);
        
        //cargar datos Iniciales
        cargarDatosIniciales();
        
        // Cargar los datos en la tabla
        actualirTabla();
        
    }
    
    
    public GUIGestionEmpleados() {
        initComponents();
    }
    // ===== Metodos Ayuda =====//
    // Método para cargar datos de prueba
    private void cargarDatosIniciales() {
        if (gestionEmpleados != null) {
            // Nota: Usamos 'gestionEmpleados.crear' porque el método está en esa clase
            gestionEmpleados.crear(new Administrador("1001", "Ana", "Gomez", "admin", "1234"));
            gestionEmpleados.crear(new Recepcionista("2002", "Carlos", "Perez", "recep", "1234"));
        }
    }
    private void LimpiarTabla(){
        modeloTablaEmpleados.setRowCount(0);
    }
    public void actualirTabla(){
        LimpiarTabla();
        if (gestionEmpleados == null)return;
        //Arreglo
        Empleado[]arregloempleados = gestionEmpleados.listarTodos();
        // recorrer el arreglo
        for (int i = 0; i < arregloempleados.length; i++) {
            //Verificamos que la posicion no este vacia
            if (arregloempleados[i] != null) {
                Object[] fila = new Object[5];
                fila[0] = arregloempleados[i].getDni();
                fila[1] = arregloempleados[i].getNombres();
                fila[2] = arregloempleados[i].getApellidos();
                fila[3] = arregloempleados[i].obtenerRol();
                fila[4] = arregloempleados[i].getLogin();
                
                modeloTablaEmpleados.addRow(fila);
            }
        }
    }
    private void limpiarCampos(){
        txtGeDNI.setText("");
        txtGeName.setText("");
        txtGeLastName.setText("");
        txtUser.setText("");
        txtPassword.setText("");
        cmbRol.setSelectedIndex(0);
        txtGeDNI.setEnabled(true); // Habilitar DNI nuevamente
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtGeDNI = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtGeName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtGeLastName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taEmpleados = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnModifi = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        cmbRol = new javax.swing.JComboBox<>();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Gestion Empleados");

        jLabel2.setText("Registro/Modificacion");

        jLabel3.setText("DNI");

        jLabel4.setText("Nombre");

        jLabel5.setText("Apellido");

        taEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Rol", "DNI", "Nombre", "Apellido", "Usuario"
            }
        ));
        taEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                taEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(taEmpleados);

        jLabel6.setText("Usuario");

        jLabel7.setText("Contraseña");

        jLabel8.setText("Rol");

        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnModifi.setText("Modificar");
        btnModifi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModifiActionPerformed(evt);
            }
        });

        btnDelete.setText("Eliminar");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        cmbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Recepcionista" }));

        btnExit.setText("Salir");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtGeDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(234, 234, 234)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtGeName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(159, 159, 159)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtGeLastName)
                                    .addComponent(cmbRol, 0, 120, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(213, 213, 213)
                                .addComponent(btnAdd)
                                .addGap(109, 109, 109)
                                .addComponent(btnModifi)
                                .addGap(95, 95, 95)
                                .addComponent(btnDelete)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtGeDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtGeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtGeLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cmbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnModifi)
                    .addComponent(btnDelete))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnExit)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String DNI = txtGeDNI.getText();
        String Nombre = txtGeName.getText();
        String Apellido = txtGeLastName.getText();
        String Usuario = txtUser.getText();
        String Contrasena = txtPassword.getText();
        String Rol = cmbRol.getSelectedItem().toString();
        
        if (DNI.isEmpty() || Nombre.isEmpty() || Usuario.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete los datos");
            return;
        }
        
        //Creamos el objeto
        Empleado nuevoEmpleado = null;
        if (Rol.equals("Administrador")) {
            nuevoEmpleado = new Administrador(DNI, Nombre, Apellido, Usuario, Contrasena);
        } else {
            nuevoEmpleado = new Recepcionista(DNI, Nombre, Apellido, Usuario, Contrasena);
        }
        
        // Agregar Arreglo 
        if(gestionEmpleados != null && gestionEmpleados.crear(nuevoEmpleado)){
            JOptionPane.showMessageDialog(this, "Agregado correctamente");
            actualirTabla(); // Actualizar tabla
            limpiarCampos(); // Limpiar campos
        } else {
            JOptionPane.showMessageDialog(this, "Error: DNI duplicado, lista llena o datos no cargados.");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if(txtGeDNI.isEnabled()){
            JOptionPane.showMessageDialog(this, "Seleccione un empleado para eliminar");
            return;
        }
        
        String DNI = txtGeDNI.getText();
        
        if(gestionEmpleados.eliminar(DNI)){
            JOptionPane.showMessageDialog(this, "Eliminado correctamente");
            actualirTabla();
            limpiarCampos();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnModifiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModifiActionPerformed
        // TODO add your handling code here:
        if(txtGeDNI.isEnabled()){
            JOptionPane.showMessageDialog(this, "Seleccione un empleado de la tabla");
            return;
        }
        
        String DNI = txtGeDNI.getText();
        String Nombre = txtGeName.getText();
        String Apellido = txtGeLastName.getText();
        String Usuario = txtUser.getText();
        String Contrasena = txtPassword.getText();
        String Rol = cmbRol.getSelectedItem().toString();
        
        Empleado emp = null;
        if(Rol.equals("Administrador")) {
            emp = new Administrador(DNI, Nombre, Apellido, Usuario, Contrasena);
        } else {
            emp = new Recepcionista(DNI, Nombre, Apellido, Usuario, Contrasena);
        }
        
        if(gestionEmpleados.modificar(emp)){
            JOptionPane.showMessageDialog(this, "Modificado correctamente");
            actualirTabla();
            limpiarCampos();
        }
    }//GEN-LAST:event_btnModifiActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void taEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_taEmpleadosMouseClicked
        // TODO add your handling code here:
        int fila = taEmpleados.getSelectedRow();
        if (fila >= 0) {
            // Pasar datos de la tabla a las cajas
            txtGeDNI.setText(modeloTablaEmpleados.getValueAt(fila, 0).toString());
            txtGeName.setText(modeloTablaEmpleados.getValueAt(fila, 1).toString());
            txtGeLastName.setText(modeloTablaEmpleados.getValueAt(fila, 2).toString());
            // La columna 3 es el Rol
            cmbRol.setSelectedItem(modeloTablaEmpleados.getValueAt(fila, 3).toString());
            // La columna 4 es el Login
            txtUser.setText(modeloTablaEmpleados.getValueAt(fila, 4).toString());
            
            txtGeDNI.setEnabled(false); // Bloquear DNI
        }
    }//GEN-LAST:event_taEmpleadosMouseClicked

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
        java.awt.EventQueue.invokeLater(() -> new GUIGestionEmpleados().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnModifi;
    private javax.swing.JComboBox<String> cmbRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable taEmpleados;
    private javax.swing.JTextField txtGeDNI;
    private javax.swing.JTextField txtGeLastName;
    private javax.swing.JTextField txtGeName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
    
}
