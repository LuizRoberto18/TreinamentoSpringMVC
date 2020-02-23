package com.home_office.treinamento_spring_mvc.configuracoes;

import com.home_office.treinamento_spring_mvc.controllers.HomeController;
import com.home_office.treinamento_spring_mvc.daos.ProductDao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/*A annotation EnableWebMvc, como ela já habilita várias funcionalidades que serão usadas na nossa aplicação web.*/
@EnableWebMvc
/*Neste exato momento, a principal annotation aqui é a @ComponentScan.
Através dela indicamos quais pacotes devem ser lidos.
Perceba que passamos como parâmetro a classe HomeController para que o Spring leia o pacote dela. 
Dessa forma, não passamos uma String e evitamos um possível erro de digitação.*/
@ComponentScan(basePackageClasses = {HomeController.class, ProductDao.class})
public class AppWebConfiguration{

    /*Perceba que é uma classe um tanto quanto estranha. Tem um monte de
    annotation, mas nenhum código. O objetivo principal dela é expor para a
    Servlet do Spring MVC quais são as classes que devem ser lidas e carregadas*/

    /*A annotation @Bean indica para o Spring que o retorno desse
    método deve ser registrado como um objeto gerenciado pelo container. 
    Em geral, no Spring, esses objetos são chamados de Beans.*/
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
       resolver.setPrefix("/resources/templates/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}