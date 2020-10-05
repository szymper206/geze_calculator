package pl.coderslab.geze_calculator.assortment_products;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.geze_calculator.assortment.Assortment;


import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class AssortmentProductsService {
    private final AssortmentProductsRepository assortmentProductsRepository;

    public void saveAssortmentProducts(AssortmentProducts assortmentProducts) {
        assortmentProductsRepository.save(assortmentProducts);
    }

    public List<AssortmentProducts> findAllByAssortment (Assortment assortment) {
        return assortmentProductsRepository.findAllByAssortment(assortment);
    }


}
