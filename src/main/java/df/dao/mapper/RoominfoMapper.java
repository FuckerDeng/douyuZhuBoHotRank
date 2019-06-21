package df.dao.mapper;

import df.bean.Roominfo;
import df.bean.RoominfoExample;
import java.util.List;

import df.structures.LiveRoom;
import org.apache.ibatis.annotations.Param;

public interface RoominfoMapper {
    long countByExample(RoominfoExample example);

    int deleteByExample(RoominfoExample example);

    int insert(Roominfo record);

    int insertSelective(Roominfo record);

    int insertBatch(List<LiveRoom> list);

    int updateBatch(List<LiveRoom> list);

    List<Roominfo> selectByExample(RoominfoExample example);

    int updateByExampleSelective(@Param("record") Roominfo record, @Param("example") RoominfoExample example);

    int updateByExample(@Param("record") Roominfo record, @Param("example") RoominfoExample example);
}