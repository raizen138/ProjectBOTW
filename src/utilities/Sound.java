package utilities;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import javazoom.jl.player.Player;

public class Sound {

	private String filename;
	private Player player;
	
	public Sound(String filename) 
	{
		this.filename = filename;
	}
	
	public void close() 
	{
		if(player != null) player.close();
	}
	
	
	public void loop()
	{
		try 
		{
			FileInputStream fis = new FileInputStream(filename);
			player = new Player(fis);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		
		new Thread() 
		{
			public void run()
			{
				try
				{
					player.play();
				}
				catch (Exception e) 
				{ 
					System.out.println(e);
				}
			}
		}.start();
	}
	
	
	public void play()
	{
		try 
		{
			FileInputStream fis = new FileInputStream(filename);
			player = new Player(fis);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		
		new Thread() 
		{
			public void run()
			{
				try{player.play();}
				catch (Exception e) { System.out.println(e);}
			}
		}.start();
	}
	
	
}
