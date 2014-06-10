package org.test.tcpclient;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TCPClientTest {
	static Socket socket;
	static List<Socket> sl = new ArrayList<>();
	static List<DataOutputStream> osl = new ArrayList<>();
	static DataOutputStream out;
	
	private static void testConnections() throws Exception {
		for (int i = 0; i < 10000; i++) {
			socket = new Socket("localhost", 60000);
			sl.add(socket);
			out = new DataOutputStream(socket.getOutputStream());
			out.writeBytes("Created socket #" + i + "\r\n");
			System.out.println("Created socket #" + i);
		}
		System.in.read();
	}
	
	private static void testMessages() {
		final int numOfSockets = 100;
		for (int i = 0; i < numOfSockets; i++) {
			try {
				socket = new Socket("localhost", 60000);
				sl.add(socket);
				out = new DataOutputStream(socket.getOutputStream());
				osl.add(out);
				out.writeBytes("Created socket #" + i + "\r\n");
				System.out.println("Created socket #" + i);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		int count = 0;
		while (true) {
			count++;
			for (int i = 0; i < numOfSockets; i++) {
				try {
					osl.get(i).writeBytes("Using socket #" + i + " (" + count + ")" + "\r\n");
					System.out.println("Using socket #" + i + " (" + count + ")");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		//testConnections();
		testMessages();
	}
}
