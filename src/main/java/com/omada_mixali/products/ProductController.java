package com.omada_mixali.products;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductRepository productRepo;

    public ProductController(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Integer id) {
        return productRepo.findById(id).orElseThrow();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productRepo.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product productData) {
        Product product = productRepo.findById(id).orElse(null);
        if(product != null) {
            product.setDescription((productData.getDescription()));
            product.setPrice((productData.getPrice()));
            return productRepo.save(product);
        }
        return  null;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        productRepo.deleteById(id);
    }
}
