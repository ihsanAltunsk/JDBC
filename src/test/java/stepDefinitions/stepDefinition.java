package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import utilities.JDBCReusableMethods;
import manage.QueryManage;
import utilities.InsertIntoMethods;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class stepDefinition {
    String query, version, expectedStr, actualStr, loan_number, updateLog;
    int rowCount, id, supportMessageID,expectedInt, actualInt;
    QueryManage queryManage = new QueryManage();
    ResultSet resultSet;
    PreparedStatement preparedStatement;
    Faker faker= new Faker();
    Random random = new Random();

    @Given("Establish a database connection.")
    public void establish_a_database_connection() {
        JDBCReusableMethods.createConnection();
    }
    @Given("Query01 Prepare and execute the query.")
    public void query01_prepare_and_execute_the_query() throws SQLException {
        query = queryManage.getQuery01();

        // OPTION 1
        query = queryManage.getQuery01();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);

        // OPTION 2
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,100);
        preparedStatement.setInt(2,500);
        resultSet = preparedStatement.executeQuery();
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
// ---------------------------------------------------------------------------------------------------------------------
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
// ---------------------------------------------------------------------------------------------------------------------
    @Given("Query03 Prepare and execute the query.")
    public void query03_prepare_and_execute_the_query() throws SQLException {
        query = queryManage.getQuery03();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);
    }
    @Given("ResultSet03 Process the results.")
    public void result_set03_process_the_results() throws SQLException {
        String expectedName = "Mehmet Genç";
        resultSet.next();
        String actualName = resultSet.getString("firstname") +
                " " + resultSet.getString("lastname");
        assertEquals(expectedName, actualName);
    }
// ---------------------------------------------------------------------------------------------------------------------
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
// ---------------------------------------------------------------------------------------------------------------------
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
// ---------------------------------------------------------------------------------------------------------------------
    @Given("preparedQuery05 Prepare and execute the query.")
    public void prepared_query05_prepare_and_execute_the_query() throws SQLException {
        query = queryManage.getUpdatePreparedQuery05();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, 444444444);
        preparedStatement.setString(2, "%e_");

        rowCount = preparedStatement.executeUpdate();
    }
    @Given("preparedQuery05 Validate the results.")
    public void prepared_query05_validate_the_results() {
        assertEquals(18, rowCount);
    }
// ---------------------------------------------------------------------------------------------------------------------
    @Given("preparedQuery06 Prepare and execute the query.")
    public void prepared_query06_prepare_and_execute_the_query() throws SQLException {
        rowCount = InsertIntoMethods.admin_password_resetsInsert();
    }
    @Given("preparedQuery06 Validate the results.")
    public void prepared_query06_validate_the_results() {
        assertEquals(1, rowCount);
    }
// ---------------------------------------------------------------------------------------------------------------------
    @Given("preparedQuery07 Prepare and execute the query.")
    public void prepared_query07_prepare_and_execute_the_query() throws SQLException {
    query = queryManage.getUpdatepreparedQuery07();
    preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
    preparedStatement.setInt(1,1);
    preparedStatement.setInt(2,773);
    rowCount = preparedStatement.executeUpdate();
    }
    @Given("preparedQuery07 Validate the results.")
    public void prepared_query07_validate_the_results() {
        assertEquals(1, rowCount);
    }
// ---------------------------------------------------------------------------------------------------------------------
    @Given("Prepare and execute an insert query for the update_logs table.")
    public void prepare_and_execute_an_insert_query_for_the_table() throws SQLException {
        id = InsertIntoMethods.update_logsInsert();
    }
    @Given("Modify the update log value of the data inserted into the update_logs table.")
    public void modify_the_update_log_value_of_the_data_inserted_into_the_table() throws SQLException {
        query = queryManage.getUpdatePreparedQuery08();
        String updatedLog = "Updated Log";
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setString(1,updatedLog);
        preparedStatement.setString(2,version);
        preparedStatement.setInt(3,id);

        rowCount = preparedStatement.executeUpdate();
    }
    @Given("Confirm the change in the update log value.")
    public void confirm_the_change_in_the_update_log_value() {
        assertEquals(1,rowCount);
    }
// ---------------------------------------------------------------------------------------------------------------------
    @Given("Delete the data inserted into the update_logs table.")
    public void delete_the_data_inserted_into_the_update_logs_table() throws SQLException {
        query = queryManage.getDeletePreparedQuery09();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,id);

        rowCount = preparedStatement.executeUpdate();
    }
    @Given("Confirm the deletion.")
    public void confirm_the_deletion() {
        assertEquals(1,rowCount);
    }
// ---------------------------------------------------------------------------------------------------------------------
    @Given("Prepare and execute an insert query for the support_attachments table.")
    public void prepare_and_execute_an_insert_query_for_the_support_attachments_table() throws SQLException {
        supportMessageID = InsertIntoMethods.support_attachmentsInsert();
    }
    @Given("Delete the data inserted into the support_attachments table.")
    public void delete_the_data_inserted_into_the_support_attachments_table() throws SQLException {
        query = queryManage.getDeletePreparedQuery10();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,supportMessageID);

        rowCount = preparedStatement.executeUpdate();
    }
// ---------------------------------------------------------------------------------------------------------------------
    @Given("Prepare and execute the query01.")
    public void prepare_and_execute_the_query01() throws SQLException {
        query = queryManage.getPracticeQuery01();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setString(1,"info@loantechexper.com");

        resultSet = preparedStatement.executeQuery();
    }
    @Given("Process the results for query01.")
    public void process_the_results_for_query01() throws SQLException {
        resultSet.next();
        expectedStr = "1xUgfVUD1Ggx5CVz7mxLvcye8RXRbeFqSktSIkhya321TqDkLOsqhys4pnJv";
        actualStr = resultSet.getString("remember_token");
        assertEquals(expectedStr,actualStr);
    }
// ---------------------------------------------------------------------------------------------------------------------
    @Given("Prepare and execute the query02.")
    public void prepare_and_execute_the_query02() throws SQLException {
        query = queryManage.getPracticeQuery02();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);

        preparedStatement.setInt(1,5000);
        preparedStatement.setString(2,"4GC9SMZUS69S");
        resultSet = preparedStatement.executeQuery();
    }
    @Given("Process the results for query02.")
    public void process_the_results_for_query02() throws SQLException {
        resultSet.next();
        expectedInt = 102;
        actualInt = resultSet.getInt("charge");
        assertEquals(expectedInt,actualInt);
    }
// ---------------------------------------------------------------------------------------------------------------------
    @Given("Prepare and execute the query03.")
    public void prepare_and_execute_the_query03() throws SQLException {
        rowCount = InsertIntoMethods.admin_password_resetsInsert();
    }
    @Given("Process the results for query03.")
    public void process_the_results_for_query03() {
        assertEquals(1, rowCount);
    }
// ---------------------------------------------------------------------------------------------------------------------
    @Given("Prepare and execute the query04.")
    public void prepare_and_execute_the_query04() throws SQLException {
        query = queryManage.getPracticeQuery04();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setString(1,"automation");

        resultSet = preparedStatement.executeQuery();
    }
    @Given("Process the results for query04.")
    public void process_the_results_for_query04() throws SQLException {
        resultSet.next();
        expectedInt = 18;
        actualInt = resultSet.getInt("support_ticket_id");
        assertEquals(expectedInt,actualInt);
    }
// ---------------------------------------------------------------------------------------------------------------------
    @Given("Prepare and execute the query05.")
    public void prepare_and_execute_the_query05() throws SQLException {
        query = queryManage.getPracticeQuery05();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setString(1,"4%");

        resultSet = preparedStatement.executeQuery();
    }
    @Given("Process the results for query05.")
    public void process_the_results_for_query05() throws SQLException {
        List<String> actualSubject = new ArrayList<>();
        while (resultSet.next()) {
            actualSubject.add(resultSet.getString("subject"));
        }

        List<String> expectedSubject = new ArrayList<>();
        expectedSubject.add("testSubject");
        expectedSubject.add("Loantech");
        expectedSubject.add("s");
        expectedSubject.add("deserunt");
        expectedSubject.add("asdasd");
        expectedSubject.add("Test Ticket");
        expectedSubject.add("Test_attachment");
        expectedSubject.add("HelloWorld");
        expectedSubject.add("Ticket666");
        expectedSubject.add("Blue Test Ticket");
        expectedSubject.add("AhmetKaya");
        expectedSubject.add("deneme");
        expectedSubject.add("Test Ticket1");

        for (String each : actualSubject) {
            assertTrue(expectedSubject.contains(each));
        }
    }
// ---------------------------------------------------------------------------------------------------------------------
    @Given("Prepare and execute the query06.")
    public void prepare_and_execute_the_query06() throws SQLException {
        loan_number = InsertIntoMethods.loansInsert();
    }
    @Given("Process the results for query06.")
    public void process_the_results_for_query06() throws SQLException {
        query = queryManage.getPracticeQuery06Delete();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setString(1, loan_number);
        rowCount = preparedStatement.executeUpdate();

        assertEquals(1,rowCount);
    }
// ---------------------------------------------------------------------------------------------------------------------
    @Given("Prepare and execute the query07.")
    public void prepare_and_execute_the_query07() throws SQLException {
        InsertIntoMethods.device_tokensInsert();
    }
// ---------------------------------------------------------------------------------------------------------------------
    @Given("Prepare and execute the query08.")
    public void prepare_and_execute_the_query08() throws SQLException {
        query = queryManage.getPracticeQuery08();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, 1);
        preparedStatement.setInt(2, 0);

        resultSet = preparedStatement.executeQuery();
    }
    @Given("Process the results for query08.")
    public void process_the_results_for_query08() throws SQLException {
        int count = 0;
        while (resultSet.next()){
            count++;
        }

        assertEquals(2, count);
    }
// ---------------------------------------------------------------------------------------------------------------------
    @Given("Prepare and execute the query10.")
    public void prepare_and_execute_the_query10() throws SQLException {
        InsertIntoMethods.cron_job_logsInsert();
    }
// ---------------------------------------------------------------------------------------------------------------------
    @Given("Prepare and execute the query11.")
    public void prepare_and_execute_the_query11() throws SQLException {
        query = queryManage.getPracticeQuery11();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setInt(1,5);
        resultSet = preparedStatement.executeQuery();
    }
    @Given("Process the results for query11.")
    public void process_the_results_for_query11() throws SQLException {
        while (resultSet.next()){
            System.out.println(resultSet.getInt("code"));
        }
    }
// ---------------------------------------------------------------------------------------------------------------------
    @Given("Prepare and execute the query12.")
    public void prepare_and_execute_the_query12() {

    }
    @Given("Process the results for query12.")
    public void process_the_results_for_query12() {

    }
}