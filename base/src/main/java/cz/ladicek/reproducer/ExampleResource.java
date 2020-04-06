package cz.ladicek.reproducer;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@Path("/example")
public class ExampleResource {
    @GET
    public List<Example> getAll() {
        return Example.listAll();
    }

    @GET
    @Path("/{id}")
    public Example get(@PathParam("id") Long id) {
        Example example = Example.findById(id);
        if (example == null) {
            throw new NotFoundException("example '" + id + "' not found");
        }
        return example;
    }
}
