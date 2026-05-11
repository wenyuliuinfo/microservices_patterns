import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.function.Supplier;

public class WaitForMySql extends DefaultTask {

    //Main function
    @TaskAction
    public void waitForMySql() {
        System.out.println("Waiting for MySql...");
        loadDriver();
        waitForConnection();
    }

    //Function to get environment variable, set to default if none
    private String getenv(String name, String defaultValue) {
        return Optional.ofNullable(System.getenv(name)).orElse(defaultValue);
    }
    
    private String getenv(String name, Supplier<String> defaultValue) {
        return Optional.ofNullable(System.getenv(name)).orElseGet(defaultValue);
    }
    
    //Function to load database driver
    private void loadDriver() {
        try {
            System.out.println("Trying to initialize driver");
            String datasourceDriverClassName = getenv("SPRINT_DATASOURCE_DRIVER_CLASS_NAME", "com.mysql.jdbc.Driver");
            Class.forName(datasourceDriverClassName);
            System.out.println("Initialization Succeed");
        } catch (ClassNotFoundException e) {
            System.out.println("Initialization Failed");
            throw new RuntimeException(e);
        }
    }

    //Function to wait for database connection
    private void waitForConnection() {
        while (true) {
            Connection connection = null;
            try {
                System.out.println("Trying to connect...");
                String datasourceUrl = getenv("SPRING_DATASOURCE_URL", () -> String.format("jdbc:mysql://%s/ftgo", getenv("DOCKER_HOST_IP", "localhost")));
                String datasourceUsername = getenv("SPRING_DATASOURCE_USERNAME", "mysqluser");
                String datasourcePassword = getenv("SPRING_DATASOURCE_PASSWORD", "mysqlpw");
                connection = DriverManager.getConnection(datasourceUrl, datasourceUsername, datasourcePassword);
                System.out.println("Connection Succeed");
            } catch (SQLException e) {
                System.out.println("Connection Failed");
                sleep();
            } finally {
                if (connection != null) {
                    closeConnection(connection);
                }
            }
        
        }
    }

    private void closeConnection(Connection connection) {
        try {
            System.out.println("Trying to close connection");
            connection.close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            System.out.println("Failed to close connection, see stack trace: ");
            e.printStackTrace();
        }
    }

    private void sleep() {
        System.out.println("Sleep for 5 seconds...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }
    }
}

