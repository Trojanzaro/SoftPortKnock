package SoftPortKnockServer;

import java.io.IOException;

public class SoftPortExec {
    
    private static final SoftPortExec instance = new SoftPortExec();

    private SoftPortExec() {
    }

    public static SoftPortExec getInstance() {
        return instance;
    }
    
    public void openPort(String ip, int port, String password) {
        Runtime rt = Runtime.getRuntime();
        try {
            Process pr = rt.exec("node open_port.js " + password + " " + ip + " " + port);
            pr.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void closePort(int port, String password) {
        Runtime rt = Runtime.getRuntime();
        try {
            Process pr = rt.exec("node close_port.js " + password + " " + port);
            pr.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
