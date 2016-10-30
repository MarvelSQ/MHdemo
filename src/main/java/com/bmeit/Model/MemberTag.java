package com.bmeit.Model;

import javax.persistence.*;

/**
 * Created by sunqiang on 2016/10/10.
 */
@Entity
@Table(name = "member_tag", schema = "mhdemodb", catalog = "")
public class MemberTag {
    private int id;
    private int memberId;
    private int tagId;
    private int type;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "tag_id")
    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    @Basic
    @Column(name = "type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MemberTag memberTag = (MemberTag) o;

        if (id != memberTag.id) return false;
        if (memberId != memberTag.memberId) return false;
        if (tagId != memberTag.tagId) return false;
        if (type != memberTag.type) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + memberId;
        result = 31 * result + tagId;
        result = 31 * result + type;
        return result;
    }
}
