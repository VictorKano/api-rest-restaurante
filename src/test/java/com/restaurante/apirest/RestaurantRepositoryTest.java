package com.restaurante.apirest;

import com.restaurante.apirest.Repository.RestauranteRepository;
import com.restaurante.apirest.model.Restaurant;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RestaurantRepositoryTest {
    @Autowired
    private RestauranteRepository restauranteRepository;

    @Test
    public void findRestaurantByIdTest(){
        Restaurant restaurant = new Restaurant("TopBurguer");
        Restaurant restaurant2 = new Restaurant("Gioday");
        this.restauranteRepository.save(restaurant);
        restauranteRepository.save(restaurant2);
        assertThat(restauranteRepository.findById(restaurant.getId())).isEqualTo(Optional.of(restaurant));
    }

    @Test
    public void getListaRestaurantTest(){
        List<Restaurant> listaRestaurante = new ArrayList<>();
        Restaurant restaurant = new Restaurant("Varandinha");
        Restaurant restaurant2 = new Restaurant("Rei do Sul");
        Restaurant restaurant3 = new Restaurant("Yoshinoya");
        this.restauranteRepository.save(restaurant);
        this.restauranteRepository.save(restaurant2);
        this.restauranteRepository.save(restaurant3);
        listaRestaurante.add(restaurant);
        listaRestaurante.add(restaurant2);
        listaRestaurante.add(restaurant3);
        assertThat(restauranteRepository.findAll()).isEqualTo(listaRestaurante);
    }

    @Test
    public void createRestaurantDataShouldPersist(){
        Restaurant restaurant = new Restaurant("V8");
        this.restauranteRepository.save(restaurant);
        assertThat(restaurant.getId()).isNotNull();
        assertThat(restaurant.getName()).isEqualTo("V8");
    }

    @Test
    public void deleteRestaurantShouldRemoveData(){
        Restaurant restaurant = new Restaurant("V8");
        this.restauranteRepository.save(restaurant);
        restauranteRepository.deleteById(restaurant.getId());
        assertThat(restauranteRepository.findById(restaurant.getId())).isEmpty();
    }

    @Test
    public void updateRestaurantShouldChangeAndPersistData(){
        Restaurant restaurant = new Restaurant("V8");
        this.restauranteRepository.save(restaurant);
        restaurant.setName("Clandestino");
        restaurant = this.restauranteRepository.save(restaurant);
        assertThat(restaurant.getName()).isEqualTo("Clandestino");
    }


}
