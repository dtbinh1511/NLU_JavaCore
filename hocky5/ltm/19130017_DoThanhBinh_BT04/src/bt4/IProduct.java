package bt4;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IProduct extends Remote {
	public boolean saveProduct(Product p) throws RemoteException;

	public boolean deleteById(String id) throws RemoteException;

	public Product findById(String id) throws RemoteException;

	public boolean editPrice(String id, double newPrice) throws RemoteException;

}
