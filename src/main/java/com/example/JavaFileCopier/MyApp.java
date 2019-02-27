package com.example.JavaFileCopier;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

public class MyApp {

	public static void main(String[] args) throws Exception {
		CamelContext camelContext = new DefaultCamelContext();
		camelContext.addRoutes(new MyRouteBuilder());
		camelContext.addRoutes(new MyRouteBuilder2());
		camelContext.start();
		ProducerTemplate template = camelContext.createProducerTemplate();
		template.sendBodyAndHeader("direct:start", "A", "id", 1);
		template.sendBodyAndHeader("direct:start", "B", "id", 1);
		template.sendBodyAndHeader("direct:start", "F", "id", 2);
		template.sendBodyAndHeader("direct:start", "C", "id", 1);
		Thread.sleep(6000);
		template.sendBodyAndHeader("direct:start", "G", "id", 2);
		template.sendBodyAndHeader("direct:start", "H", "id", 2);
		Thread.sleep(1000);
		template.sendBodyAndHeader("direct:start2", "A", "id", 1);
		template.sendBodyAndHeader("direct:start2", "B", "id", 1);
		template.sendBodyAndHeader("direct:start2", "F", "id", 2);
		template.sendBodyAndHeader("direct:start2", "C", "id", 1);
		Thread.sleep(6000);
		template.sendBodyAndHeader("direct:start2", "G", "id", 2);
		template.sendBodyAndHeader("direct:start2", "H", "id", 2);
		Thread.sleep(6000);

	}

}
