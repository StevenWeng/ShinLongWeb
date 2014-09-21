package com.wengs.web.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfUtil {
	public static void saveToPdf(BufferedImage image, File outputFile) throws DocumentException, IOException{
        Document document = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, new FileOutputStream(outputFile));
        document.open();
        Image itextImage = Image.getInstance(image, null);
        itextImage.scaleAbsolute(750, 500);
        document.add(itextImage);
        document.close();
	}
}
