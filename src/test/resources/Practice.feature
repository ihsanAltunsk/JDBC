Feature: JDBC Practice

  Background:
    * Establish a database connection.

  Scenario: 1- Verify the "remember_token" for the data with "email=info@loantechexper.com"
            in the "admins" table in the database.
    * Prepare and execute the query01.
    * Process the results for query01.
    * Close the database connection.

  Scenario: 2- Verify the "charge" value for the data with trx="4GC9SMZUS69S" in the
            "Deposits" table where the "amount" is below $5000.
    * Prepare and execute the query02.
    * Process the results for query02.
    * Close the database connection.

  Scenario: 3- Add multiple entries simultaneously to the "admin_password_resets" table
            in the database.
    * Prepare and execute the query03.
    * Process the results for query03.
    * Close the database connection.

  Scenario: 4- Verify the "support_ticket_id" for the data in the "Support_messages"
            table with "?" in the "message" field.
    * Prepare and execute the query04.
    * Process the results for query04.
    * Close the database connection.

  Scenario: 5- Verify the "subject" information for the data in the "support_tickets"
            table where the "ticket" value starts with 4.
    * Prepare and execute the query05.
    * Process the results for query05.
    * Close the database connection.

  Scenario: 6- Delete the requested data using "loan_number" in the "loans" table in the
            database and confirm the deletion.
    * Prepare and execute the query06.
    * Process the results for query06.
    * Close the database connection.

  Scenario: 7- Add the desired data to the "divice_tokens" table in a single query.


  Scenario: 8- Verify the count of users with "user id=1" and "is_read=0" in the
            "admin_notifications" table.


  Scenario: 9- Verify the users with "user id=2" in the "admin_notifications" table whose
            "id" is greater than 20.


  Scenario: 10- Insert data into the "cron_job_logs" table and confirm that it has been added.


  Scenario: 11- List the top 5 "code" values in the "Gateways" table.


  Scenario: 12- List data in the "Subscribers" table where the "email" does not contain "a."


  Scenario: 13- Separate "user_id" and "user_ip" in the "user_logins" table according
            to the city.


  Scenario: 14- Add data containing only "id, name, description" to the "Catagories" table.
            Confirm the addition.


  Scenario: 15- List all records in the "Users" table sorted by "lastname" in ascending order
            and "firstname" in descending order. Verify the first last name in the list.


  Scenario: 16- Calculate the total "amount" values in the "Transactions" table based on the
            "remark" type and verify those exceeding $1000.


  Scenario: 17- Verify the count of users in the "admin_notifications" table with "is_read=1"
            and "user_id=1."


  Scenario: 18- Update the password reset request for the user with "status=0" in the
            "admin_password_resets" table by entering the "email" information.


  Scenario: 19- List the Deposits with "status=1" in a specific "created_at" range along with
            their total amounts.


  Scenario: 20- Calculate the total amount of Deposits with "currency=USD" using the
            "gateway_currencies" table.


  Scenario: 21- Calculate and group the "total_delay_charge" amount for loans with
            "loan_id=1" based on the "loan_id."


  Scenario: 22- Verify the "name" information for the first three entries in the "loan_plans"
            table based on "delay_value" and "fixed_charge" or "percent_charge."

