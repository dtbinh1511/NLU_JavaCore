import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class SearchImpl extends UnicastRemoteObject implements ISearch {
	DAO dao;

	protected SearchImpl() throws RemoteException {
		super();
		dao = new DAO();
	}

	@Override
	public boolean checkUserName(String name) throws RemoteException {
		try {
			return dao.checkUserName(name);
		} catch (MyException e) {
			throw new RemoteException(e.getMessage());
		}
	}

	@Override
	public boolean login(String name, String password) throws RemoteException {
		return dao.login(name, password);
	}

	@Override
	public List<Student> findByName(String name) throws RemoteException {
		return dao.findByName(name);
	}

	@Override
	public List<Student> findByAge(int age) throws RemoteException {
		return dao.findByAge(age);
	}

	@Override
	public List<Student> findByScore(double score) throws RemoteException {
		return dao.findByScore(score);
	}

}
