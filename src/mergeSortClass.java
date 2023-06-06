public class mergeSortClass {


    public  static void mergeSort(int[] a, int k){ //2 veya 3 part merge sortu çalıştırmak için index kontrolü
        if(k==2){
            mergeSort2Way(a,0,a.length-1); //değişkenin değeri 2 ise mergesort2way fonksiyonunu çalıştır
        }
        else if(k==3){
            mergeSort3Way(a);   //değişkenin değeri 3 ise mergesort3way fonksiyonunu çalıştır
        }
    }
    public static void merge(int[] a, int beg, int mid, int end)
    {
        int i, j, k;
        int n1 = mid - beg + 1; // sol taraf sub array'in miktarını tutma
        int n2 = end - mid; // sağ taraf sub array'in miktarını tutma


        int[] LeftArray = new int [n1]; //sub arrayler için geçici dizi oluşturma
        int[] RightArray = new int [n2]; //sub arrayler için geçici dizi oluşturma

        // ana array'in içindeki değerleri sol ve sağ değerlere atama
        for (i = 0; i < n1; i++)
            LeftArray[i] = a[beg + i];
        for (j = 0; j < n2; j++)
            RightArray[j] = a[mid + 1 + j];

        i = 0; //ilk alt array'in başlangıç indeksi
        j = 0; //ikinci alt array'in başlangıç indeksi
        k = beg; //merge'lenmiş alt dizinin başlangıç indeksi

        while (i < n1 && j < n2)
        {
            if(LeftArray[i] <= RightArray[j])
            {
                a[k] = LeftArray[i];
                i++;
            }
            else
            {
                a[k] = RightArray[j];
                j++;
            }
            k++;
        }
        while (i<n1)    //varsa,sol dizinin değerlerini kopyalama
        {
            a[k] = LeftArray[i];
            i++;
            k++;
        }

        while (j<n2)    //varsa,sağ dizinin değerlerini kopyalama
        {
            a[k] = RightArray[j];
            j++;
            k++;
        }
    }
    static void mergeSort2Way(int[] a, int beg, int end)
    {
        if (beg < end)
        {
            int mid = (beg + end) / 2;  //array'in orta noktasını bulma
            mergeSort2Way(a, beg, mid); //array'in sol tarafını sortlama
            mergeSort2Way(a, mid + 1, end); //array'in sağ tarafını sortlama
            merge(a, beg, mid, end);    // sortlanmış değerleri merge'le (birleştir)
        }
    }

    public static void mergeSort3Way(int[] gArray)
    {
        //eğer dizi boşsa null döndür
        if (gArray == null)
            return;

        // verilen dizinin kopyasını oluşturma ve değerleri ona atama
        int[] fArray = new int[gArray.length];
        for (int i = 0; i < fArray.length; i++){
            fArray[i] = gArray[i];
        }


        mergeSort3WayRec(fArray, 0, gArray.length, gArray);      // sortlama fonksiyonunu çağır

        //kopyası alınan dizinin değerlerinin verilen diziye kopyalama
        for (int i = 0; i < fArray.length; i++)
            gArray[i] = fArray[i];
    }


    public static void mergeSort3WayRec(int[] gArray,int low, int high, int[] destArray)
    {
        //eğer dizinin boyutu 1 ise hiçbir şey yapma
        if (high - low < 2)
            return;

        // array'i 3 parçaya bölme
        int mid1 = low + ((high - low) / 3);
        int mid2 = low + 2 * ((high - low) / 3) + 1;

        // bölünen indekslerden array'i sortlama
        mergeSort3WayRec(destArray, low, mid1, gArray);
        mergeSort3WayRec(destArray, mid1, mid2, gArray);
        mergeSort3WayRec(destArray, mid2, high, gArray);

        // bölünen indekslerden array'i merge'leme (birleştirme)
        merge(destArray, low, mid1, mid2, high, gArray);
    }


    public static void merge(int[] gArray, int low, int mid1, int mid2, int high, int[] destArray)
    {
        int i = low, j = mid1, k = mid2, l = low;   //bölünmüş array'in indeks değerlerini değişkenlere atama


        while ((i < mid1) && (j < mid2) && (k < high)) //bölünmüş 3 parçanın içinden en düşük değere sahip olanı seçme
        {
            if (gArray[i]<(gArray[j]))  //i indeksi ile j indeksi arasında değerleri karşılaştırma
            {
                if (gArray[i]<(gArray[k]))  //i indeksi ile k indeksi arasında değerleri karşılaştırma
                    destArray[l++] = gArray[i++];   //değerin array'e atanması

                else
                    destArray[l++] = gArray[k++];   //değerin array'e atanması
            }
            else
            {
                if (gArray[j]<(gArray[k]))  //j indeksi ile k indeksi arasında değerleri karşılaştırma
                    destArray[l++] = gArray[j++];   //değerin array'e atanması
                else
                    destArray[l++] = gArray[k++];   //değerin array'e atanması
            }
        }

        // birinci parça ve ikinci parçanın kalan değerlerinin karşılaştırılması
        while ((i < mid1) && (j < mid2))
        {
            if (gArray[i]<(gArray[j])) //i indeksi ile j indeksi arasında değerleri karşılaştırma
                destArray[l++] = gArray[i++];   //değerin array'e atanması
            else
                destArray[l++] = gArray[j++];   //değerin array'e atanması
        }

        // ikinci parça ve üçüncü parçanın kalan değerlerinin karşılaştırılması
        while ((j < mid2) && (k < high))
        {
            if (gArray[j]<(gArray[k])) //j indeksi ile k indeksi arasında değerleri karşılaştırma
                destArray[l++] = gArray[j++];   //değerin array'e atanması

            else
                destArray[l++] = gArray[k++];   //değerin array'e atanması
        }

        // birinci parça ve üçüncü parçanın kalan değerlerinin karşılaştırılması
        while ((i < mid1) && (k < high))
        {
            if (gArray[i]<(gArray[k]))//i indeksi ile k indeksi arasında değerleri karşılaştırma
                destArray[l++] = gArray[i++];   //değerin array'e atanması
            else
                destArray[l++] = gArray[k++];   //değerin array'e atanması
        }


        while (i < mid1)        //birinci parçada kalan değerlerin atanması
            destArray[l++] = gArray[i++];

        while (j < mid2)        //ikinci parçada kalan değerlerin atanması
            destArray[l++] = gArray[j++];

        while (k < high)        //üçüncü parçada kalan değerlerin atanması
            destArray[l++] = gArray[k++];
    }
}
