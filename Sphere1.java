import processing.core.*;

public class Sphere1
{

  private PApplet papplet;
  private World currentWorld;

  private float x;
  private float y;
  private float z;
  private float vx;
  private float vy;
  private float vz;
  private boolean collide;
  private boolean move;

  private float r;

  private float fillR;
  private float fillG;
  private float fillB;

  private float strokeR;
  private float strokeG;
  private float strokeB;

  public Sphere1(PApplet papplet, boolean move, float r)
  {
    this.papplet = papplet;

    this.r = r;

    fillR = 255;
    fillG = 255;
    fillB = 255;

    strokeR = 255;
    strokeG = 255;
    strokeB = 255;

    x = 0f;
    y = 0f;
    z = 0f;

    if (move == true)
    {
      vx = papplet.random(0.1f, 0.4f);
      vy = papplet.random(0.4f, 1f);
      vz = papplet.random(0.1f, 0.4f);

    }

    else
    {
      vx = 0;
      vy = 0;
      vz = 0;
    }

  }

  public float getX()
  {
    return x;
  }

  public float getY()
  {
    return y;
  }

  public float getZ()
  {
    return z;
  }

  public void changeRadius(float newRadius){
    r = newRadius;
  }

  public void changeFill(float newR, float newG, float newB){
    fillR = newR;
    fillG = newG;
    fillB = newB;
  }

  public void changeStroke(float newR, float newG, float newB){
    strokeR = newR;
    strokeG = newG;
    strokeB = newB;
  }

  public void drawSphere()
  {

    //currentWorld = papplet.getCurrentWorld();
    //WHYYYYYY

    //r = currentblah

    papplet.pushMatrix();
    papplet.translate(x, y, z);
    papplet.stroke(strokeR, strokeG, strokeB);
    papplet.fill(fillR, fillG, fillB);
    papplet.sphere(r);
    papplet.popMatrix();

    x +=vx;
    y += vy;
    z += vz;

    if (x>(30-20)) vx = -vx;

    else if (x<(-30+20)) vx = -vx;

    if (y>(80-20))vy = -vy;

    else if (y<(-1)) vy = -vy;

    if (z>(30-20)) vz = -vz;

    else if (z<(-30+20)) vz = -vz;
  }

  public void printSphereCoords()
  {
    /*papplet.text(x, 50, 50);
    papplet.text(y, 50, 65);
    papplet.text(z, 50, 80);*/
  }




}
