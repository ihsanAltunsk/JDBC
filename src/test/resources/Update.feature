@query
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
             letter as 'e'.* Update Query05 Prepare and execute the query.
    * preparedQuery05 Prepare and execute the query.
    * preparedQuery05 Validate the results.
    * Close the database connection.

  Scenario: Insert new data (id, email, token, status)
            into the "admin_password_resets" table.
    * preparedQuery06 Prepare and execute the query.
    * preparedQuery06 Validate the results.
    * Close the database connection.
