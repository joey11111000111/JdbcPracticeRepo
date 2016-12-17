/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.schonherz.java.training.kovtamas.jdbcpractice.web.servlet;

import hu.schonherz.java.training.kovtamas.jdbcpractice.service.api.ParticipantService;
import hu.schonherz.java.training.kovtamas.jdbcpractice.service.impl.ParticipantServiceImpl;
import hu.schonherz.java.training.kovtamas.jdbcpractice.service.vo.ParticipantVO;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/new")
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
