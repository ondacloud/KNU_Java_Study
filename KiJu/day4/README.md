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
```

<br>

## Fame
```java
package Subject02;

public interface Fame {
    void fame_up();
}
```

<br>

## Raise
```java
package Subject02;

public abstract class Raise {

    public abstract int work(int money);
    public abstract int buy_person(int money);
}
```

<br>

## Fashionista
```java
package Subject02;

public class Fashionista extends Raise implements Fame{

    int work_count;
    int fame;


    @Override
    public int buy_person(int money) {
        if(money >= 10) {
            System.out.println("패셔니스타를 구매하셨습니다.");
            return money - 10;
        }

        else {
            System.out.println("돈이 부족합니다.");
            return -1;
        }
    }

    @Override
    public int work(int money) {
        work_count++;

        if(this.work_count % 5 == 0) {
                fame_up();
                System.out.println("패셔니스타가 일을 합니다.");
                return money + 10 * this.fame;
        }
        else return money;
    }

    @Override
    public void fame_up() {
        this.fame++;
    }

}

```

<br>

## Artist
```java
package Subject02;

public class Artist extends Raise implements Fame {
    int work_count;
    int fame;


    @Override
    public int buy_person(int money) {
        if(money >= 300) {
            System.out.println("아티스트를 구매하셨습니다.");
            return money - 300;
        }

        else {
            System.out.println("돈이 부족합니다.");
            return -1;
        }
    }

    @Override
    public int work(int money) {
        work_count++;

        if(this.work_count % 5 == 0) {
            fame_up();
            System.out.println("아티스트가 일을 합니다.");
            return money + 300 * this.fame;
        }
        else return money;
    }

    @Override
    public void fame_up() {
        this.fame++;
    }

}
```

<br>

## Wizard
```java
package Subject02;

public class Wizard extends Raise implements Fame{
    int work_count;
    int fame;


    @Override
    public int buy_person(int money) {
        if(money >= 10) {
            System.out.println("마법사를 구매하셨습니다.");
            return money - 2000;
        }

        else {
            System.out.println("돈이 부족합니다.");
            return -1;
        }
    }

    @Override
    public int work(int money) {
        work_count++;

        if(this.work_count % 5 == 0) {
            fame_up();
            System.out.println("마법사가 일을 합니다.");
            return money + 2000 * this.fame;
        }
        else return money;
    }

    @Override
    public void fame_up() {
        this.fame++;
    }

}
```