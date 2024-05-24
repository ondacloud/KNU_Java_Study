package IndianPoker;

import java.util.Random;

public class Dealer {

    int aiMoney = 1000;
    int BetMoney=0;
    //고앤 스탑을 할 알고리즘
    public int Aibet(int playerCard) {
        Random random = new Random();


        //0 은 스탑, 1은 고


        //플레이어 카드가 13 이나 12일 경우
        if(playerCard == 13 || 12 == playerCard) {
            int aiBet = random.nextInt(10)+1;
            if(aiBet == 1 || aiBet == 2) {
                System.out.println();
                System.out.println("상대방의 고");
                return 1;
            } else {
                System.out.println();
                System.out.println("상대방의 스탑으로 게임이 종료되었습니다.");
                return 0;
            }
        }

        //플레이어의 카드가 11에서 9일 경우
        else if(playerCard ==11 || 10 == playerCard || 9 == playerCard) {
            int aiBet = random.nextInt(10)+1;

            if(aiBet == 1 || aiBet == 4 || aiBet == 7) {
                System.out.println();
                System.out.println("상대방의 고");
                return 1;
            } else {
                System.out.println();
                System.out.println("상대방의 스탑으로 게임이 종료되었습니다.");
                return 0;
            }
        }

        //플레이어의 카드가 8에서 6일경우
        else if(playerCard == 8 || playerCard == 7 || playerCard == 6) {
            int aiBet = random.nextInt(10) + 1;

            if (aiBet == 2 || aiBet == 5 || aiBet == 4 || aiBet == 7 || aiBet == 10) {
                System.out.println();
                System.out.println("상대방의 고");
                return 1;
            } else {
                System.out.println();
                System.out.println("상대방의 스탑");
                return 0;
            }
        }

        //플레이어의 카드가 5 에서 3인경우
        else if(playerCard == 5 || playerCard == 4 || playerCard == 3) {
            int aiBet = random.nextInt(10) + 1;

            if (aiBet == 1 || aiBet == 3 || aiBet == 8) {
                System.out.println();
                System.out.println("상대방의 스탑");
                return 0;
            } else {
                System.out.println();
                System.out.println("상대방의 고");
                return 1;
            }
        }

        //플레이어 카드가 2에서 1인 경우
        else {
            /*int aiBet = random.nextInt(10) + 1;

            if (aiBet == 5) {
                System.out.println();
                System.out.println("상대방의 스탑");
                return 0;
            } else {
                System.out.println();
                System.out.println("상대방의 고");
                return 1;
            }*/
            System.out.println("상대방의 고");
            return 1;
        }
    }

    public int aiBetting(int playerMoney) {
        Random random = new Random();
        int randMoney = random.nextInt(50)+1;
        this.BetMoney = playerMoney + randMoney;
        this.aiMoney -= BetMoney;

        return this.BetMoney;
    }
}