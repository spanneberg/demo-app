package com.spanneberg.demoapp;

import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jcabi.manifests.Manifests;

@Controller
public class InfoController {

    @RequestMapping("/info")
    public String info(Model model) throws UnknownHostException, SocketException {
        String hostname = InetAddress.getLocalHost().getHostName();
        String appName = Manifests.read("appName");
        String appVersion = Manifests.read("appVersion");
        model.addAttribute("hostname", hostname);
        model.addAttribute("appName", appName);
        model.addAttribute("appVersion", appVersion);
        return "info"; 
    }

}