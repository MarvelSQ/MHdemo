package com.bmeit.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by sunqiang on 2016/9/29.
 */
@Repository
public interface ProjectMemberDao extends JpaRepository<ProjectMember, Integer> {

    @Query("select u from ProjectMember u where u.memberId =?1")
    Collection<ProjectMember> getMemberByMemberId(Integer id);

    @Query("select u from ProjectMember u where u.projectId =?1")
    Collection<ProjectMember> getMemberByProjectId(Integer id);
}
