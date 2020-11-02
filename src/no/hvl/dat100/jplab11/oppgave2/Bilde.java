package no.hvl.dat100.jplab11.oppgave2;

import no.hvl.dat100.jplab11.common.TODO;

public class Bilde extends Tekst {

	private String url;
	
	public Bilde(int id, String bruker, String dato, String tekst, String url) {
		setId(id);
		setBruker(bruker);
		setDato(dato);
		setTekst(tekst);
		this.url = url;
	}

	public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
		setId(id);
		setBruker(bruker);
		setDato(dato);
		for(int i = 0; i < likes; i++)
		{
			doLike();
		}
		setTekst(tekst);
		this.url = url;
	}
	
	public String getUrl() {
		return url;

	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "BILDE" + "\n" + getId() + "\n" + getBruker() + "\n" + getDato() + "\n" + getLikes() + "\n" + "et bilde" + "\n" + url + "\n";

	}

	@Override
	public String toHTML() {
		
		return "\n" + "<h2>" + getBruker() + getDato() + getLikes() + "<h2>" + "\n" + "<p>" + getTekst() + "<p>" + "\n" + "<iframe src=" + "\"" + url + "\"" + " height = 600 width = 800 ><iframe><hr>"; 
				
	}
}
