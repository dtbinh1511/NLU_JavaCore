import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ISearch extends Remote {
	public boolean checkUserName(String name) throws RemoteException;

	public boolean login(String name, String password) throws RemoteException;

	public List<Student> findByName(String name) throws RemoteException;

	public List<Student> findByAge(int age) throws RemoteException;

	public List<Student> findByScore(double score) throws RemoteException;
}
