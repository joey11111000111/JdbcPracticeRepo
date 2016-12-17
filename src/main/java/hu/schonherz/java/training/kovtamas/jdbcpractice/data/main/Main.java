package hu.schonherz.java.training.kovtamas.jdbcpractice.data.main;

import hu.schonherz.java.training.kovtamas.jdbcpractice.data.dao.GenericDAO;
import hu.schonherz.java.training.kovtamas.jdbcpractice.data.dao.ParticipantDAO;
import hu.schonherz.java.training.kovtamas.jdbcpractice.data.dto.ParticipantDTO;
import javax.sql.DataSource;
import org.postgresql.ds.PGPoolingDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"hu.schonherz.java.training.kovtamas.jdbcpractice"})
public class Main {

    @Autowired
    private GenericDAO<ParticipantDTO> dao;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext();
        System.out.println(((ParticipantDAO) context.getBean("participantDAO")).findAll());

        Main main = new Main();
        main.stuff();
    }

    public void stuff() {
        System.out.println(dao.findAll());
    }

    @Bean
    public DataSource createDataSource() {
        PGPoolingDataSource dataSource = new PGPoolingDataSource();

        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("postgres");
        dataSource.setInitialConnections(10);
        dataSource.setMaxConnections(20);
        dataSource.setPortNumber(5432);
        dataSource.setUser("postgres");
        dataSource.setPassword("pass");

        return dataSource;
    }

}
