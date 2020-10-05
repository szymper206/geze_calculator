package pl.coderslab.geze_calculator.product;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.geze_calculator.product_type.ProductType;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByProductType (ProductType productType);
}
