package com.bmeit.Model;

import org.hibernate.annotations.Cascade;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Created by sunqiang on 2016/9/29.
 */
@Entity
@Table(name = "project_member", schema = "mhdemodb", catalog = "")
public class ProjectMember {


    private int projectId;
    private int memberId;
    private String role;
    private String brief;
    private int id;
//    private Collection<Project> projects;

    public ProjectMember() {
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "project_id")
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column(name = "member_id")
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "brief")
    public String getBrief() {
        return brief;
    }
    public void setBrief(String brife) {
        this.brief = brife;
    }

//    @ManyToMany(targetEntity=Project.class,fetch = FetchType.LAZY)
//    @JoinColumn(name="id", referencedColumnName="project_id")
//    public Collection<Project> getProjects() {
//        return projects;
//    }
//
//    public void setProjects(Collection<Project> members) {
//        this.projects = members;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectMember that = (ProjectMember) o;

        if (projectId != that.projectId) return false;
        if (memberId != that.memberId) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        if (brief != null ? !brief.equals(that.brief) : that.brief != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = projectId;
        result = 31 * result + memberId;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        return result;
    }
}
