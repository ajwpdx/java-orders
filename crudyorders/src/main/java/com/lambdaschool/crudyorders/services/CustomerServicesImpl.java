package com.lambdaschool.crudyorders.services;


import com.lambdaschool.crudyorders.models.Customer;

import com.lambdaschool.crudyorders.models.Order;
import com.lambdaschool.crudyorders.repositories.CustomersRepository;
import com.lambdaschool.crudyorders.repositories.OrdersRepository;
import com.lambdaschool.crudyorders.views.OrderCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerServices")
public class CustomerServicesImpl implements CustomerServices {

    @Autowired
    CustomersRepository customerrepos;

    @Autowired
    OrdersRepository orderrepos;

    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> list = new ArrayList<>();
        customerrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customer findCustomerById(long id) {
        return customerrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer " + id + " Not Found!"));
    }

    @Override
    public List<Customer> findByNameLike(String subname) {
        List<Customer> list = customerrepos.findByCustnameContainingIgnoreCase (subname);
        return list;
    }

    @Override
    public List<OrderCounts> countOrdersByCustomer() {
        List<OrderCounts> list = customerrepos.findOrderCounts();
        return list;
    }


    @Transactional
    @Override
    public Customer save(Customer customer)
    {
        Customer newCustomer = new Customer();

        if(customer.getCustcode() != 0)
        {
            findCustomerById(customer.getCustcode());
            newCustomer.setCustcode(customer.getCustcode());
        }

        //single value fields
        newCustomer.setCustname(customer.getCustname());
        newCustomer.setCustcity(customer.getCustcity());
        newCustomer.setWorkingarea(customer.getWorkingarea());
        newCustomer.setCustcountry(customer.getCustcountry());
        newCustomer.setGrade(customer.getGrade());
        newCustomer.setOpeningamt(customer.getOpeningamt());
        newCustomer.setReceiveamt(customer.getReceiveamt());
        newCustomer.setPaymentamt(customer.getPaymentamt());
        newCustomer.setOutstandingamt(customer.getOutstandingamt());
        newCustomer.setPhone(customer.getPhone());
        newCustomer.setAgent(customer.getAgent());

        //collections
        newCustomer.getOrders().clear();
        for (Order o : customer.getOrders())
        {
            Order newOrder = new Order(o.getOrdamount(), o.getAdvanceamount(), newCustomer, o.getOrderdescription());

            newCustomer.getOrders().add(newOrder);
        }

        return customerrepos.save(newCustomer);
    }

    @Transactional
    @Override
    public Customer update(Customer customer, long custcode)
    {
        Customer updatedCustomer = findCustomerById(custcode);

        if (customer.getCustname() != null)
        {
            updatedCustomer.setCustname(customer.getCustname());
        }

        if (customer.getCustcity() != null)
        {
            updatedCustomer.setCustcity(customer.getCustcity());
        }

        if (customer.getWorkingarea() != null)
        {
            updatedCustomer.setWorkingarea(customer.getWorkingarea());
        }

        if (customer.getCustcountry() != null)
        {
            updatedCustomer.setCustcountry(customer.getCustcountry());
        }

        if (customer.getGrade() != null)
        {
            updatedCustomer.setGrade(customer.getGrade());
        }

        if (customer.hasvalueforopeningamt)
        {
            updatedCustomer.setOpeningamt(customer.getOpeningamt());
        }

        if (customer.hasvalueforreceiveamt)
        {
            updatedCustomer.setReceiveamt(customer.getReceiveamt());
        }

        if (customer.hasvalueforpaymentamt)
        {
            updatedCustomer.setPaymentamt(customer.getPaymentamt());
        }

        if (customer.hasvalueforoutstandingamt)
        {
            updatedCustomer.setOutstandingamt(customer.getOutstandingamt());
        }

        if (customer.getPhone() != null)
        {
            updatedCustomer.setPhone(customer.getPhone());
        }

        if (customer.getAgent() != null)
        {
            updatedCustomer.setAgent(customer.getAgent());
        }

        if (customer.getOrders().size() > 0)
        {
            updatedCustomer.getOrders()
                    .clear();
            for (Order o : customer.getOrders())
            {
                Order newOrder = new Order(o.getOrdamount(), o.getAdvanceamount(), o.getCustomer(), o.getOrderdescription());

                updatedCustomer.getOrders()
                        .add(newOrder);
            }
        }

        return customerrepos.save(updatedCustomer);
    }
}