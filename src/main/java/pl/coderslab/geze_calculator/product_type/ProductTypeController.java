package pl.coderslab.geze_calculator.product_type;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.geze_calculator.product_group.ProductGroup;
import pl.coderslab.geze_calculator.product_group.ProductGroupService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Controller
@RequestMapping("/productType")
public class ProductTypeController {
    private final ProductTypeService productTypeService;
    private final ProductGroupService productGroupService;

    @ModelAttribute("productGroups")
    public List<ProductGroup> getAllProductGroups() {
        return productGroupService.findAllProductGroup();
    }

    @GetMapping("/add")
    public String addProductType(Model model) {
        model.addAttribute("productType", new ProductType());
        return "productType/productTypeForm";
    }

    @PostMapping("/add")
    public String addProductType(@ModelAttribute @Valid ProductType productType,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "productType/productTypeForm";
        }
        productTypeService.saveProductType(productType);
        return "redirect:/productType/all";
    }

    @GetMapping("/all")
    public String findAllProductTypes(Model model) {
        model.addAttribute("productTypes", productTypeService.findAllProductType());
        return "productType/allProductType";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductTypeForm(@PathVariable long id,
                                           Model model) {
        Optional<ProductType> productType = productTypeService.findProductTypeById(id);
        if (!productType.isPresent()) {
            model.addAttribute("errorMessage", "Nie odnaleziono danego typu towaru");
            return "error";
        }
        model.addAttribute("productType", productType.get());
        return "productType/productTypeForm";
    }

    @PostMapping("/edit/{id}")
    public String saveEditedProductType(@Valid ProductType productType,
                                         BindingResult result,
                                         @PathVariable long id,
                                         Model model) {
        if (result.hasErrors()) {
            return "productType/productTypeForm";
        }
        if (productType.getId() != id) {
            model.addAttribute("errorMessage", "id sie nie zgadzają");
            return "error";
        }
        productTypeService.saveProductType(productType);
        return "redirect:/productType/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteProductType(@PathVariable long id, Model model) {
        Optional<ProductType> productType = productTypeService.findProductTypeById(id);
        if (!productType.isPresent()) {
            model.addAttribute("errorMessage", "Nie odnaleziono danego typu towaru");
            return "error";
        }
        model.addAttribute("productType", productType.get());
        return "productType/confirmProductType";
    }

    @PostMapping("/delete/{id}")
    public String deleteProductType(@Valid ProductType productType,
                             BindingResult result,
                             @PathVariable long id,
                             Model model) {
        if (result.hasErrors()) {
            return "productType/confirmProductType";
        }
        if (productType.getId() != id) {
            model.addAttribute("errorMessage", "id sie nie zgadzają");
            return "error";
        }
        productTypeService.deleteProductType(productType);
        return "redirect:/productType/all";
    }

}
