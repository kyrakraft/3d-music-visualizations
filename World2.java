import processing.core.*;
import ddf.minim.*;
import ddf.minim.analysis.*;
import java.util.*;

public class World2 extends World
{

  public World2(PApplet papplet, Sphere1 s, Sphere1 s2, Minim m)
  {
    this.papplet = papplet;
    sphere = s;
    homeSphere = s2;

    minim = m;

    currentSound = minim.loadFile("ashleypiano3.mp3");

    beam = new Beam(this.papplet, currentSound);

    beams = new ArrayList<Beam>();
    for (int i=0; i<100; i++)
        {beams.add(new Beam(papplet, currentSound));}
  }


  public String name()
  {
    return " ";
  }

  public void background()
  {
      papplet.background(195, 60, 190);

  }

  void displayInstructions()
  {
    // papplet.textSize(30);
    // papplet.text("to SWITCH WORLDS:", 15, 527);
    // papplet.textSize(19);
    // papplet.text("touch the MOVING SPHERE to move to the NEXT WORLD", 15, 565);
    // papplet.text("at any point, touch the CENTER SPHERE to return HOME", 15, 590);
  }

  public void display()
  {

    sphere.drawSphere();
    sphere.changeRadius(20 + currentSound.mix.level() * 65);
    sphere.changeFill(195+currentSound.mix.level() * 285, currentSound.mix.level() * 45, 190+currentSound.mix.level() * 305);
    sphere.changeStroke(250+currentSound.mix.level() * 25, 90+currentSound.mix.level() * 605, 250+currentSound.mix.level() * 805);

    homeSphere.drawSphere();
    homeSphere.changeRadius(20 - currentSound.mix.level() * 45);
    homeSphere.changeFill(195+currentSound.mix.level() * 285, currentSound.mix.level() * 45, 190+currentSound.mix.level() * 305);
    homeSphere.changeStroke(250+currentSound.mix.level() * 25, 90+currentSound.mix.level() * 605, 250+currentSound.mix.level() * 805);


    for (Beam b : beams)
    {
      b.drawBeam();
    }
  }

  public AudioPlayer getCurrentSound() //all worlds must have this
  {
    return currentSound;
  }

  private PApplet papplet;
  private Sphere1 sphere;
  private Sphere1 homeSphere;
  private AudioPlayer currentSound;
  private Minim minim;
  private Beam beam;
  private ArrayList<Beam> beams;
}
