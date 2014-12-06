package com.wengs.web.util;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.itextpdf.text.DocumentException;

public class PdfUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveToPdf() throws IOException, DocumentException {
		BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/coupon.jpg"));
//		PdfUtil.saveToPdf(image, new File("testCoupon.pdf"));
	}

}
