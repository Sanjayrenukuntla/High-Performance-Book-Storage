package com.bookstore.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.model.AuthorModel;
import com.bookstore.model.OrderModel;
import com.bookstore.model.PublisherModel;
import com.bookstore.model.UserModel;
import com.bookstore.repository.AuthorRepository;
import com.bookstore.repository.OrderRepository;
import com.bookstore.repository.PublisherRepository;
import com.bookstore.repository.UserRepository;

@Service
public class AdminService {


       @Autowired
       private AuthorRepository authorRepository;
       @Autowired
       private PublisherRepository publisherRepository;

       @Autowired 
       private UserRepository userRepository;

       @Autowired
       private OrderRepository orderRepository;

    public AuthorModel addAuthor(AuthorModel authorModel){
      
        authorModel.setAuthorId(UUID.randomUUID().toString().split("-")[0]);
       return authorRepository.save(authorModel);

    }

    public PublisherModel addPublisher(PublisherModel publisherModel){
        publisherModel.setPublisherId(UUID.randomUUID().toString().split("-")[0]);
        return publisherRepository.save(publisherModel);
 
     }

    public List<UserModel> getAllCustomers() {
       return  userRepository.findAll();
    }

    public List<OrderModel> getCancelledOrders() {
       
        return orderRepository.findAll().stream().filter(o->o.getOrderStatus().equalsIgnoreCase("cancelled")).collect(Collectors.toList());
    }

    public OrderModel updateRef(String orderId) {
       OrderModel orderModel=orderRepository.findByOrderId(orderId).get();
       orderModel.setOrderStatus("refund");
       return orderRepository.save(orderModel);
    }

    public OrderModel updateShip(String orderId) {
      OrderModel orderModel=orderRepository.findByOrderId(orderId).get();
      orderModel.setOrderStatus("shipped");
      return orderRepository.save(orderModel);
   }
    
}
