public class NBody {	

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];

		double radius = readRadius(filename);
		Body[] someBodies = readBodies(filename);

		drawBackground(radius);

	}
	
	public static void drawBackground(double radius) {
		StdDraw.enableDoubleBuffering();

		StdDraw.setScale(-radius, radius);
		StdDraw.clear();
		StdDraw.picture(0, 0, "./images/starfield.jpg/", 2 * radius, 2 * radius);
		StdDraw.show();


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