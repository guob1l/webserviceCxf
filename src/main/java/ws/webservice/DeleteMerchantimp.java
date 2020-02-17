package ws.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ws.bean.MerchantInfo;
import ws.service.MerchantService;
import javax.jws.WebService;



/**
 * @Description: 删除商户服务端方法
 * @Param:
 * @return:
 * @Author: gb
 * @Date: 2020/2/14
 */
@WebService(serviceName = "DeleteMerchant",
        targetNamespace = "http://webservice.wsdelete",
        endpointInterface = "ws.webservice.DeleteMerchant"

)
@Component
public class DeleteMerchantimp implements DeleteMerchant{
    @Autowired
    private MerchantService merchantService;

    @Override
    public MerchantInfo deleteMerchant(MerchantInfo merchantInfo) {

        //删除商户
        int result = merchantService.deleteMerchant(merchantInfo);
        if(result>0){
            merchantInfo.setFlag("sucess");
        }else{
            merchantInfo.setFlag("fail");
        }
        return merchantInfo;
    }
}
