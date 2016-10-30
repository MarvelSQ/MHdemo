package com.bmeit.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.zip.Inflater;

/**
 * Created by sunqiang on 2016/10/10.
 */
@Repository
public interface MemberTagDao extends JpaRepository<MemberTag, Integer> {

    @Query("select u from MemberTag u where u.memberId =?1 and u.type=?2")
    Iterable<MemberTag> getByMemberIDandType(Integer id, Integer type);
}