package com.bmeit.Manager;

import com.bmeit.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheAnnotationParser;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by sunqiang on 2016/10/10.
 */
public class MemberTagManager {
    @Autowired
    MemberTagDao mtdao;

    @Autowired
    PlatformDao platformDao;

    @Autowired
    LanguageDao languageDao;

    @Autowired
    DatabaseDao databaseDao;

    @Autowired
    FrameworkDao frameworkDao;

    private static MemberTagManager instance = new MemberTagManager();

    private MemberTagManager() {
        super();
    }

    public static MemberTagManager getInstance() {
        if (instance == null) {
            instance = new MemberTagManager();
        }
        return instance;
    }

    public LinkedList getByMemberIDandType(int memberid,int type){
        LinkedList list=new LinkedList();
        Iterable<MemberTag> all=mtdao.getByMemberIDandType(memberid,type);
        for(MemberTag mt:all){
            list.add(handleCell(mt));
        }
        return list;
    }

    private HashMap handleCell(MemberTag tag){
        HashMap map=new HashMap();
        map.put("id",tag.getId());
        switch (tag.getType()){
            case 0:
                map.put("name",languageDao.findOne(tag.getTagId()).getName());
                break;
            case 1:
                map.put("name",frameworkDao.findOne(tag.getTagId()).getName());
                break;
            case 2:
                map.put("name",platformDao.findOne(tag.getTagId()).getName());
                break;
            case 3:
                map.put("name",databaseDao.findOne(tag.getTagId()).getName());
                break;
            default:
                return null;
        }
        return map;
    }
}
