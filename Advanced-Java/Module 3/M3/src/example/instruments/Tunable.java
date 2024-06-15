package example.instruments;

public interface Tunable {
    int A_440 = 440;
    String getTuningInfo();
    boolean isTuned(int frequency);
}
