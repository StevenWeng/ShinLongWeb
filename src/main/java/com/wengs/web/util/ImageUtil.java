package com.wengs.web.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.itextpdf.text.pdf.PdfWriter;

public class ImageUtil {

	public static void saveImage(BufferedImage image, File outputFile)
			throws IOException {
		String format = getFormat(outputFile.getName());
		ImageIO.write(image, format, outputFile);
	}

	public static void deleteImage(File deleteFile) {
		if (deleteFile.exists()) {
			deleteFile.delete();
		}
	}

	public static BufferedImage resizeImage(BufferedImage originalImage,
			int width, int height) {
		int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB
				: originalImage.getType();
		BufferedImage resizedImage = new BufferedImage(width, height, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, width, height, null);
		g.dispose();
		return resizedImage;
	}

	public static String getFormat(String imageName) {
		String tmp = imageName.toLowerCase();

		if (tmp.endsWith(".png"))
			return "PNG";
		if (tmp.endsWith(".gif"))
			return "GIF";
		if (tmp.endsWith(".jpg"))
			return "JPG";
		if (tmp.endsWith(".jpeg"))
			return "JPEG";
		if (tmp.endsWith(".tiff"))
			return "TIFF";
		return "UNKNOWN";
	}


}
