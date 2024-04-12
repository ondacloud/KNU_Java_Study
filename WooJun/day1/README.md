# Day1 Problems
## 1. A라는 텍스트를 출력하세요.
```java
package KNU_Package;

public class KNU_Class01 {

	public static void main(String[] args) {
		System.out.println("A");

	}
	
}
```

<br>

## 2. n이라는 정수를 입력 받아 1부터 n까지의 정수의 개수 및 합계를 출력하세요.
```java
package KNU_Package;
import java.util.Scanner;

public class KNU_Class02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int j = 0;
		
		System.out.print("정수n을 입력하세요 : ");
		int n = sc.nextInt();
		
		System.out.println("정수의 개수 : "+n);
		
		for(int i = 1; i <= n; i++) {
			j += i;
		}
		
		System.out.println("n까지 정수의 합계 : "+j);
	

	}
}
```

<br>

## 3. 입력 받는 값이 10 이하면 "No"라는 텍스트를 10 이상이면 Yes라는 텍스트를 출력하세요.
```java
package KNU_Package;

import java.util.Scanner;

public class KNU_Class03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int n = sc.nextInt();
		
		if(n<=10) {
			System.out.println("No");
		}else {
			System.out.println("Yes");
		}

	}

}
```