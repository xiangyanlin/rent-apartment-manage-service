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
    public PicUploadResult upload(MultipartFile uploadFile);
    public void getImage(String filename, HttpServletResponse response);

}
