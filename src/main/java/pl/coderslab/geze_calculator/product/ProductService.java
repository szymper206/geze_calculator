package pl.coderslab.geze_calculator.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public Optional<Product> findProductById(long id) {
        return productRepository.findById(id);
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }
}
