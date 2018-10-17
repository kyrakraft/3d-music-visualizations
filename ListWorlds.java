import java.util.*;
import processing.core.*;

public class ListWorlds
{

  private ArrayList<World> listworlds; //variable for arraylist of worlds

  public ListWorlds()
  {
    listworlds = new ArrayList<World>(); //creates empty arraylist
  }

  public void addWorld(World world)
  {
    //World world = homeWorld;
    listworlds.add(world);
  }

}

/*public void addWorld(PApplet papplet) //? ask about papplet and "this"
{
  HomeWorld q = new HomeWorld(papplet);
  listworlds.add(q);
}

public void addWorld(World world)
{
  HomeWorld q = new HomeWorld(world);
  listworlds.add(q);

  */
