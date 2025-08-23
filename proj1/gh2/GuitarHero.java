package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {
    public static void main(String[] args) {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        int size = keyboard.length();
        GuitarString[] guitarString = new GuitarString[size];
        for (int i = 0; i < size; i++) {
            double frequency = 440 * Math.pow(2, (i - 24) / 12.0);
            guitarString[i] = new GuitarString(frequency);
        }

        while (true) {
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                if (index == -1) {
                    continue;
                }

                guitarString[index].pluck();
            }

            double sample = 0.0;
            for (int i = 0; i < size; i++) {
                sample += guitarString[i].sample();
            }

            StdAudio.play(sample);

            for (int i = 0; i < size; i++) {
                guitarString[i].tic();
            }
        }
    }
}
