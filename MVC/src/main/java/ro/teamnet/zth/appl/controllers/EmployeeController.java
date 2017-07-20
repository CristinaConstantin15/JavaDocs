package ro.teamnet.zth.appl.controllers;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;

/**
 * Created by Cristina.Constantin on 7/20/2017.
 */
@MyController(urlPath= "/employee")
public class EmployeeController {
    public EmployeeController() {
    }

    @MyRequestMethod(urlPath = "/one", methodType = "GET")
    public String getOneEmployee (){
        return "oneRandomEmployee";
    }

    @MyRequestMethod(urlPath = "/all", methodType = "GET")
    public String getAllEmployees (){
        return "allEmployees";
    }

    @MyRequestMethod(urlPath = "/create", methodType = "POST")
    public String save(){
        return null;
    }
}
