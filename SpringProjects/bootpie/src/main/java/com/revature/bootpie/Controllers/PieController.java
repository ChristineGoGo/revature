package com.revature.bootpie.Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.bootpie.models.Pie;
import com.revature.bootpie.services.PieService;


@Controller
@RequestMapping("pie")
public class PieController {
    private PieService pieService;

    public PieController(PieService pieService) {
        this.pieService = pieService;
    }

    /**
     * returns a list of pies using a GET request
     */
    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody List<Pie> getPieList() {
        return pieService.getPieList();
    }

    @GetMapping(params = "pieName")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    



     
}
