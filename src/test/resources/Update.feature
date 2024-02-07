Feature:
  Background:
    * Establish a database connection.
  @query
  Scenario: Update the "mobile" numbers of the usernames in the
            "users" table whose usernames have the second-to-last
            letter as 'e'.
    * Update Query05 Prepare and execute the query.
    * Process the results.
    * Close the database connection.