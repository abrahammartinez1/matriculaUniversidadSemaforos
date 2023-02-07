public class Student extends Thread {
    private University university;
    private int NIP;

    public Student(University university) {
        this.university = university;
    }

    public void run() {
        try {
            NIP = university.enroll(this);
            System.out.println("Student " + this.getId() + " was assigned NIP " + NIP);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
