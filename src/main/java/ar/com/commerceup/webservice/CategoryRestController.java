/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.commerceup.webservice;

import ar.com.commerceup.service.CategoryService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.com.commerceup.domain.Category;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/categorias")
@Slf4j
public class CategoryRestController {
    @Autowired
    CategoryService categoryservice;

    @GetMapping("/")
    public List<Category> obtenerCategorias(){
        return categoryservice.findAll();
    }
    @PostMapping("/")
    public Category crearCategoria(@RequestBody Category category){
        return categoryservice.save(category);
    }
    @GetMapping("/codigo/{codigo}")
    public ResponseEntity obtenerPorCodigo(@PathVariable("codigo") String codigo){
        Optional<Category> cat = categoryservice.findByCategoryCode(codigo);
        if(!cat.isPresent()){
            throw new ResponseStatusException(
             HttpStatus.NOT_FOUND, "No se encontro una categoria con el codigo proporcionado"
        );
        }
        return ResponseEntity.of(cat);                
                   
    }
    @GetMapping("/id/{id}")
    public ResponseEntity obtenerPorId(@PathVariable("id") Integer id){
        Optional<Category> cat = categoryservice.findById(id);
        if(!cat.isPresent()){
            throw new ResponseStatusException(
             HttpStatus.NOT_FOUND, "No se encontro una categoria con el ID proporcionado"
        );
        }
        return ResponseEntity.of(cat);                
                   
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity borrarPorId(@PathVariable("id") Integer id){
        Optional<Category> cat = categoryservice.findById(id);
        if(!cat.isPresent()){
            throw new ResponseStatusException(
             HttpStatus.NOT_FOUND, "No se encontro una categoria para borrar con el ID proporcionado"
        );
        }
        categoryservice.deleteById(id);
        return ResponseEntity.ok("Se borro correctamente");                
                   
    }


}
