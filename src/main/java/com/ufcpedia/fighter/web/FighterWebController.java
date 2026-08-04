//package com.ufcpedia.fighter.web;
//
//import com.ufcpedia.fighter.service.FighterService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//@Controller
//public class FighterWebController {
//
//    @Autowired
//    private FighterService fighterService;
//
//    @GetMapping("/fighter/{id}")
//    public String fighterDetails(@PathVariable Long id,
//                                 Model model) {
//
//        model.addAttribute(
//                "fighter",
//                fighterService.getFighterById(id)
//        );
//
//        return "fighter-details";
//    }
//
//}