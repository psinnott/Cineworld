import java.util.Date;

import ie.dcu.redbrick.Cineworld.*;

public class Example
{
	public static void main(String args[])
	{	
		try
		{
			Client client = new Client("YOURKEY");
			Cinema[] cinemas = client.fetch_cinema(Territory.ie);
		
			for (Cinema cinema : cinemas) 
			{
				Film films[] = client.fetch_films(cinema);
				for( Film film : films )
				{
					Date d = new Date();
					
					Performance performances[] = client.fetch_performances(film,d);
					for( Performance performance : performances)
					{
						System.out.println( performance.getFilm().getTitle() + " " + 
                                                                    performance.getDate());
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}