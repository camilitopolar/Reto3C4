package com.cuatroa.retodos.service;

import com.cuatroa.retodos.model.Chocolate;
import com.cuatroa.retodos.repository.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author camilo mendez
 */
@Service
public class ChocolateService {

    @Autowired
    private ChocolateRepository repository;

    public List<Chocolate> getAll() {
        return repository.getAll();
    }

    public Optional<Chocolate> getClothe(String reference) {
        return repository.getClothe(reference);
    }

    public Chocolate create(Chocolate accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return repository.create(accesory);
        }
    }

    public Chocolate update(Chocolate accesory) {

        if (accesory.getReference() != null) {
            Optional<Chocolate> accesoryDb = repository.getClothe(accesory.getReference());
            if (!accesoryDb.isEmpty()) {


                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }



                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                repository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getClothe(reference).map(accesory -> {
            repository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<Chocolate> productByPrice(double price) {
        return repository.productByPrice(price);
    }

}
