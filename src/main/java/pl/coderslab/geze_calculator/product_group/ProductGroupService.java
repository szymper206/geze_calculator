package pl.coderslab.geze_calculator.product_group;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class ProductGroupService {
    private final ProductGroupRepository productGroupRepository;

    public void saveProductGroup(ProductGroup productGroup) {
        productGroupRepository.save(productGroup);
    }

    public Optional<ProductGroup> findProductGroupById(long id) {
        return productGroupRepository.findById(id);
    }

    public void deleteProductGroup(ProductGroup productGroup) {
        productGroupRepository.delete(productGroup);
    }

    public List<ProductGroup> findAllProductGroup() {
        return productGroupRepository.findAll();
    }
}
