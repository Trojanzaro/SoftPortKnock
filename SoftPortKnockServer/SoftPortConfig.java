package SoftPortKnockServer;
import java.util.ArrayList;
import java.util.List;

public class SoftPortConfig {
    private String ipToFwrd;
    private List<Rule> rulesList;

    public SoftPortConfig(String ipToFwrd, String filename) {
        this.rulesList = SoftPortConfigParser.getInstance().importConfig(filename);
        this.ipToFwrd = ipToFwrd;
    }

    public List<Rule> getRules() {
        return this.rulesList;
    }

    public String getIpToFoward() {
        return this.ipToFwrd;
    }

    //Only for Creating/Reading config lists
    // public static void main(String[] args) {
    //     List<Rule> rulesList;
        
    //     // //Creating config
    //     rulesList = new ArrayList<>();
    //     rulesList.add(new Rule("192.168.0.134", 2456, 5000));
    //     rulesList.add(new Rule("192.168.0.134", 3300, 4000));
    //     rulesList.add(new Rule("192.168.0.134", 1245, 6000));
    //     SoftPortConfigParser.getInstance().exportConfig(rulesList, "config.confx");

    //     //Reading config
    //     rulesList = SoftPortConfigParser.getInstance().importConfig("config.confx");
    //     for(Rule r : rulesList)
    //         System.out.println(r);
    // }
}