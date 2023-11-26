package alex.dao;

import alex.BaseMapper;
import alex.dto.School;
import alex.dto.SchoolExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SchoolMapper extends BaseMapper<School, SchoolExample, Integer> {
}