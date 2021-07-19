

## JDK 11
## Spring boot 2.4.8
## Spring boot application 
## Spring boot config server
## AWS S3 Repository 

https://docs.aws.amazon.com/cli/latest/userguide/install-cliv2-linux.html

aws s3api create-bucket --bucket spring-cloud-config --region sa-east-1 --endpoint-url http://localhost:4566
aws s3 cp application-development.properties s3://spring-cloud-config/ --region sa-east-1 --endpoint-url http://localhost:4566
