package org.eber.palabras.resource;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import org.eber.palabras.model.BoardRequest;
import org.eber.palabras.service.PalabraValidatorService;

@Path("/validar")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PalabrasResource {

    private final PalabraValidatorService service = new PalabraValidatorService();

    @POST
    public Response validar(BoardRequest request) {
        System.out.println("Solicitud recibida...");
        boolean resultado = service.validar(request.board, request.diccionario);
        System.out.println("Resultado: " + resultado);
        return Response.ok(resultado).build();
    }
}
