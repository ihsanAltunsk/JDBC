package stepDefinitions;

import io.cucumber.java.en.Given;
import utilities.JDBCReusableMethods;
import utilities.QueryManage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class stepDefinition {
    PreparedStatement preparedStatement;
    ResultSet resultSet;

    QueryManage queryManage = new QueryManage();
    @Given("Establish a database connection.")
    public void establish_a_database_connection() {
        JDBCReusableMethods.createConnection();
    }
    @Given("Query01 Prepare and execute the query.")
    public void query01_prepare_and_execute_the_query() throws SQLException {
        String query= queryManage.getChatUsersQuery();

        resultSet= JDBCReusableMethods.getStatement().executeQuery(query);
    }
    @Given("ResultSet01 Process the results.")
    public void result_set01_process_the_results() {

    }
    @Given("Close the database connection.")
    public void close_the_database_connection() {

    }
}
