package timingtest;

import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        int testTimes = 8;
        int N = 1000;
        int M = 10000;
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        for (int i = 0; i < testTimes; i++, N *= 2) {
            SLList<Integer> list = new SLList<>();
            
            Ns.addLast(N);
            opCounts.addLast(M);

            for (int j = 0; j < N; j++) {
                list.addLast(1);
            }

            Stopwatch sw = new Stopwatch();
            for (int k = 0; k < M; k++) {
                list.getLast();
            }
            double timeInSeconds = sw.elapsedTime();

            times.addLast(timeInSeconds);
        }
        printTimingTable(Ns, times, opCounts);
    }
}
