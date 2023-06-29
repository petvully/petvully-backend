package com.hackathon.petvully.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "pet", description = "유기동물 API")
@RestController
@RequestMapping("pet")
@CrossOrigin(origins = "*")
public class DonationController {
}
