import processing.core.PApplet;

public class Sketch extends PApplet {
	
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(500, 500);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    
    //ramdomized location and size
    float outX = random(0,width);
    float outY = random(0,height);
    float diametre = random (50,100);
    float distance = diametre/6;
    
    //conditions set for background
    boolean topHalf = outY > 250;

    boolean bottomHalf = outY < 250;

    boolean leftHalf = outX > 250;

    boolean rightHalf = outX < 250;

    
    //Background changes per location
    if (topHalf && leftHalf)
    {
      background(184, 51, 106);
    }
    
    if (topHalf && rightHalf)
    {
      background(30, 255, 188);
    }

    if (bottomHalf && leftHalf)
    {
      background(240, 93, 35);
    }

    if (bottomHalf && rightHalf)
    {
      background(6, 174, 213);
    }

    //Outside of button
    fill(255,255,255);
    ellipse(outX, outY, diametre, diametre); 
    
    //Left hole
    fill(0,0,0);
    ellipse(outX - distance, outY, diametre/8, diametre/8);
    
    //Right hole
    fill(0,0,0);
    ellipse(outX + distance, outY, diametre/8, diametre/8);


  }

}