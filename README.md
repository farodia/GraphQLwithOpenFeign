# GraphQLwithOpenFeign
This project is a multiservice program using FeignClient integrating with DGS-GraphQL.



## TO RUN 

### setup local mongo using docker
- `docker images` -> check the mongo images installsed or not
- `docker ps` -> if there is any container running[[Docker]]
	-   if not: `docker run -itd --name dockername -p 27017:27017 mongo --auth`
-   `docker exec -it mongo-docker mongo admin`
-   create a user with authentication
    1. `db.createUser({ user:'admin',pwd:'root',roles:[ { role:'userAdminAnyDatabase', db: 'admin'},"readWriteAnyDatabase"]});`
    2. `db.auth("admin", "root")`
		
### After run the two applications successfully
POST:	`http://localhost:8090` to add a new book infomation

    {
	"isn": "1",
	"title": "England",
	"summary": "its a country"
	}
GET:    `http://localhost:8090` to show all books

### Have a try in QraphQL page
in `http://localhost:8091/graphiql`

          {	
		finds(titleFilter:""){ 
		isn
	  	title
	  	summary
	  	}
         }
         
## Tests
The following are the types of testing tools I have practiced in simple business logic.  

**wireMock**: `/BookSummaryClientTest.java`

**mockMVC**: `BookSummaryControllerTest.java`  

**scheme test**: `/SchemeTest.java`  

**testcontainers**: 
   -  `BookRepositoryTest.java` using a testcontainer individually.
   -  `BookRepositoryTest.java` and `BookSummaryServiceReuseContainerTest.java` reuse the testcontainer provided by `BasicMongoTestContainer`  
   
**mockito**[for dgs-grapghQL test]:  `FindsDataFetcherTest.java`
  
