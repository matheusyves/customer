package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.acme.entity.CustomerEntity;
import org.acme.mapper.CustomerMapper;
import org.acme.dto.CustomerDTO;
import org.acme.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CustomerService {

    @Inject
    CustomerRepository customerRepository;

    @Inject
    CustomerMapper customerMapper;

    public List<CustomerDTO> findAllCustomers(){
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toDTO)
                .toList();
    }

    @Transactional
    public void createNewCustomer(CustomerDTO customerDTO){
        customerRepository.persist(customerMapper.toEntity(customerDTO));
    }

    @Transactional
    public void changeCustomer(Long id, CustomerDTO customerDTO){
        CustomerEntity customer = customerRepository.findById(id);
        customer.setNome(customerDTO.getNome());
        customer.setAge(customerDTO.getAge());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());

        customerRepository.persist(customer);
    }

    @Transactional
    public void deleteCostumer(Long id){
        customerRepository.deleteById(id);
    }
}
