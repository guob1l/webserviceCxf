package ws.service;

import ws.bean.MerchantInfo;

import java.util.List;


public interface MerchantService {

    int addMerchant(MerchantInfo merchantInfo);

    List<MerchantInfo> findMerchant(MerchantInfo merchantInfo);

    int updateMerchant(MerchantInfo merchantInfo);

    int deleteMerchant(MerchantInfo merchantInfo);
}
