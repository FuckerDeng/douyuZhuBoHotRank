package df.dao.mapper;

import df.bean.Roomhotvalue;
import df.bean.RoomhotvalueExample;
import java.util.List;

import df.structures.LiveRoom;
import org.apache.ibatis.annotations.Param;

public interface RoomhotvalueMapper {
    long countByExample(RoomhotvalueExample example);

    int deleteByExample(RoomhotvalueExample example);

    int insert(Roomhotvalue record);

    int insertBatch(List<LiveRoom> list);

    int insertSelective(Roomhotvalue record);

    List<Roomhotvalue> selectByExample(RoomhotvalueExample example);

    int updateByExampleSelective(@Param("record") Roomhotvalue record, @Param("example") RoomhotvalueExample example);

    int updateByExample(@Param("record") Roomhotvalue record, @Param("example") RoomhotvalueExample example);
}