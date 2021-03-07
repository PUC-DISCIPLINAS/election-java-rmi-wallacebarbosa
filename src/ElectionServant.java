
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.util.Objects;
import java.util.Vector;


import Utils.StringUtils;

public class ElectionServant implements Election {

	protected ElectionServant() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Vector<Candidate> votos = new Vector<Candidate>();
	public static Vector<Candidate> candidates;
	
	
	//salva os votos dos candidatos em um arquivo
	public void saveLog() {
		BufferedWriter votesWriter = null;

        try{
            // Update computed votes on file
            votesWriter = new BufferedWriter(new FileWriter("votes.csv"));
            for(Candidate Cvotos : votos) {
                votesWriter.write(Cvotos.toStringVotes() + System.lineSeparator());
            }
            votesWriter.close();

        }catch (IOException e){
            e.printStackTrace();
        }
	}

	@Override
	public String vote(String eleitor, String candidato) throws RemoteException {
		if(!checkVoters(eleitor)) {
			
			for(Candidate x : candidates ) {
				String r = x.getNumber();
				if (r.equals(candidato)) {	
					x.votar();
					if(!votos.contains(x)) 
						votos.add(x);
					else
					votos.get(votos.indexOf(x)).setQtdvotos(x.getQtdvotos());
					
					saveVoter(eleitor);
					saveLog();
					return "vote succesfully.";
				}
			}
			return "Candidate not found!";
		}
		return "You already voted!";
	}
	
	//salva eleitor que votou em um arquivo
	private void saveVoter(String eleitor) {
		BufferedWriter votesWriter = null;

        try{
            // Update computed votes on file
        	 File file =new File("voters.csv");
       	  if(!file.exists()){
       	 	file.createNewFile();
       	  }
            votesWriter = new BufferedWriter(new FileWriter("voters.csv",true));
            PrintWriter pw = new PrintWriter(votesWriter);
            pw.println(eleitor);
            
            votesWriter.close();

        }catch (IOException e){
            e.printStackTrace();
        }
		
	}
 
	//Verifica se o eleitor já votou
	private static boolean checkVoters(String eleitor) {
		 
			try {
				BufferedReader FileVoters = new BufferedReader(new FileReader("voters.csv"));
				    String linha;
				    while ((linha = FileVoters.readLine()) != null) {				    	
				    	if(linha.equals(eleitor)) {
				    		return true;
				    	}			      
				    }
				    
				    FileVoters.close();
				   
			} catch (FileNotFoundException e) {
				
			} catch (IOException e) {
				
			}
			return false;
	}

	@Override
	public Candidate result(String candidato) throws RemoteException {
		return candidates.stream().filter(x -> x.getNumber().equals(candidato)).findFirst().get();
		
	}

	@Override
	public void setCandidate(Vector<Candidate> cadidates) throws RemoteException {
		// TODO Auto-generated method stub
		candidates = cadidates;
	}

	@Override
	public Vector<Candidate> getCandidate() throws RemoteException {
		// TODO Auto-generated method stub
		return votos;
	}
	

	
	
	
	
}
