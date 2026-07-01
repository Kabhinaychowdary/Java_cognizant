public class Forecasting {
    public static double calculateFutureValue(double pv, double growthRate, int periods) {
        if (periods <= 0) {
            return pv;
        }
        return calculateFutureValue(pv * (1 + growthRate), growthRate, periods - 1);
    }

    public static double calculateFutureValueIterative(double pv, double growthRate, int periods) {
        double value = pv;
        double factor = 1 + growthRate;
        for (int i = 0; i < periods; i++) {
            value *= factor;
        }
        return value;
    }
}
