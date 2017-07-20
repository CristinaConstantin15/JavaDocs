package ro.teamnet.zth.appl.controllers;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;

/**
 * Created by Cristina.Constantin on 7/20/2017.
 */
@MyController(urlPath= "/department")
public class DepartmentController {
    public DepartmentController() {
    }

    @MyRequestMethod(urlPath = "/all", methodType = "GET")
    public String getAllDepartments (){
        return "allDepartments";
    }
}
