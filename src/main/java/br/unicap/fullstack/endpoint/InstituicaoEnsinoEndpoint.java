/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.fullstack.endpoint;


import br.unicap.fullstack.model.InstituicaoEnsino;

import br.unicap.fullstack.service.InstituicaoEnsinoService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
/**
 *
 * @author Tj
 */
@Path("/ie")
public class InstituicaoEnsinoEndpoint {

    @Inject
    InstituicaoEnsinoService service;
    
    
  
    @GET
    @Produces("application/json")
    public List<InstituicaoEnsino> list() throws Exception {
        return service.list();
    }
    
    @GET
    @Produces("application/json")
    @Path("/{description:.+}")
    public List<InstituicaoEnsino> list(
            @PathParam("description") String description) throws Exception {
        return service.filterByDescription(description);
    }
   
    @PUT
    @Consumes("application/json")
    public Response add(InstituicaoEnsino instituicaoEnsino) {
        service.insert(instituicaoEnsino);
        return Response.ok().build();
    }
   
    @POST
    @Consumes("application/json")
    public Response update(InstituicaoEnsino instituicaoEnsino) {
        
        service.update(instituicaoEnsino);
        return Response.ok().build();
    }
    
    @DELETE
    @Consumes("application/json")
    public Response delete(InstituicaoEnsino instituicaoEnsino) {
        service.delete(instituicaoEnsino);
        return Response.ok().build();
    }
   
}
