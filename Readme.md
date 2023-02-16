# Prototype for the new RedHat Java SDK

[![](https://jitpack.io/v/andreaTP/rh-java-sdk.svg)](https://jitpack.io/#andreaTP/rh-java-sdk)

## Usage

Add the required dependencies to your `pom.xml` file:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
  <groupId>com.github.andreaTP.rh-java-sdk</groupId>
  <artifactId>account-management-sdk</artifactId>
  <version>version</version>
</dependency>
<dependency>
  <groupId>com.github.andreaTP.rh-java-sdk</groupId>
  <artifactId>kafka-instance-sdk</artifactId>
  <version>version</version>
</dependency>
<dependency>
  <groupId>com.github.andreaTP.rh-java-sdk</groupId>
  <artifactId>kafka-management-sdk</artifactId>
  <version>version</version>
</dependency>
<dependency>
  <groupId>com.github.andreaTP.rh-java-sdk</groupId>
  <artifactId>registry-instance-sdk</artifactId>
  <version>version</version>
</dependency>
<dependency>
  <groupId>com.github.andreaTP.rh-java-sdk</groupId>
  <artifactId>registry-management-sdk</artifactId>
  <version>version</version>
</dependency>
<dependency>
  <groupId>com.github.andreaTP.rh-java-sdk</groupId>
  <artifactId>service-accounts-sdk</artifactId>
  <version>version</version>
</dependency>

```

To easily use RH SSO add also:
```xml
<dependency>
    <groupId>com.github.andreaTP.kiota-utils</groupId>
    <artifactId>kiota-rh-auth</artifactId>
    <version>version</version>
</dependency>
```

After obtaining an offline token following the instructions [here](https://access.redhat.com/articles/3626371).
You can use the SDKs in your project like:

```java
OkHttpRequestAdapter adapter = new OkHttpRequestAdapter(new BaseBearerTokenAuthenticationProvider(new RHAccessTokenProvider(offline_token)));

// adapter.setBaseUrl("https://api.stage.openshift.com");
adapter.setBaseUrl("https://api.openshift.com");

var client = new ApiClient(adapter);

var user = client
        .api()
        .accounts_mgmt()
        .v1()
        .current_account()
        .get().get(3, TimeUnit.SECONDS);
```


## Todo

- fetch the upstream specs based on tags
