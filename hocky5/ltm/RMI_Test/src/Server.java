import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public static void main(String[] args) throws AccessException, RemoteException, AlreadyBoundException {
		Registry reg = LocateRegistry.createRegistry(12345);
		reg.bind("ST_SEARCH", new SearchImpl());
	}
}
