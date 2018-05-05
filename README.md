# Expedia SDE Exercise - Hotel Finder
 
[![Deploy on Heroku](https://www.herokucdn.com/deploy/button.png)](https://hmobaideen92.herokuapp.com)

[Tested on Travis-CI](https://travis-ci.org/HMobaideen/expedia-sde-exercise/branches)

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites


* [Maven](https://maven.apache.org/download.cgi)
* [JDK1.8.XX](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)




### Installing


1. Open command Line.

2. Clone project from git by `git clone  https://github.com/HMobaideen/expedia-sde-exercise.git`
   
   And in case you don't have git installed on your machine, you can just download it from [this repository](https://github.com/HMobaideen/expedia-sde-exercise)

3. Navigate to project folder path.

4. Build Maven using "mvn package". 

5. Start up Tomcat using `java -jar target/dependency/webapp-runner.jar hotels.war`

6. Type project URL in browser as following: 
   `{ machine domain name | machine IP address | localhost }:8080`
   
   for example: `http://localhost:8080` 
   




## Assumptions


- Assumed that minTripSartDate and maxTripSartDate must be appended to API URL as following:

   [maxTripSartDate=2018-05-11](https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&destinationCity=New%20Orleans&minTripStartDate=2018-05-11)

   As it is produced correct result as explained in the assignment email:

   Unlike format provided in assignment email:
   
   [maxTripSartDate=:2018-05-11](https://offersvc.expedia.com/offers/v2/getOffers?scenario=deal-finder&page=foo&uid=foo&productType=Hotel&destinationCity=New%20Orleans&minTripStartDate=:2018-05-11)

- Assumed that search with no parameters will return a result, as API does, maybe it is a better to check if user enter any value to search for.
   


## Issues


**Pagination**

used Primeng paginator component **Custom Component**, where the current page of hotels list did not reset to page 1 when set hotels list to a new result.



## Author

> **Haneen Mobaideen** 





