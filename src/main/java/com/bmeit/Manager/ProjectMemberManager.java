package com.bmeit.Manager;

import com.bmeit.Model.Member;
import com.bmeit.Model.Project;
import com.bmeit.Model.ProjectMember;
import com.bmeit.Model.ProjectMemberDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * Created by sunqiang on 2016/10/8.
 */
public class ProjectMemberManager {

    @Autowired
    private ProjectMemberDao pmdao;

    @Autowired
    private MemberManager memberManager;

    @Autowired
    private ProjectManager projectManager;

    private static ProjectMemberManager instance = new ProjectMemberManager();

    public static ProjectMemberManager getInstance() {
        if(instance==null){
            instance=new ProjectMemberManager();
        }
        return instance;
    }

    private ProjectMemberManager() {

    }

    public LinkedHashMap<String,Object> getAll(){
        return null;
    }

    public LinkedList getByProjectId(int id){
        LinkedList list=new LinkedList<>();
        Iterable<ProjectMember> i=pmdao.getMemberByProjectId(id);
        i.forEach(projectMember -> list.add(handelMemberCell(projectMember)));
        return list;
    }

    public LinkedList getByMemberId(int id){
        LinkedList list=new LinkedList<>();
        Iterable<ProjectMember> i=pmdao.getMemberByMemberId(id);
        i.forEach(projectMember -> list.add(handelProjectCell(projectMember)));
        return list;
    }

    private HashMap<String,Object> handelMemberCell(ProjectMember projectMember){
        LinkedHashMap cell=new LinkedHashMap();
        Member member=memberManager.getMember(projectMember.getMemberId());
        cell.put("id",member.getId());
        cell.put("name",member.getName());
        cell.put("position",member.getPosition());
        cell.put("role",projectMember.getRole());
        cell.put("brief",projectMember.getBrief());
        return cell;
    }

    private HashMap<String,Object> handelProjectCell(ProjectMember projectMember){
        LinkedHashMap cell=new LinkedHashMap();
        Project project=projectManager.getProject(projectMember.getProjectId());
        cell.put("id",project.getId());
        cell.put("name",project.getName());
        cell.put("position",project.getSummary());
        cell.put("start_time",project.stringStartTime());
        cell.put("role",projectMember.getRole());
        cell.put("brief",projectMember.getBrief());
        return cell;
    }
}
