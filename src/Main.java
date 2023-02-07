public class Main {
    public static void main(String[] args) {
        University university = new University(3);
        for (int i = 1; i <= 5; i++) {
            new Student(university).start();
        }
    }
}