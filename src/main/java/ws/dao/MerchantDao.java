package ws.dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ws.bean.MerchantInfo;

import java.util.List;


@Repository
public interface MerchantDao {

    //新增商户
    int addMerchant(MerchantInfo merchantInfo);

    //查找商户
    List<MerchantInfo> findMerchant(@Param("merchant") MerchantInfo merchantInfo, @Param("size")int size, @Param("offs")int offs);

    //跟新商户
    int updateMerchant(MerchantInfo merchantInfo);

    //删除商户
    int deleteMerchant(MerchantInfo merchantInfo);

    //查询总条数
    int findTotalNumber();
}
