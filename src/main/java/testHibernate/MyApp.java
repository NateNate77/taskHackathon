package testHibernate;

import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import testHibernate.dao.PersonDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Configuration
public class MyApp {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonDAO.class);

    DriverManagerDataSource dataSource;
    final Server server;

    public MyApp() throws SQLException {
        server = Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9898");
        LOGGER.info(String.format("Started server: ", server.toString()));

        LOGGER.info(String.format("Construct: %s", getClass().getClassLoader().toString()));
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
//        dataSource.setUrl("jdbc:h2:mem:test");
        dataSource.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("sa");
        dataSource.setPassword("");


        try {
            Connection conn = dataSource.getConnection();

            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("schema.sql");
            String createTable = readFromInputStream(inputStream);
            System.out.println(createTable);

            PreparedStatement stmt = conn.prepareStatement(createTable);


            stmt.execute();
            stmt.close();


        }
        catch (Exception e){
            e.printStackTrace();
        }

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("data.sql");
            String insertData = readFromInputStream(inputStream);
            System.out.println(insertData);

            Connection conn = dataSource.getConnection();

            PreparedStatement stmt2 = conn.prepareStatement(insertData);


            stmt2.execute();
            stmt2.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        return dataSource;
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server inMemoryH2DatabaseaServer() {
        return server;
    }


        private String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");

            }
        }
        catch (Exception e){

        }
        return resultStringBuilder.toString();
    }


}


