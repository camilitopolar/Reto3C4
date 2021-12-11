package com.cuatroa.retodos.repository;

import com.cuatroa.retodos.model.Chocolate;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cuatroa.retodos.repository.crud.FraganceCrudRepository;

/**
 *
 * @author camilo mendez
 */
@Repository
public class ChocolateRepository {
    @Autowired
    private FraganceCrudRepository repository;

    public List<Chocolate> getAll() {
        return repository.findAll();
    }

    public Optional<Chocolate> getClothe(String reference) {
        return repository.findById(reference);
    }
    
    public Chocolate create(Chocolate clothe) {
        return repository.save(clothe);
    }

    public void update(Chocolate clothe) {
        repository.save(clothe);
    }
    
    public void delete(Chocolate clothe) {
        repository.delete(clothe);
    }
    
    public List<Chocolate> productByPrice(double precio) {
	return repository.findByPriceLessThanEqual(precio);
}
}
