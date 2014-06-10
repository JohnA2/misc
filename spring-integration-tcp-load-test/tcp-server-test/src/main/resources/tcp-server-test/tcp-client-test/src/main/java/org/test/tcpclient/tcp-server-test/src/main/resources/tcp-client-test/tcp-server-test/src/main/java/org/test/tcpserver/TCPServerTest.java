package org.test.tcpserver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.integration.ip.tcp.connection.AbstractServerConnectionFactory;
import org.springframework.integration.ip.util.TestingUtilities;

public class TCPServerTest {

	public static void main(final String... args) {
		final ApplicationContext context = TCPServerTest.setupContext();
		final AbstractServerConnectionFactory crLfServer = context.getBean(AbstractServerConnectionFactory.class);
		System.out.print("Waiting for server to accept connections...");
		TestingUtilities.waitListening(crLfServer, 10000L);
		System.out.println("running.");	
	}

	public static GenericXmlApplicationContext setupContext() {
		final GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("/applicationContext.xml");
		context.registerShutdownHook();
		context.refresh();
		return context;
	}

}
