package org.acme.controllers;

import org.acme.models.response.Presupuesto;
import org.acme.models.response.Gasto;
import org.acme.services.api.PresupuestoService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/presupuestos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PresupuestoController {

    @Inject
    PresupuestoService presupuestoService;

    @POST
    public Response crearPresupuesto(Presupuesto presupuesto) {
        presupuestoService.crearPresupuesto(presupuesto);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public List<Presupuesto> listarPresupuestos() {
        return presupuestoService.listarPresupuestos();
    }

    @GET
    @Path("/{presupuestoId}")
    public Response obtenerPresupuesto(@PathParam("presupuestoId") int presupuestoId) {
        Presupuesto presupuesto = presupuestoService.obtenerPresupuesto(presupuestoId);
        if (presupuesto != null) {
            return Response.ok(presupuesto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/total-gastos/{presupuestoId}")
    public Response obtenerTotalGastos(@PathParam("presupuestoId") int presupuestoId) {
        Double totalGastos = presupuestoService.obtenerTotalGastos(presupuestoId);
        if (totalGastos != null) {
            return Response.ok(totalGastos).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("/agregar-gasto/{presupuestoId}")
    public Response agregarGasto(@PathParam("presupuestoId") int presupuestoId, Gasto gasto) {
        boolean resultado = presupuestoService.agregarGasto(presupuestoId, gasto);
        if (resultado) {
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
