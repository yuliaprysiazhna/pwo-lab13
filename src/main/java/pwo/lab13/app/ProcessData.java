package pwo.lab13.app;

public class ProcessData {

    public enum Action {
        UNDEFINE, SUM, MAX
    }

    public Double process(Action action, double[] numbers) {
        return switch (action) {
            case SUM -> sum(numbers);
            case MAX -> max(numbers);
            default -> null;
        };
    }

    /*
 Sumuje liczby przekazane jako tablica i zwraca wynik.
 Jeżeli tablica jest pusta, to zwraca null.
     */
    private Double sum(double[] numbers) {
        double sum = 0.0;
        
        if (numbers.length == 0) return null;
        for (double num : numbers) {
            sum += num;
        }
        
        return sum;
    }

    /*
 Przeszukuje przekazaną tablicę liczb i zwraca
 maksymalną. Jeżeli tablica jest pusta, to zwraca null.
     */
    private Double max(double[] numbers) {
        if (numbers.length == 0) return null;
        
        double max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        
        return max;
    }
}