import java.util.*;
class Book {
 private String isbn;
 private String title;
 private String author;
 private double price;
 private int rating;
 private List<String> reviews;
public String getTitle() {
	// TODO Auto-generated method stub
	return null;
}
public Object getCategory() {
	// TODO Auto-generated method stub
	return null;
}
public String getAuthor() {
	// TODO Auto-generated method stub
	return null;
}

 // Constructor, getters, and setters
 // ...
}

class User {
 private String username;
 private String password;
 // Additional user information (e.g., email, address)

 // Constructor, getters, and setters
 // ...
}

class Order {
 private int orderId;
 private User user;
 private List<Book> books;
 private double totalPrice;
 private Date orderDate;

 // Constructor, getters, and setters
 // ...
}

//Enum for Book categories
enum BookCategory {
 FICTION,
 NON_FICTION,
 SCIENCE_FICTION,
 MYSTERY,
 ROMANCE,
 // Add more categories as needed
}

//Main class representing the Book Store
public class OnlineBookStore {
 private List<Book> books;
 private List<User> users;
 private List<Order> orders;

 public OnlineBookStore() {
     books = new ArrayList<>();
     users = new ArrayList<>();
     orders = new ArrayList<>();
 }

 // Methods for book and user management
 // ...

 // Book search by title, author, or category
 public List<Book> searchBooks(String query) {
     List<Book> searchResults = new ArrayList<>();
     for (Book book : books) {
         if (book.getTitle().contains(query) ||
             book.getAuthor().contains(query) ||
             book.getCategory().toString().equals(query.toUpperCase())) {
             searchResults.add(book);
         }
     }
     return searchResults;
 }

 // Add book to cart for a specific user
 public void addToCart(User user, Book book) {
     // Find user's cart or create one if not exists
     // Add book to the cart
 }

 // Remove book from cart for a specific user
 public void removeFromCart(User user, Book book) {
     // Find user's cart and remove the book
 }

 // Place an order for the books in the user's cart
 public void placeOrder(User user) {
     // Retrieve user's cart and create an order
     // Calculate total price, update inventory, etc.
 }

 // Rate and review a book
 public void rateAndReviewBook(Book book, int rating, String review) {
     // Update book's rating and add the review
 }

 // Display book details
 public void displayBookDetails(Book book) {
     // Print book information, rating, and reviews
 }

 // Display user's orders
 public List<Order> getUserOrders(User user) {
	return orders;
     // Retrieve and return user's order history
 }

 // Main method to test the functionality
 public static void main(String[] args) {
     OnlineBookStore bookStore = new OnlineBookStore();
     // Initialize some books, users, etc.
     // ...

     // Test the book store functionalities
     // ...
 }
}
	