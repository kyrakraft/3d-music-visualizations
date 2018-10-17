import processing.core.*;
import ddf.minim.*;
import ddf.minim.analysis.*;
import java.util.*;

public class Beam
{

  private float x1;
  private float z1;
  private float x2;
  private float z2;

  private float vx1;
  private float vz1;
  private float vx2;
  private float vz2;

  private float r;
  private float g;
  private float b;

  private Minim minim;
  private AudioPlayer currentSound;



  private PApplet papplet;

  public Beam(PApplet p, AudioPlayer getCurrentSound)
  {
    papplet = p;

    x1 = papplet.random(-600, 600);
    z1 = papplet.random(-600, 600);
    x2 = papplet.random(-600, 600);
    z2 = papplet.random(-600, 600);

    vx1 = papplet.random(-3, 3);
    vz1 = papplet.random(-3, 3);
    vx2 = papplet.random(-3, 3);
    vz2 = papplet.random(-3, 3);

    r = papplet.random(200, 255);
    g = papplet.random(180, 200);
    b = papplet.random(230, 255);

    currentSound = getCurrentSound;

  }

  public void drawBeam()
  {

    float soundFactor = currentSound.mix.level() * 800;

    float x = x1 + papplet.random(-soundFactor/3, soundFactor/3);
    float z = z1 + papplet.random(-soundFactor/3, soundFactor/3);
    float xx = x2 + papplet.random(-soundFactor*3, soundFactor*3);
    float zz = z2 + papplet.random(-soundFactor*3, soundFactor*3);

    papplet.pushMatrix();
    papplet.translate(x1, 0, z1);
    papplet.stroke(r, g, b);
    papplet.line(x, 800, z, xx, -800, zz);
    papplet.popMatrix();


    /*vx1 = speed/2;
    vx2 = speed*2;

    vz1 = speed/2;
    vz2 = speed*2;

    x1 += vx1;
    z1 += vz1;
    x2 += vx2;
    z2 += vz2;

    if (x1>(600)) x1 = -x1;
    else if (x1==(-600)) x1 = -x1;

    if (x2<(600)) x2 = -x2;
    else if (x2>(-600)) x2 = -x2;

    if (z1>(600)) z1 = -z1;
    else if (z1<(-600)) vz1 = -vz1;

    if (z2>(600)) z2 = -z2;
    else if (z2<(-600)) z2 = -z2;



    if (vx1 > 0) x1 += speed/2;
    else if (vx1 < 0) x1 -= speed*2;

    if (vz1 > 0) z1 += speed/2;
    else if (vz1 < 0) z1 -= speed*2;*/




  }

}
