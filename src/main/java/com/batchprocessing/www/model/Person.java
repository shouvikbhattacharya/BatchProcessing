package com.batchprocessing.www.model;

public class Person {

	private String name;
	private String designation;
	private int age;
	private long mobile;

	private Person(PersonBuilder builder) {
		this.name = builder.name;
		this.designation = builder.designation;
		this.age = builder.age;
		this.mobile = builder.mobile;
	}

	@Override
	public String toString() {
		return this.name + "," + this.designation + "," + this.age + "," + this.mobile;
	}

	public static PersonBuilder personBuilder() {
		return new PersonBuilder();
	}

	public static class PersonBuilder implements Name, Designation, Age, Mobile, Build {

		private String name;
		private String designation;
		private int age;
		private long mobile;

		private PersonBuilder() {
		}

		public Person build() {
			return new Person(this);
		}

		public Build mobile(long mobile) {
			this.mobile = mobile;
			return this;
		}

		public Mobile age(int age) {
			this.age = age;
			return this;
		}

		public Age designation(String designation) {
			this.designation = designation;
			return this;
		}

		public Designation name(String name) {
			this.name = name;
			return this;
		}

	}

	interface Name {
		public Designation name(String name);
	}

	public interface Designation {
		public Age designation(String designation);
	}

	public interface Age {
		public Mobile age(int age);
	}

	public interface Mobile {
		public Build mobile(long mobile);
	}

	public interface Build {
		public Person build();
	}
}
