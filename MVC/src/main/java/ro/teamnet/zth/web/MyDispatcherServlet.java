package ro.teamnet.zth.web;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.controllers.DepartmentController;
import ro.teamnet.zth.appl.controllers.EmployeeController;
import ro.teamnet.zth.fmk.MethodAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Cristina.Constantin on 7/20/2017.
 */
public class MyDispatcherServlet extends HttpServlet{
    Map<String, MethodAttributes> allowedMethods;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dispatch(request, response, "GET");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dispatch(request, response, "POST");
    }

    private void dispatchReply(HttpServletRequest request, HttpServletResponse response, String reqType){
        try{
            Object resultToDisplay = dispatch(request, response, reqType);
            reply(response, resultToDisplay);
        }catch(Exception exp){
            sendExceptionErro();
        }
    }

    public void init(){
        allowedMethods = new HashMap<String, MethodAttributes>();


    }

    private Object dispatch(HttpServletRequest request, HttpServletResponse response, String reqType)  {
        MyController controller = request.getClass().getDeclaredAnnotation(MyController.class);
        String result = null;
        if(controller.urlPath().equals("/employee")){
            MyRequestMethod requestMethod = request.getClass().getDeclaredAnnotation(MyRequestMethod.class);
            if(requestMethod.urlPath().equals("/one") && requestMethod.methodType().equals(reqType)){
                Method method = null;
                try {
                    method = EmployeeController.class.getMethod("getOneEmployee", String.class);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                try {
                    assert method != null;
                    result = (String) method.invoke(new EmployeeController());
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }else if(requestMethod.urlPath().equals("/all")){
                Method method = null;
                try {
                    method = EmployeeController.class.getMethod("getAllEmployee", String.class);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                try {
                    assert method != null;
                    result = (String) method.invoke(new EmployeeController());
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }else{

            }

        }else if(controller.urlPath().equals("/department")){
            MyRequestMethod requestMethod = request.getClass().getDeclaredAnnotation(MyRequestMethod.class);
            if(requestMethod.urlPath().equals("/all")){
                Method method = null;
                try {
                    method = DepartmentController.class.getMethod("getAllDepartments", String.class);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                try {
                    assert method != null;
                    result = (String) method.invoke(new DepartmentController());
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }else{

            }
        }else{

        }

        return result;
    }

    private void reply(HttpServletResponse response, Object resultToDisplay){
        try {
            response.getWriter().write(resultToDisplay.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendExceptionErro(){

    }

}
