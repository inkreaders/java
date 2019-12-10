package org.language.lamda;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//https://marcin-chwedczuk.github.io/method-references-in-java-8
public class MethodReference {

	public static void main(String[] args) {
		// Both functions do the same thing:
		Function<Person, String> getNameLambda = person -> person.getName();
		Function<Person, String> getNameMethRef = Person::getName;

		// How to use it with stream:
		Stream.of(new Person("Mike"), new Person("Maya"), new Person("Carl")).map(person -> person.getName())
				.collect(Collectors.toList());

		Stream.of(new Person("Mike"), new Person("Maya"), new Person("Carl")).map(Person::getName).collect(Collectors.toList());
	}
}
