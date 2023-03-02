package fr.m2i.resources;

import fr.m2i.models.Todo;
import fr.m2i.models.Urgence;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("todo")
public class TodoList {
    @GET
    @Path("get")
    @Produces(MediaType.APPLICATION_JSON)
    public Todo getTodoByID(@QueryParam("id") int id) {
        return new Todo(id, "Poubelle", "Sors les poubelles, sérieux", Urgence.HAUTE);
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
