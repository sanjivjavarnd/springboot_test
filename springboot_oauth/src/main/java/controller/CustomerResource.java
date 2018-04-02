package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.Customer;
import repository.CustomerRepository;

@RestController
@RequestMapping("/secure")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CustomerResource {

	@Autowired
	CustomerRepository customerService;

	@GetMapping("/hello")
	public ResponseEntity<String> hello() {
		return new ResponseEntity<String>("welcome to customer resource", HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable int id) {
		Customer customer = customerService.findOne(id);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);

	}

	@GetMapping("/all")
	public ResponseEntity<List<Customer>> getAllCustomer() {
		List<Customer> customers = customerService.findAll();
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}

	@PreAuthorize("ADMIN_ROLE")
	@PostMapping("/add")
	public ResponseEntity<Customer> save(@RequestBody Customer customer) {
		Customer savedcust = customerService.save(customer);
		return new ResponseEntity<Customer>(savedcust, HttpStatus.CREATED);
	}

}
