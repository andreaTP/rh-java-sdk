package com.openshift.cloud.api.registry.instance;

import com.github.andreatp.kiota.auth.RHAccessTokenProvider;
import com.openshift.cloud.api.registry.instance.ApiClient;
import com.microsoft.kiota.authentication.BaseBearerTokenAuthenticationProvider;
import com.microsoft.kiota.http.OkHttpRequestAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class BasicITTest {

    static final String OFFLINE_TOKEN = System.getenv("OFFLINE_TOKEN");

    @Test
    void retrieveArtifactFromAnInstance() throws Exception {
        // Arrange
        OkHttpRequestAdapter adapter = new OkHttpRequestAdapter(
                new BaseBearerTokenAuthenticationProvider(
                        new RHAccessTokenProvider(OFFLINE_TOKEN)));

        // This needs to be an instance
        adapter.setBaseUrl("https://api.openshift.com");
        var client = new ApiClient(adapter);

        // Act
        // var artifacts = client
        //        .groups("default")
        //        .artifacts()
        //        .get()
        //        .get(3, TimeUnit.SECONDS);

        // Assert
    }

}
