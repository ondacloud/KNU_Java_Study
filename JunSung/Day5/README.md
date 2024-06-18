## 바카라
### 룰 설명
```
뱅커(banker) 혹은 플레이어(player) 둘 중 한 쪽을 선택하여 베팅해 어느 쪽이 9에 가까운 점수일지 대결하는 게임

1. 플레이어는 '플레이어 승리', '뱅커 승리', 또는 '무승부' 중 하나에 배팅합니다.
2. 플레이어와 뱅커 각각 두 장의 카드를 받습니다. 점수는 카드 숫자를 합산해 10을 초과하면 일의 자리 숫자를 취합니다.
3. 두 장의 카드 합이 8 또는 9이면 바로 승패가 결정됩니다. 그렇지 않으면 추가 규칙에 따라 카드를 더 받을 수 있습니다. 최종적으로 점수가 높은 쪽이 승리합니다.
```

<br>

## Main
```java
package FUN_GAME;

public class Main {
	public static void main(String[] args) {
		Managed managed = new Managed();
	}
}
```

<br>

## Managed
```java
package FUN_GAME;
import java.util.*;

public class Managed {
    public Managed(){
        Scanner sc = new Scanner(System.in);
        Card card = new Card();
        Dealer dealer = new Dealer();
        Player player = new Player();
        float money = 1000;
        String dState = "none";
        String pState = "none";
        int betting;
        
        while (true) {
            System.out.println("-----------------------------------------");
            System.out.println("<MONEY : "+money+">");
            System.out.println("<BETTING>");
            System.out.print(">>>> ");
        	betting = sc.nextInt();
        	System.out.println();

            while (betting > money){
                System.out.println();

                System.out.println("<MONEY : "+money+">");
                System.out.println("<RE-BETTING>");
                System.out.print(">>>> ");
                betting = sc.nextInt();
            }
        	
        	dealer.reset();
            player.reset();
        	
        	for (int i = 0; i < 2; i++) {
        		player.drawStore();
            	dealer.drawStore();
        	}
        	
        	System.out.println("<PLAYER>");
        	System.out.println(player.getHand()+" -> "+player.getScore());
        	
        	if (player.getScore() <= 5) {
        		player.drawStore();
        		System.out.println(player.getHand()+" -> "+player.getScore());
        		if (player.getScore() <= 5) {
        			System.out.println();
        		}
        		else if (player.getScore() <= 7){
            		pState = "stand";
            		System.out.println("Stand!");
            	}
        		else if (player.getScore() <= 9) {
            		pState = "natural";
            		System.out.println("Natural!");
            	}
        	}
        	else if (player.getScore() <= 7){
        		pState = "stand";
        		System.out.println("Stand!");
        	}
        	else if (player.getScore() <= 9) {
        		pState = "natural";
        		System.out.println("Natural!");
        	}

        	System.out.println();
        	
        	System.out.println("<DEALER>");
        	System.out.println(dealer.getHand()+" -> "+dealer.getScore());
        	
        	if (dealer.getScore() <= 5) {
        		dealer.drawStore();
        		System.out.println(dealer.getHand()+" -> "+dealer.getScore());
        		if (dealer.getScore() <= 5) {
        			System.out.println();
        		}
        		else if (dealer.getScore() <= 7){
        			dState = "stand";
            		System.out.println("Stand!");
            	} else if (dealer.getScore() <= 9) {
            		dState = "natural";
            		System.out.println("Natural!");
            	}
        	}
        	else if(dealer.getScore() <= 7){
        		dState = "stand";
        		System.out.println("Stand!");
        	}
        	else if(dealer.getScore() <= 9) {
        		dState = "natural";
        		System.out.println("Natural!");
        	}
        	
        	if (pState == "none" || dState == "none") {
        		if (player.getScore() == dealer.getScore()) {
    				System.out.println("<TIE>");
    				System.out.println(money);
    			}
        		else if (player.getScore() > dealer.getScore()) {
    				System.out.println("<PLAYER WIN>");
    				money = money+(betting*2);
    				System.out.println(money);
    			}
        		else {
    				System.out.println("<DEALER WIN>");
    				money = money-betting;
    				System.out.println(money);
    			}
        	}
        	else {
        		if (pState == "stand") {
            		if (dState == "stand") {
            			if (player.getScore() == dealer.getScore()) {
            				System.out.println("<TIE>");
            			}
            			else if (player.getScore() > dealer.getScore()) {
            				System.out.println("<PLAYER WIN>");
            				money = money+(betting*2);
            				System.out.println(money);
            			}
            			else {
            				System.out.println("<DEALER WIN>");
            				money = money-betting;
            				System.out.println(money);
            			}
            		}
            		else if (dState == "natural") {
            			System.out.println("<DEALER WIN>");
        				money = money-betting;
        				System.out.println(money);
            		}
            	}
        		else if(pState == "natural"){
        			if(dState == "stand") {
            			System.out.println("<PLAYER WIN>");
        				money = money+(betting*2);
        				System.out.println(money);
            		}
        			else if (dState == "natural") {
            			if (player.getScore() == dealer.getScore()) {
            				System.out.println("<TIE>");
            			}
            			else if (player.getScore() > dealer.getScore()) {
            				System.out.println("<PLAYER WIN>");
            				money = money+(betting*2);
            				System.out.println(money);
            			}
            			else {
            				System.out.println("<DEALER WIN>");
            				money = money-betting;
            				System.out.println(money);
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
package FUN_GAME;

import java.util.*;

public class Card {
    private String shape;
    private int num;
    private String strNum;
    private String[] shapeName = {"Diamond", "Clover", "Heart", "Spade"};
    private List<String> cards = new ArrayList<>();

    public Card() {
        setCards();
    }

    //getter
    public List<String> getCards() {
        return cards;
    }

    public int getNum(){
        return num;
    }

    //methods
    public void setCards(){
        this.cards.clear();
        for(int h = 0; h < 6; h++){
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 13; j++){
                    cards.add(shapeName[i] + "_" + ChangeNum(j+1));
                }
            }
        }
        Collections.shuffle(cards);
    }



    public String ChangeNum(int num){
        switch(num){
            case 1:
                strNum = "A";
                break;

            case 11:
                strNum = "J";
                break;

            case 12:
                strNum = "Q";
                break;

            case 13:
                strNum = "K";
                break;

            default:
                strNum = ""+num;
        }
        return strNum;
    }

    public int CheckNum(String str){
        int num = 0;
        String result = str.substring(str.length()-1);
        if(result == "0") result = "10";

        switch(result){
            case "A":
                num = 1;
                break;

            case "2":
                num = 2;
                break;

            case "3":
                num = 3;
                break;

            case "4":
                num = 4;
                break;

            case "5":
                num = 5;
                break;

            case "6":
                num = 6;
                break;

            case "7":
                num = 7;
                break;

            case "8":
                num = 8;
                break;

            case "9":
                num = 9;
                break;

            case "10":
            case "J":
            case "Q":
            case "K":
                num = 0;
                break;
        }
        return num;
    }

    public String draw(){
        String card = cards.getLast();
        num = CheckNum(card);
        cards.removeLast();
        return card;
    }
}
```

<br>

## Dealer
```java
package FUN_GAME;
import java.util.*;

public class Dealer extends Card {
	
    private int score = 0;
    private Map<Integer, String> hand = new HashMap<>();
    private List<Integer> handNum = new ArrayList<>();

    public Dealer() {
        score = 0;
    }

    public String getHand() {
        String hand = "";

        for (int i = 0; i < this.hand.size(); i++) {
            hand += this.hand.get(i) + " ";
        }
        return hand;
    }
    
    public int getScore(){
        if(score >= 10) score -= 10;
        return score;
    }

    public void setScore(){
        score += getNum();
    }


    public void reset(){
        hand.clear();
        handNum.clear();
        score = 0;
    }


    public void drawStore(){
        hand.put(hand.size(),draw());
        handNum.add(getNum());
        setScore();
    }

}
```

<br>

## Player
```java
package FUN_GAME;
import java.util.*;

public class Player extends Card {

   private int score = 0;
   private Map<Integer, String> hand = new HashMap<>();
   private List<Integer> handNum = new ArrayList<>();

   public Player() {
       score = 0;
   }

   public String getHand() {
       String hand = "";

       for (int i = 0; i < this.hand.size(); i++) {
           hand += this.hand.get(i) + " ";
       }
       return hand;
   }
   
    public int getScore(){
    	if(score >= 10) score -= 10;
    	return score;
    }

    public void setScore(){
    	score += getNum();
    }


    public void reset(){
        hand.clear();
        handNum.clear();
        score = 0;
    }


    public void drawStore(){
        hand.put(hand.size(),draw());
        handNum.add(getNum());
        setScore();
    }
}
```