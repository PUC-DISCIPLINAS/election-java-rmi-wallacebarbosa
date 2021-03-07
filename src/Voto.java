
public class Voto {
	
	private String candidato;
	private int qtdVotos;
	
	public Voto(String nome) {
		this.candidato = nome;
		this.qtdVotos = 0;
	}
	
	public void votar() {
		qtdVotos++;
	}

	public int getQtdVotos() {
		return qtdVotos;
	}

	public String getCandidato() {
		return candidato;
	}


}
