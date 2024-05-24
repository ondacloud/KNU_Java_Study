import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Dealer extends Card {
    private int score = 0;
    private Map<Integer, String> handList = new HashMap<>();
    private ArrayList<Integer> numList = new ArrayList<>();
    private int check = 0;

    public String getHandList(int choice) {
        String list = "";
        switch (choice) {
            case 1:
                list = handList.get(0) + " BLINDED";
                break;
            case 2:
                for(int i = 0; i <= handList.size()-1; i++){
                    list += handList.get(i) + " " ;
                }
                break;
        }
        return list;
    }

    public void drawStore(){
        handList.put(handList.size(),draw());
        numList.add(getNum());
    }

    public int getScore(){
        int temp = 1;
        int cnt = Collections.frequency(numList, 1);
        if(cnt == 1){
            if(getNum()==1){
                if(score <= 10){
                    score += 11;
                    temp = 11;
                }else{
                    score += 1;
                    check++;
                }
            }else{
                if(score + getNum() > 21){
                    if(check == 0){
                        score += getNum()-10;
                        temp = getNum()-10;
                        check++;
                    }else {
                        score += getNum();
                        temp = getNum();
                    }
                }else{
                    score += getNum();
                    temp = getNum();
                }
            }
        } else if (cnt >= 2) {
            if(getNum()==1){
                score += 1;
                check++;
            }else{
                if(score + getNum() > 21){
                    if(check == 0){
                        score += getNum()-10;
                        temp = getNum()-10;
                        check++;
                    }else {
                        score += getNum();
                        temp = getNum();
                    }
                }else{
                    score += getNum();
                    temp = getNum();
                }
            }
        }else{
            score += getNum();
            temp = getNum();
        }

        return temp;
    }

    public void reset(){
        handList.clear();
        numList.clear();
        score = 0;
        check = 0;
    }

}
