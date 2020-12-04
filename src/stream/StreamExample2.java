package stream;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class StreamExample2 {

	public static void main(String[] args) {
		//1~100
		//짝수 출력
		IntStream.rangeClosed(1, 100)
		.filter(t->t%2==0)
		.forEach(s->System.out.print("/"+s));
		
		int sum=IntStream.rangeClosed(1, 100)
				.filter(t->t%2==0)
				.sum();
		
		System.out.println();
		System.out.println();
		int[] intAry = {2,4,6,8,1,9};
//최대값
		IntStream is = Arrays.stream(intAry);
		int max = is.max().getAsInt();
		System.out.println("최대값: " + max);
		
		System.out.println();
//평균값
		is = Arrays.stream(intAry);
		double avg=is.average().getAsDouble();
		System.out.println("평균값: " + avg);
		
//조건(filer)
		Arrays.stream(intAry).filter((a) ->  a % 2 ==0)
		.forEach((a)-> System.out.println(a));
	
			

		
		
		//1~10
		//홀수만 출력
		System.out.println();
		IntStream.rangeClosed(1, 10)
		.filter(t->t%2==1)
		.forEach(s->System.out.println(s));
		
		
		
		
	}

}
