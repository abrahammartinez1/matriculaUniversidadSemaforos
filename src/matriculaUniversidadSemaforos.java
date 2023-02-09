import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class matriculaUniversidadSemaforos {

    private static Semaphore semaphore = new Semaphore(3); //Hay 3 mostradores para matricularse


    static class Student extends Thread {
        private int matricula;
        public static int NIP = 1;
        Student(int matricula) {
            this.matricula = matricula;
        }

        public void run() {

            try {
                semaphore.acquire();
                System.out.println("Alumno con matricula " + matricula + " matriculado con numero: " + NIP);
                NIP++;
                Thread.sleep(1000);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //Matriculamos a los estudiantes
        Integer numEstudiates = 10; //numero de estudiantes que estan en la sala de espera
        for (int i = 1; i <= numEstudiates; i++) {
            new Student(i).start();
        }
    }
}
