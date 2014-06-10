package org.test.tcpserver;

public class MyService {
	public void test(byte[] input) throws InterruptedException {
		Thread.sleep(10);
		System.out.println("Received: " + new String(input));
	}
}
