package com.bmeit.Controller;

import com.bmeit.Manager.ImgManager;
import com.bmeit.Manager.MemberManager;
import com.bmeit.Manager.ProjectManager;
import com.bmeit.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by sunqiang on 2016/9/27.
 */
@RestController
@RequestMapping(value = "/api")
public class ApiProjectController{

    @Autowired
    private ImgManager imgManager;

    @Autowired
    private ProjectManager projectManager;

    @Autowired
    private MemberManager memberManager;

    @RequestMapping(value = "/p",method = RequestMethod.GET)
    public Object getAll(){
        return new Message(Message.OK,projectManager.getAll());
    }

    @RequestMapping(value = "/admin/p",method = RequestMethod.GET)
    public Object getAlla(){
        return new Message(Message.OK,memberManager.getAll());
    }

    @RequestMapping(value = "/p/{id}",method = RequestMethod.GET)
    public Object getId(@PathVariable int id){
        return new Message(Message.OK,projectManager.getAllPaged(id,10));
    }

    @RequestMapping(value = "/admin/p/{id}",method = RequestMethod.GET)
    public Object getIda(@PathVariable int id){
        return new Message(Message.OK,memberManager.getAllPaged(id,10));
    }

    @RequestMapping(value = "/p/{id}/m/",method = RequestMethod.GET)
    public Object getIdMembers(@PathVariable int id){
        return new Message(Message.OK,"{'haha':"+id+"}","{'haha':nimen}");
    }

    @RequestMapping(value = "/admin/p/{id}/m/",method = RequestMethod.GET)
    public Object getIdMembersa(@PathVariable int id){
        return new Message(Message.OK,"{'haha':"+id+"}","{'haha':nimen}");
    }

    @RequestMapping(value = "/admin/project/pictures/",method = RequestMethod.GET)
    public Object getIdPics(){
        return new Message(Message.OK,null);
    }

    @RequestMapping(value = "/admin/project/pictures/",method = RequestMethod.POST)
    public Object setIdPics(@RequestParam("file") MultipartFile file){
        String msg=imgManager.saveFile(file);
        return new Message(Message.OK,msg+file.getContentType());
    }
}
