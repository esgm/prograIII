package controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.TreeNode;
import service.TreeDepthService;

import java.util.HashMap;
import java.util.Map;

@Path("/arbol")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TreeController {

    private final TreeDepthService service = new TreeDepthService();

    @POST
    @Path("/profundidades")
    public Response calcularProfundidades(TreeNode raiz) {
        if (raiz == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("El árbol recibido es nulo")
                    .build();
        }

        int profundidadMin = service.calcularProfundidadMinima(raiz);
        int profundidadMax = service.calcularProfundidadMaxima(raiz);

        Map<String, Integer> resultado = new HashMap<>();
        resultado.put("profundidadMinima", profundidadMin);
        resultado.put("profundidadMaxima", profundidadMax);

        return Response.ok(resultado).build();
    }
}
