package com.beesion.ms.test.resource;

import com.beesion.ms.model.Libro;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/libros")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LibroResource {

    @GET
    public List<Libro> obtenerTodos() {
        return Libro.listAll();
    }

    @GET
    @Path("/{id}")
    public Libro obtenerPorId(@PathParam("id") Long id) {
        Libro libro = Libro.findById(id);
        if (libro == null) {
            throw new NotFoundException("Libro no encontrado con id " + id);
        }
        return libro;
    }

    @POST
    @Transactional
    public Response crear(Libro libro) {
        libro.persist();
        return Response.status(Response.Status.CREATED).entity(libro).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Libro actualizar(@PathParam("id") Long id, Libro libroActualizado) {
        Libro libro = Libro.findById(id);
        if (libro == null) {
            throw new NotFoundException("Libro no encontrado con id " + id);
        }
        libro.titulo = libroActualizado.titulo;
        libro.autor = libroActualizado.autor;
        libro.anioPublicacion = libroActualizado.anioPublicacion;
        libro.genero = libroActualizado.genero;
        return libro;
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response eliminar(@PathParam("id") Long id) {
        boolean eliminado = Libro.deleteById(id);
        if (!eliminado) {
            throw new NotFoundException("Libro no encontrado con id " + id);
        }
        return Response.noContent().build();
    }
}
