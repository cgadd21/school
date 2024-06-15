package Phase2;

public class PrintChar implements Runnable{
    private char letter;
    private int times;

    public PrintChar(char letter, int times) {
        this.letter = letter;
        this.times = times;
    }

    @Override
    public void run() {
        for(int i = 0; i < times; i++){
            System.out.print(letter);
        }

    }

    //The run method with Thread.sleep() and try/catch
    /*@Override
    public void run() {
        try {
            for (int i = 0; i < times; i++) {
                System.out.print(letter);
                Thread.sleep(1);
            }
        } catch (InterruptedException e){
            System.out.println("There was a problem.");
        }
    }*/
}
