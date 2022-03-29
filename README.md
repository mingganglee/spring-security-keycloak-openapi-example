# Spring Security Openapi KeyCloak Example

* [Create and secure a Java REST API using Open Api 3, oauth2 and Spring Security](https://medium.com/@tomerikvalso/create-and-secure-a-rest-api-using-open-api-3-java-and-oauth2-55f7feefd6f1)
* [API login and JWT token generation using Keycloak](https://developers.redhat.com/blog/2020/01/29/api-login-and-jwt-token-generation-using-keycloak#)

## ENV

* JDK 11
* [Keycloak 17.01](https://github.com/keycloak/keycloak/releases/download/17.0.1/keycloak-17.0.1.zip)

## Run Keycloak

### Step 1

Download [keycloak-17.0.1.zip](https://github.com/keycloak/keycloak/releases/download/17.0.1/keycloak-17.0.1.zip) to local

### Step 2

go to the keycloak folder

```bash
cd xxx/keycloak-17.0.1
```

### Step 3

run Keycloak shell

```bash
./bin/kc.sh start-dev --http-port=8180
```

> For keycloak configuration, please see the documentation [Create and secure a Java REST API using Open Api 3, oauth2 and Spring Security](https://medium.com/@tomerikvalso/create-and-secure-a-rest-api-using-open-api-3-java-and-oauth2-55f7feefd6f1)

## Run Spring

### Step 1

Download [spring-security-keycloak-openapi-example](https://github.com/lminggang/spring-security-keycloak-openapi-example.git) to local

### Step 2

The `clientSecret` value of the `restapi_with_oauth-main/src/main/resources/application.yaml` file is modified to `MyKeycloak` of `Secret`

> For specific steps, please refer to [Create and secure a Java REST API using Open Api 3, oauth2 and Spring Security](https://medium.com/@tomerikvalso/create-and-secure-a-rest-api-using-open-api-3-java-and-oauth2-55f7feefd6f1)

### Step 3

Go to the code foler

```bash
cd xxx/restapi_with_oauth-main
```

### Step 4

Build code

```bash
gradle build
```

### Step 5

Run code

```bash
gradle bootRun
```

## Test

> For specific steps, please refer to [Create and secure a Java REST API using Open Api 3, oauth2 and Spring Security](https://medium.com/@tomerikvalso/create-and-secure-a-rest-api-using-open-api-3-java-and-oauth2-55f7feefd6f1)

## Issue

* [Keycloak 17.0.0 results in “page not found” for admin url](https://keycloak.discourse.group/t/keycloak-17-0-0-results-in-page-not-found-for-admin-url/13682)

> url: xxx/auth  
> return: page not found

17.01 默认 `url` 为 `/`, 可以用过 `--hostname-path=/auth` 将 `Keycloak` 路径更改为旧版本 **(尝试后, 有其他坑 放弃)**

```text
# 此项目解决办法
修改 restapi_with_oauth-main/src/main/resources/application.yaml 中 

issuer-uri
jwk-set-uri
authorizationUrl
tokenUrl

将以上参数 URL 中包含 /auth 部分删掉即可
```
