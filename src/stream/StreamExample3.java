package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

import lambda.Student;

public class StreamExample3 {

	public static void main(String[] args) {

		String[] strs = "Java8-lambda-Hello".split("-");

		List<String> strList = 
				Arrays.asList("Java8 lambda", "stream mapping");
		strList.stream().flatMap((String t) -> Arrays.stream(t.split(" ")))
//		.filter(s->s.startsWith("s"))
				.forEach(s -> System.out.println(s));

		strList.stream().map(new Function<String, String>() {

			@Override
			public String apply(String t) {
				return t.toUpperCase();

			}

		}).forEach(s -> System.out.println(s));

		// .map((t)->t.toUpperCase())
		// .forEach(s->System.out.println(s)); override를 줄였을떄

		List<Student> students = 
				Arrays.asList(  new Student("송다희", "F", 80), 
								new Student("윤태현", "M", 75),
								new Student("이혜빈", "F", 85), 
								new Student("정병기", "M", 90));
		double avg = students.stream().mapToInt(new ToIntFunction<Student>() {

			@Override
			public int applyAsInt(Student value) {
				System.out.println(value.getName() + " / " + value.getScore());
				return value.getScore();
			}

		})

				.average().getAsDouble();
		System.out.println(avg);

	}

}
