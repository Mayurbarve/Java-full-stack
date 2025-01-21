public class GenericClass<T, U> {
    protected T base;
    protected U exponent;

    public GenericClass(T base, U exponent) {
        this.base = base;
        this.exponent = exponent;
    }

    public double calculatePower() {
        double baseValue = Double.parseDouble(base.toString());
        double exponentValue = Double.parseDouble(exponent.toString());
        return Math.pow(baseValue, exponentValue);
    }
}