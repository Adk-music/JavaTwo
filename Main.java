package geekbrains.lessons.lessonone.lessonTwo;


import java.util.Arrays;



public class Main {



    public static void main(String[] args) {

        String s = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
        String[][] strings = myArray(s);
        System.out.println(cast(strings));

        for (int i = 0; i < strings.length; i++) {
            System.out.println(Arrays.toString(strings[i]));
        }

    }

    private static String[][] myArray(String s){
        String[][] string = new String[4][4];
        String[] split = s.split("\n");
        if(split.length > 4){
            throw new StringArraySizeException("Split length more than 4");
        }
        for (int i = 0; i < string.length; i++) {
            String[] strings2 = split[i].split(" ");
            if (strings2.length > 4){
                throw new StringArraySizeException("Split length more than 4");
            }
            for (int j = 0; j < string.length; j++) {
                string[i][j] = strings2[j];
            }
    }
        return string;
    }

    private static int cast(String[][] myArray){
        int sum = 0;
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray.length ; j++) {
                try {
                    sum += Integer.parseInt(myArray[i][j]);
                } catch (NumberFormatException e){
                    throw new CastStringToIntegerException("Array element is not Int",e);
                }
            }

        }
        return sum/2;
    }



}
