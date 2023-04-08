public class Lab6 {

    public static void main(String[] args) {
        AbstractProgram program = new AbstractProgram();
        Supervisor supervisor = new Supervisor(program);
        Thread programThread = new Thread(program);
        Thread supervisorThread = new Thread(supervisor);

        programThread.start();
        supervisorThread.start();
    }

}
