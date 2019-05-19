public class Body {
	/**
		The instance variables
		I'm a bit confused why the guidance asks me to 
		set them to public instead of private?
	*/

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

	// calcDistance
	public double calcDistance(Body b) {
		double dxSq = Math.pow((this.xxPos - b.xxPos), 2);
		double dySq = Math.pow((this.yyPos - b.yyPos), 2);
		return Math.sqrt((dxSq + dySq));
	}



}