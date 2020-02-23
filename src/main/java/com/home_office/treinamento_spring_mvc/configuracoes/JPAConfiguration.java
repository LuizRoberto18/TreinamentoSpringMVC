package com.home_office.treinamento_spring_mvc.configuracoes;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableTransactionManagement é annotation que indica que agora vamos usar o controle transacional do Spring
@EnableTransactionManagement
public class JPAConfiguration {

    /*
     * A annotation @Bean, usada em cima dos métodos, é para indicar que os objetos
     * criados por eles vão ser gerenciados pelo Spring e podem ser injetados em
     * qualquer ponto do código.
     */
    @Bean
    /*
     * o método entityManagerFactory cria alguns objetos que são importantes para o
     * nosso entendimento do que realmente está acontecendo
     */
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        /*
         * A classe LocalContainerEntityManagerFactoryBean é a abstração do arquivo
         * persistence.xml, que geralmente é necessário para termos a JPA funcionando no
         * nosso projeto
         */
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] { "com.home_office.treinamento_spring_mvc.models" });

        /*
         * A classe HibernateJpaVendorAdapter representa a nossa escolha de
         * implementação da JPA que, no nosso projeto, será o Hibernate
         */
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());

        return em;
    }

    /*
     * O método dataSource() serve para configurarmos os parâmetros de conexão com o
     * banco de dados
     */
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:8080/bancoMVC");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        return dataSource();
    }

    public Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty("hibernate.show_sql", "true");

        return properties;
    }

    // A classe PlatformTransactionManager é justamente o ponto central do Spring para esse controle

    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();

        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }
}