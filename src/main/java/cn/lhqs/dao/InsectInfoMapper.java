package cn.lhqs.dao;

import cn.lhqs.model.InsectInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface InsectInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(InsectInfo record);

    int insertSelective(InsectInfo record);

    InsectInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(InsectInfo record);

    int updateByPrimaryKey(InsectInfo record);
}