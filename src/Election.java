import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

interface Election extends Remote, Serializable{
	
	public void setCandidate(Vector<Candidate> cadidates) throws RemoteException;
	
	public Vector<Candidate> getCandidate() throws RemoteException;
	
	public String vote(String eleitor, String candidato) throws RemoteException;
	
	public Candidate result(String candidato) throws RemoteException;
}
