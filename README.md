# Book API 

## Build 

- Java 1.8+
- Docker 17.06.0+
Steps to execute:
```
    1.mvn clean package spring-boot:repackage
    2.Docker-compose build
    3.Docker-compose up
```

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

```text
How would you access a *NIX server remotely in order to debug a problem?

* First we need to connect to nix server using SSH 
* Then search for the application log and use grep for finding for relevant errors
* If java app is running with remote debugging enabled then we can connect to that for remote 
debugging.But PROD this must be turned off also this approach suffers from network lag if the app
is deployed on some cloud.
```

```text
How would you version your application?

* If it is application versioning it can be handled via the pom version. A version in Pom takes a structure as
Major.Minor.Patch version. If my change is adding a lot of new functionality and have breaking change we update
Major version. If no break change and incremental updates then we increment Minor Version. For quickfix and hotfixes
we increment Patch version

* But if we talking about versioning in API itself . Then One of the approach I would like to take as to add a version
info like /v1 or /v2 in the API itself. We need to care provide a migration time for clients to move from one version
to another if there are breaking changes . 
```

```text
How do you deliver your application to your team and for deployment?

For Deployment the application is dockerized so that it can be run on an platform local or cloud .
For this purpose we have a Dockerfile in the application we can use that to deploy on containers pr in kubernetes
or AWS ECS.

Within team also any one can clone the application and start up a docker using the compose files available in the 
project.
```

```text
If you would have to implement an authorisation / authentication system, what kind of patterns you
would choose?

JWT will be my choice. Every request will be accompanied by a header .We can configure SecurityFilter in Spring
to validate the JWT token . We can also use JWT token to hold claims that can be used for role based authz . 
```

```text
Frontend should be able to show the last access time of a book

I assume by access time we mean modification time. If that's true we can add a column modified by . We already have a column modified_on 
that shows the last modified time stamp.

If the above assumption is not correct then we have to have a separate table like below 

create table book_access(
book_id UUID references(book.id),
user_id references(user.id) // need to introduce the concept of user
accessed_time timestamp
)

An entry in the above table need to be created whenever any opration is done on book entity.

```