public class Body {
   public double xxPos;     // position // Do i need static here?
   public double yyPos;
   public double xxVel ;    // velocity
   public double yyVel;
   public double mass;
   public String imgFileName;     // the name of the file to correspond to the img that depics body

   // Later on, an instance of the Body class can represent a planet, star, or various objects in this universe
   public Body(double xP, double yP, double xV,
               double yV, double m, String img){
      this.xxPos = xP;
      this.yyPos = yP;
      this.xxVel = xV;
      this.yyVel = yV;
      this.mass = m;
      this.imgFileName = img;
   }
   public Body(Body b){
      this.xxPos = b.xxPos;
      this.yyPos = b.yyPos;
      this.xxVel = b.xxVel;
      this.yyVel = b.yyVel;
      this.mass = b.mass;
      this.imgFileName = b.imgFileName;
   }

   // not static case I'm using a particular instance of body
   public double calcDistance(Body b){
      double xxDis;
      double yyDis;
      double disSqr;
      double dis;
      double guess;
      xxDis = this.xxPos - b.xxPos;
      yyDis = this.yyPos - b.yyPos;
      disSqr = xxDis*xxDis + yyDis*yyDis;
      // Some starting point for distance
      if (xxDis > yyDis) {
         guess = xxDis;
      } else {
         guess = xxDis ;
      }
      dis = test(disSqr, guess);
      if (dis < 0){
         dis = -dis ;
      }
      return dis;
   }

   public double test(double bigNum, double guess){
      if (closeEnough(bigNum, guess)){
         return guess;
      } else {
         return test(bigNum, betterGuess(bigNum, guess));
      }
   }
   public boolean closeEnough(double bigNum, double guess){
      double threshold = 0.01;
      double difference = bigNum/guess - guess;
      if ((difference == 0) ||
          (difference > 0 &&  difference <= threshold) ||
          (difference < 0 && -difference <= threshold)
         ){
         return true;
      } else {
         return false;
      }
   }

   public double calcForceExertedBy(Body b){
      /**takes in a Body, and returns a double describing the
     force exerted on this body by the given body.*/

      double dis = calcDistance(b);
      double g = 6.67e-11;
      double m1 = this.mass;
      double m2 = b.mass ;
      double f ;

      f = (g * m1 * m2)/(dis*dis);

      return f;
   }


   public double calcForceExertedByX(Body otherBody){
      double f = this.calcForceExertedBy(otherBody);
      double dx = otherBody.xxPos - this.xxPos;
      double dis = this.calcDistance(otherBody);
      double fx = (f * dx) / dis;
      return fx;
   }

   public double calcForceExertedByY(Body otherBody){
      double f = this.calcForceExertedBy(otherBody);
      double dy = otherBody.yyPos - this.yyPos;
      double dis = this.calcDistance(otherBody);
      double fy = (f * dy) / dis;
      return fy;
   }

   public double calcNetForceExertedByX(Body[] bodyList){
      double f ;
      double dx ;
      double dis;
      double fx ;
      double netForce = 0;

      for (Body nthBody : bodyList) {
         // As long as the Nth body is not the base body itself...
         if (!(this.equals(nthBody))){
            fx = this.calcForceExertedByX(nthBody);
            netForce += fx ;
         }
      }

      return netForce ;

   }


   public double calcNetForceExertedByY(Body[] bodyList){
      double f ;
      double dy ;
      double dis;
      double fy ;
      double netForce = 0;

      for (Body nthBody : bodyList) {
         // As long as the Nth body is not the base body itself...
         if (!(this.equals(nthBody))){
            fy = this.calcForceExertedByY(nthBody);
            netForce += fy ;
         }
      }

      return netForce ;

   }

   public double betterGuess(double bigNum, double guess){
      double avgVal = (guess + bigNum/guess) / 2 ;
      return avgVal  ;
   }

   public void update(double dt, double fX, double fY){
     /** Determine how much the forces exerted on the body will
     cause that body to accelerate, and the resulting change in
     the body’s velocity and position in a small period of time dt. */

     // Calculate the acceleration using the provided x- and y-forces.
     double ax = fX / this.mass ;
     double ay = fY / this.mass ;

     // Calculate the new velocity by using the acceleration and
     // current velocity. Recall that acceleration describes the
     // change in velocity per unit time, so the new velocity is
     // (vx+dt⋅ax,vy+dt⋅ay)
     this.xxVel = this.xxVel + dt*ax;
     this.yyVel = this.yyVel + dt*ay;

     //Calculate the new position by using the velocity computed
     // in step 2 and the current position. The new position is
     // (px+dt⋅vx,py+dt⋅vy)

     this.xxPos = this.xxPos + dt*this.xxVel;
     this.yyPos = this.yyPos + dt*this.yyVel;

   }

   public void draw(){
     StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
   }

   // For java visualizer!
   public static void main(String[] args) {
      // System.out.println("Checking calcDistance...");
      Body b1 = new Body(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
      // Body b2 = new Body(2.0, 3.0, 3.0, 4.0, 5.0, "jupiter.gif");
      // Body[] bodyList = {b1, b2};
      // Body b3 = new Body(4.0, 5.0, 3.0, 4.0, 5.0, "jupiter.gif");
      // System.out.println(b1.calcForceExertedByX(b2));
      // System.out.println(b1.calcForceExertedByY(b2));
      b1.draw();
   }
}
