package spring.boot.essencial.repository;

import java.util.List;

import spring.boot.essencial.domain.Animal;

public interface AnimalRepository {

	List<Animal> listAll();
}
