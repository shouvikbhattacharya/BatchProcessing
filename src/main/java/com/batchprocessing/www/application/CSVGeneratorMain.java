package com.batchprocessing.www.application;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import com.batchprocessing.www.model.Person;

/*
 * CSV Generator
 */
public class CSVGeneratorMain {

	private static final String CSV_FILE = "d:\\data.csv";
	public static void main(String[] args) {

		Path path = Paths.get(CSV_FILE);
		if(!Files.exists(path))
			try {
				Files.createFile(path);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		try (BufferedWriter writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
			long line = 0;
			Person person = Person.personBuilder()
					.name("Shouvik")
					.designation("Software Engineer")
					.age(10)
					.mobile(123456789L)
					.build();
			System.out.println("Started...");
			while (line++ < 100000000L) {
				writer.write(person.toString());
			}
			Person person1 = Person.personBuilder()
					.name("Shouvik")
					.designation("Software Engineer")
					.age(10)
					.mobile(987654321L)
					.build();
			Person person2 = Person.personBuilder()
					.name("Shouvik")
					.designation("Software Engineer")
					.age(10)
					.mobile(147852369L)
					.build();
			writer.write(person1.toString());
			writer.write(person2.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Finished!");
	}
}