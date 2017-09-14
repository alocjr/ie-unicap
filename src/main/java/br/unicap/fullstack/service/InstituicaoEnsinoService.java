/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.fullstack.service;

import br.unicap.fullstack.model.InstituicaoEnsino;
import br.unicap.fullstack.persistence.GenericJPARepository;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author tj
 */
@Stateless
public class InstituicaoEnsinoService extends GenericJPARepository<InstituicaoEnsino>{
    
    public InstituicaoEnsinoService(){
        super(InstituicaoEnsino.class);
    }
 
    
    public List<InstituicaoEnsino> filterByDescription(final String description) throws Exception{
        HashMap<String, Object> parameters = new HashMap();
        parameters.put(InstituicaoEnsino.FILTER_PARAM,"%" + description +"%");
        return this.executeQuery(InstituicaoEnsino.FILTER_BY_DESCRIPTION, parameters);
    }
}