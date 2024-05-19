package Fun_game;

public class Wizard extends Raise implements Fame{
	private int work_count = 0;
	private int fame = 0;
	
	@Override
	public int work(int money) {
		System.out.println("마벖사가 일을 합니다.");
		work_count++;
		if (work_count%5 == 0) {
			System.out.println("마법사가 일한 지 "+work_count+"일이 지나 돈을 받습니다.");
			fame_up();
			return 2000 * fame;
		}
		else {			
			return 0;
		}
	}

	@Override
	public int buy_person(int money) {
		if (money >= 2000) {
			System.out.println();
			System.out.println("마법사를 구매하였습니다.");
			return 1;
		}
		else {
			System.out.println();
			System.out.println("잔액이 부족합니다. "+(2000-money));
			return 0;
		}
	}
	
	@Override
	public void fame_up() {
		System.out.println("마법사의 인기도가 올랐습니다.");
		fame++;
	}	
}
