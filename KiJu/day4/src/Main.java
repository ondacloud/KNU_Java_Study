package Subject02;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //다른것들 소환
        Fashionista fashionista = new Fashionista();
        Artist artist = new Artist();
        Wizard wizard = new Wizard();

        //불린 활용한 구매
        boolean[] buy_people = new boolean[3];

        //스케너
        Scanner sc = new Scanner(System.in);

        //돈
        int money = 0;

        //시작
        for(;;) {
            //입출력
            System.out.println("1. 일하기, 2. 용병 구하기, 3. 보유 용병, 4. 끝");
            System.out.println();
            System.out.print(">>>>>>>> ");

            //선택1 숫자 받기
            int number = sc.nextInt();
            sc.nextLine();
            // 칸띄어 주기
            System.out.println();

            //1번 일하기
            if (number == 1) {
                money++;
                System.out.println("일을 합니다.");

                //패셔니스타
                if (buy_people[0]) {
                    money = fashionista.work(money);
                }
                if (buy_people[1]) {
                    money = artist.work(money);
                }
                if (buy_people[2]) {
                    money = wizard.work(money);
                }
                System.out.println("현재 금액: " + money);
                System.out.println();
            }
            //2번 용병 구매하기
            else if (number == 2) {
                System.out.println("용병을 선택하세요.");
                System.out.println("1. 패셔니스타: 10원");
                System.out.println("2. 화가: 300원");
                System.out.println("3. 마법사: 2000원");

                System.out.println();
                System.out.print(">>>>>>>> ");

                // 구매 선택
                int choose = Integer.parseInt(sc.nextLine());
                System.out.println();

                //구매 돈
                int enough_money;


                //패셔니스타 구매
                if (choose == 1) {
                    if (buy_people[0]) {
                        System.out.println("이미 구매하셨습니다 !");
                        continue;
                    }
                    //유효성 검사
                    enough_money = fashionista.buy_person(money);

                    if (enough_money != -1) {
                        buy_people[0] = true;
                        money = enough_money;
                    }
                }
                //아티스트 구매
                else if (choose == 2) {
                    if (buy_people[1]) {
                        System.out.println("이미 구매하셨습니다 !");
                        continue;
                    }

                    //유효성 검사
                    enough_money = artist.buy_person(money);
                    if (enough_money != -1) {
                        buy_people[1] = true;
                        money = enough_money;
                    }
                }
                //마법사 구매
                else if (choose == 3) {
                    if (buy_people[2]) {
                        System.out.println("이미 구매하셨습니다 !");
                        continue;
                    }

                    //유효성 검사
                    enough_money = wizard.buy_person(money);
                    if (enough_money != -1) {
                        buy_people[2] = true;
                        money = enough_money;
                    }
                }
                System.out.println();
            }
            // 보유 용병 확인
            else if (number == 3) {
                System.out.println("보유 용병");
                if (buy_people[0]) {
                    System.out.println("패셔니스타");
                }
                if (buy_people[1]) {
                    System.out.println("화가");
                }
                if (buy_people[2]) {
                    System.out.println("마법사");
                }
                System.out.println();
            } else if (number == 4) {
                System.out.println("지금까지 번 돈: " + money);
                break;
            }
        }
    }
}
