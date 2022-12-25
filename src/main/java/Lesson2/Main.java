package Lesson2;

public class Main {

    static String[][] arrayDataException = {{"1","2","3","4"}, {"2","3","Б","5"},{"4","5","6","7"},{"9","8","7","6"}};
    static String[][] arraySizeException = {{"3","7"}, {"2","8"}, {"4","6"}, {"1","8"}};


    public static void main(String[] args) {

        try {
            System.out.println(getSum(arraySizeException));
        } catch (MyArraySizeException | MyArrayDataException ex){
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println(getSum(arrayDataException));
        } catch (MyArraySizeException | MyArrayDataException ex){
            System.out.println(ex.getMessage());
        }

    }

    static void checkSizeArray(String[][] array) throws MyArraySizeException{
        if (array.length != 4 || array[0].length != 4) throw new MyArraySizeException();
    }

    static int getSum(String[][] array) throws MyArraySizeException, MyArrayDataException{
        checkSizeArray(array);
        Integer result = 0;
        for (int i = 0; i< array.length; i++)
            for (int j = 0; j < array[i].length; j++){
                try {
                    result = result + Integer.parseInt(array[i][j]);
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException("Ошибка в позиции: " + i+","+j);
                }
            }

        return result;
    }
}