package com.openshift.cloud.api.connector;

import com.redhat.cloud.kiota.auth.RHAccessTokenProvider;
import com.microsoft.kiota.authentication.BaseBearerTokenAuthenticationProvider;
import com.microsoft.kiota.http.OkHttpRequestAdapter;
import com.openshift.cloud.api.connector.ApiClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class BasicITTest {

    static final String OFFLINE_TOKEN = System.getenv("OFFLINE_TOKEN");

    @Test
    void retrieveConnectorsVersionMetadata() throws Exception {
        // Arrange
        OkHttpRequestAdapter adapter = new OkHttpRequestAdapter(
                new BaseBearerTokenAuthenticationProvider(
                        new RHAccessTokenProvider(OFFLINE_TOKEN)));

        adapter.setBaseUrl("https://api.openshift.com");
        var client = new ApiClient(adapter);

        // Act
        var version = client
                .api()
                .connector_mgmt()
                .v1()
                .get()
                .get(10, TimeUnit.SECONDS);

        // Assert
        Assertions.assertEquals(4, version.getCollections().size());
        Assertions.assertEquals("ConnectorTypeList", version.getCollections().get(0).getKind());
    }

}
