package in.harshita.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.harshita.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {

}
