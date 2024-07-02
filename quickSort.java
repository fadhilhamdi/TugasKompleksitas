public class quickSort {

    // Fungsi utama untuk menjalankan Quick Sort
    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            // Tentukan indeks pivot
            int pivotIndex = partition(array, left, right);

            // Panggil quickSort rekursif pada sub-array sebelah kiri dan kanan pivot
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    // Fungsi untuk mempartisi array dan mengembalikan indeks pivot
    public static int partition(int[] array, int left, int right) {
        // Pilih elemen pivot (biasanya elemen terakhir)
        int pivot = array[right];
        int i = left - 1;

        // Lakukan partisi
        for (int j = left; j < right; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }

        // Tempatkan pivot di posisi yang benar
        swap(array, i + 1, right);
        return i + 1;
    }

    // Fungsi untuk menukar dua elemen dalam array
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Fungsi utama untuk menjalankan program
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Array sebelum diurutkan:");
        printArray(array);

        quickSort(array, 0, array.length - 1);

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
