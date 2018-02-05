# ent-customers-services
demo project

Swagger Link:  http://localhost:9052/v2/api-docs
Swagger file is attached in the response


Schema Details
CREATE TABLE customers
(
	userID NUMBER(19) NOT NULL,
	firstName VARCHAR(100) NOT NULL,
	lastName VARCHAR(100) NOT NULL,
	email VARCHAR(100) DEFAULT NULL,
	PRIMARY KEY (userID)
);


curl -X PURGE \
  'http://localhost:9052/customerInfo/v1/customer/greetingDetails?name=world' \
  -H 'Accept: application/json' \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: a19bbd71-fc3e-165c-0348-bdafe927121b' \
  -H 'applicationId: Test'

curl -X GET \
  'http://localhost:9052/customerInfo/v1/custom/fibonacci?number=10' \
  -H 'Accept: application/json' \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 5393398a-7f3a-a911-f358-a209c644a244'
  
  curl -X GET \
  http://localhost:9052/customerInfo/v1/customers/posts \
  -H 'Accept: application/json' \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: c0ea774d-298f-d290-37b2-051d36f38d01' \
  -H 'applicationId: Test'
  
  
  curl -X GET \
  http://localhost:9052/customerInfo/v1/customers \
  -H 'Accept: application/json' \
  -H 'Cache-Control: no-cache' \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 7a240822-8e57-5db4-45b1-5ea063dca075' \
  -H 'applicationId: Test'
  
  
  Steps to Build code base
  
  ./mvn clean install
  
  java -jar ./target/ent-customer-services-0.0.1-SNAPSHOT.jar
  
 
  