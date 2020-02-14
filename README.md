# Book API 

## Build 

- Java 1.8+
- Docker 17.06.0+

## APIs

- GET All Books

```
GET /books

```

- GET By book name and author name

```text
GET /books/search?name=<name>&author=<author>
```

- Get book by name 

```text
GET /books/{name} 
```
- Create a BOOK 

```
POST /books

 {
        "bookName": "mybook4",
        "authorName": "myauthor4",
        "isbn":"98765431011",
        "categories":"fiction"
        
 }

```

