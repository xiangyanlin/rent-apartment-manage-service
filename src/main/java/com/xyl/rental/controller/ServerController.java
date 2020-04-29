package com.xyl.rental.controller;


import com.xyl.rental.entity.Server;
import com.xyl.rental.utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xyl
 * @create 2020/4/29 9:42
 */
@RestController
@RequestMapping("/monitor/server")
public class ServerController {

    @GetMapping()
    public R<Server> getInfo(){
        Server server = new Server();
        try {
            server.copyTo();
        }catch (Exception e){
            R.failed("获取信息异常");
        }
        return R.success(server);
    }
}
