package pl.coderslab.geze_calculator.product_type;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.geze_calculator.product_group.ProductGroup;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class ProductTypeService {
    private final ProductTypeRepository productTypeRepository;

    public void saveProductType(ProductType productType) {
        productTypeRepository.save(productType);
    }

    public Optional<ProductType> findProductTypeById(long id) {
        return productTypeRepository.findById(id);
    }

    public void deleteProductType(ProductType productGroup) {
        productTypeRepository.delete(productGroup);
    }

    public List<ProductType> findAllProductType() {
        return productTypeRepository.findAll();
    }

    public List<ProductType> findProductTypesByProductGroup(ProductGroup productGroup) {
        return productTypeRepository.findAllByProductGroup(productGroup);
    }
}
