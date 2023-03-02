package fr.m2i.resources;

import fr.m2i.database.Database;
import fr.m2i.models.Todo;
import fr.m2i.models.Urgence;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("todo")
public class TodoList {


    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTodoByID(@QueryParam("id") int id) {
        Todo result = Database.getTodoById(id);
        if (result == null) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("Index incorrect")
                    .build();
        } else {
            return Response
                    .status(Response.Status.OK)
                    .entity(result)
                    .build();
        }
    }

    @GET
    @Path("getList")
    @Produces(MediaType.APPLICATION_XML)
    public Response getTodoListXML() {
        Todo[] result = Database.getTodoList();

        return Response
                .status(Response.Status.OK)
                .entity(result)
                .build();
    }

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Todo createTodo(
            @FormParam("title") String title,
            @FormParam("description") String description,
            @FormParam("urgence") int urgence
    ) {
        return new Todo(5, title, description, Urgence.values()[urgence - 1]);
    }

    @POST
    @Path("update")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Todo updateTodo(
            @FormParam("id") int id,
            @FormParam("title") String title,
            @FormParam("description") String description,
            @FormParam("urgence") int urgence
    ) {
        return new Todo(id, title, description, Urgence.values()[urgence - 1]);
    }

    @GET
    @Path("delete")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteTodoByID(
            @QueryParam("id") int id
    ) {
        return true;
    }
}
