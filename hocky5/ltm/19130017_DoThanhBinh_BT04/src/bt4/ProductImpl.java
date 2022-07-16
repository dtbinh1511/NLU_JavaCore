package bt4;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ProductImpl extends UnicastRemoteObject implements IProduct {
	DAO dao;

	protected ProductImpl() throws RemoteException {
		super();
		dao = new DAO();
	}

	@Override
	public boolean saveProduct(Product p) throws RemoteException {

		try {
			return dao.saveProduct(p);
		} catch (MyException e) {
			throw new RemoteException(e.getMessage());
		}
	}

	@Override
	public boolean deleteById(String id) throws RemoteException {
		try {
			return dao.deleteById(id);
		} catch (MyException e) {
			throw new RemoteException(e.getMessage());
		}
	}

	@Override
	public Product findById(String id) throws RemoteException {
		try {
			return dao.findById(id);
		} catch (MyException e) {
			throw new RemoteException(e.getMessage());
		}
	}

	@Override
	public boolean editPrice(String id, double newPrice) throws RemoteException {
		try {
			return dao.editPrice(id, newPrice);
		} catch (MyException e) {
			throw new RemoteException(e.getMessage());
		}
	}

}
