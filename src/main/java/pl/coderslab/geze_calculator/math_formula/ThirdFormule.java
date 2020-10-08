package pl.coderslab.geze_calculator.math_formula;


import org.springframework.stereotype.Service;

@Service("THIRD")
class ThirdFormule implements MathematicalFormule {

    @Override
    public double calculate(Double width, Double hight) {
        return 0;
    }
}
