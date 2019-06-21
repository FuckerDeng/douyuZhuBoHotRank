package df.dao.mapper;

import df.bean.Grouphotvalue;
import df.bean.GrouphotvalueExample;
import java.util.List;

import df.structures.BigGroup;
import org.apache.ibatis.annotations.Param;

public interface GrouphotvalueMapper {
    long countByExample(GrouphotvalueExample example);

    int deleteByExample(GrouphotvalueExample example);

    int insert(Grouphotvalue record);

    int insertBatch(List<BigGroup> list);

    int insertSelective(Grouphotvalue record);

    List<Grouphotvalue> selectByExample(GrouphotvalueExample example);

    int updateByExampleSelective(@Param("record") Grouphotvalue record, @Param("example") GrouphotvalueExample example);

    int updateByExample(@Param("record") Grouphotvalue record, @Param("example") GrouphotvalueExample example);
}