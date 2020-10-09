package pl.coderslab.geze_calculator.assortment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.geze_calculator.assortment_products.AssortmentProducts;
import pl.coderslab.geze_calculator.math_formula.MathematicalFormule;
import pl.coderslab.geze_calculator.product.Product;
import pl.coderslab.geze_calculator.product.ProductService;
import pl.coderslab.geze_calculator.product_group.ProductGroup;
import pl.coderslab.geze_calculator.product_type.ProductType;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AssortmentService {
    private final AssortmentRepository assortmentRepository;
    private final ProductService productService;
    private final Map<String, MathematicalFormule> wzory;

    public void saveAssortment(Assortment assortment) {

        assortmentRepository.save(assortment);
    }

    public Optional<Assortment> findAssortmentById(long id) {
        return assortmentRepository.findById(id);
    }

    public void deleteAssortment(Assortment assortment) {
        assortmentRepository.delete(assortment);
    }

    public List<Assortment> findAllAssortment() {
        return assortmentRepository.findAll();
    }

    public void saveAssortmentWithProductsAssortment(Assortment assortment) {
        ProductType productType = assortment.getProductType();
        List<Product> products = productService.findAllProductsByProductType(productType);
        products.forEach(product -> {
            AssortmentProducts assortmentProducts = new AssortmentProducts();
            assortmentProducts.setIdNumber(product.getIdNumber());
            assortmentProducts.setName(product.getName());
            assortmentProducts.setAssortment(assortment);
            if (product.getMathFormula() == null) {
                assortmentProducts.setQuantity(product.getDefQuantity());
            } else {
                assortmentProducts.setQuantity(wzory.get(product.getMathFormula().getName()).calculate(assortment.getWidth(), 0D));
            }
            assortment.getAssortmentProducts().add(assortmentProducts);
        });
        ProductGroup productGroup = productType.getProductGroup();
        assortment.setProductGroup(productGroup);
        assortmentRepository.save(assortment);
    }
}
