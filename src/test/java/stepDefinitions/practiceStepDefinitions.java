package stepDefinitions;

import io.cucumber.java.en.Given;
import utilities.JDBCReusableMethods;
import manage.QueryManage;
import utilities.InsertIntoMethods;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class practiceStepDefinitions {
    String query, expectedStr, actualStr, loan_number, lastname;
    int rowCount,expectedInt, actualInt;
    QueryManage queryManage = new QueryManage();
    ResultSet resultSet;
    PreparedStatement preparedStatement;

// ---------------------------------------------------------QO1---------------------------------------------------------
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

// ---------------------------------------------------------QO2---------------------------------------------------------
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

// ---------------------------------------------------------QO3---------------------------------------------------------
    @Given("Prepare and execute the query03.")
    public void prepare_and_execute_the_query03() throws SQLException {
        rowCount = InsertIntoMethods.admin_password_resetsInsert();
    }
    @Given("Process the results for query03.")
    public void process_the_results_for_query03() {
        assertEquals(1, rowCount);
    }

// ---------------------------------------------------------QO4---------------------------------------------------------
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

// ---------------------------------------------------------QO5---------------------------------------------------------
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

// ---------------------------------------------------------QO6---------------------------------------------------------
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

// ---------------------------------------------------------QO7---------------------------------------------------------
    @Given("Prepare and execute the query07.")
    public void prepare_and_execute_the_query07() throws SQLException {
        InsertIntoMethods.device_tokensInsert();
    }

// ---------------------------------------------------------QO8---------------------------------------------------------
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

// ---------------------------------------------------------Q09---------------------------------------------------------









// ---------------------------------------------------------Q10---------------------------------------------------------
    @Given("Prepare and execute the query10.")
    public void prepare_and_execute_the_query10() throws SQLException {
        InsertIntoMethods.cron_job_logsInsert();
    }

// ---------------------------------------------------------Q11---------------------------------------------------------
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

// ---------------------------------------------------------Q12---------------------------------------------------------
    @Given("Prepare and execute the query12.")
    public void prepare_and_execute_the_query12() throws SQLException {
        query = queryManage.getPracticeQuery12();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setString(1,"%a%");
        resultSet = preparedStatement.executeQuery();
    }
    @Given("Process the results for query12.")
    public void process_the_results_for_query12() throws SQLException {
        while (resultSet.next()){
            System.out.println("|id|: " + resultSet.getInt("id") +
                    " |email|: " + resultSet.getString("email") +
                    " |created_at|: " + resultSet.getTimestamp("created_at") +
                    " |updated_at|: " + resultSet.getTimestamp("updated_at") + "|");
        }
    }

// ---------------------------------------------------------Q13---------------------------------------------------------
    @Given("Prepare and execute the query13.")
    public void prepare_and_execute_the_query13() throws SQLException {
        query = queryManage.getPracticeQuery13();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);
    }
    @Given("Process the results for query13.")
    public void process_the_results_for_query13() throws SQLException {
        while (resultSet.next()){
            System.out.println(resultSet.getString("city") +
                    " |user_ids|: " + resultSet.getString("user_ids") +
                    " |user_ips|: " + resultSet.getString("user_ips"));
        }
    }

// ---------------------------------------------------------Q14---------------------------------------------------------
    @Given("Prepare and execute the query14.")
    public void prepare_and_execute_the_query14() throws SQLException {
        InsertIntoMethods.categoriesInsert();
    }

// ---------------------------------------------------------Q15---------------------------------------------------------
    @Given("Prepare and execute the query15.")
    public void prepare_and_execute_the_query15() throws SQLException {
        query = queryManage.getPracticeQuery15();
        resultSet = JDBCReusableMethods.getStatement().executeQuery(query);
    }
    @Given("Process the results for query15.")
    public void process_the_results_for_query15() throws SQLException {
        boolean condition = true;
        resultSet.next();
        while (condition){
            if (resultSet.getString("lastname") == null) {
                resultSet.next();
            }else {
                lastname = resultSet.getString("lastname");
                condition = false;
            }
        }
        assertEquals("ABSHIREBATZ", lastname);
        System.out.println("lastname: " + lastname);
    }

// ---------------------------------------------------------Q16---------------------------------------------------------
    @Given("Prepare and execute the query16.")
    public void prepare_and_execute_the_query16() throws SQLException {
        query = queryManage.getPracticeQuery16();
        preparedStatement = JDBCReusableMethods.getConnection().prepareStatement(query);
        preparedStatement.setInt(1, 1000);
        resultSet = preparedStatement.executeQuery();
    }
    @Given("Process the results for query16.")
    public void process_the_results_for_query16() throws SQLException {
        List<BigDecimal> actualTotalAmount = new ArrayList<>();
        while (resultSet.next()){
            actualTotalAmount.add(resultSet.getBigDecimal("total_amount"));
        }

        List<BigDecimal> expectedTotalAmount = new ArrayList<>();

    }


}
