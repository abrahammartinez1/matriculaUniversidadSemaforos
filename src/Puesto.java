class Puesto extends Thread {

    private int identif;
    private Matricula itv;


    public Puesto(int identif, Matricula itv) {
        this.identif = identif;
        this.itv = itv;

    }

    @Override
    public void run() {
        int retardo;
        int numeroCoche;
        int numMatricula;
        while (itv.isCochesPendientes()) {
            try {
                retardo = (int) (Math.random() * 90 + 10);

                numeroCoche = itv.terminarCoche(retardo);
                numMatricula = itv.getnumMatricula();
                sleep(retardo);
                System.out.println("El puesto " + identif + " ha matriculado al estudiante NIP" + numeroCoche + " y le ha asignado la matrícula: M" + numMatricula);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Fin del puesto " + identif );
    }
}