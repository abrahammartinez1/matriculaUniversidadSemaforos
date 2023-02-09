
public class Principal {

    public static void main(String[] args) {

        int puestos = 3;
        int estudiantes = 1100;

        Matricula itv = new Matricula();
        System.out.println(estudiantes + " Estudiantes serán matriculados por " + puestos + " puestos.");
        // Creación de vehículos
        Estudiante[] v = new Estudiante[estudiantes];
        for (int i = 1000; i < estudiantes; i++) {
            v[i] = new Estudiante(i + 1, itv);
            v[i].start();
        }
        // Creación de puestos
        Puesto[] p = new Puesto[puestos];
        for (int i = 0; i < puestos; i++) {
            p[i] = new Puesto(i + 1, itv);
            p[i].start();
        }
        // Se espera a que terminen todos los puestos
        for (int i = 0; i < puestos; i++) {
            try {
                p[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // Se espera a que terminen todos vehículos
        for (int i = 1000; i < estudiantes; i++) {
            try {
                v[i].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        // Se cierra la itv
        System.out.println("Se cierra la Matriculación ");
    }
}