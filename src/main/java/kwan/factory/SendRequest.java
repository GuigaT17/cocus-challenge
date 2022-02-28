package kwan.factory;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SendRequest {
    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    private String endpoint;

    public SendRequest(String endpoint) {
        this.endpoint = endpoint;
    }

    public void sendRequest(String invoiceId, String fiscalId, String name, String email) throws IOException {
        HttpPost post = new HttpPost(endpoint);

        // add request parameter, form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("invoice", invoiceId));
        urlParameters.add(new BasicNameValuePair("fiscal_id", fiscalId));
        urlParameters.add(new BasicNameValuePair("name", name));
        urlParameters.add(new BasicNameValuePair("email", email));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            System.out.println(EntityUtils.toString(response.getEntity()));
        }
        System.out.println("Request sent");
    }
}
