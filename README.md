# TUI Service - Quote Gardren API


## Getting started

The app consists of being able to return a specific item (quote) by ID, by author and all items from a MongoDB collection.

The collection must have a maximum of 50,000 items.

## Start the application

### Running the app

```
 docker-compose build
 docker-compose up app
```

The above commands, will build and run a docker container, starting this web service on localhost at port 8081.

### Supported endpoints

- /api/quotes?id=<..id..>
- /api/quotes?author=<..author..>
- /api/quotes

### Pagination support
The endpoints responsible to fetch the all the quotes and to fetch by author supports pagination.

You can follow the below example:

- /api/quotes?author=<..author..>&page=<..page number..>&size=<..page size..>
- /api/quotes?page=<..page number..>&size=<..page size..>

## Calling the API

After the docker container is running, you can use an API requester of you choose, like Postman, or even using the `curl` command, to start to perform some requests into the web service.

Examples:
```
GET http://localhost:8080/api/quotes?id=5eb17aadb69dc744b4e71249

GET http://localhost:8080/api/quotes?author=Steve Jobs&page=2&size=20

GET http://localhost:8080/api/quotes?page=1&size=10
```