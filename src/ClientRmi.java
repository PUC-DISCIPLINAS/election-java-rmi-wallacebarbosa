import java.math.BigInteger;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import Utils.AnimeLoading;

public class ClientRmi {
	static Election elect = null;
	static String candidato = "";
	static String name = "";
	public static void main(String[] args)  {
		//inicia conexão com objeto remoto
		tryConnect();
		
		//Ler argumentos e executa os metodos.
		try {
			
		switch (args[0]) {
		case "result":
			Candidate temp = elect.result(args[1]);
			temp.print();
			break;
		default:
			name = args[0];
			candidato = args[1];
			 // Generates a md5 hash based on eleitor's name
	        MessageDigest md = MessageDigest.getInstance("MD5");
	        md.update(name.getBytes());
	        byte[] md5 = md.digest();

	        // Format in lowercase Hexadecimal before printing to output
	        BigInteger numMd5 = new BigInteger(1, md5);
	        name = String.format("%022x", numMd5);
	        String msg = elect.vote(name, candidato);
	        System.out.println("\n" + msg);
			break;
		}
		
		} catch (RemoteException e) {
			e.printStackTrace();
			tryConnect();
		} catch (NoSuchAlgorithmException e) {
			
		}

		
	}
	

	public static void tryConnect() {
		long timeMillis = System.currentTimeMillis();
		
		//inicia animação de loading
		AnimeLoading Anim = new AnimeLoading();
		Thread load = new Thread(Anim);
		load.start();
		
		//Tenta se conectar em loop por 30 segundos
		while (true) {
			try {	
				Registry registry = LocateRegistry.getRegistry();
				elect = (Election) registry.lookup("Election");
				
				Anim.stop();			
				
				break;			           
			} catch (RemoteException | NotBoundException e) {
				if ((System.currentTimeMillis() - timeMillis) > 30000) {
					Anim.stop();
					System.out.println("\nconnection unsuccesfully.");
					break;
				}
			}
		}
	}
	
	
	
	  
	
}
