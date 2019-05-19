public class NBody {	

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