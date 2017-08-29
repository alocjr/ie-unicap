/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.fullstack.endpoint;

import br.unicap.fullstack.model.Desenvolvedor;
import br.unicap.fullstack.service.DesenvolvedorService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
/**
 *
 * @author Tj
 */
@Path("/hello")
public class DesenvolvedorEndPoint {

    @Inject
    DesenvolvedorService service;
    
    
    @GET
    @Path("fill")
    @Produces("application/json")
    public Response fill() throws Exception {
        service.fill();
        return Response.ok().build();
    }
    
    @GET
    @Produces("application/json")
    public List<Desenvolvedor> list() throws Exception {
        return service.list();
    }
    
    @PUT
    @Consumes("application/json")
    public Response add(Desenvolvedor desenv) {
        service.insert(desenv);
        return Response.ok().build();
    }
   
    @POST
    @Consumes("application/json")
    public Response update(Desenvolvedor desenv) {
        if(desenv.getNome()==null || desenv.getNome().isEmpty()) 
            return Response.serverError().build();
        service.update(desenv);
        return Response.ok().build();
    }
    
    @DELETE
    @Consumes("application/json")
    public Response delete(Desenvolvedor desenv) {
        service.delete(desenv);
        return Response.ok().build();
    }
   
}
