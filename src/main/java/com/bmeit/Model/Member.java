package com.bmeit.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.jar.Attributes;

/**
 * Created by sunqiang on 2016/9/29.
 */
@Entity
public class Member {
    private int id;
    private String name;
    private String position;
//    private Collection<ProjectMember> projects;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        if (id != member.id) return false;
        if (name != null ? !name.equals(member.name) : member.name != null) return false;
        if (position != null ? !position.equals(member.position) : member.position != null) return false;

        return true;
    }

//    @OneToMany
//    @JoinColumn(name="member_id")
//    public Collection<ProjectMember> getProjectMembers(){
//        return this.projectMembers;
//    }
//
//    public void setProjectMembers(Collection<ProjectMember> projectMembers){
//        this.projectMembers=projectMembers;
//    }

//    @OneToMany(targetEntity=ProjectMember.class,fetch = FetchType.LAZY)
//    @JoinColumn(name="member_id", referencedColumnName="member_id")
//    public Collection<ProjectMember> getProjects() {
//        return projects;
//    }

//    public void setProjects(Collection<ProjectMember> projects) {
//        this.projects = projects;
//    }


    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }
}
