package ws.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ws.bean.MerchantInfo;
import ws.service.MerchantService;

import javax.jws.WebService;


/**
 * @Description: 新增商户服务端方法
 * @Param:
 * @return:
 * @Author: gb
 * @Date: 2020/2/14
 */
@WebService(serviceName = "AddMerchant",
        targetNamespace = "http://webservice.wsadd",
        endpointInterface = "ws.webservice.AddMerchant"

)
@Component
public class AddMerchantimp implements AddMerchant {

    @Autowired
    private MerchantService merchantService;
    @Override
    public MerchantInfo addMerchant(MerchantInfo merchantInfo) {

        //新增商户
       int result = merchantService.addMerchant(merchantInfo);
       if(result>0){
           merchantInfo.setFlag("success");
       }else {
           merchantInfo.setFlag("fail");
       }
       return merchantInfo;
    }
}
