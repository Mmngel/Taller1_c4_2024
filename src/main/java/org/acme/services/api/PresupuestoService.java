package org.acme.services.api;

import org.acme.models.response.Presupuesto;
import org.acme.models.response.Gasto;
import org.acme.repository.PresupuestoRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.io.IOException;
import java.util.List;

@ApplicationScoped
public class PresupuestoService {
    private final PresupuestoRepository presupuestoRepository;

    @Inject
    public PresupuestoService(PresupuestoRepository presupuestoRepository) {
        this.presupuestoRepository = presupuestoRepository;
    }

    public void crearPresupuesto(Presupuesto presupuesto) {
        presupuestoRepository.agregarPresupuesto(presupuesto);
        try {
            presupuestoRepository.guardarDatos();
        } catch (IOException e) {
            e.printStackTrace(); // Manejo de errores
        }
    }

    public List<Presupuesto> listarPresupuestos() {
        return presupuestoRepository.listar();
    }

    public Presupuesto obtenerPresupuesto(int id) {
        return presupuestoRepository.obtenerById(id);
    }

    public Double obtenerTotalGastos(int presupuestoId) {
        Presupuesto presupuesto = presupuestoRepository.obtenerById(presupuestoId);
        if (presupuesto != null) {
            return presupuesto.getGastos().stream()
                    .mapToDouble(Gasto::getMonto)
                    .sum();
        }
        return null;
    }

    public boolean agregarGasto(int presupuestoId, Gasto gasto) {
        Presupuesto presupuesto = presupuestoRepository.obtenerById(presupuestoId);
        if (presupuesto != null) {
            double totalGastos = presupuesto.getGastos().stream()
                    .mapToDouble(Gasto::getMonto)
                    .sum();
            if (totalGastos + gasto.getMonto() <= presupuesto.getMontoPresupuestado()) {
                presupuesto.getGastos().add(gasto);
                try {
                    presupuestoRepository.guardarDatos();
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}

