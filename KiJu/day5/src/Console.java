package IndianPoker;
import java.util.Random;
import java.util.Scanner;

public class Console {

    public void run() {
        //초반 돈설정
        int playerMoney =1000;
        int checkingMoney = 0;
        int aiBetMoney = 0;

        //필요한거 불러우기
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        GameManage gm;
        Dealer dealer = new Dealer();

        //Before the Start
        System.out.println("""
                    `룰:
                    인디언 포커는 상대방의 서로 자신의 카드를 모르는 상태로 서로의 카드를 보여주어 더 높은 숫자를 가진 사람이 이기는 게임 입니다.
                    각 게임은 3번의 턴을 가지며 턴이 종료될 시 해당 배팅 금액이 승리자에게 돌아갑니다.
                    각 플레이어와 AI는 1000개의 칩이 주어지며 배팅은 플레이어에게 우선적으로 제공되어집니다.
                    한번 배팅 할 수 있는 금액은 상대방이 배팅한 금액에 최대 50원을 추가하여 배팅 할 수 있습니다.`
                    
                    """);

        //겜 시작
        for(;;) {
            gm = new GameManage(playerMoney);

            int returnMoney = 0;

            System.out.println();
            System.out.println("인디언 포커를 시작합니다.");
            System.out.println("현재 보유하고 있는 칩: "+playerMoney);
            System.out.println("상대방이 보유한 칩: "+dealer.aiMoney);
            System.out.println();
            System.out.println("1.입장하기(-50), 2.종료");
            System.out.print(">>>>>>>>>>");
            int chose = sc.nextInt();

            // 입장
            if (chose == 1) {
                //돈이 없을경우 종료
                if(playerMoney <= 0) {
                    System.out.println("보유하신 칩이 없습니다. 게임이 종료 됩니다.");
                    break;
                }

                //딜러의 패배
                if(dealer.aiMoney <= 0) {
                    System.out.println("상대방이 보유한 칩이 없습니다. 게임이 종료 됩니다.");
                    break;
                }


                //체킹머니 초기화
                checkingMoney = 0;


                //플레이어 돈 삭감
                playerMoney -= 50;
                dealer.aiMoney -=50;


                //상대방과 본인 돈 확인 코드
                System.out.println("상대방이 보유한 칩: "+dealer.aiMoney);
                System.out.println("현재 보유하고 있는 칩: "+playerMoney);


                //계속해서 시작할 코드
                for (;;) {

                    //플레이어 와 딜러에게 줄 카드뽑기
                    int playerCard = rand.nextInt(13)+1;
                    int aiCard = rand.nextInt(13)+1;


                    //상대방 카드 확인
                    System.out.println();
                    System.out.println("상대방의 카드: " + aiCard);


                    //대충 만든 알고리즘의 고 스탑 결정
                    if(dealer.Aibet(playerCard)!= 1) {
                        System.out.println("당신의 카드: "+playerCard);
                        playerMoney += 100;
                        break;
                    }


                    //본방 시작
                    for(int i = 1; i <=5; i++) {

                        if(i == 4) {
                            returnMoney = gm.WhoWinner(playerCard, aiCard, checkingMoney,aiBetMoney);

                            //비셨을때만
                            if(returnMoney == 10) {
                                playerMoney += checkingMoney + 50;
                                dealer.aiMoney += aiBetMoney + 50;
                            }
                            //졌을때
                            else if(returnMoney == 9) {
                                playerMoney -= checkingMoney;
                                dealer.aiMoney += checkingMoney + aiBetMoney + 100;
                            }
                            //이겼을때
                            else if(returnMoney == 8) {
                                playerMoney += checkingMoney + aiBetMoney + 100;
                                dealer.aiMoney -= aiBetMoney;
                            }

                            playerMoney += returnMoney;
                            dealer.aiMoney -= returnMoney;
                            //ai가 베팅한 돈 초기화
                            aiBetMoney = 0;
                            break;
                        }

                        System.out.println("\n현재라운드: "+i);
                        System.out.println();
                        System.out.println("현재 보유 금액" + playerMoney);
                        System.out.println();
                        System.out.println("상대방이 보유한 칩: "+dealer.aiMoney);
                        System.out.println();
                        System.out.println("1.Go, 2.Stop");
                        System.out.println();
                        System.out.print(">>>>>>>>>> ");
                        int bet = sc.nextInt();



                        //베팅시
                        if (bet == 1) {
                           for(;;) {

                                System.out.print("배팅하실 금액 *상대방이 건 칩에 최대 50 까지* : ");
                                int betting = sc.nextInt();

                                //체킹머니로 플레이어가 걸은 칩을 계산
                                checkingMoney += betting;


                                //베팅 금액 조건부
                                if (aiBetMoney < betting&& betting <= 50 + aiBetMoney && betting <= playerMoney) {
                                    playerMoney -= betting;
                                    System.out.println(betting + "만큼 배팅하셨습니다.");
                                    System.out.println("현재 보유 금액: "+playerMoney);

                                    //상대방의 고앤 스탑 유무 질문
                                    if(dealer.Aibet(playerCard)== 1) {
                                        aiBetMoney = dealer.aiBetting(betting);
                                        System.out.println("상대방이 " + aiBetMoney + "만큼 베팅하였습니다.");
                                    }
                                    else {
                                        System.out.println("상대방이 보유한 칩: "+dealer.aiMoney);
                                        System.out.println();

                                        playerMoney += checkingMoney + aiBetMoney + 100;
                                        dealer.aiMoney -= aiBetMoney;

                                        System.out.println();


                                        //ai가 베팅한 금액 초기화 화 돌려줄 돈 초기화
                                        aiBetMoney = 0;
                                    }
                                    break;
                                } else if (betting > 50 + aiBetMoney) {
                                    System.out.println("돈을 초과로 입력하셨습니다.");
                                    System.out.println("현재 보유 금액: "+playerMoney);
                                    System.out.println();

                                } else {
                                    System.out.println("돈이 부족합니다.");
                                    System.out.println("현재 보유 금액: "+playerMoney);
                                    if (playerMoney <= aiBetMoney) {
                                        System.out.println("돈이 부족하여 승부가 종료됩니다.");
                                        //승패를 결정 하는 함수 넣기
                                        returnMoney = gm.WhoWinner(playerCard, aiCard, checkingMoney,aiBetMoney);

                                        if(returnMoney == 10) {
                                            playerMoney += betting + 50;
                                            dealer.aiMoney += aiBetMoney + 50;
                                        }
                                        //졌을때
                                        else if(returnMoney == 9) {
                                            playerMoney -= checkingMoney;
                                            dealer.aiMoney += checkingMoney + aiBetMoney + 100;
                                        }
                                        //이겼을때
                                        else if(returnMoney == 8) {
                                            playerMoney += checkingMoney + aiBetMoney + 100;
                                            dealer.aiMoney -= aiBetMoney;
                                        }

                                        //ai가 베팅한 금액 초기화
                                        aiBetMoney = 0;
                                        System.out.println("당신의 카드: "+playerCard);
                                        break;

                                    }
                                }
                           }
                        }
                        else {
                            //겜블 포기시

                            dealer.aiMoney += 100+checkingMoney+aiBetMoney;
                            System.out.println();
                            System.out.println("포기 하셨습니다. 다음게임으로 넘어감니다.");
                            System.out.println("당신의 카드: "+playerCard);
                            System.out.println("현재 보유 금액: "+playerMoney);

                            //ai가 베팅한 금액 초기화
                            aiBetMoney = 0;
                            //한 게임 종료
                            break;
                        }
                    }
                    break;
                }

            } else {
                //모든 게임 종료
                System.out.println("종료합니다.");
                break;

            }
        }
    }
}