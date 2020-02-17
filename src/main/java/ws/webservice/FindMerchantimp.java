package ws.webservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ws.bean.MerchantInfo;
import ws.service.MerchantService;

import javax.jws.WebService;
import java.util.List;



/**
 * @Description: 查找商户服务端方法
 * @Param:
 * @return:
 * @Author: gb
 * @Date: 2020/2/14
 */
@WebService(serviceName = "FindMerchant", // 与接口中指定的name一致
        targetNamespace = "http://webservice.wsfind", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "ws.webservice.FindMerchant" // 接口地址

)
@Component
public class FindMerchantimp implements FindMerchant{


    @Autowired
    private MerchantService merchantService;

    @Override
    public List<MerchantInfo> find(MerchantInfo merchantInfo) {
       return  merchantService.findMerchant(merchantInfo);
    }
}
