
class Estudiante extends Thread {

    private int identif;
    private Matricula itv;

    public Estudiante(int identif, Matricula itv) {
        this.identif = identif;
        this.itv = itv;
    }

    @Override
    public void run() {
        itv.nuevoCoche(identif);
    }
}
