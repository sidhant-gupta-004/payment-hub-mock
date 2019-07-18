package sg.ph.gsma.mock.routebuilder.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.UUID;

@Component("postTransactionsProcessor")
public class PostTransactionsProcessor implements Processor {

    RestTemplate restTemplate;

    public PostTransactionsProcessor(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void process (Exchange exchange) throws Exception {

        Message data = exchange.getIn();
        String ndata = data.toString();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String corrId = UUID.randomUUID().toString();
        httpHeaders.set("X-CorrelationID", corrId);

        httpHeaders.set("Date", "2019-07-07T12:00:00.123Z");

        HttpEntity<String> entity = new HttpEntity<>(ndata, httpHeaders);
        HttpMethod hm = HttpMethod.POST;

        String apikey = "u8YfSQNnNsGFAaqRm3sGShpO2ywLRJgs";

        String endpointUrl = "http://sandbox.mobilemoneyapi.io/simulator/v1.0/mm/transactions?apikey=" + apikey;

        System.out.println(restTemplate.exchange(endpointUrl, hm, entity, String.class).getBody());

        //exchange.getIn().setBody();
    }
}
