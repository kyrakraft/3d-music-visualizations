import processing.core.*;
import java.util.*;
import ddf.minim.*;
import ddf.minim.analysis.*;

public class Projectt1 extends PApplet
{


  public void settings()
  {
      size(800, 600, P3D);

  }

  public void setup()
  {

      minim = new Minim(this);


      sphere = new Sphere1(this, true, 20);
      homeSphere = new Sphere1(this, false, 20);

      cylNav = new CylNav(this);

      worlds = new ArrayList<World>();
      worlds.add(new HomeWorld1(this, sphere, homeSphere, minim));
      worlds.add(new World1(this, sphere, homeSphere, minim));
      worlds.add(new World2(this, sphere, homeSphere, minim));
      worlds.add(new World3(this, sphere, homeSphere, minim));

      current = worlds.get(0);

      current.getCurrentSound().play();

      state = 0; //not necessary at the moment but maybe can use later
  }


  public void draw()
  {

      current.background();
      cylNav.update();

      pushMatrix();
      cylNav.transform();
      cylNav.drawAxes();
      current.display(); //display world
      popMatrix();

      fill(255);
      //text("current world:", 25, 25);
      textSize(80);
      text(current.name(), 220, 77);
      textSize(12);
      //fill(0);

      current.displayInstructions();

      sphere.printSphereCoords();

      if (collisions() == true)
      {
        state --;
        stateChange();
      }

      if (movingCollisions() == true)
      {
        state ++;
        stateChange();
      }

  }


    private AudioPlayer song;
    private Minim minim;

    private CylNav cylNav;
    private World current;
    private Sphere1 sphere;
    private Sphere1 homeSphere;

    private ArrayList<World> worlds;

    private int state; //dont need rn


  public void stateChange()
  {
    if (state == 0)
    {
      current.getCurrentSound().pause();  // stop curent sound
      current = worlds.get(0);
      current.getCurrentSound().play(); // start playing new sound
    }

    if (state == 1)
      {
        current.getCurrentSound().pause();
        current = worlds.get(1);
        current.getCurrentSound().play();
      }
    if (state == 2)
    {
      current.getCurrentSound().pause();
      current = worlds.get(3);
      current.getCurrentSound().play();
    }
    if (state == 3)
    {
      current.getCurrentSound().pause();
      current = worlds.get(2);
      current.getCurrentSound().play();
    }

    cylNav.initialize();

  }


  public void keyPressed()
  {
      cylNav.keyPressed();


      if (key == 'q')
      {
        state = 0;
        stateChange();
      }

      if (key == 'w')
      {
        state = 1;
        stateChange();
      }

      if (key == 'e')
      {
        state = 2;
        stateChange();
      }

      if (key == 'r')
      {
        state = 3;
        stateChange();
      }



  }

  public void keyReleased()
  {
    cylNav.keyReleased();
  }

  public void mouseDragged()
  {
    cylNav.mouseDragged();
  }

  public void mouseReleased()
  {
    cylNav.mouseReleased();
  }



  public boolean collisions()
  {

    float hsphereX = homeSphere.getX();
    float hsphereY = homeSphere.getY();
    float hsphereZ = homeSphere.getZ();

    boolean result = cylNav.collision(hsphereX, hsphereY, hsphereZ);
    return result;

  }

  public boolean movingCollisions()
  {
    float sphereX = sphere.getX();
    float sphereY = sphere.getY();
    float sphereZ = sphere.getZ();

    boolean result = cylNav.collision(sphereX, sphereY, sphereZ);
    return result;

  }







  public static void main(String[] args)
  {
      PApplet.main("Projectt1");
  }
}

//song = current.getCurrentSound();
//song.play();
