package alex.dao;

import alex.BaseMapper;
import alex.dto.Person;
import alex.dto.PersonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonMapper extends BaseMapper<Person, PersonExample, Integer> {
}