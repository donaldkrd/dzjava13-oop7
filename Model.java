public class Model extends CalcModel {
    public Model() {

    }

    @Override
    public double result() {
        switch (operation) {
            case "+":
                return x + y;
            case "-":
                return x - y;
            case "*":
                return x * y;
            default:
                return x / y;
        }
    }

    @Override
    public void setX(double value) {
        super.x = value;
    }

    @Override
    public void setY(double value) {
        super.y = value;
    }

    @Override
    public void setOperation(String sign) {
        super.operation = sign;

    }

    // public Double getX () {
    // return x;
    // }

    // public String getOper() {
    // return operation;
    // }
}