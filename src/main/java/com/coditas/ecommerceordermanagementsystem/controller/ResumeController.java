package com.coditas.ecommerceordermanagementsystem.controller;

import com.coditas.ecommerceordermanagementsystem.entity.Resume;
import com.coditas.ecommerceordermanagementsystem.service.ResumeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class ResumeController {

    private ResumeService resumeService;

    public ResumeController(ResumeService resumeService){
        this.resumeService=resumeService;
    }

    @PostMapping("/resumes")
    public Resume uploadResume(@RequestBody Resume newResume){
        return resumeService.uploadResume(newResume);
    }
}
