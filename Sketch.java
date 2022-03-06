import processing.core.PApplet;

public class Sketch extends PApplet {
	
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */


    //clock variables
    int clockX, clockY;
    float secondsCircle;
    float minutesCircle;
    float hoursCircle;
    float clock;


  public void settings() {
	// put your size call here
    size(1000, 1000);
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

    
    int radius = min(width,height) / 10;
    secondsCircle = radius * (float)0.72;
    minutesCircle = radius * (float)0.60;
    hoursCircle = radius * (float)0.50;
    clock = radius * (float)1.8;

    clockX = width/4;
    clockY = height/4;


  }
  public void draw(){
    
    //clock BG
    fill(80);
    noStroke();
    ellipse(clockX, clockY, clock, clock);

    float seconds = map(second(), 0, 60, 0, TWO_PI) - HALF_PI;
    float minutes = map(minute() + norm(second(), 0, 60), 0, 60, 0, TWO_PI) - HALF_PI; 
    float hours = map(hour() + norm(minute(), 0, 60), 0, 24, 0, TWO_PI * 2) - HALF_PI;

    //Clock Hands
    stroke(255);
    strokeWeight(1);
    line(clockX, clockY, clockX + cos(seconds) * secondsCircle, clockY + sin(seconds) * secondsCircle);
    strokeWeight(2);
    line(clockX, clockY, clockX + cos(minutes) * minutesCircle, clockY + sin(minutes) * minutesCircle);
    strokeWeight(4);
    line(clockX, clockY, clockX + cos(hours) * hoursCircle, clockY + sin(hours) * hoursCircle);
   
    strokeWeight(2);
    beginShape(POINTS);
    for (int a = 0; a < 360; a+=6) {
    float angle = radians(a);
    float x = clockX + cos(angle) * secondsCircle;
    float y = clockY + sin(angle) * secondsCircle;
    vertex(x, y);

  }
  
}

}