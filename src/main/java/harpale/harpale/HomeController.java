package harpale.harpale;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Welcome to ChickoHub - Fresh Chicken Delivered");
        model.addAttribute("tagline", "Order Fresh & Juicy Chicken Anytime, Anywhere 🍗");
        return "home"; // home.html inside templates
    }
    @GetMapping("/menu")
    public String menu(Model model) {
        model.addAttribute("title", "Our Menu - ChickoHub");
        return "menu";
    }

    @GetMapping("/offers")
    public String offers(Model model) {
        model.addAttribute("title", "Special Offers - ChickoHub");
        return "offers";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About Us - ChickoHub");
        return "about";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title", "Contact Us - ChickoHub");
        return "contact";
    }
    

@GetMapping("/order")
    public String orderPage(@RequestParam(name="item", required=false) String item, Model model) {
        // Pass the item name to the order page
        model.addAttribute("itemName", item);
        model.addAttribute("whatsappNumber", "917387625414"); // your number
        model.addAttribute("callNumber", "7387625414"); // your number
        return "order"; // returns order.html
    }
    @GetMapping("path")
    public String getMethodName(@RequestParam String param
    ) {
        return new String();
    }
    
}
