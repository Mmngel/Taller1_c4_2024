package org.acme.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.acme.models.response.Presupuesto;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PresupuestoRepository {

    private static final String FILE_PATH = "src/main/resources/gasto.json";
    private List<Presupuesto> presupuestoList;
    private ObjectMapper objectMapper;

    public PresupuestoRepository() {
        objectMapper = new ObjectMapper();
        presupuestoList = cargarDatos();
    }

    private List<Presupuesto> cargarDatos() {
        try {
            File file = new File(FILE_PATH);
            if (file.exists()) {
                return objectMapper.readValue(file, new TypeReference<List<Presupuesto>>() {});
            } else {
                return new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void guardarDatos() throws IOException {
        objectMapper.writeValue(new File(FILE_PATH), presupuestoList);
    }

    public Presupuesto obtenerById(int id) {
        return presupuestoList.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Presupuesto> listar() {
        return new ArrayList<>(presupuestoList);
    }

    public void agregarPresupuesto(Presupuesto presupuesto) {
        presupuestoList.add(presupuesto);
    }
}
