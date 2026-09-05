package org.example.controller;

import org.example.dto.ClientData;
import org.example.entity.Client;
import org.example.entity.Course;
import org.example.repo.CourseRepo;
import org.example.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class MyController {

    @Autowired
    ClientServiceImpl clientService;

    @Autowired
    CourseRepo courseRepo;

    @GetMapping("/")
    public String openForm(Model model){
        model.addAttribute("clientdata",new ClientData());
        model.addAttribute("courseDetails",courseRepo.findAll());
        return "index.html";
    }
    @PostMapping("/save")
    public String saveData(ClientData clientData, RedirectAttributes redirectAttributes) {

        Client client = clientService.findByEmail(clientData.getEmail());

        if (client == null) {
            client = new Client();
            client.setEmail(clientData.getEmail());
            client.setGender(clientData.getGender());
            List<Course> courses = courseRepo.findAllById(clientData.getCoursesId());
            client.setCourseList(new ArrayList<>(courses));
        }else{
            List<Course> courses = courseRepo.findAllById(clientData.getCoursesId());
            List<Course> courseList = client.getCourseList();
            for(Course c:courses)courseList.add(c);
            client.setCourseList(courseList);
        }
        clientService.saveClientDetails(client);
        clientService.sendEmail(client.getEmail());
        redirectAttributes.addFlashAttribute("msg","Details Send Over Mail Thanks !!");
        return "redirect:/";
    }
}
