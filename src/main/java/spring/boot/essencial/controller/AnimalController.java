package spring.boot.essencial.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import spring.boot.essencial.domain.Animal;
import spring.boot.essencial.service.AnimalService;

@RestController
@RequestMapping("animal")
@RequiredArgsConstructor
public class AnimalController {

	private final AnimalService animalService;
	
	@GetMapping
	public ResponseEntity<List<Animal>> list(){
		return new ResponseEntity<>(animalService.listAll(),HttpStatus.OK);
	}
	
	@GetMapping(path="/{id}")
	public ResponseEntity<Animal> findById(@PathVariable long id){
		return new ResponseEntity<>(animalService.findById(id),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Animal> save(@RequestBody Animal animal){
		return new ResponseEntity<>(animalService.save(animal), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id){
		animalService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping
	public ResponseEntity<Void> replace(@RequestBody Animal animal){
		animalService.replace(animal);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
