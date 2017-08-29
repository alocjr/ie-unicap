/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unicap.fullstack.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tj
 * @param <T>
 */
public class GenericDAO<T>{
    
    
    Map<Integer, T> list;
    
    public GenericDAO(){
        list = new HashMap<>();
    }
    
    public void insert(T d){
        this.list.put(d.hashCode(), d);
    }
    
    public void update(T d){
        this.list.put(d.hashCode(), d);
    }
    
    public void delete(T d){
        this.list.remove(d.hashCode());
    }
    
    public void get(T d){
        this.list.get(d.hashCode());
    }
    public List<T> list(){
        return new ArrayList<>(this.list.values());
        
    }
    
            
    
}
