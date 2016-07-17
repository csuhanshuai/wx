package com.qixin.app.zjminweb.servlet;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.swetake.util.Qrcode;

public class QuickMarkServlet extends HttpServlet
{

    /**
     * 序列号
     */
    private static final long serialVersionUID = -610479038842072948L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        String code = req.getParameter("code");

        Qrcode testQrcode = new Qrcode();
        testQrcode.setQrcodeErrorCorrect('M');
        testQrcode.setQrcodeEncodeMode('B');
        testQrcode.setQrcodeVersion(7);
        byte[] d = code.getBytes("UTF-8");
        BufferedImage image = new BufferedImage(140, 140,
                BufferedImage.TYPE_BYTE_BINARY);
        Graphics2D g = image.createGraphics();
        // ---------- 增加下面的代码使得背景透明 -----------------
        image = g.getDeviceConfiguration().createCompatibleImage(140, 140,
                Transparency.TRANSLUCENT);

        g.dispose();

        g = image.createGraphics();
        // ---------- 背景透明代码结束 -----------------
        g.setBackground(Color.WHITE);
        g.clearRect(0, 0, 140, 140);
        g.setColor(Color.BLACK);
        if (d.length > 0 && d.length < 120)
        {
            boolean[][] s = testQrcode.calQrcode(d);
            for (int i = 0; i < s.length; i++)
            {
                for (int j = 0; j < s.length; j++)
                {
                    if (s[j][i])
                    {
                        g.fillRect(j * 2 + 3, i * 2 + 3, 2, 2);
                    }
                }
            }
        }
        g.dispose();
        image.flush();
        ImageIO.write(image, "png", resp.getOutputStream());
    }

}
