package life.majiang.community.Mapper;

import life.majiang.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert("insert into QUESTION (TITLE, DESCRIPTION, GMT_CREATE, GMT_MODIFIED, CREATOR,TAG) " +
            "values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);

    @Select("select * from QUESTION order by GMT_CREATE desc limit #{offset},#{size} ")
    List<Question> list(Integer offset, Integer size);

    @Select("select count(1) from QUESTION")
    Integer count();

    @Select("select * from QUESTION where creator = #{userId} order by GMT_CREATE desc limit #{offset},#{size}")
    List<Question> listByUserId(Integer userId, Integer offset, Integer size);

    @Select("select count(1) from QUESTION where creator = #{userId} ")
    Integer countByUserId(Integer userId);
}
