//package org.itzxs.util;
//
//import java.awt.Color;
//import java.awt.Graphics2D;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import javax.imageio.ImageIO;
//
//import com.swetake.util.Qrcode;
//
//public class MakeQRCode {
//
//	/**
//	 * 生成二维码
//	 * @param content 二维码内容
//	 * @param imageUrl 保存图片二级路径
//	 * @param id 用户id
//	 * @return 除静态服务根服务路径外，图片文件的网络访问路径
//	 */
//	public static String makeQRCode(String content,String imageUrl,String id) {
//		String qrCodeUrl = "";
//		try {
//			Qrcode handler = new Qrcode();
//			handler.setQrcodeErrorCorrect('M');
//			handler.setQrcodeEncodeMode('B');
//			handler.setQrcodeVersion(7);
//			byte[] contentBytes = content.getBytes("UTF-8");
//			BufferedImage bufImg = new BufferedImage(140, 140, BufferedImage.TYPE_INT_RGB);
//			Graphics2D gs = bufImg.createGraphics();
//			gs.setBackground(Color.WHITE);
//			gs.clearRect(0, 0, 140, 140);
//			gs.setColor(Color.BLACK);
//			int pixoff = 2;
//			if(contentBytes.length > 0 && contentBytes.length < 124) {
//				boolean[][] codeOut = handler.calQrcode(contentBytes);
//				for(int i = 0; i < codeOut.length; i++) {
//					for(int j = 0; j < codeOut.length; j++) {
//						if(codeOut[j][i]) {
//							gs.fillRect(j * 3 + pixoff, i * 3 + pixoff,3, 3);
//						}
//					}
//				}
//			} else {
//				System.err.println("QRCode&nbsp;content&nbsp;bytes&nbsp;length&nbsp;=&nbsp;" + contentBytes.length + "&nbsp;not&nbsp;in&nbsp;[&nbsp;0,120&nbsp;].&nbsp;");
//			}
//			gs.dispose();
//			bufImg.flush();
//			String monthStr = new SimpleDateFormat("yyyyMM").format(new Date());
//			qrCodeUrl = monthStr + "/" + id + ".png";
//			ImageIO.write(bufImg, "png", createFile(imageUrl + qrCodeUrl));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return qrCodeUrl;
//	}
//
//
//	public static File createFile(String path){
//		File file = new File(path);
//        if(!file.getParentFile().exists())
//            file.getParentFile().mkdirs();
//        try {
//			file.createNewFile();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return file;
//	}
//
//}
