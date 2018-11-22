package com.example.demo.respository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by YF-20170911 on 2018/11/16.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{


    List<User> findByUsernameLike(String name);


    User findByUsername(String name);

    //通过用户id查询用户所具有的权限
    @Query(value = "select re.url from resource re where re.id in(SELECT rr.resource_id from role_resource rr where rr.role_id=(SELECT u.role_id from `user` u where u.id=?1)) ",nativeQuery = true)
    List<String> findPermissionById(Integer id);
}
