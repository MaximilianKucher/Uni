package HA1;

//Maximilian Kucher      kuma1050        57107
//Heinz-Werner Haas      hahe1017        51171
//Valerian Flamm         flva1011        57808

import java.io.*;
import java.net.*;

public class HTTPClient {

	public static void main(String[] args) throws IOException {

		while (true) {

			//Enter Url and Port
			System.out.println("Enter Url");
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
			String input = stdIn.readLine();

			//Exit if empty
			if (input == "") {

				System.out.println("Url failed!");
				continue;
			}
			
			//Add https if missing
			if (!input.startsWith("https://") && !input.startsWith("http://")) {
				input = "https://" + input;
			}
			
			URL url = new URL(input);

			try {

				//Open Socket
			    Socket httpSocket = new Socket(url.getHost(), url.getPort());
			    
				//Create in- and output
				PrintWriter out = new PrintWriter(httpSocket.getOutputStream());
				BufferedReader in = new BufferedReader(new InputStreamReader(httpSocket.getInputStream()));
				
				//Send query
				if (url.getPath() == "") {
				  out.println("GET /index.html HTTP/1.0");
				} else {
				  out.println("GET " + url.getPath() + " HTTP/1.0");
				}
				out.println("");
				out.flush();
				
				//Print response
				String response;

				while ((response = in.readLine()) != null) {

					System.out.println(response);
				}
				
				out.close();
				in.close();
				httpSocket.close();
				
			}
			
			catch (IllegalArgumentException e) {

				System.out.println("Input Error");
				System.out.println(e.getMessage());
			}

			catch (IOException e) {

				System.out.println("IOExeption for Hostname: " + url.getHost());
				System.out.println(e.getMessage());

			}
		}
	}

}
