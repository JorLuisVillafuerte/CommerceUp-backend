package ar.com.commerceup.service;

import ar.com.commerceup.dao.OrderDetailDAO;
import ar.com.commerceup.domain.OrderDetail;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImp implements OrderDetailService{

    @Autowired
    OrderDetailDAO orddetail;
    
    @Override
    public OrderDetail save(OrderDetail orderdetail) {
        return orddetail.save(orderdetail);
    }

    @Override
    public List<OrderDetail> findAll() {
        return (List<OrderDetail>) orddetail.findAll();
    }

    @Override
    public Optional<OrderDetail> findById(Integer id) {
        return orddetail.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return orddetail.existsById(id);
    }

    @Override
    public void deleteById(Integer id) {
        orddetail.deleteById(id);
    }

    @Override
    public void delete(OrderDetail orderdetail) {
        orddetail.delete(orderdetail);
    }
    
}
