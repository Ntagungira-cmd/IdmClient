package com.example.controllers;

import com.example.dao.Website;
import com.example.utils.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class Idm {

    @GetMapping("/")
    public String Welcome(){
        return "welcome";
    }

    @PostMapping("/download")
    public String Download(HttpServletRequest request, Model model) throws JsonProcessingException {
        try {
            RestTemplate template = new RestTemplate();
            String url = "http://localhost:5000/idm/site/add";
            Map<String,String> requestBody = new HashMap<>();
            requestBody.put("url",request.getParameter("url"));
            //System.out.println(requestBody.get("url")); // This is the url that is being sent to the server
            ResponseEntity<ApiResponse> response = template.postForEntity(url,requestBody,ApiResponse.class);
            return "redirect:/home";
        }catch (Exception e){
            System.out.println(e.getMessage());
            ApiResponse response = new ObjectMapper().readValue(e.getMessage().substring(7, e.getMessage().length() - 1),ApiResponse.class);
            model.addAttribute("error",response.getMessage());
            return "welcome";
        }
    }

    @GetMapping("/home")
    public String Home(HttpServletRequest request, Model model){
        RestTemplate template = new RestTemplate();
        String url = "http://localhost:5000/idm/site";
        ResponseEntity<Website[]> response = template.getForEntity(url, Website[].class);
        model.addAttribute("websites",response.getBody());
        return "home";
    }

}
