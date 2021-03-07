import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ServerRmi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Election a = new ElectionServant();
			a.setCandidate(setCandidates("senadores.csv"));
			Election stub = (Election) UnicastRemoteObject.exportObject(a, 0);
			
			
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("Election", stub);
            
			System.out.println("Servidor Pronto.....");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	 //Ler arquivo
	  public static Vector<Candidate> setArchive(String path) {
		  
		    BufferedReader FileSenators;
			try {
				FileSenators = new BufferedReader(new FileReader(path));
				    Vector<Candidate> line = new Vector<Candidate>();
				    String linha;
				    while ((linha = FileSenators.readLine()) != null) {
				    	String[] infos = linha.split(";");
				    	int i = infos.length;
				    	Candidate temp = new Candidate(infos[0], infos[1], infos[2]);
				    	if(i > 3) temp.setQtdvotos(Integer.parseInt(infos[i-1]));
				        line.add(temp);
				      
				    }
				    
				   FileSenators.close();
				   return line;
			} catch (FileNotFoundException e) {
				
			} catch (IOException e) {
				
			}
			
		    return null;
		  }
	  
	  public static Vector<Candidate> setCandidates(String path) throws IOException { 
		  //Retira dados duplicados
		  Vector<Candidate> listCandidates = setArchive(path).stream().distinct().collect(Collectors.toCollection(Vector::new));
		  Vector<Candidate> log = setArchive("votes.csv");
		  
		  //se existir um arquivo de log é usado para recuperar os votos
		  if ((log != null)) {
			  log.forEach(x -> {
				  for(Candidate temp : listCandidates) {
					  if (temp.getNumber().equals(x.getNumber())) {
							 temp.setQtdvotos(x.getQtdvotos());
					}
				  }
				 
			  });
		}
		  	  
		  return listCandidates;
	  }
	  

}
