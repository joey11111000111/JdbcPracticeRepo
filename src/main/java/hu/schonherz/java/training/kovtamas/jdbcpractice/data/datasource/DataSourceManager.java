package hu.schonherz.java.training.kovtamas.jdbcpractice.data.datasource;

import javax.sql.DataSource;
import org.postgresql.ds.PGPoolingDataSource;

public class DataSourceManager {

    private static PGPoolingDataSource dataSource = null;

    static {
        createDataSource();
    }

    private DataSourceManager() {
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    private static void createDataSource() {
        dataSource = new PGPoolingDataSource();

        dataSource.setServerName("localhost");
        dataSource.setDatabaseName("postgres");
        dataSource.setInitialConnections(10);
        dataSource.setMaxConnections(20);
        dataSource.setPortNumber(5432);
        dataSource.setUser("postgres");
        dataSource.setPassword("pass");
    }

}
