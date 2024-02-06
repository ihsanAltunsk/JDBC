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
    * ResultSet03 Process the results.
    * Close the database connection.
