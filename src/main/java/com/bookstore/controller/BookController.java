package com.bookstore.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bookstore.model.Admin;
import com.bookstore.model.BookModel;
import com.bookstore.model.CartModel;
import com.bookstore.model.OrderModel;
import com.bookstore.model.Refund_policy;
import com.bookstore.model.UserModel;
import com.bookstore.model.paymentModel;
import com.bookstore.service.BookService;
import com.bookstore.utils.LocalDateToString;
import com.bookstore.utils.StringSubString;



@Controller
@SessionAttributes("user")
public class BookController {
	
	@Autowired
	BookService bookService; 


	@GetMapping("/")
	public String loginPage(){
    return "index";
	}

	@GetMapping("/homepage/{username}")
	public String homepage(@PathVariable String username,Model model){
	UserModel userModel=bookService.findByUserName(username);
	model.addAttribute("user", userModel);
    return "userhome";
	}

	@GetMapping("register")
  public String userRegister(){
     return "register";
  }

	@PostMapping("/userRegister")
	public String registerUser(@RequestParam("userName") String userName,
	@RequestParam("password") String password,
	@RequestParam("emailId") String emailid,
	@RequestParam("phoneNubmer") String mobile,
	@RequestParam("address") String address,
	@RequestParam("userType") String userType,Model model){

		UserModel um=new UserModel();
		um.setUserName(userName);um.setPassword(password);um.setEmailId(emailid);
		um.setPhoneNubmer(mobile);um.setAddress(address);um.setUserType(userType);
		UserModel um1= bookService.registerUser(um);

		if(um1==null){
			model.addAttribute("msg","userRegister failed");
			return "register";

		}else{
			if(userType.equalsIgnoreCase("admin")){
				Admin admin=new Admin();
				admin.setId(um.getId());
				admin.setAddress(um.getAddress());
				admin.setEmailId(um.getEmailId());
				admin.setPassword(um.getPassword());
				admin.setPhoneNubmer(um.getPhoneNubmer());
bookService.saveAdmin(admin);
			}
			model.addAttribute("msg","User Registration success");
			return "index";
		}


	}

	@PostMapping("/userLogin")
	public String loginUser(@RequestParam("userName") String userName,
	@RequestParam("password")String password,Model model){
        UserModel userModel=new UserModel();
		userModel.setUserName(userName);userModel.setPassword(password);
		UserModel user= bookService.loginUser(userModel);
		if(user==null){
			model.addAttribute("msg", "User Login Failed");
			return "index";
		}else if(user.getUserType().equalsIgnoreCase("admin")){
			model.addAttribute("user", user);
           return "adminhome";
		}else{
			model.addAttribute("msg", "User success");
			model.addAttribute("user", user);
			
			return "userhome";
		}
		
	}
	
	@GetMapping("/paymentpage")
	public String payment(@RequestParam("userName")String userName,Model model){
    UserModel userModel=bookService.findByUserName(userName);
	model.addAttribute("user", userModel);
	List<CartModel> cartModels=bookService.getCart(userName);
   double amount=0;
	for(CartModel cart : cartModels){
		BookModel bm=cart.getBookModel();
		String s1=StringSubString.getSub(bm.getPublisherModel().getBookCost());
		amount=amount+Double.parseDouble(s1);
	}
	model.addAttribute("amount", amount);
	model.addAttribute("user", userModel);
		return "paymentpage";
	}





		
	
	@GetMapping("/viewBooks/{id}")
		public ResponseEntity<List<BookModel>> viewBook(@PathVariable String id) {
			
		List<BookModel> listOfbooks= bookService.findAllBooks(id);	
		
		if(listOfbooks==null){
			return ResponseEntity.noContent().build();
		}else{
			return ResponseEntity.ok(listOfbooks);
		}
		
		}	


		@PostMapping("/orderBooks")
		public String orderBook(@RequestParam("userName") String userName,
		@RequestParam("cardnumber") String cardnumber,
		@RequestParam("cardname") String cardname,
		@RequestParam("cardexpiry") String cardexpiry,
		@RequestParam("cardcvv")String cardcvv,Model model) {

			paymentModel pm=new paymentModel();
			pm.setPaymenttype("card");
			pm.setPaymentStatus("approved");
			pm.setPaymentCard(cardnumber);
			
			

			UserModel userModel=bookService.findByUserName(userName);

			List<CartModel> cartModels=bookService.getCart(userName);
			if(cartModels==null){
				return null;
			}else{
             model.addAttribute("cart", cartModels);
              
			 OrderModel orderModel =new OrderModel();
			 orderModel.setOrderId(UUID.randomUUID().toString().split("-")[0]);
			 orderModel.setOrderStatus("approved");
			 orderModel.setOrderedDate(LocalDateToString.convertToSring(LocalDateTime.now()));
			 orderModel.setUserId(userName);
			
			 List<BookModel> bookModels=new ArrayList<>();
			 for(CartModel cart : cartModels){
				bookModels.add(cart.getBookModel());
			}
            
			orderModel.setListofBooks(bookModels);
			orderModel=bookService.orderBook(userName, orderModel);
			if(orderModel==null){
				return null;
			}else{

           model.addAttribute("msg", "order sucess");
		   model.addAttribute("user", userModel);
		   bookService.deleteCart(userName);
		   List<CartModel> cartModels1=bookService.getCart(userName);
			model.addAttribute("cart", cartModels1);
			bookService.savePayment(pm);
			 return "cartView";
		}
			}
			
	  /* OrderModel orderModel2= bookService.orderBook(id, orderModel);
		if(orderModel2==null){
			return ResponseEntity.noContent().build();
		}else{
			return ResponseEntity.ok(orderModel2);
		} */
		
		}

		@PostMapping("/addTocart")
		public String addToCart(@RequestParam("userName")String userName,@RequestParam("bookId")String bookId,Model model){
        
			UserModel userModel=bookService.findByUserName(userName);
			BookModel bookModel=bookService.findBookByBookId(bookId);

                    CartModel cm=new CartModel();
					cm.setBookModel(bookModel);
					cm.setUserId(userModel.getUserName());

			CartModel cartModel=bookService.addToCart(cm);

			if(cartModel ==null){
				return null;
			}
			else{
				model.addAttribute("user", userModel);
				model.addAttribute("cartmsg", "Added to cart");
				List<BookModel> orderModel2= bookService.getAllBooks();
			model.addAttribute("books", orderModel2);
			List<CartModel> cartModels=bookService.getCart(userName);
			model.addAttribute("cartItems", cartModels.size());
				return "viewbooks";
			}




		}

		@GetMapping("/getOrderdBooks/{userName}")
		public String getAllOrdersOfUsers(@PathVariable String userName,Model model) {
			
	  List<OrderModel> orderModel2= bookService.getAllOrders(userName);
		if(orderModel2==null){
			return null;
		}else{
			model.addAttribute("orders", orderModel2);
			return "orderspage";
		}
		
		}

		@GetMapping("/getAllBooks/{userName}")
		public String getAllBooks(Model model, @PathVariable String userName) {
			UserModel userModel=bookService.findByUserName(userName);
	  List<BookModel> orderModel2= bookService.getAllBooks();
		if(orderModel2==null){
			return null;
		}else{
			model.addAttribute("books", orderModel2);
			model.addAttribute("user", userModel );
			List<CartModel> cartModels=bookService.getCart(userName);
			model.addAttribute("cartItems", cartModels.size());
			return "viewbooks";
		}
		
		}


		@PostMapping("/adduser")
	   @ResponseStatus(HttpStatus.CREATED)
	public UserModel createUser(@RequestBody UserModel userModel) {
		return bookService.registerUser(userModel);
		}
	
		@PostMapping("/cancelOrder")
		public String cancelOrder(@RequestParam("orderid") String orderId,
		@RequestParam("userId") String userName,
		Model model){

			OrderModel orderModel=bookService.cancelOrder(orderId);
			if(orderModel==null){
				return null;
			}else{
				List<OrderModel> orderModel2= bookService.getAllOrders(userName);
		if(orderModel2==null){
			return null;
		}else{
			model.addAttribute("orders", orderModel2);
			Refund_policy rp=new Refund_policy();
			rp.setOrderModel(orderModel);
			bookService.saveReturn(rp);
			return "orderspage";
		}
				
			}

		}

		@GetMapping("/cart/{userName}")
		public String cart(@PathVariable String userName,Model model){

			List<CartModel> cartModels=bookService.getCart(userName);
			if(cartModels==null){
				return null;
			}else{
             model.addAttribute("cart", cartModels);
              
			 OrderModel orderModel =new OrderModel();
			 orderModel.setOrderStatus("approved");
			 orderModel.setOrderedDate("23-05-2023");
			 orderModel.setUserId(userName);
			
			 List<BookModel> bookModels=new ArrayList<>();
			 for(CartModel cart : cartModels){
				bookModels.add(cart.getBookModel());
			}
            
			orderModel.setListofBooks(bookModels);
           model.addAttribute("order", orderModel);
			 return "cartView";
			}

		}

/* 	@PostMapping("/order/{id}")
	public OrderModel orderBook(@PathVariable String id,@RequestBody OrderModel orderModel){



	} */

	@GetMapping("/logout")
	public String logout(){
		return "index";
	}
	

}
