package pizzaloop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;
import java.util.List;
@Controller
@RequestMapping(path="/pizzaloop")
public class MainController {
    @Autowired
    private PizzaRepository pizzaRepository;
    private static final String SUCCESS= "Saved";
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderRepository orderRepository;
    /*
    * READ Operation
    * This method will list all the pizzas in the table
    * URI to access this: http://localhost:8080/pizzaloop/allpizza
    */
    @GetMapping(path="/allpizza")
    public @ResponseBody Iterable<PizzaDetails> getPizzaDetails() {
        return pizzaRepository.findAll();
    }
    /*
     * READ Operation
     * This method will list all the users in the table
     * URI to access this: http://localhost:8080/pizzaloop/alluser
     */
    @GetMapping(path="/allpayment")
    public @ResponseBody Iterable<PaymentDetails> getPaymentDetails(){
        return paymentRepository.findAll();
    }
    /*
     * READ Operation
     * This method will list all the users in the table
     * URI to access this: http://localhost:8080/pizzaloop/allpayment
     */
    @GetMapping(path="/alluser")
    public @ResponseBody Iterable<UserDetails> getUserDEtails(){
        return userRepository.findAll();
    }
    /*
     * READ Operation
     * This method will list all the orders in the table
     * URI to access this: http://localhost:8080/pizzaloop/allorders
     */
    @GetMapping(path="/allorder")
    public @ResponseBody Iterable<OrderDetails> getOrderDetails() {
        return orderRepository.findAll();
    }

    //=====================================================================================================================================
    /*
    * READ Operation based on Pizza ID
    * This method will return the details of a pizza specified by the id
    * URI to access this: http://localhost:8080/pizzaloop/findByPizzaId?id=2
    */
    @GetMapping(path="/findByPizzaId")
    public @ResponseBody List<PizzaDetails> getPizzaById(@RequestParam Integer id) {
        return pizzaRepository.findByPizzaId(id);
    }
    /*
     * READ Operation based on user ID
     * This method will return the details of a user specified by the id
     * URI to access this: http://localhost:8080/pizzaloop/findByUserId?id=2
     */
    @GetMapping(path="/findByUserId")
    public @ResponseBody List<UserDetails> getUserById(@RequestParam Integer id) {
        return userRepository.findByUserId(id);
    }
    /*
     * READ Operation based on payment ID
     * This method will return the details of a payment specified by the id
     * URI to access this: http://localhost:8080/pizzaloop/findByPaymentId?id=2
     */
    @GetMapping(path="/findByPaymentId")
    public @ResponseBody List<PaymentDetails> getPaymentById(@RequestParam Integer id) {
        return paymentRepository.findByPaymentId(id);
    }
    /*
     * READ Operation based on Order ID
     * This method will return the details of a order specified by the id
     * URI to access this: http://localhost:8080/pizzaloop/findByOrderId?id=2
     */

    @GetMapping(path="/findByOrderId")
    public @ResponseBody List<OrderDetails> getOrderById(@RequestParam Integer id) {
        return orderRepository.findByOrderId(id);
    }
    //=====================================================================================================================================
    /*
    * CREATE Operation
    * This method will crate new pizza item in the database table
    * and returns the SUCCESS message
    * URI to access this: http://localhost:8080/pizzaloop/addpizza?name=VegiPizza&description=vegivegi&price=2500.75&imgUrl=apple.lk
    */
    @GetMapping(path="/addpizza")
    public @ResponseBody String addNewPizza(@RequestParam String name, @RequestParam String description, @RequestParam Double price,@RequestParam String imgUrl) {
        PizzaDetails pizzaDetails = new PizzaDetails();
        pizzaDetails.setName(name);
        pizzaDetails.setDescription(description);
        pizzaDetails.setPrice(price);
        pizzaDetails.setImageUrl(imgUrl);
        pizzaRepository.save(pizzaDetails);
        return SUCCESS;
    }
    /*
     * CREATE Operation
     * This method will crate new payment in the database table
     * and returns the SUCCESS message
     * URI to access this: http://localhost:8080/pizzaloop/addpayment?cardno=11111111&pinno=00001
     */
    @GetMapping(path="/addpayment")
    public @ResponseBody String addNewPayment(@RequestParam String cardno, @RequestParam String pinno, @RequestParam Date expdate) {
        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setCardNo(cardno);
        paymentDetails.setPinNo(pinno);
        paymentDetails.setExpDate(expdate);
        paymentRepository.save(paymentDetails);
        return SUCCESS;
    }
    /*
     * CREATE Operation
     * This method will crate new user in the database table
     * and returns the SUCCESS message
     * URI to access this: http://localhost:8080/pizzaloop/addpuser?name=admin&password=123
     */

    @GetMapping(path="/adduser")
    public @ResponseBody String addNewUsert(@RequestParam String name, @RequestParam String password) {
        UserDetails userDetails = new UserDetails();
        userDetails.setName(name);
        userDetails.setPassword(password);
        userRepository.save(userDetails);
        return SUCCESS;
    }
    /*
     * CREATE Operation
     * This method will crate new order in the database table
     * and returns the SUCCESS message
     * URI to access this: http://localhost:8080/pizzaloop/addorder?name=11111111&address=00001&contactNo=0786177433
     */

    @GetMapping(path="/addorder")
    public @ResponseBody String addNewOrder(@RequestParam String name, @RequestParam String address, @RequestParam String contactNumber) {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setName(name);
        orderDetails.setAddress(address);
        orderDetails.setContactNumber(contactNumber);
        orderRepository.save(orderDetails);
        return SUCCESS;
    }
    //=====================================================================================================================================


    /*
    * DELETE Operation
    * This method will delete existing pizza item by finding it using the ID
    * and returns the deleted item
    * URI to access this: http://localhost:8080/pizzaloop/deleteByPizzaId?id=2
    */
    @GetMapping(path="/deleteByPizzaId")
    public @ResponseBody List<PizzaDetails> deletePizzaById(@RequestParam Integer id) {
        return pizzaRepository.deleteByPizzaId(id);
    }
    /*
     * DELETE Operation
     * This method will delete existing user  by finding it using the ID
     * and returns the deleted user
     * URI to access this: http://localhost:8080/pizzaloop/deleteByUserId?id=2
     */
    @GetMapping(path="/deleteByUserId")
    public @ResponseBody List<UserDetails> deleteUserById(@RequestParam Integer id) {
        return userRepository.deleteByUserId(id);
    }
    /*
     * DELETE Operation
     * This method will delete existing order  by finding it using the ID
     * and returns the deleted order
     * URI to access this: http://localhost:8080/pizzaloop/deleteByOrderId?id=2
     */

    @GetMapping(path="/deleteByOrderId")
    public @ResponseBody List<OrderDetails> deleteOrderById(@RequestParam Integer id) {
        return orderRepository.deleteByOrderId(id);
    }

    //=====================================================================================================================================


    /*
    * UPDATE Operation
    * This method will update existing pizza details by finding it using the ID
    * and returns the updated data
    * URI to access this: http://localhost:8080/pizzaloop/update?id=1&name=updatedname&description=updated&price=1234.56
    */
    @GetMapping(path="/updatepizza")
    public @ResponseBody List<PizzaDetails> updatePizzaDetails(@RequestParam Integer id, @RequestParam String name, @RequestParam String description, @RequestParam Double price) {
        //First get all the pizza details according to the provided ID
        List<PizzaDetails> pizzaDetailsList = pizzaRepository.findByPizzaId(id);
        if(!pizzaDetailsList.isEmpty()) {
            //Iterate through the pizza list
            for(PizzaDetails pizzaDetails: pizzaDetailsList) {
                //Set new values
                pizzaDetails.setName(name);
                pizzaDetails.setDescription(description);
                pizzaDetails.setPrice(price);
                //Update existing pizza item
                pizzaRepository.save(pizzaDetails);
            }
        }
        return pizzaRepository.findByPizzaId(id);
    }
    /*
     * UPDATE Operation
     * This method will update existing order details by finding it using the ID
     * and returns the updated data
     * URI to access this: http://localhost:8080/pizzaloop/update?id=1&name=updatedname&address=updated&contactNumber=0786177344
     */


    @GetMapping(path="/updateorder")
    public @ResponseBody List<OrderDetails> updateOrderDetails(@RequestParam Integer id, @RequestParam String name, @RequestParam String address, @RequestParam String contactNumber) {
        //First get all the order details according to the provided ID
        List<OrderDetails> orderDetailsList = orderRepository.findByOrderId(id);
        if(!orderDetailsList.isEmpty()) {
            //Iterate through the pizza list
            for(OrderDetails orderDetails: orderDetailsList) {
                //Set new values
                orderDetails.setOrderId(id);
                orderDetails.setName(name);
                orderDetails.setAddress(address);
                orderDetails.setContactNumber(contactNumber);
                //Update existing pizza item
                orderRepository.save(orderDetails);
            }
        }
        return orderRepository.findByOrderId(id);
    }
}
