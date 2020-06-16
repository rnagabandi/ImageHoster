package com.imagehoster.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imagehoster.application.model.Image;
import com.imagehoster.application.service.ImageService;

@Controller
public class HomeController {

    //Write the code to inject the ImageService bean
	@Autowired
	ImageService imageService;

    @RequestMapping("/")
    public String getAllImages(Model model) {
        //Call getAllImages() method in ImageService class to get the list of all images
        //Add the list of images in the model with the key as "images"
    	
    	List<Image> allImages = imageService.getAllImages();
    	
    	model.addAttribute("images", allImages);

        return "index";
    }
}
