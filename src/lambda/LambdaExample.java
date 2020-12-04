package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LambdaExample {
	private static List<Student> list = Arrays.asList(new Student("Hong", "MALE", 70),
			new Student("Hwang", "FEMALE", 80), new Student("Park", "MALE", 90), new Student("Choi", "FEMALE", 85));

//3.남학생 총점
	public static int malesum(Predicate<Student> predicate) {
		int sum = 0;
		for (Student student : list) {
			if (predicate.test(student)) {
				sum += student.getScore();
			}
		}
		return (int) sum;
	}

//4. 여학생의 평균
	public static double avg(Predicate<Student> predicate) {
		int count = 0, sum = 0;
		for (Student student : list) {
			if (predicate.test(student)) {
				count++;
				sum += student.getScore();
			}

		}
		return (double) sum / count;
	}

	public static void main(String[] args) {
		// 1. 여학생정보: 이름 - 점수
		System.out.println("1.여학생 정보");
		for (Student student : list) {
			if (student.getSex().equals("FEMALE")) {
				System.out.println(student.getName() + "-" + student.getScore());
			}
		}

		System.out.println("----------------");

		// 2.전체 학생: 점수 80점 초과.
		System.out.println("2.80점 초과인 학생");
		for (Student student : list) {
			if (student.getScore() > 80) {
				System.out.println(student.getName() + "-" + student.getScore());
			}
		}

		System.out.println("----------------");

		// 3.남학생 총점: 남학생 총점: 160점
		System.out.println("2.남학생 총점");
		int sum = malesum(t -> t.getSex().equals("MALE"));
		System.out.println(sum);

		System.out.println("----------------");

		// 4. 여학생의 평균: 여학생 평균: 82.5점
		System.out.println("4.여학생 평균");
		double femaleAvg = avg(t -> t.getSex().equals("FEMALE"));
		System.out.println("여자 평균 점수: " + femaleAvg);

		System.out.println("-----Stream------");
		// 반복문(반복자) : 스트림(반복자)
		// 스트림 생성-> 소진.

// 1.여학생 정보 
		Stream<Student> stream = list.stream();
		stream.filter((t) -> t.getSex().equals("FEMALE"))
				.forEach((t) -> System.out.println(t.getName() + "-" + t.getScore()));

		System.out.println("----------------");

//2.80점 초과 학생 Stream 이용하는 방법
		stream = list.stream();
		stream.filter(new Predicate<Student>() {

			@Override
			public boolean test(Student t) {
				return t.getScore() > 80;

			}

		}).forEach(new Consumer<Student>() {

			@Override
			public void accept(Student t) {
				System.out.println(t.getName() + t.getScore());
			}

		});

	}

}

//	Stream<Student> stream = list.stream();
//	stream.filter((t) -> t.getSex().equals("MALE"))args
//					.forEach((t) -> System.out.println(s.getName() + "-" + s.getScore());
