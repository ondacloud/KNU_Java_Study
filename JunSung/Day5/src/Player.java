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