package com.openshift.cloud.api.srs;

import com.redhat.cloud.kiota.auth.RHAccessTokenProvider;
import com.openshift.cloud.api.srs.ApiClient;
import com.microsoft.kiota.authentication.BaseBearerTokenAuthenticationProvider;
import com.microsoft.kiota.http.OkHttpRequestAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class BasicITTest {

    static final String OFFLINE_TOKEN = System.getenv("OFFLINE_TOKEN");

    @Test
    void retrieveSRSStatus() throws Exception {
        // Arrange
        OkHttpRequestAdapter adapter = new OkHttpRequestAdapter(
                new BaseBearerTokenAuthenticationProvider(
                        new RHAccessTokenProvider(OFFLINE_TOKEN)));

        adapter.setBaseUrl("https://api.openshift.com");
        var client = new ApiClient(adapter);

        // Act
        var status = client
                .api()
                .serviceregistry_mgmt()
                .v1()
                .status()
                .get()
                .get(3, TimeUnit.SECONDS);

        // Assert
        Assertions.assertEquals(false, status.getMaxInstancesReached());
    }

}
