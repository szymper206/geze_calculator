package pl.coderslab.geze_calculator.math_formula;

import org.springframework.stereotype.Service;

@Service("MODULE_CARRIER")
class ModuleCarrierFormule implements MathematicalFormule{

    @Override
    public double calculate(Double width, Double hight) {
        return (width * 2 + 150) - 11;
    }
}
