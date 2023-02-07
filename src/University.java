import java.util.concurrent.Semaphore;

public class University {
    private int NIP = 1;
    private Semaphore semaphore;

    public University(int numberOfDesks) {
        semaphore = new Semaphore(numberOfDesks, true);
    }

    public int enroll(Student student) throws InterruptedException {
        semaphore.acquire();
        int currentNIP = NIP;
        NIP++;
        semaphore.release();
        return currentNIP;
    }
}



