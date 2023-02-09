import java.util.Random;

class Estudiante extends Thread {

    private int identif;
    private int NIP;
    private int numMatricula;
    private Matricula itv;
    private Matricula matricula;

    public Estudiante(int identif, Matricula itv) {
        this.identif = identif;
        this.itv = itv;

        this.NIP = identif * 1050;
        this.matricula = itv;
       // this.numMatricula = 1;
    }

    @Override
    public void run() {
        //itv.nuevoCoche(identif);
        itv.nuevoCoche(this.NIP);
    }
}
