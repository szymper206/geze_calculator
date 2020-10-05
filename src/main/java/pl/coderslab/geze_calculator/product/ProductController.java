package pl.coderslab.geze_calculator.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.geze_calculator.math_formula.MathFormula;
import pl.coderslab.geze_calculator.math_formula.MathFormulaService;
import pl.coderslab.geze_calculator.product_type.ProductType;
import pl.coderslab.geze_calculator.product_type.ProductTypeService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final ProductTypeService productTypeService;
    private final MathFormulaService mathFormulaService;

    @ModelAttribute("productTypes")
    public List<ProductType> getAllProductTypes() {
        return productTypeService.findAllProductType();
    }

    @ModelAttribute("mathFormulas")
    public List<MathFormula> getAllMathFormulas() {
        return mathFormulaService.findAllMathFormulas();
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product/productForm";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute @Valid Product product,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "product/productForm";
        }
        productService.saveProduct(product);
        return "redirect:/product/all";
    }

    @GetMapping("/all")
    public String findAllProducts(Model model) {
        model.addAttribute("products", productService.findAllProduct());
        return "product/allProduct";
    }

    @GetMapping("/edit/{id}")
    public String showEditProductType(@PathVariable long id,
                                          Model model) {
        Optional<Product> product = productService.findProductById(id);
        if (!product.isPresent()) {
            model.addAttribute("errorMessage", "Nie odnaleziono danego towaru");
            return "error";
        }
        model.addAttribute("product", product.get());
        return "product/productForm";
    }

    @PostMapping("/edit/{id}")
    public String saveEditedProduct(@Valid Product product,
                                        BindingResult result,
                                        @PathVariable long id,
                                        Model model) {
        if (result.hasErrors()) {
            return "product/productForm";
        }
        if (product.getId() != id) {
            model.addAttribute("errorMessage", "id sie nie zgadzają");
            return "error";
        }
        productService.saveProduct(product);
        return "redirect:/product/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable long id, Model model) {
        Optional<Product> product = productService.findProductById(id);
        if (!product.isPresent()) {
            model.addAttribute("errorMessage", "Nie odnaleziono danego towaru");
            return "error";
        }
        model.addAttribute("product", product.get());
        return "product/confirmProduct";
    }

    @PostMapping("/delete/{id}")
    public String deleteProduct(@Valid Product product,
                                    BindingResult result,
                                    @PathVariable long id,
                                    Model model) {
        if (result.hasErrors()) {
            return "product/confirmProduct";
        }
        if (product.getId() != id) {
            model.addAttribute("errorMessage", "id sie nie zgadzają");
            return "error";
        }
        productService.deleteProduct(product);
        return "redirect:/product/all";
    }

}
