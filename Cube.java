import processing.core.*;
import ddf.minim.*;
import ddf.minim.analysis.*;


public class Cube
{
  private float x;
  private float y;
  private float z;

  private float s;

  private float r;
  private float g;
  private float b;

  private float theta;
  private float vtheta = .03f;

  private AudioPlayer currentSound;



  private PApplet papplet;

  public Cube(PApplet p, AudioPlayer getCurrentSound)
  {
    papplet = p;
    x = papplet.random(-900, 900);
    y = papplet.random(-900, 900);
    z = papplet.random(-900, 900);

    s = papplet.random(10, 30);

    r = papplet.random(200, 255);
    g = papplet.random(190, 205);
    b = papplet.random(100, 150);

    theta = papplet.random(.1f, 1);

    currentSound = getCurrentSound;
  }

  public void drawCube()
  {
    float sizeFactor = currentSound.mix.level() * 250;

    papplet.pushMatrix();
    papplet.translate(x, y, z);
    papplet.rotateX(theta);
    papplet.rotateY(theta);
    papplet.stroke(r, g, b);
    papplet.fill(r, g, b);
    papplet.box(s + sizeFactor);
    papplet.popMatrix();

    theta += vtheta;




  }


}
