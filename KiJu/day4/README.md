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

```

<br>

## Raise
```java

```

<br>

## Fame
```java

```

<br>

## Artist
```java

```

<br>

## Wizard
```java

```