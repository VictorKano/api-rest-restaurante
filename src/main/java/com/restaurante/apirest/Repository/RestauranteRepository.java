package com.restaurante.apirest.Repository;

import com.restaurante.apirest.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestauranteRepository extends CrudRepository<Restaurant, Long> {
}
