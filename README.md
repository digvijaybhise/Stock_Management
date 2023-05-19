<center>
<h1> STOCK MANAGEMENT SYSTEM </h1>
</center>
<center>
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-3.0.5-brightgreen.svg" />
</a>
</center>
This is a Spring Boot project for managing Stocks of the company.
---
<br>

## Framework Used
* Spring Boot

---
<br>

## Language Used
* Java

---
<br>

## Data Model

* Stock

```
private Integer stockId;
private String stockName;
private Double stockPrice;
private Integer stockOwnerCount;
private StockType stockType;
private Double stockMarketCap;
private LocalDate stockBirthTimeStamp;

```
---
<br>

## Data Flow

1. The user at client side sends a request to the application through the API endpoints.
2. The API receives the request and sends it to the appropriate controller method.
3. The controller method makes a call to the method in service class.

4. The method in service class builds logic and retrieves or modifies data from the database, which is in turn given to controller class
5. The controller method returns a response to the API.
6. The API sends the response back to the user.

---

<br>


## API End Points (Event)

</br>

### Inbuilt @CrudRepo methods
- We're extending CRUDRepository into repository interface.

* PostMapping: "/stock"
```
This endpoint makes a call to method in eventService class where we implement method "saveAll()" in CRUD Repository.
```

* PutMapping : "marketCap/{marketCap}/id/{id}"
```
This endpoint makes a call to method in eventService class which is connected to database. In database we update a event by id given through API.
```

</br>

### Custom get methods using custom finders (based on method names)
- Custom finder methods are defined in a library to get the data so we don't have to write sql queries to get the data.

* @GetMapping("/type/{stockType}")
```
This endpoint makes a call to method in eventService class where we implement method "getStocksByType()" in CRUD Repository.
```
*  @GetMapping("/abovePrice/price/{price}/lowerDate/{date}")
```
This endpoint makes a call to method in eventService class where we implement method "getAllStockAboveCapPercentage()" in CRUD Repository.
```

## DataBase Used
* SQL Database
```
We have used Persistent database to implement CRUD Operations.
```
---
<br>

## Project Summary

The Stock Event Management System is a project that stores data related to stocks of the company. It provides a comprehensive solution for managing the data and can be easily extended to support additional features.

The project provides several endpoints to interact with the data, such as adding a stock, updating a stock, get stock by stock type on a specific date.

Overall, the Stock Event Management System provides a comprehensive solution for managing stock. The project can be easily extended to support additional features as needed, and the use of a database ensures that the data is stored securely and can be easily accessed and managed.
