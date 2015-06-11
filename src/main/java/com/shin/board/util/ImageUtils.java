package com.shin.board.util;

import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.web.multipart.MultipartFile;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

@SuppressWarnings("restriction")
public class ImageUtils {
	
	/**
	 * MultipartFile 을 BufferedImage 형으로 변환
	 * @param MultipartFile
	 * @return BuffredImage
	 * @throws IOException
	 */
	public static BufferedImage getImage(MultipartFile resource) throws IOException {
		InputStream is = resource.getInputStream();
		try {
			return ImageIO.read(is);
		} finally {
			is.close();
		}
	}
	
	public static BufferedImage resize(BufferedImage image, int width, int height) {
		BufferedImage rv = new BufferedImage(width, height, image.getType());
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Graphics2D graphics2D = ge.createGraphics(rv);
		graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		graphics2D.drawImage(image, 0, 0, width, height, null);
		return rv;
	}
	
	public static byte[] imageToBytes(BufferedImage img) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(img, "jpg", baos);
		baos.flush();
		byte[] imageByte = baos.toByteArray();
		baos.close();
		return imageByte;
	}
	
	public static void writeJpeg(BufferedImage image, File dest, int dpi) throws IOException {
		File folder = dest.getParentFile();
		if (!folder.exists()) {
			folder.mkdirs();
		}
		OutputStream out = new FileOutputStream(dest);
		try {
			writeJpeg(image, out, dpi);
		} finally {
			out.close();
		}
	}
	
	public static void writeJpeg(BufferedImage image, OutputStream out, int dpi) throws ImageFormatException, IOException {
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(image);
		param.setQuality(0.85f, false);
		param.setDensityUnit(JPEGEncodeParam.DENSITY_UNIT_DOTS_INCH);
		param.setXDensity(dpi);
		param.setYDensity(dpi);
		encoder.setJPEGEncodeParam(param);
		encoder.encode(image);
	}
}