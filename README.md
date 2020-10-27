Session attributes modified without calling `setAttribute` are not stored properly in Redis 
when using the following redisson configuration:

    readMode="REDIS"
    updateMode="AFTER_REQUEST"

Requirements
------------

Running redis on port 6379.

Test
----

    mvn clean tomcat7:run-war
    
Then browse to http://localhost:8080 and reload the page multiple times. 

Expected behaviour: On each reload there should be an additional "bar" in the "foo" attribute.

Observed behaviour:

* at most _one_ "bar" in html response
* _no_ "bar" in redis (empty list)