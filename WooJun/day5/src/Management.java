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
