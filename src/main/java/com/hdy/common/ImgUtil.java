/*package com.internshipTour.util.common;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

@SuppressWarnings("restriction")
public class ImgUtil {
	private static Logger log = Logger.getRootLogger();
	// 图片宽和高的最大尺寸
	public static final int IMAGEMAXBIG = 2000;
	// 图片宽和高的最小尺寸
	public static final int IMAGEMINBIG = 10;
	// 按原图大小生成新图
	public static final int CREATENEWIMAGETYPE_0 = 0;
	// 按指定的大小生成新图
	public static final int CREATENEWIMAGETYPE_1 = 1;
	// 按原图宽高比例生成新图-按指定的宽度
	public static final int CREATENEWIMAGETYPE_2 = 2;
	// 按原图宽高比例生成新图-按指定的高度
	public static final int CREATENEWIMAGETYPE_3 = 3;
	// 按原图宽高比例生成新图-按指定的宽和高中较大的尺寸
	public static final int CREATENEWIMAGETYPE_4 = 4;
	// 按原图宽高比例生成新图-按指定的宽和高中较小的尺寸
	public static final int CREATENEWIMAGETYPE_5 = 5;

	*//**
	 * 
	 * @param _file
	 *            原图片
	 * @param createType
	 *            处理类型
	 * @param newW
	 *            新宽度
	 * @param newH
	 *            新高度
	 * @return
	 * @throws Exception
	 *//*
	public static String createNewImage(File _file, int createType, int newW, int newH) throws Exception {
		if (_file == null)
			return null;
		String fileName = _file.getPath();
		if (fileName == null || "".equals(fileName) || fileName.lastIndexOf(".") == -1)
			return null;
		String newFileName = "_" + newW + "_" + newH;
		
		 * else newFileName = "_" + newFileName;
		 

		String outFileName = fileName.substring(0, fileName.lastIndexOf(".")) + newFileName
				+ fileName.substring(fileName.lastIndexOf("."), fileName.length());
		String fileExtName = fileName.substring((fileName.lastIndexOf(".") + 1), fileName.length());
		if (newW < IMAGEMINBIG)
			newW = IMAGEMINBIG;
		else if (newW > IMAGEMAXBIG)
			newW = IMAGEMAXBIG;

		if (newH < IMAGEMINBIG)
			newH = IMAGEMINBIG;
		else if (newH > IMAGEMAXBIG)
			newH = IMAGEMAXBIG;

		// 得到原图信息
		if (!_file.exists() || !_file.isAbsolute() || !_file.isFile() || !checkImageFile(fileExtName))
			return null;
		if ((new File(outFileName)).exists()) {
			System.out.println("file [" + outFileName + "] already exists");
			throw new Exception();
		}
		Image src = ImageIO.read(_file);
		int w = src.getWidth(null);
		int h = src.getHeight(null);

		// 确定目标图片的大小
		int nw = w;
		int nh = h;
		if (createType == CREATENEWIMAGETYPE_0)
			;
		else if (createType == CREATENEWIMAGETYPE_1) {
			nw = newW;
			nh = newH;
		} else if (createType == CREATENEWIMAGETYPE_2) {
			nw = newW;
			nh = (int) ((double) h / (double) w * nw);
		} else if (createType == CREATENEWIMAGETYPE_3) {
			nh = newH;
			nw = (int) ((double) w / (double) h * nh);
		} else if (createType == CREATENEWIMAGETYPE_4) {
			if ((double) w / (double) h >= (double) newW / (double) newH) {
				nh = newH;
				nw = (int) ((double) w / (double) h * nh);
			} else {
				nw = newW;
				nh = (int) ((double) h / (double) w * nw);
			}
		} else if (createType == CREATENEWIMAGETYPE_5) {
			if ((double) w / (double) h <= (double) newW / (double) newH) {
				nh = newH;
				nw = (int) ((double) w / (double) h * nh);
			} else {
				nw = newW;
				nh = (int) ((double) h / (double) w * nw);
			}
		}

		// 构造目标图片
		BufferedImage tag = new BufferedImage(nw, nh, BufferedImage.TYPE_INT_RGB);

		// 得到目标图片输出流
		FileOutputStream out = new FileOutputStream(outFileName);

		// 根据需求画出目标图片 方式1
		tag.getGraphics().drawImage(src, 0, 0, nw, nh, null);

		// 将画好的目标图输出到输出流 方式1
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
		encoder.encode(tag);
		out.close();
		return outFileName;
	}

	public static boolean checkImageFile(String extName) {

		if ("jpg".equalsIgnoreCase(extName))
			return true;
		if ("gif".equalsIgnoreCase(extName))
			return true;
		if ("bmp".equalsIgnoreCase(extName))
			return true;
		if ("jpeg".equalsIgnoreCase(extName))
			return true;
		if ("png".equalsIgnoreCase(extName))
			return true;
		return false;
	}

	*//***
	 * 功能 :调整图片大小 开发
	 * 
	 * @param srcImgPath
	 *            原图片路径
	 * @param distImgPath
	 *            转换大小后图片路径
	 * @param width
	 *            转换后图片宽度
	 * @param height
	 *            转换后图片高度
	 *//*
	public static void resizeImage(InputStream input, String distImgPath, int width, int height) throws IOException {
		Image srcImg = ImageIO.read(input);
		BufferedImage buffImg = null;
		buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		buffImg.getGraphics().drawImage(srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);

		ImageIO.write(buffImg, "JPEG", new File(distImgPath));

	}

	@SuppressWarnings("unused")
	public static String saveImg(MultipartFile mFile,Integer uid) {

		String[] split = mFile.getOriginalFilename().split("\\.");
		String fileName = split[0].replaceAll("-", "");
		String end = split[1];
		String _32_32 = fileName + "_32_32";
		String _64_64 = fileName + "_64_64";
		String _128_128 = fileName + "_128_128";
		String _256_256 = fileName + "_256_256";
		String _512_512 = fileName + "_512_512";
		// 存贮原图片
		BufferedOutputStream bof = null;
		String newFileName = fileName + "." + end;
		try {
			InputStream ip = mFile.getInputStream();
			File file =new File(SystemConf.getSaveImgPath()+"/" + uid);    
			//如果文件夹不存在则创建    
			if  (!file .exists()  && !file .isDirectory()){        
			    file .mkdir();    
			}			
			bof = new BufferedOutputStream(
					new FileOutputStream(new File(SystemConf.getSaveImgPath() + uid + File.separator + fileName + "." + end)));
			bof.write(mFile.getBytes());
		} catch (IOException e) {
			log.error("存贮" + fileName + "图片出错");
			e.printStackTrace();
		} finally {
			if (bof != null) {
				try {
					bof.flush();
					bof.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		// 存贮32*32图片
		String distImgPath_32_32 = SystemConf.getSaveImgPath() + uid + File.separator + _32_32 + "." + end;
		try {
			ImgUtil.resizeImage(mFile.getInputStream(), distImgPath_32_32, 32, 32);
		} catch (IOException e) {
			log.error("存贮" + distImgPath_32_32 + "图片出错");
			e.printStackTrace();
		}

		// 存贮64*64图片
		String distImgPath_64_64 = SystemConf.getSaveImgPath() + uid + File.separator + _64_64 + "." + end;
		try {
			ImgUtil.resizeImage(mFile.getInputStream(), distImgPath_64_64, 64, 64);
		} catch (IOException e) {
			log.error("存贮" + distImgPath_64_64 + "图片出错");
			e.printStackTrace();
		}

		// 存贮128*128图片
		String distImgPath_128_128 = SystemConf.getSaveImgPath() + uid + File.separator + _128_128 + "." + end;
		try {
			ImgUtil.resizeImage(mFile.getInputStream(), distImgPath_128_128, 128, 128);
		} catch (IOException e) {
			log.error("存贮" + distImgPath_128_128 + "图片出错");
			e.printStackTrace();
		}

		// 存贮256*256图片
		String distImgPath_256_256 = SystemConf.getSaveImgPath() + uid + File.separator + _256_256 + "." + end;
		try {
			ImgUtil.resizeImage(mFile.getInputStream(), distImgPath_256_256, 256, 256);
		} catch (IOException e) {
			log.error("存贮" + distImgPath_256_256 + "图片出错");
			e.printStackTrace();
		}

		// 存贮512*512图片
		String distImgPath_512_512 = SystemConf.getSaveImgPath() + uid + File.separator + _512_512 + "." + end;
		try {
			ImgUtil.resizeImage(mFile.getInputStream(), distImgPath_512_512, 512, 512);
		} catch (IOException e) {
			log.error("存贮" + distImgPath_512_512 + "图片出错");
			e.printStackTrace();
		}
		return newFileName;
	}
	
	*//**
	 * 删除头像图片
	 * @param path
	 *//*
	public static void deleteImg(String path,Integer uid) {
		
		String[] split = (path.split("/")[2]).split("\\.");
		String fileName = split[0];
		String end = split[1];
		for(int i = 0;i < 6; i++){
			if( i == 0){
				deleteFile( SystemConf.getSaveImgPath() + uid + "/" +fileName+ "." + end);				
			} else {
				Double pow = Math.pow(2, i-1);
				int name  = pow.intValue() * 32;
				deleteFile( SystemConf.getSaveImgPath() + uid + "/" +fileName+ "_" + name + "_" + name + "." + end);				
			}
		}
	}
	
	
    *//**
     * 删除单个文件
     * @param   sPath    被删除文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     *//*
    public static boolean deleteFile(String sPath) {
    	boolean flag = false;
        File file = new File(sPath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }
    
    public static String getPicturePath(String path,String format){
    	String[] split = path.split("\\.");
    	String prefix = split[0] + format;
    	String suffix = split[1];
    	return prefix + "."+ suffix;
    }
}
*/