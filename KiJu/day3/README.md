## 1. start_num과 end_num이 주어집니다. 해당 start_num에서 end_num까지의 수를 출력하시오.
```
start_num> 10
end_num> 3
result> [10, 9, 8, 7, 6, 5, 4, 3]
```

<br>

**Result Value** <br>
```java
package KNU_package;
import java.util.Scanner;
import java.util.Arrays;

public class KNU_class {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int insert;
		
		System.out.print("start_num >");
		int start_num = sc.nextInt();
		System.out.print("end_num >");
		int end_num = sc.nextInt();
		
		int n = start_num-end_num;
		
		int[] arr = new int[n];
		
		
		for(int i =0;i<n;i++) {
			arr[i] = start_num;
			start_num--;
		}
		if(n == 0) {
			System.out.print("result> ["+start_num+"]");
		}
		else {
			System.out.print("result> [");
			for(int i = 0;i<n;i++) {
				System.out.print(arr[i]);
				if(i != n-1) {
					System.out.print(",");
				}
				else System.out.print("]");
			}
		}
	}

}
```

<br>

### 2. 소문자로 입력된 값을 대문자로, 대문자로 입력받은 값을 소문자로 출력하시오.
```
ex) 
input> Apple
output> aPPLE
```

<br>

**Result Value** <br>
```java
package KNU_package;
import java.util.*;


public class KNU_class {
	public static final int N=100;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("input>");
		String input = sc.nextLine();
		int tmp;
		String output = "";
		
		int size = input.length();
		
		for(int i = 0;i<size;i++) {
			tmp = (int)input.charAt(i);
			
			if((65 <= tmp) &&(tmp <=90)) {
				output +=(char)(tmp+32);
			}
			else if( (97 <= tmp)&&(tmp<=122) ) {
				output += (char)(tmp-32);
			}
			else {
				output +=(char)tmp;
			}
		}
		System.out.print("output> "+output);
	}
}
```

<br>

## 3. 문자형 String과 정수 n이 주어집니다. 해당 String에서 n번째 값을 입력 받으면 해당 n번째를 제외한 문자열을 출력합니다.
```
input> HelloWorld 6
output> Helloorld
```

<br>

**Result Value** <br>
```java

```

<br>

## 4 while문과 switch & case를 코드에 포함하여 코드를 구현합니다. 사용자는 1부터 12 사이의 정수를 입력하며. 해당 월을 마지막 일을 출력합니다. 사용자가 2월을 입력했을 때, 윤년 여부를 고려하여 28일 또는 29일을 출력해야 합니다. 아래를 참고하여 구성합니다.
```
ex)

day> 2024-02
output> 29

day> 2024-04
output> 30

day> 0000-00
output> 프로그램을 종료합니다.
```

<br>

**Result Value** <br>
```java

```