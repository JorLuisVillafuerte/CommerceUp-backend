package ar.com.commerceup.service;

import ar.com.commerceup.domain.Order;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    public Order save(Order order);
    public List<Order> findAll();
    public Optional<Order> findByOrderCode(String ordercode);
    public Optional<Order> findById(Integer id);
    public boolean existsById(Integer id);
    public void deleteById(Integer id);
    public void delete(Order order);
}
