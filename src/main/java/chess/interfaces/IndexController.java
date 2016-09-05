package chess.interfaces;

import chess.core.Imagecaptcha.VerifyCodeUtils;
import chess.core.common.Constants;
import chess.domain.service.count.ICountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by YJH on 2016/4/13.
 */
@Controller
public class IndexController {

    @Autowired
    private ICountService countService;

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("page/index").addObject("count", countService.add());
    }

    @RequestMapping("/download")
    public ModelAndView download() {
        return new ModelAndView("page/download").addObject("count", countService.add());
    }

    @RequestMapping("/synopsis")
    public ModelAndView synopsis() {
        return new ModelAndView("page/synopsis").addObject("count", countService.add());
    }

    @RequestMapping("/rule")
    public ModelAndView rule() {
        return new ModelAndView("page/rule").addObject("count", countService.add());
    }

    @RequestMapping("/admin")
    public ModelAndView admin(HttpSession session) {
        if (null != session.getAttribute(Constants.SESSION_USER)) {
            return new ModelAndView("redirect:/logged");
        }
        return new ModelAndView("redirect:/login");
    }

    @RequestMapping(value = "/logged")
    public ModelAndView logged(HttpSession session) throws Exception {

        if (null != session.getAttribute(Constants.SESSION_USER)) {
            return new ModelAndView("redirect:/history/pagination");
        }

        return new ModelAndView("redirect:/login");
    }

    @RequestMapping(value = "/verificationCode")
    @ResponseBody
    public void verificationCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        //生成4位随机验证码
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4).toLowerCase();
        session.setAttribute("code", verifyCode);

        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        // 将图像输出到Servlet输出流中。
        int w = 200, h = 80;
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
    }

    @RequestMapping(value = "/page404")
    public ModelAndView page404() {
        return new ModelAndView("/error/404");
    }

    @RequestMapping(value = "/page500")
    public ModelAndView page500() {
        return new ModelAndView("/error/500");
    }

    @RequestMapping(value = "/ie_update")
    public ModelAndView ipUpdate() {
        return new ModelAndView("/IeUpdate");
    }
}
