package uz.pdp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.entity.Category;
import uz.pdp.entity.Product;
import uz.pdp.model.ProductDto;
import uz.pdp.repository.CategoryRepo;
import uz.pdp.repository.ProductRepo;

import java.util.Optional;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;


    @PreAuthorize(value = "hasAuthority('POST')")
    @PostMapping
    public ResponseEntity<?> add(@RequestBody ProductDto dto) {
        return getResponseEntity(dto);
    }

    @PreAuthorize(value = "hasAuthority('PUT')")
    @PutMapping("{id}")
    public ResponseEntity<?> add(@PathVariable("id") Long id, @RequestBody ProductDto dto) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isEmpty()) return ResponseEntity.status(404).body("Product not found");
        return getResponseEntity(dto);
    }

    @PreAuthorize(value = "hasAuthority('GET_ALL')")
    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(productRepo.findAll());
    }

    @PreAuthorize(value = "hasAuthority('GET')")
    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable(value = "id") Long id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isEmpty()) return ResponseEntity.status(404).body("Product not found");
        return ResponseEntity.ok(optionalProduct.get());
    }

    @PreAuthorize(value = "hasAuthority('DELETE')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isEmpty()) return ResponseEntity.status(404).body("Product not found");
        productRepo.delete(optionalProduct.get());
        return ResponseEntity.ok("Product delete");
    }

    private ResponseEntity<?> getResponseEntity(@RequestBody ProductDto dto) {
        Optional<Category> optionalCategory = categoryRepo.findById(dto.getCategory());
        if (optionalCategory.isEmpty()) return ResponseEntity.status(404).body("Category not found");
        Product product = new Product();
        product.setActive(dto.isActive());
        product.setCategory(optionalCategory.get());
        product.setPrice(dto.getPrice());
        product.setName(dto.getName());
        return ResponseEntity.ok(productRepo.save(product));
    }
}
