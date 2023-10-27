package q4_JardianaGalvao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MultiplicarMatrizes {

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(
				new FileReader("D:\\Temp\\ws-eclipse\\AV2_JardianaGalvao\\src\\q4_JardianaGalvao\\matrizes.txt"))) {
			String line;
			int matrizAtual = 0;
			int[][][] matrizes = new int[2][][];
			int[][] resultMatrix = null;

			while ((line = reader.readLine()) != null) {
				if (line.startsWith("#")) {
					line = reader.readLine();
					String[] dimensoes = line.split(" ");
					int numRows = Integer.parseInt(dimensoes[0]);
					int numCols = Integer.parseInt(dimensoes[1]);

					matrizes[matrizAtual] = new int[numRows][numCols];

					for (int i = 0; i < numRows; i++) {
						line = reader.readLine();
						String[] elementos = line.split(" ");
						for (int j = 0; j < numCols; j++) {
							matrizes[matrizAtual][i][j] = Integer.parseInt(elementos[j]);
						}
					}

					matrizAtual++;
				}
			}

			if (matrizes[0][0].length == matrizes[1].length) {
				int numRowsA = matrizes[0].length;
				int numColsA = matrizes[0][0].length;
				int numRowsB = matrizes[1].length;
				int numColsB = matrizes[1][0].length;

				resultMatrix = new int[numRowsA][numColsB];

				for (int i = 0; i < numRowsA; i++) {
					for (int j = 0; j < numColsB; j++) {
						resultMatrix[i][j] = 0;
						for (int k = 0; k < numColsA; k++) {
							resultMatrix[i][j] += matrizes[0][i][k] * matrizes[1][k][j];
						}
					}
				}

				System.out.println("Resultado da multiplicacao das matrizes:");
				for (int i = 0; i < numRowsA; i++) {
					for (int j = 0; j < numColsB; j++) {
						System.out.print(resultMatrix[i][j] + " ");
					}
					System.out.println();
				}
			} else {
				System.out.println("As matrizes nao podem ser multiplicadas devido as dimensoes incompatveis.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
