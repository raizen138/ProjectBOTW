import java.util.HashMap;

public class MapChunk 
{
	public String name = new String();
	public int[][] layout;
	public HashMap<Integer, String> exits = new HashMap<>(); 
	public int[][] exitLayout;
	public String BgImg = new String();
	public int[][] charLayout;
	
	public MapChunk()
	{
		name = "defaultname";
		layout = new int[11][16];
	}
	
	public MapChunk(String newName, int[][] newLayout, HashMap<Integer, String> newExits, int[][] newExitLayout, int[][] newCharLayout, String newBgImg)
	{
		name = newName;
		layout = newLayout;
		exitLayout = newExitLayout;
		exits.putAll(newExits);
		charLayout = newCharLayout;
		BgImg = newBgImg;
		
	}
	
	public String getNextMap(int key)
	{
		return exits.get(key);
	}
	
	public String toString()
	{
		return "Name: " + name + "\nExits: " + exits;
	}
}
