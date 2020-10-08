package pl.coderslab.geze_calculator.product_type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.geze_calculator.product_group.ProductGroup;

import java.util.List;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
    List<ProductType> findAllByProductGroup(ProductGroup productGroup);
}
