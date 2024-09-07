package com.balancee.rewardsManagementApi.security.services;

import com.balancee.rewardsManagementApi.data.models.Customer;
import com.balancee.rewardsManagementApi.exceptions.CustomerNotFoundException;
import com.balancee.rewardsManagementApi.security.models.SecureCustomer;
import com.balancee.rewardsManagementApi.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomCustomerDetailsService implements UserDetailsService {
    private CustomerService customerService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = null;
        try {
            customer = customerService.getCustomerByUsername(username);
        } catch (CustomerNotFoundException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
        return new SecureCustomer(customer);
    }
}
