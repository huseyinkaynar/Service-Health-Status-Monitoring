# Service-Health-Status-Monitoring
This is a spring-boot project for web services check status and monitoring


## Service Health Check

If we want to check the service we have to use the method below.If the service is healthy, it will be saved as "up" in the database or the service is unhealthy,it will be saved as "down" in the database.
##### POST localhost:8080/checkservices
```bash
{
	"serviceName":"omdbapi",
	"serviceUrl":"http://www.omdbapi.com/?i=tt3896198&apikey=816468fd",
	"time":"3000"

}
```
