
public record Supervisor(AbstractProgram program) implements Runnable {

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (program) {
                    if (program.getState() == State.STOPPING) {
                        System.out.println("STOPPING. Restarting the program...");
                        program.wait();
                    }
                    if (program.getState() == State.FATAL_ERROR) {
                        System.out.println("FATAL ERROR. Finishing process...");
                        return;
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
