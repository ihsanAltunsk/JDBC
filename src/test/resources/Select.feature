Feature: SELECT QUERY EXECUTE

  Background:
    * Establish a database connection.

  Scenario:Validate the user_ids in the "deposits" table within
           the database for which the "amount" value is between $100 and $500.
    * Query01 Prepare and execute the query.
    * ResultSet01 Process the results.
    * Close the database connection.

  Scenario:Verify the "name" information of the first 2 records
           in the "cron_schedules" table within the database.
    * Query02 Prepare and execute the query.
    * ResultSet02 Process the results.
    * Close the database connection.

  Scenario:Verify the "firstname" and "lastname" information of the data in the
           "Users" table on the database that does not have "country_code=TR"
           and has "id=11".
    * Query03 Prepare and execute the query.
    * ResultSet03 Process the results.
    * Close the database connection.

    Scenario: Group the browsers and operating systems used for logins into
              the system based on user_ids in the "user_logins" table and
              display them on the screen.
      * Query04 Prepare and execute the query.
      * ResultSet04 Process the results.
      * Close the database connection.