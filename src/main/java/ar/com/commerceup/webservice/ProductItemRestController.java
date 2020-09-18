package ar.com.commerceup.webservice;

import ar.com.commerceup.service.ProductItemService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.com.commerceup.domain.ProductItem;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
@RestController
@RequestMapping("/productosItem")
@Slf4j
class ProductItemRestController {
    
    @Autowired
    ProductItemService productitem;
    
    @GetMapping("/")
    public List<ProductItem> obtenerTodos(){
        return productitem.findAll();
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity obtenerPorId(@PathVariable("id")Integer id){
        Optional item = productitem.findById(id);
        if(!item.isPresent()){
            throw new ResponseStatusException(
             HttpStatus.NOT_FOUND, "No se encontro un item con el ID proporcionado");
        }
        return ResponseEntity.of(item);
    }
    @GetMapping("/codigo/{codigo}")
    public ResponseEntity obtenerPorCodigo(@PathVariable("codigo") String codigo){
        Optional item = productitem.findByItemCode(codigo);
        if(!item.isPresent()){
            throw new ResponseStatusException(
             HttpStatus.NOT_FOUND, "No se encontro un item con el codigo proporcionado");
        }
        return ResponseEntity.of(item);
    }
    @PostMapping("/")
    public ProductItem crearItem(@RequestBody ProductItem productitem1){
        return productitem.save(productitem1);
    }
    @PostMapping("/lote")
    public List<ProductItem> crearItemLote(@RequestBody List<ProductItem> productitem1){
        return productitem.saveAll(productitem1);
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity borrarPorId(@PathVariable("id") Integer id){
        if(!productitem.existsById(id)){
            throw new ResponseStatusException(
             HttpStatus.NOT_FOUND, "No se encontro un item con el ID proporcionado");
        }
        productitem.deleteById(id);
        return ResponseEntity.ok("Se borro correctamente");  
    }
}
