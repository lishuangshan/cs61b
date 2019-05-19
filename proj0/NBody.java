public class NBody {	

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];

		double radius = readRadius(filename);
		Body[] someBodies = readBodies(filename);


		StdDraw.enableDoubleBuffering();

		double time = 0;

		while(time < T) {
			double[] xForces = new double[someBodies.length];
			double[] yForces = new double[someBodies.length];
			for(int i = 0; i < someBodies.length; i++) {
				xForces[i] = someBodies[i].calcNetForceExertedByX(someBodies);
				yForces[i] = someBodies[i].calcNetForceExertedByY(someBodies);	
			}

			for(int i = 0; i < someBodies.length; i++) {
				someBodies[i].update(dt, xForces[i], yForces[i]);	

			}
			
			drawBackground(radius);

			for(Body b : someBodies) {
				b.draw();
			}

			StdDraw.show();
			StdDraw.pause(10);
			time += dt;
		}
		StdOut.printf("%d\n", someBodies.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < someBodies.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            someBodies[i].xxPos, someBodies[i].yyPos, someBodies[i].xxVel,
            someBodies[i].yyVel, someBodies[i].mass, someBodies[i].imgFileName);   
		}


	}
	
	public static void drawBackground(double radius) {

		StdDraw.setScale(-radius, radius);

		StdDraw.picture(0, 0, "./images/starfield.jpg/", 2 * radius, 2 * radius);



	}


	public static double readRadius(String fileName) {
		In in = new In(fileName);
		int num = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Body[] readBodies(String fileName) {
		In in = new In(fileName);
		int num = in.readInt();
		double radius = in.readDouble();
		Body[] someBodies = new Body[num];
		for(int i = 0; i < someBodies.length; i++) {
			double xP = in.readDouble();
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double m = in.readDouble();
			String img = in.readString();
			someBodies[i] = new Body(xP, yP, xV, yV, 
	 							m, img);
		}

		return someBodies;

	}
} 