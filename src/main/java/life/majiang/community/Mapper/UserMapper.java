package life.majiang.community.Mapper;

import life.majiang.community.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Insert("insert into user (account_id, name, token, gmt_create, gmt_modified,AVATAR_URL) " +
            "values (#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified},#{avatarUrl})")
    void insert(User user);

    @Select("select * from USER where token = #{token}")
    User findByToken(@Param("token") String token);

    @Select("select * from USER where id = #{creator}")
    User findById(Integer creator);

    @Select("select * from USER where account_id = #{accountId}")
    User findByAccountId(String accountId);

    @Update("update user set name = #{name} , token = #{token}," +
            "gmt_modified = #{gmtModified} , avatar_url = #{avatarUrl} where id = #{id}")
    void update(User user);
}
