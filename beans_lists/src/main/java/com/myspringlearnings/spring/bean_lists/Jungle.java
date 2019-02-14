package com.myspringlearnings.spring.bean_lists;

import java.util.List;

public class Jungle {
	private Animal largest;
	private List<Animal> animals;
	private Animal king;

	public Animal getLargest() {
		return largest;
	}

	public void setLargest(Animal largest) {
		this.largest = largest;
	}

	public List<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(List<Animal> animals) {
		this.animals = animals;
	}

	public Animal getKing() {
		return king;
	}

	public void setKing(Animal king) {
		this.king = king;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("\nList of animals\n");

		for (Animal animal : animals) {
			sb.append(animal);
			sb.append("\n");
		}

		return sb.toString();
	}
}
