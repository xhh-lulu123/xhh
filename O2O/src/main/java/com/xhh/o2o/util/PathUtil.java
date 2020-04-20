package com.xhh.o2o.util;

public class PathUtil {
	private static String seperator = System.getProperty("file.separator");//系统的文件分隔符
/**
 * 添加后的项目图片的根路径
 * @return
 */
	public static String getImgBasePath() {
		String os = System.getProperty("os.name");//操作系统名字
		String basePath = "";
		if (os.toLowerCase().startsWith("win")) {
			basePath = "D:/O2Oimage";
		} else {
			basePath = "/Users/baidu/work/image";
		}
		basePath = basePath.replace("/", seperator);//替换成系统的分隔符
		return basePath;
	}
	/**
	 * 项目图片的相对路径
	 * @param shopId
	 * @return
	 */
	public static String getShopImagePath(long shopId) {
		String imagePath = "/upload/item/shop/" + shopId + "/";
		return imagePath.replace("/", seperator);
	}
}
