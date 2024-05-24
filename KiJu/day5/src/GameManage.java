package IndianPoker;

public class GameManage {

    public GameManage(int money) {
        if(money < 0) {
            System.out.println("돈을 모두 소진하여 패배 하셨습니다.");
        }
    }

    public int WhoWinner(int playerCard, int aiCard, int playerBet, int aiBet) {
        if(playerCard > aiCard) {
            System.out.println("플레이어가 승리하였습니다.");
            return 8;
        }
        else if(playerCard < aiCard) {
            System.out.println("상대방이 승리하였습니다.");
            return 9;
        }
        else {
            System.out.println("비겼습니다.");
            return 10;
        }
    }



    public int moneyCounter(int moeny) {
        return 0;
    }
}