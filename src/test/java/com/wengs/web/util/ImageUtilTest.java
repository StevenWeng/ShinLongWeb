package com.wengs.web.util;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.itextpdf.text.DocumentException;
import com.wengs.web.util.ImageUtilTest;

public class ImageUtilTest {
	 


	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveImage() throws IOException {
		BufferedImage image = ImageIO.read(getClass().getResourceAsStream("/coupon.jpg"));
		ImageUtil.saveImage(image, new File("D:\\tmp\\io\\testCoupon.jpg"));
	}
	

	@Test
	public void testResizeImage() throws IOException {
		BufferedImage orgImage = ImageIO.read(getClass().getResourceAsStream("/coupon.jpg"));
		BufferedImage resizeImage = ImageUtil.resizeImage(orgImage, 150, 100);
		ImageUtil.saveImage(resizeImage, new File("D:\\tmp\\io\\testCoupon150_100.jpg"));
	}
	
	

}
