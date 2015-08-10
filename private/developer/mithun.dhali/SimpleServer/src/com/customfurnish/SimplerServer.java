package com.customfurnish;

import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

import org.simpleframework.http.Request;
import org.simpleframework.http.Response;
import org.simpleframework.http.core.Container;
import org.simpleframework.http.core.ContainerSocketProcessor;
import org.simpleframework.transport.SocketProcessor;
import org.simpleframework.transport.connect.Connection;
import org.simpleframework.transport.connect.SocketConnection;

public class SimplerServer implements Container {

	private static Connection connection;

	public void handle(Request request, Response response) {
		try {
			PrintStream body = response.getPrintStream();
			long time = System.currentTimeMillis();

			response.setValue("Content-Type", "text/html");
			response.setValue("Server", "HelloWorld/1.0 (Simple 4.0)");
			response.setDate("Date", time);
			response.setDate("Last-Modified", time);

			body.println("<html>" + "<head><title>Hello HTML World</title></head>" + "<body><b>Hello World</b></body>");
			body.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] list) throws Exception {
		Container container = new SimplerServer();
		SocketProcessor server = new ContainerSocketProcessor(container);
		SimplerServer.connection = new SocketConnection(server);
		SocketAddress address = new InetSocketAddress(8081);

		SimplerServer.connection.connect(address);
	}
}