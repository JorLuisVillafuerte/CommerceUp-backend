package ar.com.commerceup.dao;

import org.springframework.data.repository.CrudRepository;
import ar.com.commerceup.domain.Order;
import java.util.Optional;

public interface OrderDAO extends CrudRepository<Order, Integer>{
    public abstract Optional<Order> findByOrderCode(String ordercode);
}
