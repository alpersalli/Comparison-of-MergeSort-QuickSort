import java.util.Random;

public class QuickSortClass {
    public static void quickSort(int[] a, String pivotType){ //hangi quick sortu çalıştıılması için değer kontrolü
        if(pivotType=="firstelement"){
            quickSortFirst(a,0,a.length-1); //değişkenin değeri firstelement ise quickSortFirst fonksiyonunu çalıştır
        }
        else if(pivotType=="randomelement"){
            randomPivotSort(a,0,a.length-1);    //değişkenin değeri randomelement ise randomPivotSort fonksiyonunu çalıştır
        }
        else if(pivotType=="medianelement"){
            quicksortmed(a,0,a.length-1);   //değişkenin değeri medianelement ise quickSortmed fonksiyonunu çalıştır
        }
    }

    public static int firstPivotPartition(int arr[], int low, int high)
    {

        int pivot = arr[low];   // ilk elemenı pivot olarak alma
        int st = low; // array'in başlangıç noktasını tutma
        int end = high; // array'in bitiş noktasını tutma
        int k = high;
        for (int i = high; i > low; i--) {
            if (arr[i] > pivot)     // array'in içinde gezerek pivot indeksin değerinden büyük olan değerleri array'in sonuna swaplama
                swap(arr, i, k--);
        }
        swap(arr, low, k); // array'in başlangıç değerinide array'in sonuna swaplama
        return k;
    }


    public static void swap(int[] arr, int i, int j)
    {       //array'in i indeksini temp'e atayıp, parametrelerdeki j indeksiyle i indeksin değerlerini yer değiştirme fonksiyonu
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSortFirst(int arr[], int low, int high)
    {

        if (low < high) { // low değeri high değerinden küçükse
            //pivot elemenanın indeksi sorted konumdadır
            int idx = firstPivotPartition(arr, low, high);


            //recursive fonksiyon
            quickSortFirst(arr, low, idx - 1); // arrayin parçalanarak sortlanması
            quickSortFirst(arr, idx + 1, high); // arrayin parçalanarak sortlanması
        }
    }

    public static void random(int arr[],int low,int high)
    {
        //array'in içinden random bir indeksi pivot seçme
        Random rand= new Random();
        int pivot = rand.nextInt(high-low)+low;

        int temp1=arr[pivot];   // bu random indeks değerini(pivot) array'in sonuna atama
        arr[pivot]=arr[high];
        arr[high]=temp1;
    }

    public static int randomPartition(int arr[], int low, int high)
    {
        //random fonksiyonunu çağırarak random pivot seçme
        random(arr,low,high);
        int pivot = arr[high];


        int i = (low-1); //küçük elementin indeksi
        for (int j = low; j < high; j++)
        {
            //array'in j indeksindeki değer pivottan küçükse
            if (arr[j] < pivot)
            {
                i++;

                //array'in i indeksini ve j indeksini swapla
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];       //array'in i+1 indeksi ile high(pivot) indeksini swapla
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }



    public static void randomPivotSort(int arr[], int low, int high)
    {
        if (low < high) // low değeri high değerinden küçükse
        {
            //pivot elemenanın indeksi sorted konumdadır
            int pi = randomPartition(arr, low, high);

            //recursive fonksiyon
            randomPivotSort(arr, low, pi-1); // arrayin parçalanarak sortlanması
            randomPivotSort(arr, pi+1, high); // arrayin parçalanarak sortlanması
        }
    }


        public static void quicksortmed(int[] a, int low, int high) {
        int i = low, j = high;
        // Pivot değerini array'in ortasından alınması
        int pivot = a[low + (high-low)/2];

        //array'in 2 diziye bölünüp medyanın bulunması
        while (i <= j) {
            //sol indeksteki değer pivotun değerinden küçükse sol indeksten bir sonraki değeri alma
            while (a[i] < pivot) {
                i++;
            }
            //sağ indeksteki değer pivotun değerinden büyükse sağ indeksten bir sonraki değeri alma
            while (a[j] > pivot) {
                j--;
            }

            // sol indekste pivottan büyük ve sağ indekste pivottan küçük değer bulunursa bu değerler swaplanır
            if (i <= j) {
                swap(a,i, j);
                i++; //swaplandıktan sonra i'yi bir arttırabiliriz, ve j'yi bir azaltabiliriz
                j--;
            }
        }
        // Recursion
        if (low < j) // low değeri j değerinden küçükse
            quicksortmed(a,low, j); // tekrar quicksortmed fonksiyonunu çağır
        if (i < high)   //i değeri high değerinden küçükse
            quicksortmed(a,i, high); // tekrar quicksortmed fonksiyonunu çağır
    }

}
