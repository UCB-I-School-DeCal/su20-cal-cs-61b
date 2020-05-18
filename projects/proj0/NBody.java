public class NBody {
  public static int readNumPlanets(String fileName){
    /* Start reading in national_salt_production.txt */
		In in = new In(fileName);

    int numPlanets = in.readInt();
		return numPlanets;
  }

  public static double readRadius(String fileName){
    /* Start reading in national_salt_production.txt */
		In in = new In(fileName);

    int numPlanets = in.readInt();  // How to skip the first line?
		double radius = in.readDouble();
		return radius;
  }

  public static Body[] readBodies(String fileName){
    /* Start reading in national_salt_production.txt */
		In in = new In(fileName);

    int numPlanets = in.readInt();
		double radius = in.readDouble();
    Body[] bodyList = new Body[numPlanets];

    for (int i = 0; i < numPlanets; i++) {
          double xxPos = in.readDouble();     // position // Do i need static here?
          double yyPos = in.readDouble();
          double xxVel = in.readDouble() ;    // velocity
          double yyVel = in.readDouble();
          double mass = in.readDouble();
          String imgFileName = in.readString();

          Body b = new Body(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
          bodyList[i] = b ;

        }

		return bodyList;
  }


  public static void main(String[] args) {
     // Grab T and dt from the arguments
     double T = Double.parseDouble(args[0]);
     double dt = Double.parseDouble(args[1]);

     // grab the file name
     String filename = args[2];

     // Extract radius, num planets, and list of bodies
     double radius = readRadius(filename);
     int numPlanets = readNumPlanets(filename);
     Body[] bodyList = readBodies(filename);

     // Enable double buffering
     StdDraw.enableDoubleBuffering();

     // field as big as the radius
     StdDraw.setScale(-radius, radius);
     double[] xForces;
     double[] yForces;
     double netForceX;
     double netForceY;

     // Loop through time
     for (int t=0; t <= T; t+= dt) {
          xForces = new double [numPlanets];
          yForces = new double [numPlanets];

          // Star field
          StdDraw.picture(0, 0, "images/starfield.jpg");

          /* Loop through bodies in bodyList */
          for (int p = 0; p < numPlanets; p++) {
            Body nthBody = bodyList[p];

            /* Calculuate the net forces for every Body,
            then add it to the forces list*/
            netForceX = nthBody.calcNetForceExertedByX(bodyList);
            netForceY = nthBody.calcNetForceExertedByY(bodyList);
            xForces[p] = netForceX;
            yForces[p] = netForceY;

          }

          // Loop again through bodies
          for (int p = 0; p < numPlanets; p++) {
            Body nthBody = bodyList[p];
            double fX = xForces[p];
            double fY = yForces[p];

            nthBody.update(dt, fX, fY);
            nthBody.draw();
          }

           /* Shows the drawing to the screen, and waits 1 milliseconds. */
      		StdDraw.show();
      		StdDraw.pause(1);

      }

      // print output
      StdOut.printf("%d\n", bodyList.length);
      StdOut.printf("%.2e\n", radius);
      for (int i = 0; i < bodyList.length; i++) {
          StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                        bodyList[i].xxPos, bodyList[i].yyPos, bodyList[i].xxVel,
                        bodyList[i].yyVel, bodyList[i].mass, bodyList[i].imgFileName);
      }

  }
}
