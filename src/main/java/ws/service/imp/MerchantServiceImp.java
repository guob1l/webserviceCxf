package ws.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ws.bean.MerchantInfo;
import ws.dao.MerchantDao;
import ws.service.MerchantService;

import java.util.List;

@Service
public class MerchantServiceImp implements MerchantService {

    @Autowired
    private MerchantDao merchantDao;

    @Override
    public int addMerchant(MerchantInfo merchantInfo) {
        return merchantDao.addMerchant(merchantInfo);
    }

    public List<MerchantInfo> findMerchant(MerchantInfo merchantInfo){

        return merchantDao.findMerchant(merchantInfo);
    }

    @Override
    public int updateMerchant(MerchantInfo merchantInfo) {
        return  merchantDao.updateMerchant(merchantInfo);
    }

    @Override
    public int deleteMerchant(MerchantInfo merchantInfo) {
        return  merchantDao.deleteMerchant(merchantInfo);
    }
}
