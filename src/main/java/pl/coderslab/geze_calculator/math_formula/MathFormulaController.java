package pl.coderslab.geze_calculator.math_formula;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/mathFormula")
public class MathFormulaController {
    private final MathFormulaService mathFormulaService;


    @GetMapping("/add")
    public String addMathFormula(Model model) {
        model.addAttribute("mathFormula", new MathFormula());
        return "mathFormula/mathFormulaForm";
    }

    @PostMapping("/add")
    public String addMathFormula(@ModelAttribute @Valid MathFormula mathFormula,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "mathFormula/mathFormulaForm";
        }
        mathFormulaService.saveMathFormula(mathFormula);
        return "redirect:/mathFormula/all";
    }

    @GetMapping("/all")
    public String findAllMathFormulas(Model model) {
        model.addAttribute("mathFormulas", mathFormulaService.findAllMathFormulas());
        return "mathFormula/allMathFormulas";
    }

    @GetMapping("/edit/{id}")
    public String getEditMathFormula(@PathVariable long id,
                                      Model model) {
        Optional<MathFormula> mathFormula = mathFormulaService.findMathFormulaById(id);
        if (!mathFormula.isPresent()) {
            model.addAttribute("errorMessage", "Nie odnaleziono danego wzoru");
            return "error";
        }
        model.addAttribute("mathFormula", mathFormula.get());
        return "mathFormula/mathFormulaForm";
    }

    @PostMapping("/edit/{id}")
    public String saveEditedMathFormula(@Valid MathFormula mathFormula,
                                    BindingResult result,
                                    @PathVariable long id,
                                    Model model) {
        if (result.hasErrors()) {
            return "mathFormula/mathFormulaForm";
        }
        if (mathFormula.getId() != id) {
            model.addAttribute("errorMessage", "id sie nie zgadzają");
            return "error";
        }
        mathFormulaService.saveMathFormula(mathFormula);
        return "redirect:/mathFormula/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteMathFormula(@PathVariable long id, Model model) {
        Optional<MathFormula> mathFormula = mathFormulaService.findMathFormulaById(id);
        if (!mathFormula.isPresent()) {
            model.addAttribute("errorMessage", "Nie odnaleziono danego towaru");
            return "error";
        }
        model.addAttribute("mathFormula", mathFormula.get());
        return "mathFormula/confirmMathFormula";
    }

    @PostMapping("/delete/{id}")
    public String deleteMathFormula(@Valid MathFormula mathFormula,
                                BindingResult result,
                                @PathVariable long id,
                                Model model) {
        if (result.hasErrors()) {
            return "mathFormula/confirmMathFormula";
        }
        if (mathFormula.getId() != id) {
            model.addAttribute("errorMessage", "id sie nie zgadzają");
            return "error";
        }
        mathFormulaService.deleteMathFormula(mathFormula);
        return "redirect:/mathFormula/all";
    }
}
