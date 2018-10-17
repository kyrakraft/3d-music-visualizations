import processing.core.*;
import java.util.*;

import ddf.minim.*;
import ddf.minim.analysis.*;

public class Raindrop
{

  private PApplet papplet;

  private float x;
  private float y;
  private float z;
  private float vx;
  private float vy;
  private float vz;
  private float ay;
  private float c;
  private float s;
  private Minim minim;
  private AudioPlayer currentSound;
  private boolean isLoud;


  public Raindrop(PApplet papplet, AudioPlayer getCurrentSound)
  {
    this.papplet = papplet;

    x = papplet.random(-600, 600);
    y = papplet.random(-600, 600);
    z = papplet.random(-600, 600);



    vx = 1.23f;
    vy = 0.5f;
    vz = 1.23f;

    ay = 0.05f;

  s = papplet.random(0.001f, 1.7f);

  currentSound = getCurrentSound;



  }

  public void drawRain()
  {
    float speed = (currentSound.mix.level()-0.015f) * 200;

    float theta = 0;

    papplet.pushMatrix();
    papplet.translate(x, y, z);
    papplet.rotateY(theta);
    papplet.stroke(0, 0, 140);
    papplet.fill(40, 40, 225);
    papplet.box(s);
    papplet.popMatrix();
    papplet.fill(0);

    theta += 0.2f;

    y -= vy;
    y -=speed;

    vy += ay;


    if (currentSound.mix.level() == 0.02f)
    {
      isLoud = true;
    }

    if(isLoud == true)
    {
      vx = -vx;
    }



    x+=vx;
    z+=vz;


    if (x>(600))
    {
      x = -x+2;
      //vx = -0.2f;
    }

    else if (x<(-600))
    {
      x = -x-2;
      //vx = 0.2f;
    }

    if (y<(-600))
    {
      y = -y;
      vy = 0.5f;
    }

    if (z>(600))
    {
      z = -z+2;
      //vz = 0.2f;
    }

    else if (z<(-600))
    {
      z = -z-2;
      //vz = 0.2f;
    }
  }

  public void print()
  {
    papplet.text(vx, 50, 50);
  }



}
