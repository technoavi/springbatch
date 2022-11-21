package com.technoavi.twiggy.app;


import com.technoavi.twiggy.model.Order;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//localhost:8082/order/
@RestController
@RequestMapping("/order")
public class FoodOrder {



    @GetMapping("/msg")
    public String msg(){

        return "ready to place order!!";
    }
    List<Order>  listOfOrders= new ArrayList<>();
   @PostMapping("/place-order")
public String createOrder( @RequestBody Order order){
       Random r = new Random();
       Order newOrder= new Order();
       newOrder.setOrderId(r.nextInt(900)+100);
       System.out.println(newOrder.getOrderId());
       newOrder.setItemName(order.getItemName());
       newOrder.setPrice(order.getPrice());
       newOrder.setTime(order.getTime());
       newOrder.setRestaurantName(order.getRestaurantName());
       newOrder.setDeliveryAddress(order.getDeliveryAddress());
       listOfOrders.add(newOrder);
      return " Your order of :"+newOrder.getItemName()+" has been placed and order Id is :"+newOrder.getOrderId();
}

    @GetMapping("/getAll")
    public List<Order> getAllOrder(){



        return listOfOrders;
    }
@GetMapping("/getorder/{id}")
    public Order getOrderById(@PathVariable("id") int id){
        for(int i=0; i<listOfOrders.size();i++){
            if(listOfOrders.get(i).getOrderId()==(id)){
                return listOfOrders.get(i);
            }

        }
        return null;
    }
@PutMapping("/update")
    public Order updateOrder(@RequestBody Order order){

    int id=0;
        for(int i=0; i<listOfOrders.size();i++) {
            if (listOfOrders.get(i).getOrderId() == (order.getOrderId())) {
                id = order.getOrderId();
                break;
            }
        }
        //updated
         Order upOrder= new Order();
        upOrder.setOrderId(id);
        upOrder.setItemName(order.getItemName());
        upOrder.setPrice(order.getPrice());
        upOrder.setTime(order.getTime());
        upOrder.setRestaurantName(order.getRestaurantName());
        upOrder.setDeliveryAddress(order.getDeliveryAddress());

        listOfOrders.add(id,upOrder);
        return upOrder;

    }
    @DeleteMapping("/delete/{oderId}")
    public String deleteOrder(@PathVariable("oderId") int id){
       // listOfOrders.remove(id);
        listOfOrders.removeIf(order-> order.getOrderId()==(id));
        return "Oder id"+id+ " id cancelled!!";
    }
}
