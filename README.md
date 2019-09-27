# MotoInventory Service Project

The purpose of this project is to practice working with existing code and modifying existing applications to use the Spring Cloud configuration server and the Eureka service registry.

## Spring Cloud Configuration Server

* Create a new Spring Cloud configuration server for this project. Have this service run on port 9999 and have it access a public read-only GitHub repository (you can reuse a repo used for other projects if you wish).

## Eureka Service Registry

* Create a new Eureka service registry for this project. Have this service run on port 8761.

## MotoInventory Service

1. Modify this application so that it uses the Spring Cloud configuration server that you created earlier to store its configuraiton files.

2. Add the following endpoint:

  ```javascript
  RI: /vehicle/{vin}
  HTTP Method: GET
  Request Body: None
  Response Body: Vehicle Information (Map)
  
  HashMap must consist of the following keys and values:
  
  Key = "Vehicle Type", Value = Value returned from VIN Lookup Service
  Key = "Vehicle Make", Value = Value returned from VIN Lookup Service
  Key = "Vehicle Model", Value = Value returned from VIN Lookup Service
  Key = "Vehicle Year", Value = Value returned from VIN Lookup Service
  Key = "Vehicle Color", Value = Value returned from VIN Lookup Service
  ```

3. This endpoint must integrate with the provided VIN lookup service to provide this information

4. The MotoInventory service must use the Eureka service registry to look up the location of the VIN lookup service.

5. Fix the following issues:
  * The unit tests are all failing. Please fix.
  * The specified JSR303 validation settings on the Motorcycle class don't match the limits in the database - please change to match the database.
  * The Controller/REST code and the DAO code were developed by different teams and has not been integrated.  Integrate this code.


## VIN Lookup Service

This is a project that another team started and didn't quite finish. You need to fix a few things and then integrate this service with your MotoInventory service. There's no documentation so you must read the code to figure out what this service does and how it does it.

1. Modify the service so that it uses the Spring Cloud Config Server for its configuration settings.

2. Modify the service so that it registers with the Eureka Service Registry.

--- 

© 2019 Trilogy Education Services
