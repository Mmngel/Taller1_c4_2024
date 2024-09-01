package org.acme.entities.apiresponse;

import java.util.Date;
import java.util.List;

public class Presupuesto {
    private int id;
    private Date fechaInicio;
    private Date fechaFin;
    private double montoPresupuestado;
    private List<Gasto> gastos;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    public double getMontoPresupuestado() {
        return montoPresupuestado;
    }
    public void setMontoPresupuestado(double montoPresupuestado) {
        this.montoPresupuestado = montoPresupuestado;
    }
    public List<Gasto> getGastos() {
        return gastos;
    }
    public void setGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    // Getters y Setters
}
