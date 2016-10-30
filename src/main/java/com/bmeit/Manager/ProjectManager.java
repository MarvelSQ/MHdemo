package com.bmeit.Manager;

import com.bmeit.Model.Project;
import com.bmeit.Model.ProjectDao;
import com.bmeit.util.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.*;

/**
 * Created by sunqiang on 2016/10/8.
 */
public class ProjectManager {

    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private ProjectMemberManager projectMemberManager;

    private static ProjectManager instance = new ProjectManager();

    public static ProjectManager getInstance() {
        if(instance==null){
            instance=new ProjectManager();
        }
        return instance;
    }

    private ProjectManager() {

    }

    public LinkedList getAll(){
        //LinkedHashMap map=new LinkedHashMap();
        LinkedList i=new LinkedList<>();
        Iterable<Project> all=projectDao.findAll();
        for(Project p:all){
            i.add(handleCell(p));
        }
        return i;
    }

    public LinkedHashMap getAllPaged(int page,int count){
        LinkedHashMap map=new LinkedHashMap();
        LinkedList i=new LinkedList<>();
        Page<Project> pall=projectDao.findAll(new PageRequest(page,count));
        Iterable<Project> all=pall.getContent();
        for(Project p:all){
            i.add(handleCell(p));
        }
        map.put("list",i);
        map.put("page",new PageData(pall));
        return map;
    }

    private LinkedHashMap<String,Object> handleCell(Project project){
        LinkedHashMap cell=new LinkedHashMap();
        cell.put("id",project.getId());
        cell.put("name",project.getName());
        cell.put("summary",project.getSummary());
        cell.put("start_time",project.stringStartTime());
        cell.put("members",projectMemberManager.getByProjectId(project.getId()));
        return cell;
    }

    public Project getProject(int projectId) {
        return projectDao.findOne(projectId);
    }

    /*
    public Page<Task> getUserTask(Long userId, Map<String, Object> searchParams, int pageNumber, int pageSize,
                                  String sortType) {
        PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
        Specification<Task> spec = buildSpecification(userId, searchParams);

        return taskDao.findAll(spec, pageRequest);
    }
    */

    /**
     * 创建分页请求.
     */

    /*
    private PageRequest buildPageRequest(int pageNumber, int pagzSize, String sortType) {
        Sort sort = null;
        if ("auto".equals(sortType)) {
            sort = new Sort(Direction.DESC, "id");
        } else if ("title".equals(sortType)) {
            sort = new Sort(Direction.ASC, "title");
        }

        return new PageRequest(pageNumber - 1, pagzSize, sort);
    }*/

    /**
     * 创建动态查询条件组合.
     */
    /*
    private Specification<Task> buildSpecification(Long userId, Map<String, Object> searchParams) {
        Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
        filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
        Specification<Task> spec = DynamicSpecifications.bySearchFilter(filters.values(), Task.class);
        return spec;
    }
    */
}
