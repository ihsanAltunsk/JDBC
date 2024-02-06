package stepDefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.JDBCReusableMethods;
import manage.QueryManage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        query= queryManage.getQuery01();
        resultSet= JDBCReusableMethods.getStatement().executeQuery(query);
    }
    @Given("ResultSet01 Process the results.")
    public void result_set01_process_the_results() throws SQLException {
        resultSet.next();
        int actualUserID = resultSet.getInt("user_id");
        int expectedUserID = 1;

        Assert.assertEquals(expectedUserID,actualUserID);
    }
    @Given("Close the database connection.")
    public void close_the_database_connection() throws SQLException {
        JDBCReusableMethods.closeConnection();
    }
}
