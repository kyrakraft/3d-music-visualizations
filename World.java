import ddf.minim.*;
import ddf.minim.analysis.*;
import processing.core.*;

abstract class World
{
  abstract public void background();

  abstract void display();

  void displayInstructions()
  {
    
  }

  abstract String name();
  abstract AudioPlayer getCurrentSound();
  //public Sphere getPortal();
}
