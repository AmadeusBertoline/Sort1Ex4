package merge.fatec.berto;

import java.util.Arrays;

public class MergeSort {

	public static int[] mergeSort(int[] array) {
		if (array.length <= 1)
			return array;

		int meio = array.length / 2;
		int[] esquerda = new int[meio];
		int[] direita = new int[array.length - meio];

		// Preenche os arrays esquerdo e direito manualmente
		for (int i = 0; i < meio; i++) {
			esquerda[i] = array[i];
		}
		for (int i = meio; i < array.length; i++) {
			direita[i - meio] = array[i];
		}

		// Chama recursivamente e faz o merge
		return merge(mergeSort(esquerda), mergeSort(direita));
	}

	private static int[] merge(int[] esquerda, int[] direita) {
		int[] resultado = new int[esquerda.length + direita.length];
		int i = 0, j = 0, k = 0;

		while (i < esquerda.length && j < direita.length) {
			resultado[k++] = (esquerda[i] <= direita[j]) ? esquerda[i++] : direita[j++];
		}

		while (i < esquerda.length)
			resultado[k++] = esquerda[i++];
		while (j < direita.length)
			resultado[k++] = direita[j++];

		return resultado;
	}

	public static void main(String[] args) {
		int[] array = { 38, 27, 43, 3, 9, 82, 10 };
		int[] ordenado = mergeSort(array);

		System.out.println("Array ordenado: " + Arrays.toString(ordenado));
	}
}
