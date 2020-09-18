package ar.com.commerceup.dao;

import ar.com.commerceup.domain.OrderDetail;
import org.springframework.data.repository.CrudRepository;


public interface OrderDetailDAO extends CrudRepository<OrderDetail, Integer>{
 
}
