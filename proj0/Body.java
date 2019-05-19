public class Body {
	/**
		The instance variables
		I'm a bit confused why the guidance asks me to 
		set them to public instead of private?
	*/
	// The constant G
	public static final double G = 6.67e-11;
	// Its current x position
	public double xxPos;
	// Its current y position
	public double yyPos;
	// Its current velocity in the x direction
	public double xxVel;
	// Its current velocity in the y direction
	public double yyVel;
	// Its mass
	public double mass;
	// The name of the file that corresponds to the image that depicts
	// the body (e.g. jupiter.gif)
	public String imgFileName;

	/** 
		Constructor
	*/

	// Constructor one: create a body instance using instance variables
	public Body(double xP, double yP, double xV, double yV, 
		double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	// Constructor two: copy a body instance using an existing Body instance
	public Body(Body b) {
		this.xxPos = b.xxPos;
		this.yyPos = b.yyPos;
		this.xxVel = b.xxVel;
		this.yyVel = b.yyVel;
		this.mass = b.mass;
		this.imgFileName = b.imgFileName;
	}

	/** 
		Methods
	*/

	// calcDistance:
		// This method will take in a single Body and should
		// return a double equal to the distance between the supplied body and the body that is doing the calculation
	public double calcDistance(Body b) {
		double dxSq = Math.pow((this.xxPos - b.xxPos), 2);
		double dySq = Math.pow((this.yyPos - b.yyPos), 2);
		return Math.sqrt((dxSq + dySq));
	}
	// calcForceExertedBy:
		// This method takes in a Body and returns a double
		// describing the force exerted on this body by the given body
	public double calcForceExertedBy(Body b) {
		return (G * this.mass * b.mass) / Math.pow(this.calcDistance(b), 2);
	}

	// calcForceExertedByX:
		// Describes the force exerted in the X direction by a given Body
		// I shouln't use Math.abs to get the absolute value since it migh cause 
		// troubles when I try drawing planet, said by the guidance
	public double calcForceExertedByX(Body b) {
		double dx = b.xxPos - this.xxPos;
		double force = this.calcForceExertedBy(b);
		double distance = this.calcDistance(b);
		return (force * dx) / distance;
	} 

	// calcForceExertedByY:
		// Describes the force exerted in the Y direction by a given Body
		// I shouln't use Math.abs to get the absolute value since it migh cause 
		// troubles when I try drawing planet, said by the guidance
	public double calcForceExertedByY(Body b) {
		double dy = b.yyPos - this.yyPos;
		double force = this.calcForceExertedBy(b);
		double distance = this.calcDistance(b);
		return (force * dy) / distance;
	} 

	// calcNetForceExertedByX:
		// take in an array of Bodys and calculates the net X force exerted 
		// by all bodies in that array upon the current Body.
		// The method must avoid working on the object itself or the univer will collapse
	public double calcNetForceExertedByX(Body[] allBodys) {
		double netForceX = 0;
		for(Body b : allBodys) {
			if(this.equals(b)) {
				continue;
			}
			netForceX += this.calcForceExertedByX(b);
		}
		return netForceX;
	}

	// calcNetForceExertedByY:
		// take in an array of Bodys and calculates the net Y force exerted 
		// by all bodies in that array upon the current Body.
		// The method must avoid working on the object itself or the univer will collapse
	public double calcNetForceExertedByY(Body[] allBodys) {
		double netForceY = 0;
		for(Body b : allBodys) {
			if(this.equals(b)) {
				continue;
			}
			netForceY += this.calcForceExertedByY(b);
		}
		return netForceY;
	}


}