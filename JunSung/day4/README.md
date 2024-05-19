## 거지 키우기
### 설명
```
플레이어는 돈이 없습니다. 0원에서 시작해서 돈을 모으려고 합니다. 하지만 플레이어는 능력이 부족해서 한 번 일할 때 1원 밖에 얻지 못합니다. 그러나 용병은 능력이 매우 좋아서 돈을 많이 벌 수 있습니다.

용병을 사면 인기도가 0에서 시작하여 5번 일할 때마다 인기도 1씩 상승하고 플레이어에게 (용병 값*인기도) 만큼 지급합니다.

용병을 사면 다시 살 수도 없고 팔 수도 없습니다.
```

**용병리스트** <br>
- `패셔니스타` - 10원
- `화가` - 300원
- `마법사` - 2000원

<br>

**5번마다 지급하는 돈** <br>
- `패셔니스타` - (10 x 인기도)원
- `화가` - (300 x 인기도)원
- `마법사` - (2000 x 인기도)원

<br>

### 조건

**Rasie** <br>
```
- 부모 클래스, 추상 클래스
추상 메소드
work(int money), buy_person(int money) -> int 반환

work(int money): 일, 인기도 관련 메소드
buy_person(int mony): 용병 구매 관련 메소드
```

<br>

**Fame** <br>
```
- 인터페이스

추상메소드
fame_up() : 인기도 올리는 메소드
```

<br>

**Fashionista** <br>
```
- 자식

work_count : fame으로 필드 구성
work_count : 일 횟수
fame : 인기도
```

<br>

**artist** <br>
```
- 자식

work_count : fame으로 필드 구성
work_count : 일 횟수
fame : 인기도
```

<br>

**Wizard** <br>
```
- 자식

work_count : fame으로 필드 구성
work_count : 일 횟수
fame : 인기도
```

<br>

## Main
```java
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
```

<br>

## Fame
```java
package Fun_game;

public interface Fame {
	abstract void fame_up();
}
```

<br>

## Raise
```java
package Fun_game;

public abstract class Raise {
	private int money;
	
	public abstract int work(int money);
	public abstract int buy_person(int money);
}
```

<br>

## Fashionista
```java
package Fun_game;

public class Fashionista extends Raise implements Fame{
	private int work_count = 0;
	private int fame = 0;
	
	@Override
	public int work(int money) {
		System.out.println("패션니스타 일을 합니다.");
		work_count++;
		if (work_count%5 == 0) {
			System.out.println("패셔니스타가 일한 지 "+work_count+"일이 지나 돈을 받습니다.");
			fame_up();
			return 10 * fame;
		}
		else {			
			return 0;
		}
	}

	@Override
	public int buy_person(int money) {
		if (money >= 10) {
			System.out.println();
			System.out.println("패셔니스타를 구매하였습니다.");
			return 1;
		}
		else {
			System.out.println();
			System.out.println("잔액이 부족합니다. "+(10-money));
			return 0;
		}
	}
	
	@Override
	public void fame_up() {
		System.out.println("패셔니스트의 인기도가 올랐습니다.");
		fame++;
	}	
}
```

<br>

## Artist
```java
package Fun_game;

public class Artist extends Raise implements Fame{
	private int work_count = 0;
	private int fame = 0;
	
	@Override
	public int work(int money) {
		System.out.println("화가가 일을 합니다.");
		work_count++;
		if (work_count%5 == 0) {
			System.out.println("화가가 일한 지 "+work_count+"일이 지나 돈을 받습니다.");
			fame_up();
			return 300 * fame;
		}
		else {			
			return 0;
		}
	}

	@Override
	public int buy_person(int money) {
		if (money >= 300) {
			System.out.println();
			System.out.println("화가를 구매하였습니다.");
			return 1;
		}
		else {
			System.out.println();
			System.out.println("잔액이 부족합니다. "+(300-money));
			return 0;
		}
	}
	
	@Override
	public void fame_up() {
		System.out.println("화가의 인기도가 올랐습니다.");
		fame++;
	}	
}
```

<br>

## Wizard
```java
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
```