package ws.webservice;

import ws.bean.MerchantInfo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


@WebService(targetNamespace = "http://webservice.wsupdate")
public interface UpdateMerchant {
    @WebMethod
    MerchantInfo updateMerchant(@WebParam(name = "merchant") MerchantInfo merchantInfo);
}
