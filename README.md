![travis-ci](https://travis-ci.org/luiz-maffeis/ginmon-core.svg?branch=master)


# ginmon-core
Java Core

This project is a programming assignment that consumes REST endpoints from https://api.github.com and saves the result in a H2 database.

## Built With

* [JDK 1.8](http://www.oracle.com/technetwork/pt/java/javase/downloads/index.html) - JDK
* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring Boot](https://spring.io/docs) 

## REST API

1- http://localhost:8080/userDetail/{login}
* This request returns a User Detail from (https://api.github.com)

```
curl --request GET \
  --url http://localhost:8080/userDetail/mojombo
```

2- localhost:8080/userList/{id}
* This request returns a list of Users from (https://api.github.com)

```
curl --request GET \
  --url http://localhost:8080/userList/0
```

3- localhost:8080/saveUser
* This request saves a User with a personal comment in a database

```
curl --request POST \
  --url http://localhost:8080/saveUser \
  --header 'content-type: application/json' \
  --data '{
        "login": "errfree",
        "id": 44,
        "comment":"teste"
}
'
```

4- localhost:8080/userCommentId/{id}
* This request return a list of User´s comments saved in a database

```
curl --request GET \
  --url http://localhost:8080/userCommentId/44
```

5- localhost:8080/userCommentLogin/{login}
* This request return a list of User´s Comments saved in a database

```
curl --request GET \
  --url http://localhost:8080/userCommentLogin/errfree
```

## Author

* **Luiz Maffeis** - *Initial work* - [luiz-maffeis](https://github.com/luiz-maffeis)


