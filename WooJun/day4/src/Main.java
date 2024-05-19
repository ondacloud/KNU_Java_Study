package assignment2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = 0;
        Fashionista fash = new Fashionista();
        Artist artist = new Artist();
        Wizard wizard = new Wizard();


        while(true){

            System.out.println("1. 일하기, 2. 용병 구하기, 3. 보유 용병, 4. 끝");
            System.out.println();
            System.out.print(">>>>>>>> ");
            int choice = sc.nextInt();
            System.out.println();

            switch(choice){
                case 1:
                    System.out.println("일을 합니다.");
                    if(fash.getOwn() == true){
                        money += fash.work(money);
                    }
                    if(artist.getOwn() == true){
                        money += artist.work(money);
                    }
                    if(wizard.getOwn() == true){
                        money += wizard.work(money);
                    }

                    money++;
                    System.out.println("현재 잔액 : "+money);
                    System.out.println();
                    break;

                case 2:
                    System.out.println("용병을 선택하세요.");
                    System.out.println("""
                            1. 패셔니스트 : 10원
                            2. 화가 : 300원
                            3. 마법사 : 2000원
                            """);
                    System.out.print(">>>>>>>> ");
                    int personChoice = sc.nextInt();
                    System.out.println();

                    if(personChoice == 1){
                        if(fash.getOwn() == false) {
                            money -= fash.buy_person(money);
                            System.out.println();
                        }
                    } else if (personChoice == 2) {
                        if(artist.getOwn() == false) {
                            money -= artist.buy_person(money);
                            System.out.println();
                        }
                    } else if (personChoice == 3) {
                        if(wizard.getOwn() == false) {
                            money -= wizard.buy_person(money);
                            System.out.println();
                        }
                    }
                    break;

                case 3:
                    System.out.println("보유 용병");
                    if(fash.getOwn() == true) System.out.println(fash.getName());
                    if(artist.getOwn() == true) System.out.println(artist.getName());
                    if(wizard.getOwn() == true) System.out.println(wizard.getName());
                    System.out.println();
                    break;

                case 4:
                    System.out.println("지금까지 번 돈 : "+money);
                    System.out.println();
                    return;

            }



        }

    }
}