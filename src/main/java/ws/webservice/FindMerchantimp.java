package ws.webservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ws.bean.MerchantInfo;
import ws.service.MerchantService;

import javax.jws.WebService;
import java.util.ArrayList;
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
    public List<MerchantInfo> find(MerchantInfo merchantInfo,int page,int size) {
        //查询总条数：
        int totalNumber = merchantService.findTotalNumber();
        //按pagesize计算总页数
        double totalDouble = (double)totalNumber/ (double)size;
        int totalPage  = (int) Math.ceil(totalDouble);
        if(totalPage<page){
            return null;
        }
        ArrayList<MerchantInfo> merchantInfoArrayList = (ArrayList<MerchantInfo>) merchantService.findMerchant(merchantInfo,page,size);

        if(merchantInfoArrayList.size()>0){
            return merchantInfoArrayList;
        }else{
           /* MerchantInfo merchantInfo1 = new MerchantInfo();
            merchantInfo1.setFlag("fail");
            merchantInfoArrayList.add(merchantInfo1);*/
            return  null;
        }
    }
}
