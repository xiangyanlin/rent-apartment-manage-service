package com.xyl.rental.service;

import com.xyl.rental.vo.PicUploadResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author xyl
 * @version 1.0
 * @date 2020/3/9 11:15
 */
public interface PicUploadFileService {
    /**
     * 图片上传
     * @param uploadFile
     * @return
     */
    public PicUploadResult upload(MultipartFile uploadFile);

    /**
     * 获取图片
     * @param filename
     * @param response
     */
    public void getImage(String filename, HttpServletResponse response);

}
