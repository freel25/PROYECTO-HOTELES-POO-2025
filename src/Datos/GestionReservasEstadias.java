package Datos;

import Modelo.*;
import java.time.LocalDate;

public class GestionReservasEstadias {

    // --- 1. CLASE INTERNA PARA DATOS HISTÓRICOS ---
    private class IngresoHistorico {
        LocalDate fecha;
        double montoHabitacion;
        double montoServicios;

        public IngresoHistorico(LocalDate f, double hab, double serv) {
            this.fecha = f;
            this.montoHabitacion = hab;
            this.montoServicios = serv;
        }
    }

    // --- 2. ATRIBUTOS ---
    private Reservacion[] reservas;
    private int cantReservas;
    private final int MAX_RESERVAS = 200;
    
    private Estadia[] estadias;
    private int cantEstadias;
    private final int MAX_ESTADIAS = 200;
    
    private Factura[] facturas;
    private int cantFacturas;
    private final int MAX_FACTURAS = 200;
    
    // Arreglo para reporte histórico
    private IngresoHistorico[] historialAntiguo; 
    private int cantHistorial;

    private GestionHabitaciones gestionHabitaciones;
    private GestionConsumos gestionConsumos;

    private int nextReservaId = 1;
    private int nextEstadiaId = 1;
    private int nextFacturaId = 1;

    // --- 3. CONSTRUCTOR ---
    public GestionReservasEstadias(GestionHabitaciones gestionHabitaciones, GestionConsumos gestionConsumos) {
        this.reservas = new Reservacion[MAX_RESERVAS];
        this.cantReservas = 0;
        
        this.estadias = new Estadia[MAX_ESTADIAS];
        this.cantEstadias = 0;
        
        this.facturas = new Factura[MAX_FACTURAS];
        this.cantFacturas = 0;
        
        this.gestionHabitaciones = gestionHabitaciones;
        this.gestionConsumos = gestionConsumos;
        
        // Cargar historial simulado del 2023
        this.historialAntiguo = new IngresoHistorico[50];
        this.cantHistorial = 0;
        cargarDatosHistoricos(); 
    }
    
    private void cargarDatosHistoricos() {
        agregarHistoria(new IngresoHistorico(LocalDate.of(2023, 1, 15), 200.0, 50.0));
        agregarHistoria(new IngresoHistorico(LocalDate.of(2023, 2, 20), 450.0, 100.0));
        agregarHistoria(new IngresoHistorico(LocalDate.of(2023, 3, 10), 120.0, 30.0));
        agregarHistoria(new IngresoHistorico(LocalDate.of(2023, 12, 5), 800.0, 150.0));
    }
    
    private void agregarHistoria(IngresoHistorico ingreso) {
        if (cantHistorial < historialAntiguo.length) {
            historialAntiguo[cantHistorial] = ingreso;
            cantHistorial++;
        }
    }

    // --- MÉTODOS DE NEGOCIO ---

    public boolean crear(Reservacion reserva) {
        if (cantReservas < MAX_RESERVAS) {
            reserva.setIdReservacion(nextReservaId++);
            this.reservas[cantReservas] = reserva; 
            this.cantReservas++;
            return true;
        }
        return false;
    }

    public Reservacion buscarPorId(String id) {
        try {
            int idBusqueda = Integer.parseInt(id);
            for (int i = 0; i < cantReservas; i++) { 
                if (this.reservas[i].getIdReservacion() == idBusqueda) {
                    return this.reservas[i];
                }
            }
        } catch (NumberFormatException e) { }
        return null;
    }

    public Reservacion[] listarTodos() { 
        Reservacion[] arrayFinal = new Reservacion[cantReservas];
        System.arraycopy(this.reservas, 0, arrayFinal, 0, cantReservas);
        return arrayFinal;
    }

    public Estadia realizarCheckIn(int idReserva, int numeroHabitacion) {
        if (cantEstadias >= MAX_ESTADIAS) return null; 
        
        Reservacion reserva = buscarPorId(String.valueOf(idReserva));
        Habitacion habitacion = gestionHabitaciones.buscarPorId(String.valueOf(numeroHabitacion));
        
        if (reserva == null || habitacion == null || !habitacion.estaDisponible()) return null;
        
        Estadia nuevaEstadia = new Estadia(nextEstadiaId++, reserva, habitacion, LocalDate.now());
        
        this.estadias[cantEstadias] = nuevaEstadia;
        this.cantEstadias++;
        
        habitacion.setEstado("Ocupada"); 
        reserva.setEstado("Confirmada"); 
        
        return nuevaEstadia;
    }
    
    public Estadia buscarEstadiaPorId(int idEstadia) {
        for (int i = 0; i < cantEstadias; i++) {
            if (this.estadias[i].getIdEstadia() == idEstadia) {
                return this.estadias[i];
            }
        }
        return null;
    }

    public Factura realizarCheckOut(int idEstadia) {
        Estadia estadia = buscarEstadiaPorId(idEstadia);
        if (estadia == null || (estadia.getEstado() != null && estadia.getEstado().equals("Finalizada")) || cantFacturas >= MAX_FACTURAS) return null;
        
        estadia.registrarCheckOut(LocalDate.now());
        estadia.getHabitacionAsignada().setEstado("Sucia");
        
        long noches = estadia.calcularNochesReales();
        double costoHabitacion = noches * estadia.getHabitacionAsignada().getPrecioPorNoche();

        double costoServicios = 0.0;
        if(gestionConsumos != null) {
            ConsumoServicio[] consumosEstadia = gestionConsumos.obtenerConsumosPorEstadia(idEstadia);
            if(consumosEstadia != null) {
                for (ConsumoServicio c : consumosEstadia) {
                    if(c != null) costoServicios += c.getCostoTotal();
                }
            }
        }

        Factura factura = new Factura(nextFacturaId++, estadia, costoHabitacion, costoServicios);
        this.facturas[cantFacturas] = factura;
        this.cantFacturas++;
        
        return factura;
    }
    
    // --- 5. MÉTODO DEL REPORTE (CORREGIDO CON TUS GETTERS) ---
    public double[] generarReporteIngresos(LocalDate inicio, LocalDate fin) {
        double totalHab = 0;
        double totalServ = 0;
        
        // A) Iterar el Arreglo de Facturas (Datos Nuevos)
        for (int i = 0; i < cantFacturas; i++) {
            Factura f = this.facturas[i];
            if (f != null && !f.getFechaEmision().isBefore(inicio) && !f.getFechaEmision().isAfter(fin)) {
                
                // --- CORRECCIÓN AQUÍ: Usamos los nombres de TU clase Factura ---
                totalHab += f.getTotalNoches();     // Antes decía getCostoTotalHabitacion
                totalServ += f.getTotalServicios(); // Antes decía getCostoTotalServicios
            }
        }
        
        // B) Iterar el Arreglo de Historial (Datos Antiguos/Prueba)
        for (int i = 0; i < cantHistorial; i++) {
            IngresoHistorico h = this.historialAntiguo[i];
            
            boolean fechaValida = (h.fecha.isEqual(inicio) || h.fecha.isAfter(inicio)) && 
                                  (h.fecha.isEqual(fin) || h.fecha.isBefore(fin));
            
            if (fechaValida) {
                totalHab += h.montoHabitacion;
                totalServ += h.montoServicios;
            }
        }
        
        return new double[] { totalHab, totalServ }; 
    }
}