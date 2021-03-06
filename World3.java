import processing.core.*;
import ddf.minim.*;
import ddf.minim.analysis.*;
import java.util.*;

public class World3 extends World
{

  public World3(PApplet papplet, Sphere1 s, Sphere1 s2, Minim m)
  {
    this.papplet = papplet;
    sphere = s;
    homeSphere = s2;

    minim = m;

    currentSound = minim.loadFile("ashleypiano4.mp3");

    cubes = new ArrayList<Cube>();
    for (int i = 0; i< 450; i++)
    {
      cubes.add(new Cube(papplet, currentSound));
    }

  }


  public String name()
  {
    return " ";
  }

  public void background()
  {
      papplet.background(100, 10, 200);

  }

  void displayInstructions()
  {
    // papplet.textSize(30);
    // papplet.text("to SWITCH WORLDS:", 15, 527);
    // papplet.textSize(19);
    // papplet.text("touch the MOVING SPHERE to move to the NEXT WORLD", 15, 565);
    // papplet.text("at any point, touch the CENTER SPHERE to return to HOME", 15, 590);
  }

  public void display()
  {

    sphere.drawSphere();
    sphere.changeRadius(20 + currentSound.mix.level() * 25);
    sphere.changeFill(105+currentSound.mix.level() * 285, 10+currentSound.mix.level() * 45, 190+currentSound.mix.level() * 305);
    sphere.changeStroke(227+currentSound.mix.level() * 25, 125+currentSound.mix.level() * 605, 109+currentSound.mix.level() * 805);

    homeSphere.drawSphere();
    homeSphere.changeRadius(20 - currentSound.mix.level() * 25);
    homeSphere.changeFill(105+currentSound.mix.level() * 285, 10+currentSound.mix.level() * 45, 190+currentSound.mix.level() * 305);
    homeSphere.changeStroke(227+currentSound.mix.level() * 25, 125+currentSound.mix.level() * 605, 109+currentSound.mix.level() * 805);



    for (Cube c : cubes)
    {
      c.drawCube();
    }

  }

  public AudioPlayer getCurrentSound()
  {
    return currentSound;
  }

  private PApplet papplet;
  private Sphere1 sphere;
  private Sphere1 homeSphere;
  private AudioPlayer currentSound;
  private Minim minim;
  private ArrayList<Cube> cubes;
}
