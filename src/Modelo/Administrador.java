package Modelo;

public class Administrador extends Empleado {
    
    public Administrador(String dni, String nombres, String apellidos, String login, String password) {
        super(dni, nombres, apellidos, login, password);
    }

    // ESTE ES EL MÉTODO QUE OBLIGAMOS A TENER
    @Override
    public String obtenerRol() {
        return "Administrador";
    }
}