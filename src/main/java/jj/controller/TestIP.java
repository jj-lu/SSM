package jj.controller;

import jj.util.IPUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/ip")
public class TestIP {

    @RequestMapping("/getIP")
    public String getIP(HttpServletRequest request, HttpServletResponse response){
        return IPUtils.getIP(request);
    }
}
