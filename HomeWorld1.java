import processing.core.*;
import ddf.minim.*;
import ddf.minim.analysis.*;

public class HomeWorld1 extends World
{

  public HomeWorld1(PApplet papplet, Sphere1 s, Sphere1 s2, Minim m)
  {
    this.papplet = papplet;
    sphere = s;
    homeSphere = s2;
    minim = m;
    currentSound = minim.loadFile("ashleypiano1.mp3");
    //sphere = new Sphere1(this.papplet); //private sphere in project class. pass to constructor for each world; or accessor fuinction; set sphere function
  }



  public String name()
  {
    return "HOME";
  }

  public void background()
  {
      float c = currentSound.mix.level() * 400;
      papplet.background(2+c);


  }

  void displayInstructions()
    {
      papplet.fill(255);
      papplet.textSize(40);
      papplet.text("CONTROLS:", 20, 200);
      papplet.textSize(19);
      papplet.text("ZOOM: 'a' & 'z' keys", 20, 235);
      papplet.text("ARROW KEYS :", 20, 275);
      papplet.text("ROTATE: left & right arrow keys", 20, 294);
      papplet.text("UP & DOWN: up & down arrow keys", 20, 316);
      papplet.text("or...MOUSE :", 20, 350);
      papplet.text("navigate by dragging and holding", 20, 366);

      papplet.textSize(30);
      papplet.text("to SWITCH WORLDS:", 15, 527);
      papplet.textSize(19);
      papplet.text("touch the MOVING SPHERE to move to the NEXT WORLD", 15, 565);
      papplet.text("at any point, touch the CENTER SPHERE to return HOME", 15, 590);

    }


  public void display()
  {


    papplet.stroke(0);
    papplet.fill(255);
    papplet.sphere(15);

    sphere.drawSphere();
    homeSphere.drawSphere();


  }

  public AudioPlayer getCurrentSound()
  {
    //minim = new Minim(papplet);
    //currentSound = minim.loadFile("apcshome.mp3");
    return currentSound;
  }

  private Minim minim;
  private PApplet papplet;
  private Sphere1 sphere;
  private Sphere1 homeSphere;
  private AudioPlayer currentSound;

}
