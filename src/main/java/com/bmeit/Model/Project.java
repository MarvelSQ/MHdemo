package com.bmeit.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by sunqiang on 2016/9/29.
 */
@Entity
public class Project {//extends LinkedHashMap{
    private int id;
    private String name;
    private String summary;
    private String descripHtml;
    private String descripMd;
//    private Collection<MemberNoProjects> members;
    private Timestamp startTime;

    public Project(){
//        put("id",id);
//        put("name",name);
//        put("summary",summary);
//        put("descrip_html",descripHtml);
//        put("descrip_md",descripMd);
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
        //return (int) this.get("id");
    }

    public void setId(int id) {
        this.id=id;
        //replace("id",id);
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
        //replace("name",name);
    }

    @Basic
    @Column(name = "summary")
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary=summary;
        //replace("summary", summary);
    }

    @Basic
    @Column(name = "descrip_html")
    public String getDescripHtml() {
        return descripHtml;
    }

    public void setDescripHtml(String descripHtml) {
        this.descripHtml=descripHtml;
        //replace("descrip_html",descripHtml);
    }

    @Basic
    @Column(name = "descrip_md")
    public String getDescripMd() {
        return descripMd;
    }
//
//    @ManyToMany(targetEntity=MemberNoProjects.class,fetch = FetchType.LAZY)
//    @JoinTable(name="project_member",
//            // 定义连接表中名为person_id的外键列，该外键列参照当前实体对应表的主键列
//            joinColumns=@JoinColumn(name="project_id", referencedColumnName="id"),
//            // 定义连接表中名为address_id的外键列，
//            // 该外键列参照当前实体的关联实体对应表的主键列
//            inverseJoinColumns=@JoinColumn(name="member_id", referencedColumnName="id")
//    )
//    public Collection<MemberNoProjects> getMembers() {
//        return members;
//    }
//
//    public void setMembers(Collection<MemberNoProjects> members) {
//        this.members = members;
//    }

    public void setDescripMd(String descripMd) {
        this.descripMd=descripMd;
//        replace("descrip_md",descripMd);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (id != project.id) return false;
        if (name != null ? !name.equals(project.name) : project.name != null) return false;
        if (summary != null ? !summary.equals(project.summary) : project.summary != null) return false;
        if (descripHtml != null ? !descripHtml.equals(project.descripHtml) : project.descripHtml != null) return false;
        if (descripMd != null ? !descripMd.equals(project.descripMd) : project.descripMd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (descripHtml != null ? descripHtml.hashCode() : 0);
        result = 31 * result + (descripMd != null ? descripMd.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "start_time")
    public Timestamp getStartTime() {
        return startTime;
    }

    public String stringStartTime() {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(startTime);
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }
}
