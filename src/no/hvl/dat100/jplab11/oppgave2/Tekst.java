package no.hvl.dat100.jplab11.oppgave2;

import no.hvl.dat100.jplab11.oppgave1.*;

public class Tekst extends Innlegg {

	private String tekst;
	
	public Tekst () {
		
	}
	
	public Tekst(int id, String bruker, String dato, String tekst) {
		super(id, bruker, dato);
		this.tekst = tekst;
	}
	
	public Tekst(int id, String bruker, String dato, int likes, String tekst) {
	super(id, bruker, dato);
		for(int i = 0; i < likes; i++)
		{
			doLike();
		}
		this.tekst = tekst;
	}
	
	public String getTekst() {
		return tekst;

	}

	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	@Override
	public String toString() {
		return "TEKST" + "\n" + getId() + "\n" + getBruker() + "\n" + getDato() + "\n" + getLikes() + "\n" + tekst + "\n";

	}
	
	@Override
	public String toHTML() {
			
		return "\n" + "<h2>" + getBruker() + getDato() + getLikes() + "<h2>" + "\n" + "<p>" + tekst + "<p>" + "\n" + "<hr>"; 
				
	}
}
