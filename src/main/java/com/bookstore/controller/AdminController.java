package com.bookstore.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

import com.bookstore.model.AuthorModel;
import com.bookstore.model.BookModel;
import com.bookstore.model.OrderModel;
import com.bookstore.model.Pickup_delivery;
import com.bookstore.model.PublisherModel;
import com.bookstore.model.UserModel;
import com.bookstore.service.AdminService;
import com.bookstore.service.BookService;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    BookService bookService;

    String upload_folder="C:\\Users\\shyam\\Documents\\workspace-spring-tool-suite-4-4.14.0.RELEASE\\bookstore\\src\\main\\resources\\static\\images\\";

    

    @GetMapping("/adminHome/{userName}")
    public String homePage(@PathVariable String userName,Model model){
      UserModel userModel= bookService.findByUserName(userName);
      model.addAttribute("user", userModel);
      return "adminhome";
    }

    @GetMapping("/customers")
    public String getAllCustomers(Model model){

      List<UserModel> userModels=adminService.getAllCustomers();

      if(userModels==null){
     return  null;
      }else{
          model.addAttribute("users",userModels);
       return  "viewcustomers";
      }

    }

    @GetMapping("/addbookpage")
    public String addbookPage(){
      return "addbookpage";
    }

    @PostMapping("/Editbookpage")
    public String EditbookPage(@RequestParam("bookId")String bookId,Model model){
BookModel bookModel=bookService.findBookByBookId(bookId);
    model.addAttribute("book", bookModel);
    model.addAttribute("update1", "update");
      return "addbookpage";
    }

    @PostMapping("/deleteBook")
    public String deleteBook(@RequestParam("bookId")String bookId,Model model){
     BookModel bookModel=bookService.findBookByBookId(bookId);
       bookService.deleteBook(bookModel);
       List<BookModel> bookModels=bookService.getAllBooks();
    model.addAttribute("books", bookModels);
    return "adminViewbooks";
     
    }



    @PostMapping("/updateBook")
    public String updateBook(
      @RequestParam("bookId") String bookId,
       @RequestParam("bookName")String bookName,
       @RequestParam("bookIsn")String bookIsn,
       @RequestParam("authorName")String authorName,
       @RequestParam("authorAddress")String authorAddress,
       @RequestParam("publisherName")String publisherName,
       @RequestParam("publisherAddress")String publisherAddress,
       @RequestParam("bookCost")String bookCost,
       @RequestParam("file") MultipartFile file,
       Model model
       
    ) throws IOException {


     BookModel bookModel=bookService.findBookByBookId(bookId);
     bookModel.setBookName(bookName);bookModel.setBookIsn(bookIsn);

     AuthorModel authorModel=bookModel.getAuthorModel();
     authorModel.setAuthorId(authorModel.getAuthorId());
     authorModel.setAuthorAddress(authorAddress);
     authorModel.setAuthorName(authorName);

     PublisherModel pm=bookModel.getPublisherModel();
     pm.setPublisherId(pm.getPublisherId());
     pm.setPublisherName(publisherName);
     pm.setPublisherAddress(publisherAddress);

     bookModel.setAuthorModel(authorModel);bookModel.setPublisherModel(pm);

     BookModel bookModelss= bookService.updateBook(bookModel);

     if(bookModelss==null){
    return null;
     }else{
      model.addAttribute("msg", "Book Updated");
      return "addbookpage";
     }



      
       }


    @PostMapping("/addBook")
	public String createBook(
      @RequestParam("bookName")String bookName,
      @RequestParam("bookIsn")String bookIsn,
      @RequestParam("authorName")String authorName,
      @RequestParam("authorAddress")String authorAddress,
      @RequestParam("publisherName")String publisherName,
      @RequestParam("publisherAddress")String publisherAddress,
      @RequestParam("bookCost")String bookCost,
      @RequestParam("file") MultipartFile file,
      Model model
      
   ) throws IOException {
      BookModel bookModel=new BookModel();
      AuthorModel authorModel=new AuthorModel();
      PublisherModel pm=new PublisherModel();
       bookModel.setBookId(UUID.randomUUID().toString().split("-")[0]);
       authorModel.setAuthorId(UUID.randomUUID().toString().split("-")[0]);
       pm.setPublisherId(UUID.randomUUID().toString().split("-")[0]);
      bookModel.setBookName(bookName);
      bookModel.setBookIsn(bookIsn);
      authorModel.setAuthorName(authorName);
      authorModel.setAuthorAddress(authorAddress);
      bookModel.setAuthorModel(authorModel);
      pm.setPublisherName(publisherName);
      pm.setPublisherAddress(publisherAddress);
      pm.setBookCost(bookCost);
      bookModel.setPublisherModel(pm);
      bookModel.setBookUrl(file.getOriginalFilename());
	
      BookModel bookModel2= bookService.addBook(bookModel);
      byte[] bytes = file.getBytes();
			Path path = Paths.get(upload_folder+file.getOriginalFilename());
			Files.write(path, bytes);
      if(bookModel2==null){
         model.addAttribute("msg", "Book Failed to add");
         return "addbookpage";
      }else{
      model.addAttribute("msg", "Book successfully added");
      bookService.saveAuthor(authorModel);
      bookService.savePublisher(pm);
      return "addbookpage";
      }
		}


      @GetMapping("/getAllBooksAdmin")
    public String getAllBooksForAdmin(Model model){

    List<BookModel> bookModels=bookService.getAllBooks();
    model.addAttribute("books", bookModels);
    return "adminViewbooks";
      
    }

    @PostMapping("/addAuthor")
    public ResponseEntity<AuthorModel> addAuthor(@RequestBody AuthorModel authorModel){

       AuthorModel aModel=adminService.addAuthor(authorModel);
       if(aModel==null){
      return ResponseEntity.noContent().build();
       }else{
        return ResponseEntity.ok().body(aModel);
       }
    }

    @PostMapping("/addPublisher")
    public ResponseEntity<PublisherModel> addPublisher(@RequestBody PublisherModel publisherModel){

       PublisherModel pModel=adminService.addPublisher(publisherModel);
       if(pModel==null){
      return ResponseEntity.noContent().build();
       }else{
        return ResponseEntity.ok().body(pModel);
       }
    }

    @GetMapping("/viewCancelledOrders")
    public ResponseEntity<List<OrderModel>> viewCancelledOrders(){

      List<OrderModel> orderModels=adminService.getCancelledOrders();
      if(orderModels==null){
         return ResponseEntity.noContent().build();
      }else{
         return ResponseEntity.ok().body(orderModels);
      }
      
    }
    
    @PostMapping("/updateRefund")
    public String updateRefund(@RequestParam("orderId") String orderId,Model model){

     OrderModel orderModels= adminService.updateRef(orderId);
      if(orderModels==null){
         return null;
      }else{
         List<OrderModel> orderModels1=bookService.findAllOrders();
      model.addAttribute("orders", orderModels1);
      return "adminorderpage";
      }
      
    }

    @PostMapping("/shipTheOrder")
    public String shipTheOrder(@RequestParam("orderId") String orderId,Model model){

     OrderModel orderModels= adminService.updateShip(orderId);
      if(orderModels==null){
         return null;
      }else{
         List<OrderModel> orderModels1=bookService.findAllOrders();
      model.addAttribute("orders", orderModels1);
      Pickup_delivery pd=new Pickup_delivery();
      pd.setOrderModel(orderModels);
      bookService.savePickup(pd);
      return "adminorderpage";
      }
      
    }



    @GetMapping("/adminOrders")
    public String adminOrders(Model model){
      
      List<OrderModel> orderModels=bookService.findAllOrders();
      model.addAttribute("orders", orderModels);
      return "adminorderpage";

     
    }


    
}
