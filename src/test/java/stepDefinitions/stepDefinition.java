package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.JDBCReusableMethods;
import manage.QueryManage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class stepDefinition {
    String query;
    QueryManage queryManage = new QueryManage();
    ResultSet resultSet;

    @Given("Establish a database connection.")
    public void establish_a_database_connection() {
        JDBCReusableMethods.createConnection();
    }
    @Given("Query01 Prepare and execute the query.")
    public void query01_prepare_and_execute_the_query() throws SQLException {
        query = queryManage.getQuery01();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);
    }
    @Given("ResultSet01 Process the results.")
    public void result_set01_process_the_results() throws SQLException {
        resultSet.next();
        int actualUserID = resultSet.getInt("user_id");
        int expectedUserID = 1;
        assertEquals(expectedUserID, actualUserID);
    }
    @Given("Close the database connection.")
    public void close_the_database_connection() throws SQLException {
        JDBCReusableMethods.closeConnection();
    }
    @Given("Query02 Prepare and execute the query.")
    public void query02_prepare_and_execute_the_query() throws SQLException {
        query = queryManage.getQuery02();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);
    }
    @Given("ResultSet02 Process the results.")
    public void result_set02_process_the_results() throws SQLException {
        List<String> names = new ArrayList<>();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            names.add(name);
        }

        List<String> expectedNames = new ArrayList<>();
        expectedNames.add("5 Minutes");
        expectedNames.add("10 Minutes");

        for (int i = 0; i < names.size(); i++) {
            assertEquals(expectedNames.get(i), names.get(i));
        }
    }
    @Given("Query03 Prepare and execute the query.")
    public void query03_prepare_and_execute_the_query() throws SQLException {
        query = queryManage.getQuery03();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);

    }
    @Given("ResultSet03 Process the results.")
    public void result_set03_process_the_results() throws SQLException {
        String expectedName = "Mehmet Genç";
        resultSet.next();
        String actualName = resultSet.getString("firstname") + " " + resultSet.getString("lastname");
        assertEquals(expectedName,actualName);
    }
    @Given("Query04 Prepare and execute the query.")
    public void query04_prepare_and_execute_the_query() throws SQLException {
        query = queryManage.getQuery04();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);
    }
    @Given("ResultSet04 Process the results.")
    public void result_set04_process_the_results() throws SQLException {
        while(resultSet.next()){
            String user_id = resultSet.getString("user_id");
            String browserOS = resultSet.getString("browser_os");

            System.out.println("User id: " + user_id);
            System.out.println("Browser & OS: " + browserOS);
        }
    }

}
