package ws.WebrtcController;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebRTCController {

    @RequestMapping("/rtcone")
    public String index(){

        return "htmlone";
    }

    @RequestMapping("/rtctwo")
    public String indextwo(){

        return "htmltwo";
    }

    @RequestMapping("/rtcthree")
    public String indexthree(){

        return "htmlthree";
    }
}
