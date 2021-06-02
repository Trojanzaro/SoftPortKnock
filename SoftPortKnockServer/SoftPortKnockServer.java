package SoftPortKnockServer;

public class SoftPortKnockServer {

    public static void main(String... args) {
        String filename = "config.confx";

        System.out.println("SoftPortKnock V0.1");
        System.out.println("by Trojanzaro");
        System.out.println();

        System.out.println("Reading [" + filename + "] config file . . .");

        SoftPortConfig config = new SoftPortConfig("192.168.0.143", filename);
        
        if(config.getRules().isEmpty()) {
            System.out.println("[ERROR] File colletion of rules empty.");
            System.exit(1);
        }
        System.out.println("Read succesfull!");
        System.out.println("Initializing server with first port . . .");
    }

}