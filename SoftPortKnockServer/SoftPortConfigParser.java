import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SoftPortConfigParser {

    private static final SoftPortConfigParser instance = new SoftPortConfigParser();

    private SoftPortConfigParser() {
    }

    public static SoftPortConfigParser getInstance() {
        return instance;
    }

    public void exportConfig(List<Rule> ruleList, String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            for (Rule rule : ruleList)
                out.writeObject(rule);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public List<Rule> importConfig(String filename) {
        List<Rule> list = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            while (fileIn.available() > 0) {
                Rule rule = (Rule)in.readObject();
                list.add(rule);
            }
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
        return list;
    }
}
