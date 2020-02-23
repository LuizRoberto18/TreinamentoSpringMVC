package com.home_office.treinamento_spring_mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*Agora precisamos ensinar ao Spring MVC que essa classe, efetivamente,
é responsável por atender requisições vindas de um cliente, nesse caso o navegador.
Para isso, vamos adicionar a annotation @Controller nela.*/
@Controller
public class HomeController{
    
    /*Essa última configuração que acabamos de fazer é também conhecida como binding.
    Fizemos a ligação entre uma rota e o método responsável por tratá-la.*/
    @RequestMapping("/")
    public String  index(){
        System.out.println("carregando os produtos.");
        return "hello-world";
    }

}