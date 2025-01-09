package com.login.login.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.login.login.models.Product;

//Repository för produkt
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
