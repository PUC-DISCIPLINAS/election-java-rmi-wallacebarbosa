import java.io.Serializable;
import java.util.Objects;

public class Candidate implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String number;
	private String name;
	private String politicalParty;
	private int qtdvotos;
	
	public Candidate(String number, String name, String politicalParty) {
		super();
		this.number = number;
		this.name = name;
		this.politicalParty = politicalParty;
		this.qtdvotos = 0;
	}
	
	public void votar() {
		qtdvotos++;
	}
	
	public String getName() {
		return name;
	}
	
	public String getNumber() {
		return number;
	}
	
	public String getPoliticalParty() {
		return politicalParty;
	}
	
	public int getQtdvotos() {
		return qtdvotos;
	}
	
	public void setQtdvotos(int qtdvotos) {
		this.qtdvotos = qtdvotos;
	}
	
	public void print() {
		System.out.println("---------------------------------");
		System.out.println("Nome: " + name);
		System.out.println("partido: " + politicalParty);
		System.out.println("number: " + number);
		System.out.println("qtdvotos: " + qtdvotos);
		System.out.println("---------------------------------");
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate that = (Candidate) o;
        return Objects.equals(this.getNumber(), that.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getNumber());
    }
	
   public String toStringVotes() {
       return this.number + ";" + this.name + ";" + this.politicalParty + ";" + this.qtdvotos;
   }
}
