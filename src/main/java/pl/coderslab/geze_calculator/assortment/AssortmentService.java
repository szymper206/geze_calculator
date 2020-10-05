package pl.coderslab.geze_calculator.assortment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.geze_calculator.assortment_products.AssortmentProducts;
import pl.coderslab.geze_calculator.assortment_products.AssortmentProductsService;
import pl.coderslab.geze_calculator.math_formula.MathPatterns;
import pl.coderslab.geze_calculator.product.Product;
import pl.coderslab.geze_calculator.product.ProductService;
import pl.coderslab.geze_calculator.product_type.ProductType;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AssortmentService {
    private final AssortmentRepository assortmentRepository;
    private final ProductService productService;
    private final AssortmentProductsService assortmentProductsService;

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
        List<Product> products;
        products = productService.findAllProductsByProductType(productType);
        MathPatterns mathPatterns = new MathPatterns();
        for (Product product: products) {
            AssortmentProducts assortmentProducts = new AssortmentProducts();
            assortmentProducts.setIdNumber(product.getIdNumber());
            assortmentProducts.setName(product.getName());
            assortmentProducts.setAssortment(assortment);
            assortmentProducts.setQuantity(mathPatterns.wzorSzynyJezdnejECDrive(assortment.getWidth()));
            assortmentProducts.setQuantity(product.getDefQuantity());
            assortmentProductsService.saveAssortmentProducts(assortmentProducts);
        }
        assortmentRepository.save(assortment);
    }
}
