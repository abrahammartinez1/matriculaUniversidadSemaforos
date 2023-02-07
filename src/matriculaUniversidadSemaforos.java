import java.util.concurrent.Semaphore;

class matriculaUniversidadSemaforos {
    private static int NIP = 1001;
    private static Semaphore semaphore = new Semaphore(3);

    static class Student extends Thread {
        private int matricula;

        Student(int matricula) {
            this.matricula = matricula;
        }

        public void run() {
            try {
                semaphore.acquire();
                System.out.println("Alumno " + matricula + " matriculado con NIP " + NIP);
                NIP++;
                Thread.sleep(1000);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 1001; i <= 1020; i++) {
            new Student(i).start();
        }
    }
}
