package com.openshift.cloud.api.kas.auth;

import com.github.andreatp.kiota.auth.RHAccessTokenProvider;
import com.openshift.cloud.api.kas.auth.ApiClient;
import com.microsoft.kiota.authentication.BaseBearerTokenAuthenticationProvider;
import com.microsoft.kiota.http.OkHttpRequestAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class BasicITTest {

    static final String OFFLINE_TOKEN = System.getenv("OFFLINE_TOKEN");

    @Test
    void retrieveAcls() throws Exception {
        // Arrange
        OkHttpRequestAdapter adapter = new OkHttpRequestAdapter(
                new BaseBearerTokenAuthenticationProvider(
                        new RHAccessTokenProvider(OFFLINE_TOKEN)));

        // Need a Kafka instance
        // adapter.setBaseUrl("https://api.openshift.com");
        // var client = new ApiClient(adapter);

        // Act
        // var acls = client
        //        .api()
        //        .v1()
        //        .acls()
        //        .get()
        //        .get(3, TimeUnit.SECONDS);

        // Assert
        // Assertions.assertEquals(1, acls.getItems().size());
    }

}
