package pl.coderslab.geze_calculator.math_formula;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.geze_calculator.assortment.Assortment;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MathFormulaService {
    private final MathFormulaRepository mathFormulaRepository;

    public void saveMathFormula(MathFormula mathFormula) {
        mathFormulaRepository.save(mathFormula);
    }

    public Optional<MathFormula> findMathFormulaById(long id) {
        return mathFormulaRepository.findById(id);
    }

    public void deleteMathFormula(MathFormula mathFormula) {
        mathFormulaRepository.delete(mathFormula);
    }

    public List<MathFormula> findAllMathFormulas() {
        return mathFormulaRepository.findAll();
    }
}
