package Lesson3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // 1е задание
        Integer arr1[] = {1, 2, 3, 4, 5, 6, 7};
        String arr2[] = {"A", "B", "C"} ;
        swap(arr1,0,4);
        swap(arr2,1,2);

        // 2е задание

        Box<Orange> orange1 = new Box<>();
        Box<Orange> orange2 = new Box<>();
        Box<Apple> apple1 = new Box<>();
        Box<Apple> apple2 = new Box<>();
        orange1.addFruit(new Orange(),10);
        orange2.addFruit(new Orange(),12);
        apple1.addFruit(new Apple(),8);
        apple2.addFruit(new Apple(),4);
        System.out.println("Вес [Box 1]: "+orange1.getWeight());
        System.out.println("Вес [Box 2]: "+orange2.getWeight());
        System.out.println("Вес [Box 3]: "+apple1.getWeight());
        System.out.println("Вес [Box 4]: "+apple2.getWeight());
        System.out.println("[Box 1] сравниваем с [box 3]: "+orange1.compare(apple1));
        System.out.println("[Box 2] сравниваем с [box 4]: "+orange2.compare(apple2));
        System.out.println("Пересыпаем фрукты из коробок:");
        orange1.pourTo(orange2);
        apple1.pourTo(apple2);
        System.out.println("Вес коробок после пересыпания:");
        System.out.println("[Box 1]: "+orange1.getWeight());
        System.out.println("[Box 2]: "+orange2.getWeight());
        System.out.println("[Box 3]: "+apple1.getWeight());
        System.out.println("[Box 4]: "+apple2.getWeight());

    }
    //1е задание
    public static void swap(Object[] arr, int n1, int n2){
        Object ob = arr[n1];
        arr[n1]=arr[n2];
        arr[n2]=ob;
        System.out.println(Arrays.toString(arr));
    }

    // 2е задание




}
