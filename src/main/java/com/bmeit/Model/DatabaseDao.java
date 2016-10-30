package com.bmeit.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sunqiang on 2016/10/10.
 */
@Repository
public interface DatabaseDao extends JpaRepository<Database, Integer> {

}