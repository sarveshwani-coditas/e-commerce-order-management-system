package com.coditas.ecommerceordermanagementsystem.service;

import com.coditas.ecommerceordermanagementsystem.entity.Resume;
import com.coditas.ecommerceordermanagementsystem.repository.ResumeRepository;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {

    private ResumeRepository resumeRepository;

    public ResumeService(ResumeRepository resumeRepository){
        this.resumeRepository=resumeRepository;
    }

    public Resume uploadResume(Resume resume){
        if(resume.getExperience() < 3){
            throw new RuntimeException("Something went wrong!");
        }
        return resumeRepository.save(resume);
    }

}
