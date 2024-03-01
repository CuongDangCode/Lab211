package View;


import Controller.CalculatorDAO;


public interface ICalculatorRepository {
    void inputandcalculatorShape();

    class CalculatorRepository implements ICalculatorRepository {
        @Override
        public void inputandcalculatorShape() {
            CalculatorDAO.Instance().inputandcalculatorShape();
        }
    }
}
