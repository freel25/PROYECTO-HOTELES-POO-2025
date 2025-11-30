package Principal;
import Vista.GUILogin;

public class main2 {
    
    public static void main(String[] args) {
        
        // 1. PONER EL DISEÑO "NIMBUS"
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println("No se pudo cargar el diseño visual.");
        }

        // 2. ABRIR EL LOGIN (Aquí empieza la magia)
        // Al hacer "new GUILogin()", se disparará el constructor del Login que carga los datos.
        GUILogin ventana = new GUILogin();
        ventana.setLocationRelativeTo(null); // Centrar
        ventana.setVisible(true);
    }
}