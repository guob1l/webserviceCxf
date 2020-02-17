package ws.webservice;

import ws.bean.MerchantInfo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://webservice.wsadd")
public interface AddMerchant {
    @WebMethod
    MerchantInfo addMerchant(@WebParam(name = "merchant") MerchantInfo merchantInfo);
}
