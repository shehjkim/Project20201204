package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamExample3 {

	public static void main(String[] args) {

		String[] strs = "Java8-lambda-Hello".split("-");

		List<String> strList = 
				Arrays.asList("Java8 lambda", "stream mapping");
		strList.stream()
		.flatMap((String t)->Arrays.stream(t.split(" ")))
//		.filter(s->s.startsWith("s"))
		.forEach(s->System.out.println(s));

		strList.stream()
		.map(new Function<String, String>() {

			@Override
			public String apply(String t) {
				return t.toUpperCase();
				
			}
			
		}).forEach(s->System.out.println(s));
		
		
	}

}
