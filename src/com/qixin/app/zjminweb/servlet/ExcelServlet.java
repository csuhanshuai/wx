package com.qixin.app.zjminweb.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.qixin.app.zjminweb.common.CommonTool;
import com.qixin.app.zjminweb.common.ExportExcel;
import com.qixin.app.zjminweb.model.Member;
import com.qixin.app.zjminweb.service.MemberService;

@Component
public class ExcelServlet extends HttpServlet
{
    @Resource
    private MemberService memberservice;

    /**
     * 序列号
     */
    private static final long serialVersionUID = 7362578413058874904L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String cardno = request.getParameter("cardno");
        String telephone = request.getParameter("telephone");
        try
        {
            List<Member> memberlist = this.memberservice.getMemberList(cardno,
                    telephone);

            String str = CommonTool.getNowDate("yyyyMMddHHmmssSSS") + ".xls";
            String path = request.getSession().getServletContext()
                    .getRealPath("exportfile" + File.separator + str);

            ExportExcel<Member> ee = new ExportExcel<Member>();
            ee.exportMember(memberlist, path);

            ee.download(path, response);
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
