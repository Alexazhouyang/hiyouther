package com.tool;


import java.awt.Image;  
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;  
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import com.sun.image.codec.jpeg.JPEGCodec;  
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import jdk.internal.util.xml.impl.Input;  


public class ImageCompress {

	/*******************************************************************************
	 * 缩略图类（通用） 本java类能将jpg、bmp、png、gif图片文件，进行等比或非等比的大小转换。 具体使用方法
	 * compressPic(大图片路径,生成小图片路径,大图片文件名,生成小图片文名,生成小图片宽度,生成小图片高度,是否等比缩放(默认为true))
	 */
	private File file = null; // 文件对象
	private String outputDir; // 输出图路径
	private String outputFileName; // 输出图文件名
	private boolean proportion = true; // 是否等比缩放标记(默认为等比缩放)
	public boolean isProportion() {
		return proportion;
	}

	public void setProportion(boolean proportion) {
		this.proportion = proportion;
	}

	private Image img;
	public ImageCompress() { // 初始化变量

		outputDir = "";

		outputFileName = "";

	}



	public void setOutputDir(String outputDir) {
		this.outputDir = outputDir;
	}



	public void setOutputFileName(String outputFileName) {
		this.outputFileName = outputFileName;
	}
	/*
	 * 获得图片大小 传入参数 String path ：图片路径
	 */
	public long getPicSize(String path) {
		file = new File(path);
		return file.length();
	}

	// 图片处理
	public InputStream compressPic() {
		InputStream is =null;
		try {
			// 获得源文件
			//System.out.println(inputDir + inputFileName);
			// 判断图片格式是否正确
			if (img.getWidth(null) == -1) {
				System.out.println(" can't read,retry!" + "<BR>");
				return is;
			} else {
				int newWidth;
				int newHeight;
				newWidth= img.getWidth(null);
				newHeight=img.getHeight(null);
				BufferedImage tag = new BufferedImage((int) newWidth,
						(int) newHeight, BufferedImage.TYPE_INT_RGB);

				/*
				 * Image.SCALE_SMOOTH 的缩略算法 生成缩略图片的平滑度的 优先级比速度高 生成的图片质量比较好 但速度慢
				 */
				tag.getGraphics().drawImage(
						img.getScaledInstance(newWidth, newHeight,
								Image.SCALE_SMOOTH), 0, 0, null);
				File f=new File(outputDir);
				if (!f.exists()){
					f.mkdirs(); 
				}
				
				FileOutputStream out = new FileOutputStream(outputDir
						+ outputFileName);
				// JPEGImageEncoder可适用于其他图片类型的转换
				JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
				encoder.encode(tag);
				ByteArrayOutputStream bs =new ByteArrayOutputStream();

				ImageOutputStream imOut =ImageIO.createImageOutputStream(bs);

				ImageIO.write(tag,"jpg",imOut); //scaledImage1为BufferedImage，jpg为图像的类型

				is =new ByteArrayInputStream(bs.toByteArray());
				
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return is;
	}

	public InputStream compressPic(InputStream input,String outputDir,	String outputFileName) {
		// 输出图路径
		this.outputDir = outputDir;
		// 输入图文件名
		try {
			this.img = ImageIO.read(input);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 输出图文件名
		this.outputFileName = outputFileName;
		return compressPic();
	}
}
