/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonsSkafferi.rest.webservices.restfulwebservices.controllers;

import com.antonsSkafferi.rest.webservices.restfulwebservices.services.ItemOrderService;
import com.antonsSkafferi.rest.webservices.restfulwebservices.tables.ItemOrder;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author
 */
@RestController
public class ItemOrderController {
    
    @Autowired
    ItemOrderService itemOrderService = ItemOrderService.getInstance();
    
    
    //Get Requests
    @RequestMapping(value = "/orders")
    //Request GET
    private List<ItemOrder> getAllOrders(){
       return itemOrderService.getAllOrders();
    }
    
    @RequestMapping(value = "/orders/table", params = "dinnertable")
    private List<ItemOrder> getOrderByTable(@RequestParam int dinnertable){
        return itemOrderService.getOrederByTable(dinnertable);
    }
    
    @PostMapping(value = "/post/orders", params = "order")
    private void saveItemOrder(@RequestBody ItemOrder order){
        itemOrderService.saveOrUpdateItemOrder(order);
    }
    
    @RequestMapping(value = "/orders/unready")
    private List<ItemOrder> getUnreadyOrder()
    {
        return itemOrderService.getUnreadyOrders();
    }
    
    @RequestMapping(value = "/orders/ready")
    private List<ItemOrder> getReadyOrders()
    {
        return itemOrderService.getReadyOrders();
    }
    
    @RequestMapping(value = "/orders/sorted")
    private List<ItemOrder> getSortedOrders()
    {
        return itemOrderService.getSortedOrders();
    }
    
    @RequestMapping(value = "/orders/prepare")
    private List<ItemOrder> getOrdersToPrepare()
    {
        return itemOrderService.getOrdersToPrepare();
    }
     
    @PostMapping(value = "/post/ready", params = "dinnertable")
    private void setOrderReady(int dinnertable)
    {
        itemOrderService.setOrderReady(dinnertable);
    }
    
    @PostMapping(value = "/post/delivered", params = "dinnertable")
    private void setOrderDelivered(int dinnertable)
    {
        itemOrderService.setOrderDeliverd(dinnertable);
    }
    
    @RequestMapping(value = "/orders/sum", params= "dinnertable")
    private int getSumOrder(int dinnertable){
        return itemOrderService.getSumOfOrder(dinnertable);
    }
    
    @DeleteMapping(value = "/orders/delete", params= "dinnertable")
    private void deleteOrdersFromTable(int dinnertable){
        itemOrderService.deleteOrdersFromTable(dinnertable);
    }
}
