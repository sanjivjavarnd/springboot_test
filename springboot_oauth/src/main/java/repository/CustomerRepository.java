package repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Serializable> {

}
