# Day1 Problems
## 1. 변수를 잘못 초기화한 것은 무엇입니까?
1) int var1 = 10;
2) long var2 = 10000000000L;
3) char var3 = '&emsp;'; &nbsp; //작은따옴표 두 개가 붙어 있음
4) float var4 = 10;
5) String var5 = "abc\ndef";
6) String var6=""" <br>
	abc <br>
	def <br>
	""";

<br>

**Result Value** <br>
3

<br>

## 2. 연산식의 타입 변환 중에서 컴파일 에러가 발생하는 것을 선택하세요.
```java
byte byteValue = 10;
float floatValue = 2.5F
double doubleValue = 2.5;
```
1) byte result = byteValue + byteValue;
2) int result = 5 + byteValue;
3) float result = 5 + floatValue;
4) double result = 5 + doubleValue

<br>

**Result Value** <br>
1

<br>

## 3. 534자루의 연필을 30명의 학생들에게 똑같은 개수로 나누어 줄 때 1인당 몇 개를 가질 수 있고 마지막에 몇 개가 남는지를 구하는 코드입니다. ( )에 들어갈 알맞은 코드를 차례대로 작성해 보세요.
```java
int pencils = 534;
int students = 30;

//학생 한 명이 가지는 연필 수
int pencilsPerStudent = (						);
System.out.println(pencilsPerStudent);

// 남은 연필 수
int pencilsLeft = (								);
System.out.println(pencilsLeft)
```

<br>

**Result Value** <br>
```java
package KNU_Package;

public class KNU_Class {

	public static void main(String[] args) {
		int penclis = 534;
		int studnets = 30;
		
		int pencilsPerStudent = (penclis / studnets);
		System.out.println(pencilsPerStudent);
		
		int pencilsLeft = (penclis % studnets);
		System.out.println(pencilsLeft);

	}

}
```

<br>

## 4. 다음 코드는 사다리꼴의 넓이를 구하는 코드입니다. 정확히 소수 자릿수가 나올 수 있도록 ( )에 들어갈 수 있는 코드를 모두 선택하세요.
```java
int lengthTop = 5;
int lengthBottom = 10;
int height = 7;
double area = (						);
System.out.println(area);
```

<img src="https://github.com/ondacloud/KNU_Java_Study/raw/main/JunSung/day2/img/image-1.png" width="300" height="200"/>

1) (lengthTop+lengthBottom) * height / 2.0
2) (lengthTop+lengthBottom) * height * 1.0 / 2
3) (double) (lengthTop+lengthBottom) * height / 2
4) (double) ((lengthTop+lengthBottom) * height / 2)

<br>

**Result Value** <br>
1, 2, 3

<br>

## 5. for문을 이용해서 1부터 100까지의 정수 중에서 3의 배수의 총합을 출력하는 코드를 작성해 보세요.

<br>

**Result Value** <br>
```java
package KNU_Package;

public class KNU_Class {

	public static void main(String[] args) {
		int sum = 0;
		for (int i=1; i <= 100; i++) {
			if (i%3 == 0) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

}
```

<br>

## 6. 중첩 for문을 이용하여 방적식 4x + 5y = 60의 모든 해를 구해서 (x,y) 형태로 출력하는 코드를 작성해 보세요. 단, x와 y는 10 이하의 자연수입니다.

<br>

**Result Value** <br>
```java
package KNU_Package;

public class KNU_Class {

	public static void main(String[] args) {
		for (int x=1; x <= 10; x++) {
			for (int y=1; y <= 10; y++) {
				if (4*x + 5 * y == 60) {
					System.out.println("("+ x + "," + y + ")");
				}
			}
		}
	}
}
```

<br>

## 7. while 문과 Scanner의 nextLine() 메소드를 이용해서 다음 실행 결과와 같이 키보드로부터 입력된 데이터로 예금, 출금, 조회, 종료 기능을 제공하는 코드를 작성해 보세요.
```java
--------------------------------
1.예금 | 2.출금 | 3.잔고 | 4.종료
--------------------------------
선택> 1
예금액> 10000

--------------------------------
1.예금 | 2.출금 | 3.잔고 | 4.종료
--------------------------------
선택> 2
출금액> 2000

--------------------------------
1.예금 | 2.출금 | 3.잔고 | 4.종료
--------------------------------
선택> 3
잔고> 8000

--------------------------------
1.예금 | 2.출금 | 3.잔고 | 4.종료
--------------------------------
선택> 4

프로그램 종료
```

<br>

**Result Value** <br>
```java
package KNU_Package;
import java.util.*;

public class KNU_Class {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = 0;
		
		while(true) {
			System.out.println("----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("----------------------------");
			System.out.print("선택> ");
			int num = sc.nextInt();
			
			if (num != 1 &&  num != 2 && num != 3 && num != 4) {
				System.out.println("Error");
			}
			
			if (num == 1) {
				System.out.print("예금액> ");
				int plus = sc.nextInt();
				money += plus ;
				
			}
			else if (num == 2) {
				System.out.print("출금액> ");
				int minus = sc.nextInt();
				money -= minus;
			}
			else if (num == 3) {
				System.out.println("잔고> " + money);
			}
			else if (num == 4) {
				break;
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("프로그램 종료");
	}
}
```