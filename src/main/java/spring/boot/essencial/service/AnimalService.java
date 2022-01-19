package spring.boot.essencial.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import spring.boot.essencial.domain.Animal;

@Service
public class AnimalService{
	
	private static List<Animal> animals;
			static {
		animals = new ArrayList<Animal>(Arrays.asList(new Animal(1,"Cachorro"), new Animal(2,"Gato")));
	}

	public List<Animal> listAll() {
		return animals;
	}
	
	public Animal findById(long id) {
		return animals.stream()
					 .filter(animal -> animal.getId()==id)
					 .findFirst()
					 .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"animal não encontrado"));
	}

	public Animal save(Animal animal) {
		animal.setId(ThreadLocalRandom.current().nextLong(3, 10000));
		animals.add(animal);
		return animal;
		// TODO Auto-generated method stub
		
	}
	
	public void delete(Long id) {
		animals.remove(findById(id));
	}

	public void replace(Animal animal) {
		delete(animal.getId());
		animals.add(animal);
		
	}
}
