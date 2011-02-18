package ES;
import java.net.*;
import java.io.*;
public class StartEchoServer 
{
	private ServerSocket Echo;
	private String inOut;
	private DataInputStream inkommande;
	private PrintStream utgaende;
	private Socket klientIngang;
	
	@SuppressWarnings("deprecation")
	public StartEchoServer()
	{
		try
		{
			Echo = new ServerSocket(9999);
			System.out.println("Seversocket skapats");
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		
		try
		{
			klientIngang = Echo.accept();
			inkommande = new DataInputStream(klientIngang.getInputStream());
			utgaende = new PrintStream(klientIngang.getOutputStream());
			System.out.println("In och utströmmar skapats");
			while(true)
			{
				inOut = inkommande.readLine();
				inOut += " Serverside Svar!";
				utgaende.println(inOut);
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}

}
