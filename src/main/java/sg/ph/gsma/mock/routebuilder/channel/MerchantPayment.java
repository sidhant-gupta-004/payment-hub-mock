package sg.ph.gsma.mock.routebuilder.channel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class MerchantPayment extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        String port = "8081";   // What should this be?
        String url = "http://0.0.0.0:" + port;

        String clientUrl = "jetty:" + url + "?httpMethodRestrict=" + HttpMethod.POST;

        from(clientUrl)
            .log("First Steps...")
            .process("postTransactionsProcessor")
            .end()
        ;
    }
}
