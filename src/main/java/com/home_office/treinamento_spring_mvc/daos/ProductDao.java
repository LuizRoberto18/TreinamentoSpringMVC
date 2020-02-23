package com.home_office.treinamento_spring_mvc.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.home_office.treinamento_spring_mvc.models.Produto;
import org.springframework.stereotype.Repository;


@Repository
public class ProductDao{
    
    /*@PersistenceContext. Essa annotation vem da própria especificação JPA. Geralmente, ela é usada dentro dos servidores JavaEE,
    mas nada impede de outro framework qualquer fazer uso da mesma.*/
    @PersistenceContext
    private EntityManager manager;

    public void save(Produto produto){
        manager.persist(produto);
    }
}