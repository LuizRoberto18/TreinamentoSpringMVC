package com.home_office.treinamento_spring_mvc.controllers;

import javax.transaction.Transactional;

import com.home_office.treinamento_spring_mvc.daos.ProductDao;
import com.home_office.treinamento_spring_mvc.models.Produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//Assim como a @PersistenceContext, a @Transactional pertence a uma especificação do JavaEE, só que nesse caso, a JTA.
@Transactional
public class ProductsController{

    /*A annotation @Autowired é justamente a responsável por indicar os pontos de injeção dentro da sua classe.*/
    @Autowired
    private ProductDao productDao;

    @RequestMapping("/produtos")
    public String save(Produto produto){
        productDao.save(produto);
        return "products/ok";
    }

    @RequestMapping("/produtos/form")
    public String form(){
        return "products/form";
    }
}