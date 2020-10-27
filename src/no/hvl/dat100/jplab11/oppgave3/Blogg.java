package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	Innlegg[] innleggtabell;
	int nesteledige = 0;

	public Blogg() {
		innleggtabell = new Innlegg[20];
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
	}

	public int getAntall() {
		return nesteledige;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {

		int index = -1;
		for(int i = 0; i < nesteledige; i++)
		{
			if(innlegg.erLik(innleggtabell[i]))
			{
				index = i;
			}
		}
		
		
		return index;
		
	}

	public boolean finnes(Innlegg innlegg) {
		
		boolean finnes = false;
		for(int i = 0; i < innleggtabell.length; i++)
		{
			if(innlegg != null && innleggtabell[i] != null && innlegg.getId() == innleggtabell[i].getId())
			{
				finnes = true;
			}
		}
		
		return finnes;
	}

	public boolean ledigPlass() {
		boolean ledigplass = false;
		if(nesteledige < innleggtabell.length)
		{
			ledigplass = true;
		}
		return ledigplass;

	}
	
	public boolean leggTil(Innlegg innlegg) {

		boolean leggtil = false;
		if(!finnes(innlegg))
		{
			innleggtabell[nesteledige] = innlegg;
			leggtil = true;
			nesteledige++;
		}
		return leggtil;
	}
	
	public String toString() {
		String tostring = "";
		tostring += getAntall() + "\n" ;
		for(int i = 0; i < nesteledige; i++)
		{
			tostring +=  innleggtabell[i].toString();
		}
		
		return tostring;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] storinnleggtabell = new Innlegg[innleggtabell.length*2]; 
		for(int i = 0; i < nesteledige; i++)
		{
			storinnleggtabell[i] = innleggtabell[i];
		}
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		boolean leggtil = false;
		if(!finnes(innlegg) && nesteledige < innleggtabell.length)
		{
			innleggtabell[nesteledige] = innlegg;
			leggtil = true;
			nesteledige++;
		}
		else if(!finnes(innlegg) && nesteledige >= innleggtabell.length)
		{
			Innlegg[] storinnleggtabell = new Innlegg[innleggtabell.length*2]; 
			for(int i = 0; i < innleggtabell.length; i++)
			{
				storinnleggtabell[i] = innleggtabell[i];
				
			}
			storinnleggtabell[nesteledige] = innlegg;
			leggtil = true;
			nesteledige++;
			
		}
		return leggtil;
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		boolean slettet = false;
		int index = finnInnlegg(innlegg);
		
		if(index >= 0 && innleggtabell[nesteledige-1] != null)
		{
			innleggtabell[index] = innleggtabell[nesteledige-1];
			innleggtabell[nesteledige-1] = null;
			nesteledige -= 1;
			slettet = true;
		}
		
		return slettet;
	
	}
	
	public int[] search(String keyword) {
		int[] tekstid = new int[20];
		for(int i = 0; i < nesteledige; i++)
		{
			if(innleggtabell.toString().contains(keyword))
			{
				tekstid[i] = innleggtabell[i].getId();
			}
		}
		
		return tekstid;

	}
}