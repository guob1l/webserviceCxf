package ws.webservice;
import ws.bean.MerchantInfo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;


@WebService(targetNamespace = "http://webservice.wsdelete")
public interface DeleteMerchant {
    @WebMethod
    MerchantInfo deleteMerchant(@WebParam(name = "merchant") MerchantInfo merchantInfo);
}
