package hu.schonherz.java.training.kovtamas.jdbcpractice.web.servlet;

import hu.schonherz.java.training.kovtamas.jdbcpractice.service.api.ParticipantService;
import hu.schonherz.java.training.kovtamas.jdbcpractice.service.impl.ParticipantServiceImpl;
import hu.schonherz.java.training.kovtamas.jdbcpractice.service.vo.ParticipantVO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(
        path = "/new",
        method = {RequestMethod.GET, RequestMethod.POST},
        produces = MediaType.TEXT_HTML_VALUE)
public class NewServlet extends HttpServlet {

    private final ParticipantService participantService;

    public NewServlet() {
        participantService = new ParticipantServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        participantService.save(convertToVo(req));
    }

    private ParticipantVO convertToVo(HttpServletRequest req) {
        ParticipantVO vo = new ParticipantVO();
        vo.setName(req.getParameter("nameInput"));
        vo.setEmail(req.getParameter("emailInput"));
        return vo;
    }

}
