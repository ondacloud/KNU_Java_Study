## 블랙잭
### 룰 설명
```
"베팅 -> 카드 배분 -> 플레이어 Hit 여부 결정 -> 승패 판정"의 흐름
카드 두 장을 기본적으로 지급받게 되며, 카드 숫자를 합쳐 가능한 21에 가깝게 만들면 이기는 게임.이다. K, Q, J는 10에 해당하며, A는 1 혹은 11 어느 쪽으로도 계산할 수 있다. 처음 받은 2장 합쳐 21이 나오는 경우 블랙잭이 되며 21이 되지 않았을 경우 원한다면 얼마든지 카드를 계속 뽑을 수 있다. 하지만 카드 숫자의 합이 21을 초과하게 되는 순간 '버스트'라고 하며 딜러의 결과에 관계없이 플레이어가 패배한다.

-Hit
처음 2장의 상태에서 카드를 더 뽑는 것을 Hit이라고 한다. 21이 되지 않는 한 얼마든지 원하는 만큼 카드를 뽑을 수 있다.

-Stand / Stay
카드를 더 뽑지 않고 차례를 마치는 것을 스탠드, 혹은 스테이라고 부른다. 카드의 합이 21을 초과하여 버스트가 되는 상황이 나오지 않는 이상 언제든 멈출 수 있다.

-Double Down
돈을 두 배로 거는 것. 본래 합이 21이 넘지 않는 한 무제한으로 뽑을 수 있는 카드를 이후 단 하나만 더 받는 조건으로 돈을 두 배로 걸 수 있다.

-Bust
카드 총합이 21을 넘는 경우. 플레이어가 버스트 당하면 이후 경기 진행에 상관없이 바로 패배가 확정되어 배팅액을 잃는다.

-BlackJack
블랙잭에서 가장 좋은 패. A 한장과 10에 해당하는 패(10,J,Q,K)로 21을 이루는 경우 베팅 금액의 1.5배를 돌려준다.
```

<br>

## Main
```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Management management = new Management();
    }
}
```

<br>

## Management
```java
import java.util.Scanner;

public class Management {
    public Management(){
        Scanner sc = new Scanner(System.in);
        Dealer dealer = new Dealer();
        Player player = new Player();
        int d_score, p_score, bet, choice;
        float money = 1000;


        while(true){
            boolean h = true;
            dealer.reset();
            player.reset();
            d_score =0;
            p_score =0;

            System.out.println("-----------------------------------------");
            System.out.println("<MONEY : "+money+">");
            System.out.println("<BETTING>");
            System.out.print(">>>> ");
            bet = sc.nextInt();

            while(bet>money){
                System.out.println();

                System.out.println("<MONEY : "+money+">");
                System.out.println("<RE-BETTING>");
                System.out.print(">>>> ");
                bet = sc.nextInt();
            }

            System.out.println();
            System.out.println("<DEALER>");
            for(int i=0;i<=1;i++) {
                dealer.drawStore();
                d_score += dealer.getScore();
            }
            System.out.println(dealer.getHandList(1));

            System.out.println();
            System.out.println("<PLAYER>");
            for(int i=0;i<=1;i++) {
                player.drawStore();
                p_score += player.getScore();
            }
            System.out.println(player.getHandList(2));

            System.out.println("<player : "+p_score+">");


            while(h){

                System.out.println();
                System.out.println("1.Hit 2.Double Down 3.Stand");
                System.out.print(">>>> ");
                choice = sc.nextInt();

                switch(choice) {
                    case 1:
                        System.out.println("<<Hit!>>");
                        player.drawStore();
                        p_score += player.getScore();
                        System.out.println("<PLAYER>");
                        System.out.println(player.getHandList(2) + "-> "+ "<player : "+p_score+">");

                        if(p_score > 21) {
                            h = false;
                            break;
                        }

                        continue;

                    case 2:
                        System.out.println("<<Double Down!>>");
                        bet *= 2;
                        System.out.println("<Bet : "+bet+">");
                        player.drawStore();
                        p_score += player.getScore();
                        System.out.println("<PLAYER>");
                        System.out.println(player.getHandList(2)+ "-> "+ "<player : "+p_score+">");

                        if(p_score <= 21){
                            while(d_score < 17){
                                System.out.println();
                                System.out.println("<DEALER>");
                                System.out.println(dealer.getHandList(2)+ "-> "+ "<dealer : "+d_score+">");
                                dealer.drawStore();
                                d_score += dealer.getScore();
                            }
                            System.out.println();
                            System.out.println("<DEALER>");
                            System.out.println(dealer.getHandList(2)+ "-> "+ "<dealer : "+d_score+">");
                        }

                        h = false;
                        break;

                    case 3:
                        System.out.println("<<Stand!>>");
                        while(d_score < 17){
                            System.out.println();
                            System.out.println("<DEALER>");
                            System.out.println(dealer.getHandList(2)+ "-> "+ "<dealer : "+d_score+">");
                            dealer.drawStore();
                            d_score += dealer.getScore();
                        }
                        System.out.println();
                        System.out.println("<DEALER>");
                        System.out.println(dealer.getHandList(2)+ "-> "+ "<dealer : "+d_score+">");


                        h = false;

                }


            }

            if(p_score>21){
                System.out.println();
                System.out.println("<Bust!>");

                money -= bet;
                System.out.println();
                System.out.println("<<LOSE>>");
                System.out.println("<MONEY : "+money+">");

            }else if(d_score > 21){
                if(player.getHandLen() == 2 && p_score == 21){
                    money += (float) (1.5 * bet);
                    System.out.println();
                    System.out.println("<BlackJack!!!>");
                }else{
                    money += bet;
                }
                System.out.println();
                System.out.println("<<WIN>>");
                System.out.println("<MONEY : "+money+">");
            }else{
                if(p_score <= 21){
                    if(player.getHandLen() == 2 && p_score == 21){
                        money += (float) (1.5 * bet);
                        System.out.println();
                        System.out.println("<BlackJack!!!>");

                        System.out.println();
                        System.out.println("<<WIN>>");
                        System.out.println("<MONEY : "+money+">");
                    }else{
                        if(d_score > p_score){
                            money -= bet;
                            System.out.println();
                            System.out.println("<<LOSE>>");
                            System.out.println("<MONEY : "+money+">");
                        }else if(d_score == p_score){
                            System.out.println();
                            System.out.println("<<DRAW>>");
                            System.out.println("<MONEY : "+money+">");
                        }else{
                            money += bet;
                            System.out.println();
                            System.out.println("<<WIN>>");
                            System.out.println("<MONEY : "+money+">");
                        }
                    }

                }
            }

            System.out.println();
            System.out.print("CONTINUE? (Y/N) : ");
            String select = sc.next();

            switch(select) {
                case "Y":
                case "y":
                    System.out.println();
                    System.out.println("-----------------------------------------");
                    continue;
                case "N":
                case "n":
                    System.out.println("Ending Game...");
                    System.out.println();
                    return;
            }
        }
    }
}
```

<br>

## Card
```java
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
```

<br>

## Dealer
```java
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
```

<br>

## Player
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Player extends Card {
    private int score = 0;
    private Map<Integer, String> handList = new HashMap<>();
    private ArrayList<Integer> numList = new ArrayList<>();
    private int check = 0;

    public String getHandList(int choice) {
        String list = "";
        switch (choice) {
            case 1:
                list = handList.get(0) + " -BLINDED-";
                break;
            case 2:
                for(int i = 0; i < handList.size(); i++){
                    list += handList.get(i) + " " ;
                }
                break;
        }
        return list;
    }

    public int getHandLen(){
        return handList.size();
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
```