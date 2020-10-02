package pl.coderslab.geze_calculator.product_type;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.geze_calculator.product_group.ProductGroup;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
}
