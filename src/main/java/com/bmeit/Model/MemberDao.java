package com.bmeit.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sunqiang on 2016/9/29.
 */
@Repository
public interface MemberDao extends JpaRepository<Member,Integer> {

}
