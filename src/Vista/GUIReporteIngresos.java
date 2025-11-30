
package Vista;
import Datos.*;
import javax.swing.JOptionPane;
import java.time.*;
import java.time.format.DateTimeParseException;

public class GUIReporteIngresos extends javax.swing.JFrame {
    //===== Atributos ====//
    private GestionReservasEstadias gestionReservas;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GUIReporteIngresos.class.getName());

    //==== CONSTRUCTORES ====//
    public GUIReporteIngresos() {
        initComponents();
    }
    
    public GUIReporteIngresos(GestionReservasEstadias gre) {
        initComponents();
        this.gestionReservas = gre;
        this.setLocationRelativeTo(null);// centra la ventana
        // Texto de ayuda inicial
        txtFechaInicio.setText("2023-01-01");
        txtFechaFin.setText("2023-12-31");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFechaInicio = new javax.swing.JTextField();
        txtFechaFin = new javax.swing.JTextField();
        btnReporte = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultados = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Fecha Inicio (AAAA-MM-DD)");

        jLabel2.setText("Fecha Fin (AAAA-MM-DD)");

        btnReporte.setText("Generar Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        txtResultados.setColumns(20);
        txtResultados.setRows(5);
        jScrollPane1.setViewportView(txtResultados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFechaInicio)
                    .addComponent(txtFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(53, 53, 53)))))
                .addGap(98, 98, 98))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:
        String inicioStr = txtFechaInicio.getText();
        String finStr = txtFechaFin.getText();
        
        // 1. Validar que el gestor exista
        if(gestionReservas == null){
            JOptionPane.showMessageDialog(this, "Error: No hay datos de Reserva Cargados");
            return; // Importante: Salir si no hay datos
        }

        try {
            // 2. Convertir texto a Fechas (Esto faltaba)
            LocalDate fechaInicio = LocalDate.parse(inicioStr);
            LocalDate fechaFin = LocalDate.parse(finStr);
            
            // 3. Validar orden de fechas
            if(fechaInicio.isAfter(fechaFin)){
                JOptionPane.showMessageDialog(this, "La fecha inicio no puede ser mayor a la fin");
                return;
            }

            // 4. CALCULAR LOS DATOS (¡Esto es lo que te faltaba!)
            // Llamamos al método del gestor que devuelve un arreglo [habitaciones, servicios]
            double[] resultados = gestionReservas.generarReporteIngresos(fechaInicio, fechaFin);
            
            // Creamos las variables que te daban error rojo
            double totalHabitaciones = resultados[0];
            double totalServicios = resultados[1];
            double totalGeneral = totalHabitaciones + totalServicios;

            // 5. Imprimir en el área de texto
            txtResultados.setText(""); // Limpiar anterior
            txtResultados.append("==========================================\n");
            txtResultados.append("      REPORTE DE INGRESOS FINANCIEROS     \n");
            txtResultados.append("==========================================\n");
            txtResultados.append(" Desde: " + inicioStr + "\n");
            txtResultados.append(" Hasta: " + finStr + "\n\n");
            
            // Ahora sí funcionan porque las variables ya existen
            txtResultados.append(String.format(" + Ingresos Habitaciones:  S/ %10.2f\n", totalHabitaciones));
            txtResultados.append(String.format(" + Ingresos Serv. Adic.:   S/ %10.2f\n", totalServicios));
            txtResultados.append(" ------------------------------------------\n");
            txtResultados.append(String.format(" TOTAL GANANCIA:           S/ %10.2f\n", totalGeneral));
            txtResultados.append("==========================================\n");

        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Formato de fecha incorrecto. Use: AAAA-MM-DD");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error: " + e.getMessage());
        }
    }//GEN-LAST:event_btnReporteActionPerformed
    public static void main2(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) { }

        java.awt.EventQueue.invokeLater(() -> {
            
            // --- 1. CREAR DATOS DE PRUEBA (SOLO PARA ESTA VENTANA) ---
            // Necesitamos crear los gestores previos porque Reservas los pide
            Datos.GestionHabitaciones gh = new Datos.GestionHabitaciones();
            Datos.GestionConsumos gc = new Datos.GestionConsumos();
            
            // Creamos el gestor de reservas con datos
            Datos.GestionReservasEstadias gre = new Datos.GestionReservasEstadias(gh, gc);
            
            // --- 2. ABRIR LA VENTANA CON DATOS ---
            new GUIReporteIngresos(gre).setVisible(true);
        });
    }
    
    
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
        java.awt.EventQueue.invokeLater(() -> new GUIReporteIngresos().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JTextArea txtResultados;
    // End of variables declaration//GEN-END:variables
}
