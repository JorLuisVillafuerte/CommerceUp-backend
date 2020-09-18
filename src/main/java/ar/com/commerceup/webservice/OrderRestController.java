package ar.com.commerceup.webservice;

import ar.com.commerceup.domain.Category;
import ar.com.commerceup.domain.Order;
import ar.com.commerceup.service.OrderService;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin
@RequestMapping("/ordenes")
@Slf4j
public class OrderRestController {
    
    @Autowired
    OrderService orderservice;
    @GetMapping("/")
    public List<Order> obtener(){
        return orderservice.findAll();
    }
    @PostMapping("/")
    public Order crearOrden(@Valid @RequestBody Order order){
        log.info("categproa add: "+order.toString());
        return orderservice.save(order);
    }
    @GetMapping("/codigo/{codigo}")
    public ResponseEntity obtenerPorCodigo(@PathVariable("codigo") String codigo){
        Optional<Order> ord = orderservice.findByOrderCode(codigo);
        if(!ord.isPresent()){
            throw new ResponseStatusException(
             HttpStatus.NOT_FOUND, "No se encontro una orden con el codigo proporcionado"
        );
        }
        return ResponseEntity.of(ord);                
                   
    }
    @GetMapping("/id/{id}")
    public ResponseEntity obtenerPorId(@PathVariable("id") Integer id){
        Optional<Order> prd = orderservice.findById(id);
        if(!prd.isPresent()){
            throw new ResponseStatusException(
             HttpStatus.NOT_FOUND, "No se encontro una orden con el ID proporcionado"
        );
        }
        return ResponseEntity.of(prd);                
                   
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity borrarPorId(@PathVariable("id") Integer id){
        Optional<Order> prd = orderservice.findById(id);
        if(!prd.isPresent()){
            throw new ResponseStatusException(
             HttpStatus.NOT_FOUND, "No se encontro una orden para borrar con el ID proporcionado"
        );
        }
        orderservice.deleteById(id);
        return ResponseEntity.ok("Se borro correctamente");                
                   
    }
}
