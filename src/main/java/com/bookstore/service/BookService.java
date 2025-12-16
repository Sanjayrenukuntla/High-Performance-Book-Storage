package com.bookstore.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookstore.model.Admin;
import com.bookstore.model.AuthorModel;
import com.bookstore.model.BookModel;
import com.bookstore.model.CartModel;
import com.bookstore.model.OrderModel;
import com.bookstore.model.Pickup_delivery;
import com.bookstore.model.PublisherModel;
import com.bookstore.model.Refund_policy;
import com.bookstore.model.UserModel;
import com.bookstore.model.paymentModel;
import com.bookstore.repository.AdminRepository;
import com.bookstore.repository.AuthorRepository;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.CartRepository;
import com.bookstore.repository.OrderRepository;
import com.bookstore.repository.PaymentRepository;
import com.bookstore.repository.PickupRepository;
import com.bookstore.repository.PublisherRepository;
import com.bookstore.repository.RefundRepository;
import com.bookstore.repository.UserRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private PublisherRepository publisherRepository;

	@Autowired
	private  AdminRepository adminRepository;

	@Autowired
	private RefundRepository refundRepository;

	@Autowired
	private PickupRepository pickupRepository;

	
	public UserModel registerUser(UserModel userModel){
       userModel.setId(UUID.randomUUID().toString().split("-")[0]);
		return userRepository.save(userModel);
	}

	public UserModel loginUser(UserModel userModel){

		UserModel user=userRepository.findByUserNameAndPassword(userModel.getUserName(),userModel.getPassword());
		if(user==null){
			System.out.println("user is  did not fetch the values");
		}else{
			System.out.println("user is success");
		}
		return user;
	}
	
	public BookModel addBook(BookModel bookModel) {
		
	   bookModel.setBookId(UUID.randomUUID().toString().split("-")[0]);
		return bookRepository.save(bookModel);
	}

	public BookModel updateBook(BookModel bookModel) {

		 return bookRepository.save(bookModel);
	 }


	
	public List<BookModel> findAllBooks(String userId){
		
		return bookRepository.findAll();
		
	}
	
	public BookModel findBookByBookId(String bookId){
		return bookRepository.findById(bookId).get();
	}
	
	public List<BookModel> findBookByBookName(String bookName){
		return bookRepository.findByBookName(bookName);
	}

	public OrderModel orderBook(String userId,OrderModel orderModel){

		orderModel.setOrderId(UUID.randomUUID().toString().split("-")[0]);
		orderModel.setUserId(userId);
		UserModel userModel=userRepository.findByUserName(userId);
		return  orderRepository.save(orderModel);

	}

    public UserModel checkUser(String userid) {
      UserModel userModel= userRepository.findByUserName(userid);
	  if(userModel.getUserType().equalsIgnoreCase("admin")){
		return userModel;
	  }else{
		userModel=null;
		return userModel;
	  }
    }

	public List<OrderModel> getAllOrders(String id) {
		UserModel userModel=userRepository.findByUserName(id);
		if(userModel==null){
         return null;
		}else{
			return orderRepository.findByUserId(userModel.getUserName());
		}
	}

	public OrderModel cancelOrder(String orderId) {

		OrderModel orderModel=orderRepository.findByOrderId(orderId).get();
		orderModel.setOrderStatus("cancelled");
		//orderRepository.delete(orderModel);
		orderModel=orderRepository.save(orderModel);
		return orderModel;
		
	}

	public List<BookModel> getAllBooks() {
		return bookRepository.findAll();
	}

    public UserModel findByUserName(String userName) {
      return userRepository.findByUserName(userName);
    }

    public CartModel addToCart(CartModel cm) {

		cm.setCartId(UUID.randomUUID().toString().split("-")[0]);
		return cartRepository.save(cm);
      
    }

	public List<CartModel> getCart(String userName) {
		
		return cartRepository.findByUserId(userName);
	}

	public void deleteCart(String userName) {
	
		List<CartModel> cartModels=cartRepository.findByUserId(userName);
		for(CartModel cm: cartModels){
			cartRepository.delete(cm);
		}
	}

    public List<OrderModel> findAllOrders() {
       
		return orderRepository.findAll();
    }

	public void deleteBook(BookModel bookModel) {
		bookRepository.delete(bookModel);
	}

    public void savePayment(paymentModel pm) {
        paymentRepository.save(pm);
    }

	public void saveAuthor(AuthorModel authorModel) {
		authorRepository.save(authorModel);
	}

    public void savePublisher(PublisherModel pm) {
       publisherRepository.save(pm);
    }

	public void saveAdmin(Admin um) {
		adminRepository.save(um);
	
	}

	public void saveReturn(Refund_policy rp) {
	refundRepository.save(rp);
	}

	public void savePickup(Pickup_delivery pd) {
		pickupRepository.save(pd);
		}
	

}
