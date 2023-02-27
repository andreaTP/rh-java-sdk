package com.openshift.cloud.api.accountmanagement;

import com.redhat.cloud.kiota.auth.RHAccessTokenProvider;
import com.openshift.cloud.api.accountmanagement.ApiClient;
import com.microsoft.kiota.authentication.BaseBearerTokenAuthenticationProvider;
import com.microsoft.kiota.http.OkHttpRequestAdapter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class BasicITTest {

    static final String OFFLINE_TOKEN = System.getenv("OFFLINE_TOKEN");

    @Test
    void retrieveCurrentAccountInfo() throws Exception {
        // Arrange
        OkHttpRequestAdapter adapter = new OkHttpRequestAdapter(
                new BaseBearerTokenAuthenticationProvider(
                        new RHAccessTokenProvider(OFFLINE_TOKEN)));

        adapter.setBaseUrl("https://api.openshift.com");
        var client = new ApiClient(adapter);

        // Act
        var account = client
                .api()
                .accounts_mgmt()
                .v1()
                .current_account()
                .get()
                .get(10, TimeUnit.SECONDS);

        // Assert
        Assertions.assertEquals("aperuffo@redhat.com", account.getUsername());
    }

}
