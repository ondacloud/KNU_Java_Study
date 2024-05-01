## 1. start_num과 end_num이 주어집니다. 해당 start_num에서 end_num까지의 수를 출력하시오.
```
start_num> 10
end_num> 3
result> [10, 9, 8, 7, 6, 5, 4, 3]
```

<br>

**Result Value** <br>
```java
package KNU_Package;
import java.util.Arrays;
import java.util.Scanner;

public class KNU_Class03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("start_num> ");
		int start_num = sc.nextInt();
		
		System.out.print("end_num> ");
		int end_num = sc.nextInt();
		
		int size = start_num - end_num >= 0 ? start_num - end_num + 1: end_num - start_num + 1;
		
		int[] result = new int[size];
		int j = 0;
		
		if(start_num - end_num >= 0) {
			for(int i = start_num; i>=end_num; i--) {
				if(j<size) {
					result[j] = i;
					j++;
				}
			}
		}else {
			for(int i = start_num; i<=end_num; i++) {
				if(j<size) {
					result[j] = i;
					j++;
				}
			}
		}
		
		System.out.println(Arrays.toString(result));
		
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
package KNU_Package;
import java.util.Arrays;
import java.util.Scanner;

public class KNU_Class03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("input> ");
		String input = sc.nextLine();
		
		String output = "";
		for(int i = 0; i < input.length(); i++ ) {
			char ch = input.charAt(i);
			if((ch >= 65)&&(ch<=96)) {
				output += input.valueOf(ch).toLowerCase();
				
			}else if((ch>=97)&&(ch<=128)) {
				output += input.valueOf(ch).toUpperCase();
				
			}
		}
		System.out.println("output> "+output);
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
package KNU_Package;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class KNU_Class03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input = "";
		String output = "";
		int num;
		
		System.out.print("input> ");
		input = sc.next();
		num = sc.nextInt();
		
		output = input.substring(0, num-1)+input.substring(num, input.length());
		
		System.out.println(output);
	}
}
```

<br>

## 4 while문과 switch & casse를 코드에 포함하여 코드를 구현합니다. 사용자는 1부터 12 사이의 정수를 입력하며. 해당 월을 마지막 일을 출력합니다. 사용자가 2월을 입력했을 때, 윤년 여부를 고려하여 28일 또는 29일을 출력해야 합니다. 아래를 참고하여 구성합니다.
```
ex)

day> 2024-02
output> 29

dayh> 2024-04
output> 30

day> 0000-00
output> 프로그램을 종료합니다.
```

<br>

**Result Value** <br>
```java
package KNU_Package;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class KNU_Class {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input = "";
		String output = "";
		
		
		while(true) {
			System.out.print("day> ");
			input = sc.nextLine();
			int year = Integer.valueOf(input.substring(0, 4));
			int month = Integer.valueOf(input.substring(5));
			
			if(year == 0) {
				if(month == 0) {
					System.out.println("프로그램을 종료합니다.");
					break;
				}else {
					System.out.println("프로그램을 종료하려면 0000-00을 입력하세요.");
				}
			}else {
				switch(month) {
				case 1 :
				case 3 :
				case 5 :
				case 7 :
				case 8 :
				case 10 :
				case 12 :	
					System.out.println("31");
					break;
				case 2 : 
					if((year%4==0)&&(year%100!=0)) {
						System.out.println("29");
					}else {
						System.out.println("28");
					}
					break;	
				case 4 :
				case 6 :
				case 9 :
				case 11 :	
					System.out.println("30");
					break;	
				}
			}
		}
		
	}

}
```