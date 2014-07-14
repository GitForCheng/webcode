package com.ebpf.base.utils;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class ImageUtils {

	/**
	 * 上传文件
	 * @param file
	 * @param path
	 * @return
	 */
	public static boolean uploadFile(MultipartFile _file,String path,String fileName){
		File file = new File(path,fileName);
    	if(!file.exists()) {
    		file.mkdirs();
    	}
    	try {
			_file.transferTo(file);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
