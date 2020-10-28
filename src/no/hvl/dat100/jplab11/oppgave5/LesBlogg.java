package no.hvl.dat100.jplab11.oppgave5;

import java.io.File;
import java.util.Scanner;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {

		Blogg myblogg = new Blogg();
		try
		{
			File obj = new File(mappe + filnavn);
			Scanner reader = new Scanner(mappe + filnavn);
			Tekst[] myblogtekst = new Tekst[reader.nextInt()];
			Bilde[] myblogbilde = new Bilde[myblogtekst.length];
			
			
			for(int i = 0; i < myblogtekst.length; i++)
			{
				if(reader.nextLine().contains(TEKST))
				{
					myblogtekst[i].setId(reader.nextInt());
					myblogtekst[i].setBruker(reader.nextLine());
					myblogtekst[i].setDato(reader.nextLine());
					for(int j = 0; j < reader.nextInt(); j++)
					{
						myblogtekst[i].doLike();
						
					}
					myblogtekst[i].setTekst(reader.nextLine());
					
					
				}
				else if(reader.nextLine().contains(BILDE))
				{
					myblogbilde[i].setId(reader.nextInt());
					myblogbilde[i].setBruker(reader.nextLine());
					myblogbilde[i].setDato(reader.nextLine());
					for(int j = 0; j < reader.nextInt(); j++)
					{
						myblogbilde[i].doLike();
					}
					myblogbilde[i].setUrl(reader.nextLine());
				}
				if(myblogtekst[i] != null)
				{
					myblogg.leggTil(myblogtekst[i]);
				}
				else if(myblogbilde[i] != null)
				{
					myblogg.leggTil(myblogbilde[i]);
				}
				
			}
			reader.close();
		}
		catch(Exception e)
		{
			System.out.println("An error occurred.");
			 e.printStackTrace();
		}
		
		
		return myblogg;

	}
}
