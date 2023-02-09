
import java.util.concurrent.Semaphore;
import java.util.PriorityQueue;

class Matricula {

    private final Semaphore semaforo;
    private final PriorityQueue<Integer> listaCoches;

    private Integer contadorMatricula;

    public Matricula() {
        semaforo = new Semaphore(1);
        listaCoches = new PriorityQueue<Integer>();
        contadorMatricula = 0;
    }

    public void nuevoCoche(Integer numeroCoche) {
        try {
            semaforo.acquire();
            listaCoches.add(numeroCoche);
            semaforo.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int terminarCoche(Integer tiempoParcial) {
        int coche = 0;
        try {
            if (isCochesPendientes()) {
                semaforo.acquire();
                coche = listaCoches.poll();
                contadorMatricula+=1;
                semaforo.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return coche;
    }

    public boolean isCochesPendientes() {
        return listaCoches.size() > 0;
    }

    public Integer getnumMatricula() {
        return contadorMatricula;
    }

}