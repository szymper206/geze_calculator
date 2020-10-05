package pl.coderslab.geze_calculator.assortment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.geze_calculator.product_group.ProductGroup;
import pl.coderslab.geze_calculator.product_group.ProductGroupService;
import pl.coderslab.geze_calculator.product_type.ProductType;
import pl.coderslab.geze_calculator.product_type.ProductTypeService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/assortment")
public class AssortmentController {

    private final AssortmentService assortmentService;
    private final ProductTypeService productTypeService;
    private final ProductGroupService productGroupService;

    @ModelAttribute("productTypes")
    public List<ProductType> getAllProductTypes() {
        return productTypeService.findAllProductType();
    }

    @ModelAttribute("productGroups")
    public List<ProductGroup> getAllProductGroups() {
        return productGroupService.findAllProductGroup();
    }

    @GetMapping("/add")
    public String addAssortment(Model model) {
        model.addAttribute("assortment", new Assortment());
        return "assortment/assortmentForm";
    }

    @PostMapping("/add")
    public String addAssortment(@ModelAttribute @Valid Assortment assortment,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "assortment/assortmentForm";
        }
        assortmentService.saveAssortmentWithProductsAssortment(assortment);
        return "redirect:/assortment/all";
    }

    @GetMapping("/all")
    public String findAllAssortments(Model model) {
        model.addAttribute("assortments", assortmentService.findAllAssortment());
        return "assortment/allAssortment";
    }

    @GetMapping("/edit/{id}")
    public String showEditAssortment(@PathVariable long id,
                                      Model model) {
        Optional<Assortment> assortment = assortmentService.findAssortmentById(id);
        if (!assortment.isPresent()) {
            model.addAttribute("errorMessage", "Nie odnaleziono danego doboru");
            return "error";
        }
        model.addAttribute("assortment", assortment.get());
        return "assortment/assortmentForm";
    }

    @PostMapping("/edit/{id}")
    public String saveEditedAssortment(@Valid Assortment assortment,
                                    BindingResult result,
                                    @PathVariable long id,
                                    Model model) {
        if (result.hasErrors()) {
            return "assortment/assortmentForm";
        }
        if (assortment.getId() != id) {
            model.addAttribute("errorMessage", "id sie nie zgadzają");
            return "error";
        }
        assortmentService.saveAssortment(assortment);
        return "redirect:/assortment/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteAssortment(@PathVariable long id, Model model) {
        Optional<Assortment> assortment = assortmentService.findAssortmentById(id);
        if (!assortment.isPresent()) {
            model.addAttribute("errorMessage", "Nie odnaleziono danego doboru");
            return "error";
        }
        model.addAttribute("assortment", assortment.get());
        return "assortment/confirmAssortment";
    }

    @PostMapping("/delete/{id}")
    public String deleteAssortment(@Valid Assortment assortment,
                                BindingResult result,
                                @PathVariable long id,
                                Model model) {
        if (result.hasErrors()) {
            return "assortment/confirmAssortment";
        }
        if (assortment.getId() != id) {
            model.addAttribute("errorMessage", "id sie nie zgadzają");
            return "error";
        }
        assortmentService.deleteAssortment(assortment);
        return "redirect:/assortment/all";
    }


}
