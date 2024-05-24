import java.util.HashMap;
import java.util.Map;

public class Card {
    private String shape;
    private int num;
    private String strnum;
    private String[] shapeName = {"Diamond", "Clover", "Heart", "Spade" };


    Map<String, Integer> bin = new HashMap<>();

    //getter
    public int getNum() {
        return num;
    }

    public String draw(){
        shape = shapeName[(int) (Math.random() * shapeName.length)];
        num = (int) (Math.random() * 13 +1);
        strnum = strCheck(num);
        num = numCheck(num);

        return shape + " " +strnum;
    }


    public String strCheck(int num) {
        switch(num){
            case 1:
                return "A";

            case 11:
                return "J";

            case 12:
                return "Q";

            case 13:
                return "K";

            default:
                return ""+num;
        }
    }

    public int numCheck(int num) {
        switch(num){
            case 1:
                return 1;

            case 11:
            case 12:
            case 13:
                return 10;

            default:
                return num;
        }
    }
}
