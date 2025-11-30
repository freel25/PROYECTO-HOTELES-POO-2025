package Modelo;


public class Habitacion {
    private int numero;
    private int capacidadMaxima;
    private double precioPorNoche;
    private String tipo; 
    private String estado; 

    // Constructor
    public Habitacion(int numero, int capacidadMaxima, double precioPorNoche, 
                      String tipo, String estado) {
        this.numero = numero;
        this.capacidadMaxima = capacidadMaxima;
        this.precioPorNoche = precioPorNoche;
        this.tipo = tipo;
        this.estado = estado;
    }

    // Getters y Setters (los más relevantes)
    public int getNumero() {
        return numero;
    }
    
    public void setNumero(int Numero){
        this.numero = Numero;
    }

    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String Tipo){
        this.tipo = Tipo;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }
    
    public void setPrecioPorNoche(double PrecioPorNoche){
        this.precioPorNoche = PrecioPorNoche;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean estaDisponible() {
        return this.estado.equals("Limpia");
    }
    public int getCapacidadMaxima(){
        return capacidadMaxima;
    }
    public void setCapacidadMaxima(int CapacidadMaxima){
        this.capacidadMaxima = CapacidadMaxima;
    }
}