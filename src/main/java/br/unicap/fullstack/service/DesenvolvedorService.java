/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.fullstack.service;

import br.unicap.fullstack.model.Desenvolvedor;
import br.unicap.fullstack.persistence.GenericDAO;
import javax.ejb.Stateless;

/**
 *
 * @author tj
 */
@Stateless
public class DesenvolvedorService extends GenericDAO<Desenvolvedor>{
    
    public void fill(){
        Desenvolvedor d = new Desenvolvedor(1, "Catapóbio",1000);
        insert(d);
        d = new Desenvolvedor(2, "Saponácio",2000);
        insert(d);
        d = new Desenvolvedor(3, "Coniglio",3000);
        insert(d);
    }
    
    
}
