package Fun_game;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Fashionista fashionista = new Fashionista();
		Artist artist = new Artist();
		Wizard wizard = new Wizard();
		int money = 0;
		boolean work_fashinista = false;
		boolean work_artist = false;
		boolean work_wizard = false;
		
		while(true) {
			System.out.println("1. 일하기. 2. 용병 구하기. 3. 보유 용병, 4. 끝");
			System.out.println();
			System.out.print(">>>>>>>> ");
			String input_num = sc.next();
			
			switch(input_num) {
				case "1":
					money++;
					System.out.println("일을 합니다.");
					
					if (work_fashinista) {
						money = money + fashionista.work(money);
					}

					if (work_artist) {
						money = money + artist.work(money);
					}

					if (work_wizard) {
						money = money + wizard.work(money);
					}
					
					System.out.println("현재 금액: "+money);
					System.out.println();
					break;
				case "2":
					System.out.println("1. 패셔니스타: 10원");
					System.out.println("2. 화가: 300원");
					System.out.println("3. 마법사: 2000원");					
					System.out.println();
					System.out.print(">>>>>>>> ");
					int input_person_num = sc.nextInt();
					
					if (input_person_num == 1) {
						if (!work_fashinista) {
							if (fashionista.buy_person(money) == 1) {
								work_fashinista = true;
								money -= 10;
							}
						}
						else {
							System.out.println();
							System.out.println("이미 영입한 용병입니다.");
						}
					}
					else if (input_person_num == 2) {
						if (!work_artist) {
							if (artist.buy_person(money) == 1) {
								work_artist = true;
								money -= 300;
							}
						}
						else {
							System.out.println();
							System.out.println("이미 영입한 용병입니다.");
						}
					}
					else if (input_person_num == 3) {
						if (!work_wizard) {
							if (wizard.buy_person(money) == 1) {
								work_wizard = true;
								money -= 2000;
							}
						}
						else {
							System.out.println();
							System.out.println("이미 영입한 용병입니다.");
						}
					}
					else {
						System.out.println("잘못된 입력입니다.");
					}
					System.out.println();
					break;
				case "3":
					System.out.println();
					System.out.println("보유 용병");
					if (work_fashinista) {
						System.out.println("패셔니스타");
					}
					if (work_artist) {
						System.out.println("화가");
					}
					if (work_wizard) {
						System.out.println("마법사");
					}
					System.out.println();
					break;
				case "4":
					System.out.println();
					System.out.println("지금까지 번 돈: "+money);
					return ;
				default:
					System.out.println("잘못된 입력입니다.");
					System.out.println();
					
			}
		}
	}
}
