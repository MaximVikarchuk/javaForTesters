package hw2;

public class Main {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] matrix1 = {
                {"1", "2", "3", "4"},
                {"4", "3", "2", "1"},
                {"1", "1", "2", "4"},
                {"1", "5", "3", "2"}
        };

        int sum = 0;

        if (matrix1.length != 4) throw new MyArraySizeException();
        if (matrix1[0].length != 4) throw new MyArraySizeException();

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                try {
                    sum += Integer.parseInt(matrix1[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Wrong value on place: " + i + " x " + j);
                }
            }

        }
        System.out.println(sum);
    }
}