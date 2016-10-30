package com.bmeit.Manager;

import com.bmeit.Model.Member;
import com.bmeit.Model.MemberDao;
import com.bmeit.util.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Created by sunqiang on 2016/10/8.
 */
public class MemberManager {

    @Autowired
    MemberDao memberDao;

    @Autowired
    ProjectMemberManager projectMemberManager;

    private static MemberManager instance = new MemberManager();

    private MemberManager() {
        super();
    }

    public static MemberManager getInstance() {
        if (instance == null) {
            instance = new MemberManager();
        }
        return instance;
    }

    public LinkedList getAll(){
        //LinkedHashMap map=new LinkedHashMap();
        LinkedList i=new LinkedList<>();
        Iterable<Member> all=memberDao.findAll();
        for(Member m:all){
            i.add(handleCell(m));
        }
        //map.put("list",i);
        return i;
    }

    public LinkedHashMap getAllPaged(int page,int count){
        LinkedHashMap map=new LinkedHashMap();
        LinkedList i=new LinkedList<>();
        Page<Member> pall=memberDao.findAll(new PageRequest(page,count));
        Iterable<Member> all=pall.getContent();
        for(Member m:all){
            i.add(handleCell(m));
        }
        map.put("list",i);
        map.put("page",new PageData(pall));
        return map;
    }

    public Member getMember(int id){
        return memberDao.findOne(id);
    }

    private LinkedHashMap<String,Object> handleCell(Member member){
        LinkedHashMap cell=new LinkedHashMap();
        cell.put("id",member.getId());
        cell.put("name",member.getName());
        cell.put("summary",member.getPosition());
        cell.put("projects",projectMemberManager.getByMemberId(member.getId()));
        return cell;
    }
}
