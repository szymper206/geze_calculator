package pl.coderslab.geze_calculator.assortment_products;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.geze_calculator.assortment.Assortment;

@RequiredArgsConstructor
@Controller
@RequestMapping("/assortmentProduct")
public class AssortmentProductsController {
    private final AssortmentProductsService assortmentProductsService;

    @GetMapping("/all/{assortment}")
    public String findAllProductsAssortmentByAssortment(@PathVariable Assortment assortment, Model model) {
        model.addAttribute("assortmentProducts", assortmentProductsService.findAllByAssortment(assortment));
        model.addAttribute("assortment", assortment);
        return "assortmentProducts/assortmentProductsAll";
    }
}
