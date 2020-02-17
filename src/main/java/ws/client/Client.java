package ws.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ws.bean.MerchantInfo;
import ws.service.MerchantService;

@Controller
@RequestMapping(value = "/client")
public class Client {

    @Autowired
    private MerchantService merchantService;

    @RequestMapping("/index")
    public String index(){


        return "index";
    }

    @RequestMapping("/addMerchant")
    @ResponseBody
    public void add(){

        MerchantInfo merchantInfo = new MerchantInfo();
        merchantInfo.setCustNo("1111");
        merchantInfo.setMerchantAccount("11111");
        merchantInfo.setMerchantNo("1111111");
        merchantInfo.setAddress("asd");
        merchantInfo.setMerchantName("www");
        merchantInfo.setStatus("1");
        merchantInfo.setTelephone("13444455455");

        merchantService.addMerchant(merchantInfo);
        System.out.println("asd");
    }
}
