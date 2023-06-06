import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        mergeSortClass mergesortClass = new mergeSortClass(); // mergesortclass nesnesinin oluşturulması
        QuickSortClass quickSortClass = new QuickSortClass();// quicksortclass nesnesinin oluşturulması
        Scanner scanner = new Scanner(System.in);

        boolean loopController = true; // menü kontrolü
        while(loopController) { // menü
        System.out.println("1) Merge Sort (Two Parts)");
        System.out.println("2) Merge Sort (Three Parts)");
        System.out.println("3) Quick Sort (First Element)");
        System.out.println("4) Quick Sort (Random Element)");
        System.out.println("5) Quick Sort (Mid Of First Mid Last Element)");
        System.out.println("6) EXIT");
        System.out.print("Enter your choice:");
        int choice = scanner.nextInt(); //input alma
        int typeOfInteger;  // equal, random, increasing, decrasing tipini tutmak için değişken
        int createIntegers; // 1000, 10000, 100000 veri miktarını tutmak için değişken
        int[] x; // veri seti


            switch (choice) {
                case 1:         //2 part merge sort algoritmasını kullanma case'i
                    typeOfInteger = integerType();  // fonksiyon çağırarak veri sıralanışını input alma
                    createIntegers = printAmountOfIntegers();   // fonksiyon çağırarak veri miktarını alma
                    x = IntegerArrays(typeOfInteger, createIntegers);   // fonksiyon çağırarak istenilen sıralanış ve miktara göre dizi oluşturma
                    long startTime = System.currentTimeMillis();    // runtime süre başlatılması
                    mergesortClass.mergeSort(x, 2); //merge sort class'ından 2 part merge sort algoritmasını çağırma
                    long estimatedTime = System.currentTimeMillis() - startTime;    //runtime süresi hesaplanması
                    System.out.println(estimatedTime);
                    break;
                case 2:     //3 part merge sort algoritmasını kullanma case'i
                    typeOfInteger = integerType();  // fonksiyon çağırarak veri sıralanışını input alma
                    createIntegers = printAmountOfIntegers();   // fonksiyon çağırarak veri miktarını alma
                    x = IntegerArrays(typeOfInteger, createIntegers);   // fonksiyon çağırarak istenilen sıralanış ve miktara göre dizi oluşturma
                    long startTimeMergeSort3Way = System.currentTimeMillis();    // runtime süre başlatılması
                    mergeSortClass.mergeSort(x,3); //merge sort class'ından 3 part merge sort algoritmasını çağırma
                    long estimatedTimeMergeSort3Way = System.currentTimeMillis() - startTimeMergeSort3Way;    //runtime süresi hesaplanması
                    System.out.println(estimatedTimeMergeSort3Way);
                    break;

                case 3:     //First element pivot quick sort algoritmasını kullanma case'i
                    typeOfInteger = integerType();  // fonksiyon çağırarak veri sıralanışını input alma
                    createIntegers = printAmountOfIntegers();   // fonksiyon çağırarak veri miktarını alma
                    x = IntegerArrays(typeOfInteger, createIntegers);   // fonksiyon çağırarak istenilen sıralanış ve miktara göre dizi oluşturma
                    long startTimeQuickSortFirstPivotElement = System.currentTimeMillis();    // runtime süre başlatılması
                    QuickSortClass.quickSort(x,"firstelement"); //quicksort class'ından first element pivot quick sort algoritmasını çağırma
                    long estimatedTimeQuickSortFirstPivotElement = System.currentTimeMillis() - startTimeQuickSortFirstPivotElement;    //runtime süresi hesaplanması
                    System.out.println(estimatedTimeQuickSortFirstPivotElement);
                    break;

                case 4:     //random element pivot quick sort algoritmasını kullanma case'i
                    typeOfInteger = integerType();  // fonksiyon çağırarak veri sıralanışını input alma
                    createIntegers = printAmountOfIntegers();   // fonksiyon çağırarak veri miktarını alma
                    x = IntegerArrays(typeOfInteger, createIntegers);   // fonksiyon çağırarak istenilen sıralanış ve miktara göre dizi oluşturma
                    long startTimeQuickSortRandomPivotElement = System.currentTimeMillis();    // runtime süre başlatılması
                    QuickSortClass.quickSort(x,"randomelement"); //quicksort class'ından random element pivot quick sort algoritmasını çağırma
                    long estimatedTimeQuickSortRandomPivotElement = System.currentTimeMillis() - startTimeQuickSortRandomPivotElement;    //runtime süresi hesaplanması
                    System.out.println(estimatedTimeQuickSortRandomPivotElement);
                    break;

                case 5:     //median element pivot quick sort algoritmasını kullanma case'i
                    typeOfInteger = integerType();  // fonksiyon çağırarak veri sıralanışını input alma
                    createIntegers = printAmountOfIntegers();   // fonksiyon çağırarak veri miktarını alma
                    x = IntegerArrays(typeOfInteger, createIntegers);   // fonksiyon çağırarak istenilen sıralanış ve miktara göre dizi oluşturma
                    long startTimeQuickSortMiddlePivotElement = System.currentTimeMillis();    // runtime süre başlatılması
                    QuickSortClass.quickSort(x,"medianelement"); //quicksort class'ından median element pivot quick sort algoritmasını çağırma
                    long estimatedTimeQuickSortMiddlePivotElement = System.currentTimeMillis() - startTimeQuickSortMiddlePivotElement;    //runtime süresi hesaplanması
                    System.out.println(estimatedTimeQuickSortMiddlePivotElement);
                    break;
                case 6:       //exit case

                    loopController=false;
                    break;

                default:        //incorrect choice case'i
                    System.out.println("Please enter correct choice!");
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    break;
            }
        x=null;
        }
        scanner.close();


    }
    public static int printAmountOfIntegers(){ // Veri miktarını input alma fonksiyonu. Seçilen rakama göre o miktar döndürülür.
        System.out.println("        1) 1000");
        System.out.println("        2) 10000");
        System.out.println("        3) 100000");
        System.out.print("        Enter your choice:");
        Scanner scanner = new Scanner(System.in);
        int amountChoice = scanner.nextInt();
        return amountChoice;
    }

    public static int integerType(){ // Veri dizilişini input alma fonksiyonu. Seçilen rakama göre o tip döndürülür.
        System.out.println("    1)Equal Integers");
        System.out.println("    2)Random Integers");
        System.out.println("    3)Increasing Integers");
        System.out.println("    4)Decreasing Integers");
        System.out.print("    Enter your choice:");
        Scanner scanner = new Scanner(System.in);
        int type = scanner.nextInt();
        return type;
    }

    public static int[] IntegerArrays(int type, int amount){    //menüden seçtiğimiz veri sıralaşını ve miktarını bu fonksiyona göndererek istenilen sıra ve miktarda bir dizi oluşturuyoruz.
        if(type==1 & amount==1){        //1-1 seçim yaptığımızda 1000 integer boyutunda equal integer dizisi oluşturma
            int[] numbers = new int[1000];
            int value = 21;

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = value;
            }
            return numbers;

        }
        else if(type==1 & amount==2){       //1-2 seçim yaptığımızda 10000 integer boyutunda equal integer dizisi oluşturma
            int[] numbers = new int[10000];
            int value = 21;

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = value;
            }
            return numbers;
        }
        else if(type==1 & amount==3){       //1-3 seçim yaptığımızda 100000 integer boyutunda equal integer dizisi oluşturma
            int[] numbers = new int[100000];
            int value = 21;

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = value;
            }
            return numbers;
        }
        else if(type==2 & amount==1){       //2-1 seçim yaptığımızda 1000 integer boyutunda random integer dizisi oluşturma
            int[] numbers = new int[1000];
            Random rand = new Random();

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = rand.nextInt(1000);
            }
            return numbers;
        }
        else if(type==2 & amount==2){       //2-2 seçim yaptığımızda 10000 integer boyutunda random integer dizisi oluşturma
            int[] numbers = new int[10000];
            Random rand = new Random();

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = rand.nextInt(10000);
            }
            return numbers;
        }
        else if(type==2 & amount==3){       //2-3 seçim yaptığımızda 100000 integer boyutunda random integer dizisi oluşturma
            int[] numbers = new int[100000];
            Random rand = new Random();

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = rand.nextInt(100000);
            }
            return numbers;
        }
        else if(type==3 & amount==1){       //3-1 seçim yaptığımızda 1000 integer boyutunda increasing integer dizisi oluşturma
            int[] numbers = new int[1000];

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = i + 1;
            }
            return numbers;
        }
        else if(type==3 & amount==2){       //3-2 seçim yaptığımızda 10000 integer boyutunda increasing integer dizisi oluşturma
            int[] numbers = new int[10000];

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = i + 1;
            }
            return numbers;
        }
        else if(type==3 & amount==3){       //3-3 seçim yaptığımızda 100000 integer boyutunda increasing integer dizisi oluşturma
            int[] numbers = new int[100000];

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = i + 1;
            }
            return numbers;
        }
        else if(type==4 & amount==1){       //4-1 seçim yaptığımızda 1000 integer boyutunda decreasing integer dizisi oluşturma
            int[] numbers = new int[1000];

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = 1000 - i;
            }
            return numbers;
        }
        else if(type==4 & amount==2){       //4-1 seçim yaptığımızda 10000 integer boyutunda decreasing integer dizisi oluşturma
            int[] numbers = new int[10000];

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = 10000 - i;
            }
            return numbers;
        }
        else if(type==4 & amount==3){       //4-1 seçim yaptığımızda 100000 integer boyutunda decreasing integer dizisi oluşturma
            int[] numbers = new int[100000];

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = 100000 - i;
            }
            return numbers;
        }
        else { return null;}
    }



}
