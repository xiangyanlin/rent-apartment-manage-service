package com.xyl.rental.controller;

import com.xyl.rental.service.PicUploadFileSystemService;
import com.xyl.rental.vo.PicUploadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("common")
public class CommonController {
    @Autowired
    private PicUploadFileSystemService picUploadService;

    /**
     * @param uploadFile
     * * @return
     ** @throws Exception
     * */
    @PostMapping("picUpload")
    @ResponseBody
    public PicUploadResult upload(
            @RequestParam("file") MultipartFile uploadFile) throws Exception {
        return this.picUploadService.upload(uploadFile);
    }
}
