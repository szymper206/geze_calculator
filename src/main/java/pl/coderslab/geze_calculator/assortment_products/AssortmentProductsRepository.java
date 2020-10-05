package pl.coderslab.geze_calculator.assortment_products;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.geze_calculator.assortment.Assortment;

import java.util.List;

public interface AssortmentProductsRepository extends JpaRepository<AssortmentProducts, Long> {
    List<AssortmentProducts> findAllByAssortment (Assortment assortment);
}
