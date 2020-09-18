package ar.com.commerceup.service;

import ar.com.commerceup.domain.OrderDetail;
import java.util.List;
import java.util.Optional;

public interface OrderDetailService {
    public OrderDetail save(OrderDetail orderdetail);
    public List<OrderDetail> findAll();
    public Optional<OrderDetail> findById(Integer id);
    public boolean existsById(Integer id);
    public void deleteById(Integer id);
    public void delete(OrderDetail orderdetail);
}
