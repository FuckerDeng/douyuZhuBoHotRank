package df.dao.mapper;

import df.bean.Groupinfo;
import df.bean.GroupinfoExample;
import java.util.List;

import df.structures.BigGroup;
import org.apache.ibatis.annotations.Param;

public interface GroupinfoMapper {
    long countByExample(GroupinfoExample example);

    int deleteByExample(GroupinfoExample example);

    int insert(Groupinfo record);
    int insertBatch(List<BigGroup> list);

    int insertSelective(Groupinfo record);

    List<Groupinfo> selectByExample(GroupinfoExample example);

    int updateByExampleSelective(@Param("record") Groupinfo record, @Param("example") GroupinfoExample example);

    int updateByExample(@Param("record") Groupinfo record, @Param("example") GroupinfoExample example);
}