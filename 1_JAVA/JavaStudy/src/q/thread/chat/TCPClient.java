package q.thread.chat;

import java.io.IOException;
import java.net.Socket;

public class TCPClient {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 3000);
			
			ClientReceive receive = new ClientReceive(socket);
			Thread receiveTask = new Thread(receive);
			receiveTask.start();
			
			ClientSend send = new ClientSend(socket);
			Thread sendTask = new Thread(send);
			sendTask.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
