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
    return "WELCOME";
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
      //papplet.text("CONTROLS:", 20, 200);
    }


  public void display()
  {


    papplet.stroke(0);
    papplet.fill(255);
    //papplet.sphere(15);

    sphere.drawSphere();
    sphere.changeRadius(20 + currentSound.mix.level() * 25);
    sphere.changeFill(255-currentSound.mix.level() * 305, 255-currentSound.mix.level() * 305, 255-currentSound.mix.level() * 305);
    sphere.changeStroke(currentSound.mix.level() * 805, currentSound.mix.level() * 805, currentSound.mix.level() * 805);

    homeSphere.drawSphere();
    homeSphere.changeRadius(20 - currentSound.mix.level() * 25);
    homeSphere.changeFill(255-currentSound.mix.level() * 305, 255-currentSound.mix.level() * 305, 255-currentSound.mix.level() * 305);
    homeSphere.changeStroke(currentSound.mix.level() * 805, currentSound.mix.level() * 805, currentSound.mix.level() * 805);


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
