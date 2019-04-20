package com.restaurante.apirest.endpoint;

import com.restaurante.apirest.Repository.RestauranteRepository;
import com.restaurante.apirest.error.ResourceNotFoundException;
import com.restaurante.apirest.model.Restaurant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/restaurants")
@Api(value="API REST RESTAURANTES")
@CrossOrigin(origins = "*")
public class RestauranteEndPoint {

    private final RestauranteRepository restauranteRepository;

    @Autowired
    public RestauranteEndPoint(RestauranteRepository restauranteRepository){
        this.restauranteRepository = restauranteRepository;
    }

    @GetMapping
    @ApiOperation(value = "Retorna Lista de Restaurantes.")
    public ResponseEntity<?> listRestaurant(){
        return new ResponseEntity<>(restauranteRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorne um único restaurante através do id.")
    public ResponseEntity<?> getRestaurantById(@PathVariable("id") Long id){
        verifyIfRestauranteExists(id);
        Restaurant restaurant = restauranteRepository.findById(id).get();
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @PostMapping
    @ApiOperation(value = "Salva um restaurante no BD.")
    public ResponseEntity<?> save(@Valid @RequestBody Restaurant restaurant){
        return new ResponseEntity<>(restauranteRepository.save(restaurant), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta um Restaurante do BD através do id.")
    public ResponseEntity<?> delete(@PathVariable Long id){
        verifyIfRestauranteExists(id);
        restauranteRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    @ApiOperation(value = "Atualiza um restaurante do BD.")
    public ResponseEntity<?> update(@Valid @RequestBody Restaurant restaurant){
        verifyIfRestauranteExists(restaurant.getId());
        restauranteRepository.save(restaurant);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void verifyIfRestauranteExists(Long id){
        if(!restauranteRepository.findById(id).isPresent()){
            throw new ResourceNotFoundException("Restaurant with id " + id + " not found!");
        }
    }
}
