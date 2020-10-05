package pl.coderslab.geze_calculator.product_group;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/productGroup")
public class ProductGroupController {
    private final ProductGroupService productGroupService;

    @GetMapping("/add")
    public String addProductGroup(Model model) {
        model.addAttribute("productGroup", new ProductGroup());
        return "productGroup/productGroupForm";
    }

    @PostMapping("/add")
    public String addProductGroup(@ModelAttribute @Valid ProductGroup productGroup,
                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "productGroup/productGroupForm";
        }
        productGroupService.saveProductGroup(productGroup);
        return "redirect:/productGroup/all";
    }

    @GetMapping("/all")
    public String findAllProductGroups(Model model) {
        model.addAttribute("productGroups", productGroupService.findAllProductGroup());
        return "productGroup/allProductGroup";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductGroupForm(@PathVariable long id,
                                   Model model) {
        Optional<ProductGroup> productGroup = productGroupService.findProductGroupById(id);
        if (!productGroup.isPresent()) {
            model.addAttribute("errorMessage", "Nie odnaleziono danej grupy towarów");
            return "error";
        }
        model.addAttribute("productGroup", productGroup.get());
        return "productGroup/productGroupForm";
    }

    @PostMapping("/edit/{id}")
    public String saveEditedProductGroup(@Valid ProductGroup productGroup,
                                 BindingResult result,
                                 @PathVariable long id,
                                 Model model) {
        if (result.hasErrors()) {
            return "productGroup/productGroupForm";
        }
        if (productGroup.getId() != id) {
            model.addAttribute("errorMessage", "id sie nie zgadzają");
            return "error";
        }
        productGroupService.saveProductGroup(productGroup);
        return "redirect:/productGroup/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteProductGroup(@PathVariable long id, Model model) {
        Optional<ProductGroup> productGroup = productGroupService.findProductGroupById(id);
        if (!productGroup.isPresent()) {
            model.addAttribute("errorMessage", "Nie odnaleziono danej grupy towarów");
            return "error";
        }
        model.addAttribute("productGroup", productGroup.get());
        return "productGroup/confirmProductGroup";
    }

    @PostMapping("/delete/{id}")
    public String deleteProductGroup(@Valid ProductGroup productGroup,
                             BindingResult result,
                             @PathVariable long id,
                             Model model) {
        if (result.hasErrors()) {
            return "productGroup/confirmProductGroup";
        }
        if (productGroup.getId() != id) {
            model.addAttribute("errorMessage", "id sie nie zgadzają");
            return "error";
        }
        productGroupService.deleteProductGroup(productGroup);
        return "redirect:/productGroup/all";
    }


}
