Feature:
  Background:
    * Establish a database connection.

  Scenario: Update the "mobile" numbers of the usernames in the
            "users" table whose usernames have the second-to-last
            letter as 'e'.
    * Update Query01 Prepare and execute the query.
    * ResultSet01 Process the results.
    * Close the database connection.