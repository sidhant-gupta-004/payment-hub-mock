package sg.ph.gsma.mock.routebuilder;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AdminRouteBuilder extends RouteBuilder {

    private static Logger logger = LoggerFactory.getLogger(AdminRouteBuilder.class);

    @Autowired
    public AdminRouteBuilder (CamelContext context) {

        super(context);
    }

    @Override
    public void configure() throws Exception {

    }

}
