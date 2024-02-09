Feature: JDBC Practice

  Background:
    * Establish a database connection.
  @Query02
  Scenario: Verify the "remember_token" for the data with "email=info@loantechexper.com"
            in the "admins" table in the database.
    * Prepare and execute the query01.
    * Process the results for query01.
    * Close the database connection.
  @Query03
  Scenario: Verify the "charge" value for the data with trx="4GC9SMZUS69S" in the
            "Deposits" table where the "amount" is below $5000.
    * Prepare and execute the query02.
    * Process the results for query02.
    * Close the database connection.

  Scenario: Add multiple entries simultaneously to the "admin_password_resets" table
            in the database.
    * Prepare and execute the query03.
    * Process the results for query03.
    * Close the database connection.

  Scenario: Verify the "support_ticket_id" for the data in the "Support_messages"
            table with "?" in the "message" field.
    * Prepare and execute the query04.
    * Process the results for query04.
    * Close the database connection.

  Scenario: Verify the "subject" information for the data in the "support_tickets"
            table where the "ticket" value starts with 4.
    * Prepare and execute the query05.
    * Process the results for query05.
    * Close the database connection.

  Scenario: Delete the requested data using "loan_number" in the "loans" table in the
            database and confirm the deletion.


  Scenario: Add the desired data to the "divice_tokens" table in a single query.


  Scenario: Verify the count of users with "user id=1" and "is_read=0" in the
            "admin_notifications" table.


  Scenario: Verify the users with "user id=2" in the "admin_notifications" table whose
            "id" is greater than 20.


  Scenario: Insert data into the "cron_job_logs" table and confirm that it has been added.


  Scenario: List the top 5 "code" values in the "Gateways" table.


  Scenario: List data in the "Subscribers" table where the "email" does not contain "a."


  Scenario: Separate "user_id" and "user_ip" in the "user_logins" table according
            to the city.


  Scenario: Add data containing only "id, name, description" to the "Catagories" table.
            Confirm the addition.


  Scenario: List all records in the "Users" table sorted by "lastname" in ascending order
            and "firstname" in descending order. Verify the first last name in the list.


  Scenario: Calculate the total "amount" values in the "Transactions" table based on the
            "remark" type and verify those exceeding $1000.


  Scenario: Verify the count of users in the "admin_notifications" table with "is_read=1"
            and "user_id=1."


  Scenario: Update the password reset request for the user with "status=0" in the
            "admin_password_resets" table by entering the "email" information.


  Scenario: List the Deposits with "status=1" in a specific "created_at" range along with
            their total amounts.


  Scenario: Calculate the total amount of Deposits with "currency=USD" using the
            "gateway_currencies" table.


  Scenario: Calculate and group the "total_delay_charge" amount for loans with
            "loan_id=1" based on the "loan_id."


  Scenario: Verify the "name" information for the first three entries in the "loan_plans"
            table based on "delay_value" and "fixed_charge" or "percent_charge."

