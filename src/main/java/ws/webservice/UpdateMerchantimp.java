package ws.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ws.bean.MerchantInfo;
import ws.service.MerchantService;

import javax.jws.WebService;

/**
 * @Description: 更新商户服务端方法
 * @Param:
 * @return:
 * @Author: gb
 * @Date: 2020/2/14
 */

@WebService(serviceName = "UpdateMerchant",
        targetNamespace = "http://webservice.wsupdate",
        endpointInterface = "ws.webservice.UpdateMerchant"
)
@Component
public class UpdateMerchantimp implements UpdateMerchant {

    @Autowired
    private MerchantService merchantService;
    @Override
    public MerchantInfo updateMerchant(MerchantInfo merchantInfo) {

        //更新商户
        int result = merchantService.updateMerchant(merchantInfo);
        if(result>0){
            merchantInfo.setFlag("success");
            return merchantInfo;
        }
        merchantInfo.setFlag("fail");
        return  merchantInfo;
    }
}