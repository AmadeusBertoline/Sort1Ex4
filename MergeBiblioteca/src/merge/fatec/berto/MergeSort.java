package merge.fatec.berto;

import java.util.Arrays;

import java.util.Scanner;
import java.util.Arrays;

public class MergeSort {
	public static void mergeSort(int[] array, int esquerda, int direita) {
		if (esquerda < direita) {
			int meio = (esquerda + direita) / 2;

			// Divide o array recursivamente
			mergeSort(array, esquerda, meio);
			mergeSort(array, meio + 1, direita);

			// Mescla as partes ordenadas
			merge(array, esquerda, meio, direita);
		}
	}

	private static void merge(int[] array, int esquerda, int meio, int direita) {
		// Tamanho das sublistas
		int n1 = meio - esquerda + 1;
		int n2 = direita - meio;

		// Arrays temporários para armazenar as sublistas
		int[] esquerdaArray = new int[n1];
		int[] direitaArray = new int[n2];

		// Copia os elementos para os arrays temporários
		for (int i = 0; i < n1; i++) {
			esquerdaArray[i] = array[esquerda + i];
		}
		for (int j = 0; j < n2; j++) {
			direitaArray[j] = array[meio + 1 + j];
		}

		// Mescla os dois arrays temporários
		int i = 0, j = 0, k = esquerda;
		while (i < n1 && j < n2) {
			if (esquerdaArray[i] <= direitaArray[j]) {
				array[k] = esquerdaArray[i];
				i++;
			} else {
				array[k] = direitaArray[j];
				j++;
			}
			k++;
		}

		// Copia os elementos restantes, se houver
		while (i < n1) {
			array[k] = esquerdaArray[i];
			i++;
			k++;
		}
		while (j < n2) {
			array[k] = direitaArray[j];
			j++;
			k++;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o tamanho do array:");
		int tamanho = scanner.nextInt();

		int[] array = new int[tamanho];

		System.out.println("Digite os elementos do array:");
		for (int i = 0; i < tamanho; i++) {
			array[i] = scanner.nextInt();
		}

		mergeSort(array, 0, array.length - 1);

		System.out.println("Array ordenado:");
		System.out.println(Arrays.toString(array));
	}
}

//vetor, auxiliar.