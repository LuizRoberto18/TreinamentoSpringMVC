package com.home_office.treinamento_spring_mvc.configuracoes;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/*A Servlet responsável por tratar todas as requisições que chegam para o Spring MVC é a DispatcherServlet.*/
public class SeveletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer{

    @Override
    protected Class<?>[] getRootConfigClasses(){
        return null;
    }

    /*Nele, será retornada uma ou mais classes responsáveis por indicar quais outras classes devem ser lidas durante o carregamento da aplicação web.*/
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppWebConfiguration.class,JPAConfiguration.class};
    }

    /*Aqui é onde você diz qual é o padrão de endereço que vai ser delegado para o Servlet do Spring MVC. 
    Caso fôssemos usar o web.xml, essa configuração seria equivalente ao <url-mapping>.*/
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}