package com.xyl.rental.controller;

import com.xyl.rental.service.PicUploadFileSystemService;
import com.xyl.rental.vo.PicUploadResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("common")
@Slf4j
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

    /**
     *
     * @param filename
     * @param response
     */
    @ResponseBody
    @RequestMapping(value = "/getImage", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public void getImage(@RequestParam(value = "filename", required = false)
                                     String filename, HttpServletResponse response){
        log.info("路径："+filename);
        picUploadService.getImage(filename,response);
    }

}
