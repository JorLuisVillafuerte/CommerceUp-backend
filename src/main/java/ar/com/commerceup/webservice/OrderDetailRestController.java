package ar.com.commerceup.webservice;

import ar.com.commerceup.domain.Order;
import ar.com.commerceup.domain.OrderDetail;
import ar.com.commerceup.service.OrderDetailService;
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
@RequestMapping("/detalleorden")
@Slf4j
public class OrderDetailRestController {
    
    @Autowired
    OrderDetailService detailservice;
    @GetMapping("/")
    public List<OrderDetail> obtener(){
        return detailservice.findAll();
    }
    @PostMapping("/")
    public OrderDetail crearOrden(@Valid @RequestBody OrderDetail orderdetail){
        log.info("categproa add: "+orderdetail.toString());
        return detailservice.save(orderdetail);
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity obtenerPorId(@PathVariable("id") Integer id){
        Optional<OrderDetail> prd = detailservice.findById(id);
        if(!prd.isPresent()){
            throw new ResponseStatusException(
             HttpStatus.NOT_FOUND, "No se encontro un detalle de orden con el ID proporcionado"
        );
        }
        return ResponseEntity.of(prd);                
                   
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity borrarPorId(@PathVariable("id") Integer id){
        Optional<OrderDetail> prd = detailservice.findById(id);
        if(!prd.isPresent()){
            throw new ResponseStatusException(
             HttpStatus.NOT_FOUND, "No se encontro un detalle de orden para borrar con el ID proporcionado"
        );
        }
        detailservice.deleteById(id);
        return ResponseEntity.ok("Se borro correctamente");                
                   
    }
}
