@Deprecated
public class NBody {
    public static double readRadius(String fileName) {
        In in = new In(fileName);
        int num = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);
        int num = in.readInt();
        double radius = in.readDouble();
        Planet[] planets = new Planet[num];
        for (int i = 0; i < num; i++) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            planets[i] = new Planet(xP, yP, xV, yV, m, img);
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.valueOf(args[0]);
        double dt = Double.valueOf(args[1]);
        String fileName = args[2];

        double r = readRadius(fileName);
        Planet[] planets = readPlanets(fileName);
        int num = planets.length;

        StdDraw.setXscale(-r, r);
        StdDraw.setYscale(-r, r);
        StdDraw.enableDoubleBuffering();

        double t = 0;
        while (t <= T) {
            double[] xForces = new double[num];
            double[] yForces = new double[num];

            for (int i = 0; i < num; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            for (int i = 0; i < num; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(0, 0, "./images/starfield.jpg");

            for (Planet p : planets) {
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            t += dt;
        }
        
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", r);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }

}