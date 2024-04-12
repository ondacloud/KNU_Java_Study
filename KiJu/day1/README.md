# Day1 Problems
## 1. A라는 텍스트를 출력하세요.
```java
package KNU_package;

public class KNU_class {
	
public static void main(String[] args) {
	
	System.out.print("A");
	

	}
}
```

<br>

## 2. n이라는 정수를 입력 받아 1부터 n까지의 정수의 개수 및 합계를 출력하세요.
```java
package KNU_package;
import java.util.Scanner;

public class KNU_class02 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	System.out.print("n의 값을 입력해 주세요 :");
	int n = sc.nextInt();
	int num = 0;
	
	for(int i = 1;i<=n;i++) {
		num += i;
	}
	
	System.out.println("n의 합은 :"+num);
}
}
```

<br>

## 3. 입력 받는 값이 10 이하면 "No"라는 텍스트를 10 이상이면 Yes라는 텍스트를 출력하세요.
```java
package KNU_package;
import java.util.Scanner;

public class KNU_class03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("n의 값을 입려해주세요 :");
		int num = sc.nextInt();
			
		if(num >=10) {
		System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}		
	}

}
```