import processing.core.*;

public class UseCylNav extends PApplet
{
  public void settings()
  {
      size(800, 600, P3D);
  }

  public void setup()
  {
      cylNav = new CylNav(this); //creating a cylnav object
      // construct world1
  }

  public void draw()
  {
      background(0);
      cylNav.update();

      pushMatrix();
      cylNav.transform();
      drawScene();
      popMatrix();

      //world1.display();

  }

  private void drawScene()
  {
      cylNav.drawAxes();
  }

  private CylNav cylNav;
  private World1 world1;

  public static void main(String[] args)
  {
      PApplet.main("UseCylNav");
  }

  public void keyPressed()
  {
      cylNav.keyPressed();
  }

  public void keyReleased()
  {
    cylNav.keyReleased();
  }

  public void mouseDragged()
  {
    cylNav.mouseDragged();
  }

  public void mouseReleased()
  {
    cylNav.mouseReleased();
  }

}
