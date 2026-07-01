public class ForecastingTest {
    public static void main(String[] args) {
        double pv = 1000.0;
        double growthRate = 0.05;
        int periods = 10;

        double recursiveResult = Forecasting.calculateFutureValue(pv, growthRate, periods);
        double iterativeResult = Forecasting.calculateFutureValueIterative(pv, growthRate, periods);

        System.out.println("Initial Value: $" + pv);
        System.out.println("Growth Rate: " + (growthRate * 100) + "%");
        System.out.println("Periods: " + periods);
        System.out.printf("Future Value (Recursive): $%.2f%n", recursiveResult);
        System.out.printf("Future Value (Iterative): $%.2f%n", iterativeResult);

        if (Math.abs(recursiveResult - iterativeResult) < 1e-9) {
            System.out.println("Success: Both implementations yielded the same results.");
        } else {
            System.out.println("Failure: Output mismatch between implementations.");
        }
    }
}
