package ar.com.commerceup.service;

import ar.com.commerceup.dao.OrderDAO;
import ar.com.commerceup.domain.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService{
    
    @Autowired
    OrderDAO orderdao;
    
    @Override
    public Order save(Order order) {
        return orderdao.save(order);
    }

    @Override
    public List<Order> findAll() {
        return (List<Order>) orderdao.findAll();
    }

    @Override
    public Optional<Order> findByOrderCode(String ordercode) {
        return orderdao.findByOrderCode(ordercode);
    }

    @Override
    public Optional<Order> findById(Integer id) {
        return orderdao.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return orderdao.existsById(id);
    }

    @Override
    public void deleteById(Integer id) {
        orderdao.deleteById(id);
    }

    @Override
    public void delete(Order order) {
        orderdao.delete(order);
    }
    
}
