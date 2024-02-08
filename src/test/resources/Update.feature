Feature:
  Background:
    * Establish a database connection.

  Scenario: Update the "mobile" numbers of the usernames in the
            "users" table whose usernames have the second-to-last
            letter as 'e'.
    * UpdateQuery05 Prepare and execute the query.
    * UpdateQuery05 Validate the results.
    * Close the database connection.

  Scenario: Update the "mobile" numbers of the usernames in the
            "users" table whose usernames have the second-to-last
             letter as 'e' .
    * preparedQuery05 Prepare and execute the query.
    * preparedQuery05 Validate the results.
    * Close the database connection.
  @query
  Scenario: Insert new data (id, email, token, status)
            into the "admin_password_resets" table.
    * preparedQuery06 Prepare and execute the query.
    * preparedQuery06 Validate the results.
    * Close the database connection.

  Scenario: Update the notifications with 'is_read=0' for the user
            with 'id=?' to '1' and confirm.
    * preparedQuery07 Prepare and execute the query.
    * preparedQuery07 Validate the results.
    * Close the database connection.

  Scenario: Update and verify the 'update_log' value of the data
            in the 'update_logs' table where 'version=?' and 'id=?'.
    * Prepare and execute an insert query for the 'update_logs' table.
    * Modify the update log value of the data inserted into the 'update_logs' table.
    * Confirm the change in the update log value.
    * Close the database connection.