package com.shop.pumpkin.service;

import com.shop.pumpkin.model.Customer;
import com.shop.pumpkin.repository.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @ParameterizedTest
    @CsvFileSource(resources = "/com/shop/pumpkin/service/CustomerServiceData.csv", numLinesToSkip = 1)
    void save(String name, boolean membership, String membershipDateBought, double totalAmountPurchased,
              double totalAmountRefunded, String complaints, String employeeComments, boolean ban) {
        Customer customer = new Customer(name, membership, membershipDateBought, totalAmountPurchased,
                totalAmountRefunded, complaints, employeeComments, ban);

        customerService.save(customer);

        ArgumentCaptor<Customer> captor = ArgumentCaptor.forClass(Customer.class);
        verify(customerRepository).save(captor.capture());

        assertThat(captor.getValue().getId()).isEqualTo(customer.getId());
        assertThat(captor.getValue().isMembership()).isEqualTo(customer.isMembership());
        assertThat(captor.getValue().getMembershipDateBought()).isEqualTo(customer.getMembershipDateBought());
        assertThat(captor.getValue().getTotalAmountPurchased()).isEqualTo(customer.getTotalAmountPurchased());
        assertThat(captor.getValue().getTotalAmountRefunded()).isEqualTo(customer.getTotalAmountRefunded());
        assertThat(captor.getValue().getComplaints()).isEqualTo(customer.getComplaints());
        assertThat(captor.getValue().getEmployeeComments()).isEqualTo(customer.getEmployeeComments());
        assertThat(captor.getValue().isBan()).isEqualTo(customer.isBan());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/com/shop/pumpkin/service/CustomerServiceData.csv", numLinesToSkip = 1)
    void getAll(String name, boolean membership, String membershipDateBought, double totalAmountPurchased,
              double totalAmountRefunded, String complaints, String employeeComments, boolean ban) {
        List<Customer> customer = List.of(new Customer(name, membership, membershipDateBought, totalAmountPurchased,
                totalAmountRefunded, complaints, employeeComments, ban));

        when(customerRepository.findAll()).thenReturn(customer);
        List<Customer> resultCustomer = customerService.getAll();

        assertThat(customer).isEqualTo(resultCustomer);
        verify(customerRepository, times(1)).findAll();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/com/shop/pumpkin/service/CustomerServiceData.csv", numLinesToSkip = 1)
    void delete(String name, boolean membership, String membershipDateBought, double totalAmountPurchased,
                double totalAmountRefunded, String complaints, String employeeComments, boolean ban) {
        Customer customer = new Customer(name, membership, membershipDateBought, totalAmountPurchased,
                totalAmountRefunded, complaints, employeeComments, ban);
        String id = customer.getId() + "";

        customerService.delete(id);

        verify(customerRepository, times(1)).deleteById(id);
    }
}
