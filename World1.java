import processing.core.*;
import java.util.*;
import ddf.minim.*;
import ddf.minim.analysis.*;

public class World1 extends World
{

  public World1(PApplet papplet, Sphere1 s, Sphere1 s2, Minim m)
  {
    this.papplet = papplet;
    sphere = s;
    homeSphere = s2;
    minim = m;
    currentSound = minim.loadFile("ashleypiano2.mp3");
    //sphere1 = new Sphere1(this.papplet);
    rain = new Raindrop(this.papplet, currentSound);

    raindrops = new ArrayList<Raindrop>();
    for (int i=0; i<1800; i++)
        {raindrops.add(new Raindrop(this.papplet, currentSound));}
  }

  public String name()
  {
    return " ";
  }

  public void background()
  {
      papplet.background(15, 180, 180);

  }

  void displayInstructions()
  {
  //   papplet.textSize(30);
  //   papplet.text("to SWITCH WORLDS:", 15, 527);
  //   papplet.textSize(19);
  //   papplet.text("touch the MOVING SPHERE to move to the NEXT WORLD", 15, 565);
  //   papplet.text("at any point, touch the CENTER SPHERE to return HOME", 15, 590);
  }

  public void display()
  {
    sphere.drawSphere();
    sphere.changeRadius(20 + currentSound.mix.level() * 65);
    sphere.changeFill(currentSound.mix.level() * 205, 205-currentSound.mix.level() * 285, 215-currentSound.mix.level() * 305);
    sphere.changeStroke(currentSound.mix.level() * 605, 10+currentSound.mix.level() * 25, 70+currentSound.mix.level() * 805);

    homeSphere.drawSphere();
    homeSphere.changeRadius(20 - currentSound.mix.level() * 65);
    homeSphere.changeFill(currentSound.mix.level() * 205, 205-currentSound.mix.level() * 285, 215-currentSound.mix.level() * 305);
    homeSphere.changeStroke(currentSound.mix.level() * 605, 10+currentSound.mix.level() * 25, 70+currentSound.mix.level() * 805);

    //quickSoundTest();

    for (Raindrop r : raindrops)
    {r.drawRain();}

  }

  public void quickSoundTest()
  {
    if (currentSound.mix.level() < 1) papplet.text(currentSound.mix.level(), 50, 50);
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
  private Raindrop rain;
  private ArrayList<Raindrop> raindrops;
}
