import processing.core.*;
import processing.event.*;

public class CylNav implements PConstants
{

  private PApplet papplet;

  //cyl coords instead of rect

  private float theta;
  private float y;
  private float r;

  private float vtheta;
  private float vy;
  private float vr;

  private float a;
  private float b;
  private float c;


  public void initialize()
  {
    theta = 0;
    y = 0;
    r = 0;

    vtheta = 0;
    vy = 0;
    vr = 0;
  }


  public CylNav(PApplet papplet)
  {
      this.papplet = papplet;
      initialize();
  }

  public void transform()
  {
      vrcoords();
      //rotate and translate are functions that come with.
      papplet.translate(0, 0, -r);
      papplet.rotateY(-theta); //rotateY means rotate around y axis with theta as angle
      papplet.translate(0, -y, 0);
  }

  public void update()
  {
      theta += vtheta; //velocity of rotation
      y += vy;
      r += vr;
  }

  public void drawAxes()
  {
      final float length = 200;

      papplet.colorMode(RGB, 255);

      papplet.strokeWeight(1);
      // x = red
      papplet.stroke(255);
      papplet.line(0, 0, 0, length, 0, 0);
      papplet.stroke(255);
      papplet.line(-length, 0, 0, 0, 0, 0);

      // y = green
      papplet.stroke(255);
      papplet.line(0, 0, 0, 0, length, 0);
      papplet.stroke(255);
      papplet.line(0, -length, 0, 0, 0, 0);

      // z = blue
      papplet.stroke(255);
      papplet.line(0, 0, 0, 0, 0, length);
      papplet.stroke(255);
      papplet.line(0, 0, -length, 0, 0, 0);
  }


  public void keyPressed()
  {
    final float thetaspeed = .03f;
    final float yspeed = 2;
    final float rspeed = 2;

    //if (r<0):
    if (papplet.keyCode == RIGHT)
        vtheta = thetaspeed;
    else if (papplet.keyCode == LEFT)
        vtheta = -thetaspeed;

    //if >0 then which keys




    else if (papplet.keyCode == UP)
        vy = yspeed;
    else if (papplet.keyCode == DOWN)
        vy = -yspeed;

    else if (papplet.key == 'z')
        vr = rspeed;
    else if (papplet.key == 'a')
        vr = -rspeed;
  }

  public void keyReleased()
  {
    if (papplet.keyCode == RIGHT || papplet.keyCode == LEFT)
        vtheta = 0;
    else if (papplet.keyCode == UP || papplet.keyCode == DOWN)
        vy = 0;

    else if (papplet.key == 'a' || papplet.key == 'z')
        vr = 0;
  }

  public void mouseDragged()
  {
    PVector v = new PVector(papplet.mouseX-papplet.pmouseX,
                            papplet.mouseY-papplet.pmouseY);
    v.normalize();
    vtheta = -.02f * v.x;
    vy = .9f * v.y;
  }

  public void mouseReleased()
  {
    vtheta = 0f; //f = float
    vy = 0f;
    //vr = 0;
  }


  private void vrcoords() ///forgot... why is this private?
  {
      papplet.translate(papplet.width/2, papplet.height/2); //origin at center
      final float maxY = 100; //y scaled to 100
      final float scalingFactor = papplet.height/2 / maxY;
      papplet.scale(scalingFactor, -scalingFactor, scalingFactor); //y positive up
  }


  public void convert()
  {
    a = (175+r)*(papplet.sin(theta));
    b = (175+r)*(papplet.cos(theta));
    c = y;

    /*papplet.text("cyl", 50, 420);
    papplet.text("radius: " + r, 50, 450);
    papplet.text("angle: " + theta, 50, 460);
    papplet.text("height: " +y, 50, 470);

    papplet.text("rect", 50, 220);
    papplet.text("side: " + a, 50, 250);
    papplet.text("depth: " +b, 50, 260);
    papplet.text("height: " +c, 50, 270);*/
  }


  public boolean collision(float x, float w, float z)
  {
    convert();

    if (papplet.abs(x - a) < 10 && (papplet.abs(z - b) < 10) && (papplet.abs(w - c) < 10))
    {
      return true;
    }

    else return false;
  }




}
