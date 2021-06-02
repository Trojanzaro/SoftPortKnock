import java.io.Serializable;

public class Rule implements Serializable {
    private String ip;
    private int port;
    private long milliseconds;

    public Rule(String ip, int port, long milliseconds){
        this.ip = ip;
        this.port = port;
        this.milliseconds = milliseconds;
    }

    public String getIp() {
        return this.ip;
    }

    public int getPort() {
        return this.port;
    }

    public long getMillis() {
        return this.milliseconds;
    }

    @Override
    public String toString() {
        return "IP = " + this.ip + " Port = " + this.port + " Milliseconds = " + this.milliseconds;
    }
}
