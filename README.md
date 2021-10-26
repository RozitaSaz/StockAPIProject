### Stock API

This is an example application that provides the means of managing 3 process of stock.

This is offered as a simple web service that provides the following operations:
- Record a stock
- Record a bulk data stock
- Get stock details by stock name

### Requirements
- Java 8
- Maven 4
- MySQL

### Design
The application is structured in layers, namely:

A *controller* is responsible for handling the requests and communicating with the layer service for providing a response. Here the internal domain is converted to DTOs to eliminate the coupling between the API and the internal domain.

A *service* is responsible for executing the business logic, here we know how to compute stock prices and GBCE indexes.

A *domain object* represents the model (Stock and Trade)

A *repository* abstracts the underlying datastore. For the sake of the example, the underlying datastore is a local hash set.

### Code structure
The *application* contains the main application source code and unit tests.


### Build

    project$ mvn clean install

### Running

	project$ cd application
    project$ mvn spring-boot:run

For validation purposes you can now access localhost:8080 in the corresponding endpoints in order to test the service. The following endpoints are available:

    POST stocks-management/saveStock - Create a new stock
    POST stocks-management/uploadStocks - Upload a bulk stock

    GET stocks-management/findStocks?stockName=AA - Get List of stocks in db table with name AA
