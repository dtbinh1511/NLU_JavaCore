package bt4;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client2 {
	public static void main(String[] args) throws RemoteException, NotBoundException {
		ClientConnect c2 = new ClientConnect();
		c2.run();
	}
}
