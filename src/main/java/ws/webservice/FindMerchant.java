package ws.webservice;


import ws.bean.MerchantInfo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://webservice.wsfind")
public interface FindMerchant {
    @WebMethod
    List<MerchantInfo> find(@WebParam(name = "merchant") MerchantInfo merchantInfo);

}
