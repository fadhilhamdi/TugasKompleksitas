public class mergeSort {

    // Fungsi utama untuk menjalankan Merge Sort
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            // Hitung mid point dari array
            int mid = (left + right) / 2;

            // Lakukan rekursi pada separuh pertama
            mergeSort(array, left, mid);
            
            // Lakukan rekursi pada separuh kedua
            mergeSort(array, mid + 1, right);
            
            // Gabungkan dua sub-array yang sudah diurutkan
            merge(array, left, mid, right);
        }
    }

    // Fungsi untuk menggabungkan dua sub-array
    public static void merge(int[] array, int left, int mid, int right) {
        // Hitung ukuran dari dua sub-array yang akan digabungkan
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Buat array sementara
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Salin data ke array sementara
        for (int i = 0; i < n1; ++i) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = array[mid + 1 + j];
        }

        // Gabungkan array sementara ke array asli
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Salin elemen-elemen yang tersisa dari leftArray
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Salin elemen-elemen yang tersisa dari rightArray
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Fungsi utama untuk menjalankan program
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Array sebelum diurutkan:");
        printArray(array);

        mergeSort(array, 0, array.length - 1);

        System.out.println("Array setelah diurutkan:");
        printArray(array);
    }

    // Fungsi untuk mencetak array
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
