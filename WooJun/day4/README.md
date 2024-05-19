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
```

<br>

## Fame
```java
package assignment2;

public interface Fame {
    void fame_up();
}
```

<br>

## Raise
```java
package assignment2;

public abstract class Raise {
    public abstract int work(int money);
    public abstract int buy_person(int money);
}
```

<br>

## Fashionista
```java
package assignment2;

public class Fashionista extends Raise implements Fame {
    private String name;
    private int price;
    private int work_count;
    private int fame;
    private boolean own;

    public Fashionista() {
        this.name = "패셔니스트";
        this.price = 10;
        this.work_count = 0;
        this.fame = 0;
        this.own = false;
    }


    //getter

    public String getName() {
        return name;
    }

    public int getWork_count() {
        return work_count;
    }

    public int getFame() {
        return fame;
    }

    public boolean getOwn(){
        return own;
    }

    //setter

    public void setOwn() {
        this.own = true;
    }

    @Override
    public int work(int money) {
        System.out.println(name+"가 일을 합니다.");
        if(work_count % 5 == 0 && work_count != 0){
            System.out.println(name+"가 일한 지 "+work_count+"일이 지나 돈을 받습니다.");
            work_count++;
            fame_up();
            return price*fame;
        }else{
            work_count++;
            return 0;
        }
    }

    @Override
    public int buy_person(int money) {
        if(money >= price){
            setOwn();
            System.out.println(name+"를 구매하였습니다.");
            return price;
        }
        else {
            System.out.println("잔액이 부족합니다. 잔액 : "+money);
            return 0;
        }
    }

    @Override
    public void fame_up(){
        System.out.println(name+"의 인기도가 올랐습니다.");
        fame++;
    }

}
```


## Artist
```java

package assignment2;

public class Artist extends Raise implements Fame {
    private String name;
    private int price;
    private int work_count;
    private int fame;
    private boolean own;

    public Artist() {
        this.name = "화가";
        this.price = 300;
        this.work_count = 0;
        this.fame = 0;
        this.own = false;
    }

    //getter

    public String getName() {
        return name;
    }

    public int getWork_count() {
        return work_count;
    }

    public int getFame() {
        return fame;
    }

    public boolean getOwn(){
        return own;
    }


    //setter

    public void setOwn() {
        this.own = true;
    }


    @Override
    public int work(int money) {
        System.out.println(name+"가 일을 합니다.");
        if(work_count % 5 == 0 && work_count != 0){
            System.out.println(name+"가 일한 지 "+work_count+"일이 지나 돈을 받습니다.");
            work_count++;
            fame_up();
            return price*fame;
        }else{
            work_count++;
            return 0;
        }
    }

    @Override
    public int buy_person(int money) {
        if(money >= price){
            setOwn();
            System.out.println(name+"를 구매하였습니다.");
            return price;
        }
        else {
            System.out.println("잔액이 부족합니다. 잔액 : "+money);
            return 0;
        }
    }

    @Override
    public void fame_up(){
        System.out.println(name+"의 인기도가 올랐습니다.");
        fame++;
    }
}
```

<br>

## Wizard
```java

package assignment2;

public class Wizard extends Raise implements Fame{
    private String name;
    private int price;
    private int work_count;
    private int fame;
    private boolean own;

    public Wizard(){
        this.name = "마법사";
        this.price = 2000;
        this.work_count = 0;
        this.fame = 0;
        this.own = false;
    }

    //getter

    public String getName() {
        return name;
    }

    public int getWork_count() {
        return work_count;
    }

    public int getFame() {
        return fame;
    }

    public boolean getOwn(){
        return own;
    }


    //setter

    public void setOwn() {
        this.own = true;
    }


    @Override
    public int work(int money) {
        System.out.println(name+"가 일을 합니다.");
        if(work_count % 5 == 0 && work_count != 0){
            System.out.println(name+"가 일한 지 "+work_count+"일이 지나 돈을 받습니다.");
            work_count++;
            fame_up();
            return price*fame;
        }else{
            work_count++;
            return 0;
        }
    }

    @Override
    public int buy_person(int money) {
        if(money >= price){
            setOwn();
            System.out.println(name+"를 구매하였습니다.");
            return price;
        }
        else {
            System.out.println("잔액이 부족합니다. 잔액 : "+money);
            return 0;
        }
    }

    @Override
    public void fame_up(){
        System.out.println(name+"의 인기도가 올랐습니다.");
        fame++;
    }
}
```