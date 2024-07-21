package com.tchcareer.utilities;

import com.mailslurp.apis.EmailControllerApi;
import com.mailslurp.apis.InboxControllerApi;
import com.mailslurp.apis.WaitForControllerApi;
import com.mailslurp.clients.ApiClient;
import com.mailslurp.clients.Configuration;
import com.mailslurp.models.Email;
import com.mailslurp.models.InboxDto;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class MailSlurpUtil {
    public static ApiClient defaultClient;
    static final String apiKey = "5e9a4f91b3aef67e55cfae129071d41dec5650be6213f571809ed00dac894420";
    public static final Long TIMEOUT = 30000L;
    public static InboxControllerApi inboxControllerApi;
    public static InboxDto inboxDto;
    public static Email email;
    public static UUID inboxId;
    public static WaitForControllerApi waitForControllerApi;
    public static OkHttpClient httpClient;
    public static EmailControllerApi emailControllerApi;


    public static void initializeObjects() throws Exception {

        // get API KEY for mailslurp from environment variable
        if (StringUtils.isBlank(apiKey)) {
            throw new Exception("Must provide API KEY");
        }

        // IMPORTANT set timeout for the http client
        httpClient = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                .writeTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                .build();
        defaultClient = Configuration.getDefaultApiClient();

        // IMPORTANT set api client timeouts
        defaultClient.setConnectTimeout(TIMEOUT.intValue());
        defaultClient.setWriteTimeout(TIMEOUT.intValue());
        defaultClient.setReadTimeout(TIMEOUT.intValue());

        // IMPORTANT set API KEY and client
        defaultClient.setHttpClient(httpClient);
        defaultClient.setApiKey(apiKey);

        // create an inbox using the inbox controller
        inboxControllerApi = new InboxControllerApi(defaultClient);
        //inboxId = UUID.fromString("2f30151a-cb23-4faa-99b8-5c2f3e0b66c5");
        //inboxDto = inboxControllerApi.getInbox(inboxId);
        inboxDto = inboxControllerApi.createInboxWithDefaults();
        waitForControllerApi = new WaitForControllerApi(defaultClient);
        emailControllerApi = new EmailControllerApi(defaultClient);
    }
}
