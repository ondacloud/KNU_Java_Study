# Day1 Problems
## 1. A라는 텍스트를 출력하세요.
```java
package KNU_Package;

public class KNU_Class {

	public static void main(String[] args) {
		System.out.println("A");

	}
}
```

## 2. n이라는 정수를 입력 받아 1부터 n까지의 정수의 개수 및 합계를 출력하세요.
```java
package KNU_Package;
import java.util.*;

public class KNU_Class {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n값을 입력하세요. : ");
		int n = sc.nextInt();
		int sum=0;
		
		for (int i=1; i <= n; i++) {
			sum += i;
		}
		System.out.println("n = " +n);
		System.out.println("sum = "+sum);	

	}

}
```

## 3. 입력 받는 값이 10 이하면 "No"라는 텍스트를 10 이상이면 Yes라는 텍스트를 출력하세요.
```java
package KNU_Package;
import java.util.*;

public class KNU_Class {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("수를 입력하세요. : ");
		int n = sc.nextInt();
		
		if (n >= 10) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}

	}

}
```