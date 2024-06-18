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