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
    int rowCount;
    QueryManage queryManage = new QueryManage();
    ResultSet resultSet;
    PreparedStatement preparedStatement;


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
        assertEquals(expectedName, actualName);
    }
    @Given("Query04 Prepare and execute the query.")
    public void query04_prepare_and_execute_the_query() throws SQLException {
        query = queryManage.getQuery04();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);
    }
    @Given("ResultSet04 Process the results.")
    public void result_set04_process_the_results() throws SQLException {
        while (resultSet.next()) {
            String user_id = resultSet.getString("user_id");
            String browserOS = resultSet.getString("browser_os");

            System.out.println("User id: " + user_id);
            System.out.println("Browser & OS: " + browserOS);
        }
    }
    @Given("UpdateQuery05 Prepare and execute the query.")
    public void update_query05_prepare_and_execute_the_query() throws SQLException {
        query = queryManage.getUpdateQuery05();
        rowCount = JDBCReusableMethods.getStatement().executeUpdate(query);
        rowCount = JDBCReusableMethods.updateQuery(query);
    }
    @Given("UpdateQuery05 Validate the results.")
    public void update_query05_validate_the_results() {
        assertEquals(18,rowCount);
    }
    @Given("preparedQuery05 Prepare and execute the query.")
    public void prepared_query05_prepare_and_execute_the_query() throws SQLException {
        query = queryManage.getPreparedQuery05();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, 444444444);
        preparedStatement.setString(2, "%e_");

        rowCount = preparedStatement.executeUpdate();
    }
    @Given("preparedQuery05 Validate the results.")
    public void prepared_query05_validate_the_results() {
        assertEquals(18,rowCount);
    }
    @Given("preparedQuery06 Prepare and execute the query.")
    public void prepared_query06_prepare_and_execute_the_query() throws SQLException {
        query = queryManage.getPreparedQuery06();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);

        // INSERT INTO admin_password_resets (id,email,token,status) VALUES (?,?,?,?);
        preparedStatement.setInt(1,106);
        preparedStatement.setString(2,"email33@gmail.com");
        preparedStatement.setString(3,"125478");
        preparedStatement.setInt(4,1);
        rowCount = preparedStatement.executeUpdate();
    }
    @Given("preparedQuery06 Validate the results.")
    public void prepared_query06_validate_the_results() {
        assertEquals(1,rowCount);
    }
}
