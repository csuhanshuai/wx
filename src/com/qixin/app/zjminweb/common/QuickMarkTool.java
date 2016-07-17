package com.qixin.app.zjminweb.common;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

public class QuickMarkTool
{
    public static boolean creatQuickMark(String filepath, String param)
            throws Exception
    {

        Qrcode qrcode = new Qrcode();

        qrcode.setQrcodeErrorCorrect('M');

        qrcode.setQrcodeEncodeMode('B');

        qrcode.setQrcodeVersion(7);

        byte[] bstr = param.getBytes("UTF-8");

        BufferedImage bi = new BufferedImage(140, 140,
                BufferedImage.TYPE_INT_RGB);

        Graphics2D g = bi.createGraphics();
        // ---------- 增加下面的代码使得背景透明 -----------------
        bi = g.getDeviceConfiguration().createCompatibleImage(140, 140,
                Transparency.TRANSLUCENT);

        g.dispose();

        g = bi.createGraphics();
        // ---------- 背景透明代码结束 -----------------
        g.setBackground(Color.WHITE); // 背景颜色

        g.clearRect(0, 0, 140, 140);

        g.setColor(Color.BLACK); // 条码颜色

        if (bstr.length > 0 && bstr.length < 120)
        {

            boolean[][] b = qrcode.calQrcode(bstr);

            for (int i = 0; i < b.length; i++)
            {

                for (int j = 0; j < b.length; j++)
                {

                    if (b[j][i])
                    {

                        g.fillRect(j * 3 + 2, i * 3 + 2, 3, 3);

                    }

                }

            }

        }

        g.dispose();

        bi.flush();

        File f = new File(filepath);

        return ImageIO.write(bi, "png", f);

    }
}
