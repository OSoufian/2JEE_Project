package com.supinfo.demo;

import com.supinfo.DAOFactory.ObjectEntityDAO;
import com.supinfo.entities.ObjectEntity;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/objects")
public class HelloResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListObject() {
        ObjectEntityDAO objectEntityDAO = new ObjectEntityDAO();
        return Response.status(200).entity(objectEntityDAO.serialObjectsEntities(objectEntityDAO.getAll())).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    public Response findByName(@PathParam("name") String name){

        ObjectEntityDAO objectEntityDAO = new ObjectEntityDAO();
        return Response.status(200).entity(objectEntityDAO
                .serialObjectsEntities(objectEntityDAO.getByName(name))).build();

    }
}