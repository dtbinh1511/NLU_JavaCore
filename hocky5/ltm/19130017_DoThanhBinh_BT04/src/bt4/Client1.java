package bt4;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client1 {
	public static void main(String[] args) throws RemoteException, NotBoundException {
		ClientConnect c1 = new ClientConnect();
		c1.run();
	}
}
