# Conferences API  v1.0
 
 This API allows you to receive and search for conferences that are in the `resources/conferences.json` file.
 The backend is based on Java 9, Spring Boot 2. The Spring configuration is based on Java. 

  
 <h3>Installation dependencies
  
The following dependencies are necessary:  
  
 - Java 9
 - maven 3.6.3


<h3>Building and starting the server
  
To build the backend and start the server, run the following command on the root folder of the repository:  
  
`mvn spring-boot:run`  
 
After the server starts, the application is accessible at the following URL:  
  
`http://localhost:8080/`  

<h6> Hint: to terminate the server, press ^C </h6>  


## REST API documentation

 

***GET***/conferences

`api/v1/conferences`

Request 

| Key           | Required      | Description|
| ------------- | ------------- |------------|
| tags |  optional| query with multiple `tags`=java,nodejs,ruby |
| country | optional | search by `country` (Belarus) |  
| city | optional | search by `city` (Prague) |  
| title | optional |  search by `title` (Developer Week)|
| status | optional | search by `status` (ACCEPTED). <h6>Available values: ACCEPTED, REJECTED, PROPOSED |

Response

| Key           | Description     |
| ------------- | ------------- |
|    id          |    conference `id`         |
|  title      |       conference `title`        |
|  projects []             |    conference `projects` array           |
| location {}             |  it consists of `city` and `country` keys             |
|tags []               |   conference `tags` array           |
|dateStart               |  conference start date in [ISO-8601] representation        |
|dateFinish               |   conference end date in [ISO-8601] representation         |
|participants {}              |  it consists of `name`, `type`  (PARTICIPANT), `status` (INVITED), `invited` (true) **keys**           |
|ytLink               |    conference YouTrack link           |
|attendance               |    conference `attendance`           |
|link               |       conference web link        |
|comments []              |   conference `comments`  array        |
|status               |       conference `status`        |




***GET*** /conferences{id}

`api/v1/conferences/id`

Request 

| Key           | Required      | Description|
| ------------- | ------------- |------------|
| id            |  reqiured    | conference `id`|

Response

| Key           | Description     |
| ------------- | ------------- |
|    id          |    conference `id`         |
|  title      |       conference `title`        |
|  projects []             |    conference `projects` array           |
| location {}             |  it consists of `city` and `country` keys             |
|tags []               |   conference `tags` array           |
|dateStart               |  conference start date in [ISO-8601] representation        |
|dateFinish               |   conference end date in [ISO-8601] representation         |
|participants {}              |  it consists of `name`, `type`  (PARTICIPANT), `status` (INVITED), `invited` (true) **keys**           |
|ytLink               |    conference YouTrack link           |
|attendance               |    conference `attendance`           |
|link               |       conference web link        |
|comments []              |   conference `comments`  array        |
|status               |       conference `status`        |
