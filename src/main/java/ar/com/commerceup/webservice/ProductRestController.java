package ar.com.commerceup.webservice;

import ar.com.commerceup.domain.Category;
import ar.com.commerceup.domain.Product;
import ar.com.commerceup.service.ProductService;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/productos")
@Slf4j
public class ProductRestController {

    @Autowired
    ProductService productservice;

    @GetMapping("/")
    public List<Product> obtenerProductos(){
        return productservice.findAll();
    }    
    @GetMapping("/categoria")
    public List<Product> obtenerProductosPorCategoria(@RequestBody Category category ){
        return productservice.findAllByCategoryId(category);
    }
    
    @PostMapping("/")
    public Product crearProducto(@RequestBody Product producto){
        return productservice.save(producto);
    }
    
    @GetMapping("/codigo/{codigo}")
    public ResponseEntity obtenerPorCodigo(@PathVariable("codigo") String codigo){
        Optional<Product> prd = productservice.findByProductCode(codigo);
        if(!prd.isPresent()){
            throw new ResponseStatusException(
             HttpStatus.NOT_FOUND, "No se encontro un producto con el codigo proporcionado"
        );
        }
        return ResponseEntity.of(prd);                
    }
    @GetMapping("/id/{codigo}")
    public ResponseEntity obtenerPorCodigo(@PathVariable("id") Integer id){
        Optional<Product> prd = productservice.findById(id);
        if(!prd.isPresent()){
            throw new ResponseStatusException(
             HttpStatus.NOT_FOUND, "No se encontro un producto con el ID proporcionado"
        );
        }
        return ResponseEntity.of(prd);                
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity borrarPorId(@PathVariable("id") Integer id){
        Optional<Product> prd = productservice.findById(id);
        if(!prd.isPresent()){
            throw new ResponseStatusException(
             HttpStatus.NOT_FOUND, "No se encontro una categoria para borrar con el ID proporcionado"
        );
        }
        productservice.deleteById(id);
        return ResponseEntity.ok("Se borro correctamente");                
                   
    }
}
