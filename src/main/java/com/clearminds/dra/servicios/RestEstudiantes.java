package com.clearminds.dra.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.clearminds.dra.dtos.Estudiante;
import com.clearminds.dra.excepciones.BDDException;

@Path("/estudiantes")
public class RestEstudiantes {

	@Path("/insertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void insertar(Estudiante estudiante) {
		System.out.println("Insertando estudiante: " + estudiante);
		ServicioEstudiante servEst = new ServicioEstudiante();
		try {
			servEst.insertarEstudiante(estudiante);
		} catch (BDDException e) {
			e.printStackTrace();
		}
	}

	@Path("/actualizar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void actualizar(Estudiante estudiante) {
		ServicioEstudiante servEst = new ServicioEstudiante();
		try {
			servEst.actualizarEstudiante(estudiante);
		} catch (BDDException e) {
			e.printStackTrace();
		}
	}

}
