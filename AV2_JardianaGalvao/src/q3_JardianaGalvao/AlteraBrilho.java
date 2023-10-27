package q3_JardianaGalvao;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class AlteraBrilho {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		BufferedImage imagemOriginal = ImageIO
				.read(new File("D:\\Temp\\ws-eclipse\\AV2_JardianaGalvao\\src\\q3_JardianaGalvao\\gato_close_original.jpg"));

		int largura = imagemOriginal.getWidth();
		int altura = imagemOriginal.getHeight();

		BufferedImage imagemModificada = new BufferedImage(largura, altura, imagemOriginal.getType());

		System.out.println("Insira o valor do brilho (de -255 a 255):");
		int brilho = scanner.nextInt();

		if (brilho < -255 || brilho > 255) {
			System.out.println("Valor do brilho inválido.");
			System.exit(1);
		}

		for (int x = 0; x < largura; x++) {
			for (int y = 0; y < altura; y++) {
				int r = imagemOriginal.getRGB(x, y) >> 16 & 0xFF;
				int g = imagemOriginal.getRGB(x, y) >> 8 & 0xFF;
				int b = imagemOriginal.getRGB(x, y) & 0xFF;

				r += brilho;
				g += brilho;
				b += brilho;

				int novoR = Math.min(255, r);
				int novoG = Math.min(255, g);
				int novoB = Math.min(255, b);
				imagemModificada.setRGB(x, y, (novoR << 16) | (novoG << 8) | novoB);
			}
		}

		ImageIO.write(imagemModificada, "jpg", new File("D:\\Temp\\ws-eclipse\\AV2_JardianaGalvao\\src\\q3_JardianaGalvao\\gato_close_editada.jpg"));

		System.out.println("Imagem modificada com sucesso!");
	}
}
