public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet b) {
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Planet p2) {
        double dx = p2.xxPos - xxPos;
        double dy = p2.yyPos - yyPos;
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance;
    }

    public double calcForceExertedBy(Planet p2) {
        double r = calcDistance(p2);
        double force = G * mass * p2.mass / (r * r);
        return force;
    }

    public double calcForceExertedByX(Planet p2) {
        double dx = p2.xxPos - xxPos;
        double r = calcDistance(p2);
        return calcForceExertedBy(p2) * dx / r;
    }

    public double calcForceExertedByY(Planet p2) {
        double dy = p2.yyPos - yyPos;
        double r = calcDistance(p2);
        return calcForceExertedBy(p2) * dy / r;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double totalForce = 0;
        for (Planet p : allPlanets) {
            if (p.equals(this))
                continue;
            totalForce += this.calcForceExertedByX(p);
        }
        return totalForce;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double totalForce = 0;
        for (Planet p : allPlanets) {
            if (p.equals(this))
                continue;
            totalForce += this.calcForceExertedByY(p);
        }
        return totalForce;
    }

    public void update(double dt, double f_x, double f_y) {
        double a_x = f_x / mass;
        double a_y = f_y / mass;
        xxVel += dt * a_x;
        yyVel += dt * a_y;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "./images/" + imgFileName);
    }
}
