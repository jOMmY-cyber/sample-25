package web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
class Page {
    @RequestMapping("/")
    String showHome(Model model){
        model.addAttribute("shop","iCoffee");
        String[] data = {"Latte","Mocha","Esspresso"};
        model.addAttribute("products",data);
        return "home";  //home.html
    }
    @RequestMapping("/status")
    String showStatus(Model m){
        Runtime r = Runtime.getRuntime();
        double memory =  r.totalMemory();
        double free = r.freeMemory();
        double usage = memory - free;
        double percent = usage / memory * 100;
        m.addAttribute("memory",r.totalMemory());
        m.addAttribute("usage",percent);
        m.addAttribute("processor",r.availableProcessors());
        return "status";
    }
}

@RestController
class Memory{
    @RequestMapping("/get-memory-usage")
    double m(){
       Runtime r = Runtime.getRuntime();
       //double processor = Runtime.getRuntime().availableProcessors();
       double total = r.totalMemory();
       double free = r.freeMemory();
       double usage = total - free;
       return usage / total * 100 ;
    }
    
    
    
}