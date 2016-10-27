package com.car.training.action.website;

import com.car.training.service.CaptchManager;
import org.apache.struts2.ServletActionContext;
import org.ironrhino.core.metadata.AutoConfig;
import org.ironrhino.core.struts.BaseAction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@AutoConfig
public class CaptchAction extends BaseAction {

    private static final long serialVersionUID = -2872618258899872140L;

    @Autowired
    private transient CaptchManager captchManager;

    private String token;

    public String captimg() {
        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest request = ServletActionContext.getRequest();

        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        try {
            ImageIO.write(captchManager.refreshCode(request.getSession().getId()), "JPEG", response.getOutputStream());
            response.getOutputStream().close();
            ServletActionContext.getContext().getActionInvocation().getProxy().setExecuteResult(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
