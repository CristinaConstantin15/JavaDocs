package ro.teamnet.zth;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import ro.teamnet.zth.api.annotations.Z2HController;
import ro.teamnet.zth.fmk.MethodAttributes;
import ro.teamnet.zth.fmk.domain.HttpMethod;
import ro.teamnet.zth.utils.BeanDeserializator;
import ro.teamnet.zth.utils.ControllerScanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Z2HDispatcherServlet extends HttpServlet {
    private ControllerScanner controllerScanner;

    @Override
    public void init() throws ServletException {
        controllerScanner = new ControllerScanner("ro.teamnet.zth.appl.controller");
        controllerScanner.scan();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatchReply(req, resp, HttpMethod.GET);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatchReply(req, resp, HttpMethod.POST);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatchReply(req, resp, HttpMethod.DELETE);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatchReply(req, resp, HttpMethod.PUT);
    }

    private void dispatchReply(HttpServletRequest req, HttpServletResponse resp, HttpMethod methodType) {
        try {
            Object resultToDisplay = dispatch(req, methodType);
            reply(resp, resultToDisplay);
        } catch (Exception e) {
            try {
                sendExceptionError(e, resp);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    private void sendExceptionError(Exception e, HttpServletResponse resp) throws IOException {
        resp.getWriter().print(e.getMessage());
    }

    private void reply(HttpServletResponse resp, Object resultToDisplay) {
       /* try {
            resp.getWriter().write(resultToDisplay.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //TODO serialize the output(resultToDisplay = controllerinstance.invokeMethod(parameters)) into JSON
        // TODO using ObjectMapper (jackson)

        ObjectMapper obj = new ObjectMapper();
        try{
            resp.getWriter().write(obj.writeValueAsString(resultToDisplay.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Object dispatch(HttpServletRequest req, HttpMethod methodType) {
        //TODO to invoke the controller method for the current request and return the controller output
        MethodAttributes methodAttributes = controllerScanner.getMetaData(req.getPathInfo(), methodType);
        Method testMethod = methodAttributes.getMethod();
        testMethod.setAccessible(true);

        List<Object> parameters = BeanDeserializator.getMethodParams(testMethod, req);

        try{
            return testMethod.invoke(methodAttributes.getControllerClass().newInstance(), parameters.toArray());
        }catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }


}
