package pwo.lab13.app;

import java.util.List;
import java.util.ArrayList;
import pwo.lab13.app.ProcessData.Action;

public class ProcessArgs {

    /*
 Wyszukuje w tablicy stringów pozycję, która może być
 zinterpretowana jako wartość typu ProcessData.Action.
 Wielkość czcionki nie ma znaczenia. Obowiązuje
 pierwsze dopasowanie. Jeżeli nie znajdzie to zwraca
 wartość UNDEFINE.
     */
    public static Action getAction(String[] args) {
        String max = Action.MAX.toString();
        String sum = Action.SUM.toString();

        for (String arg : args) {
            arg = arg.toUpperCase();
            if (arg.equals(max)) {
                return Action.MAX;
            }
            if (arg.equals(sum)) {
                return Action.SUM;
            }
        }

        return Action.UNDEFINE;
    }


    /*
 Wyszukuje w tablicy stringów pozycje, które mogą być
 zinterpretowane jako liczby. Tworzy z tych liczb
 tablicę. Jeżeli nie ma liczb to zwraca pustą tablicę.
     */
    public static double[] getNumbers(String[] args) {
        List<Double> numbers = new ArrayList<Double>();

        for (String arg : args) {
            if (isNumeric(arg)) {
                numbers.add(Double.valueOf(arg));
            }
        }

        if (numbers.isEmpty()) {
            return new double[0];
        }

        return numbers.stream().mapToDouble(d -> d).toArray();
    }

    public static boolean isNumeric(String str) {
        try {
            Double.valueOf(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}