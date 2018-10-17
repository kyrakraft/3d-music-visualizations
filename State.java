public class state{


private Papplet papplet;

public State(Papplet p)
{
 papplet = p;
}

  public void state()
  {

    public void keyPressed()
    {
        cylNav.keyPressed();


        if (key == 'q')
        {
          state = 0;

          current.getCurrentSound().pause();  // stop curent sound
          current = worlds.get(0);
          current.getCurrentSound().play(); // start playing new sound

        }

        if (key == 'w')
        {
          state = 1;

        }

        if (key == 'e')
        {
          state = 2;
          //current = worlds.get(2);
        }

        if (key == 'r')
        {
          state = 3;
          //current = worlds.get(3);
        }

        if (sphere.SphereCollision() == true)
        {
          state ++;
        }

        if (state == 0) current = worlds.get(0);
        if (state == 1)
          {
            current.getCurrentSound().pause();
            current = worlds.get(1);
            current.getCurrentSound().play();
          }
        if (state == 2) current = worlds.get(2);
        if (state == 3) current = worlds.get(3);


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

}
