package com.ujeat;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by MetalSteel on 2017/11/5.
 */
public class TicketProcess {
    public void generate(OutputStream os, String title, String num,String nickname,String cinema,String movie,String date) throws IOException {

        // 获取图片源头
        Image srcImg = ImageIO.read(new File("C:/a.png"));
        // 创建缓冲区图片
        BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null),
                srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);
        // 得到缓冲区图片画笔对象
        Graphics2D g = buffImg.createGraphics();
        // 设置对线段的锯齿状边缘处理
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        // 复制源图片到缓冲区图片
        g.drawImage(
                srcImg.getScaledInstance(srcImg.getWidth(null),
                        srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0,
                null);
        // 设置文字颜色
        g.setColor(Color.black);
        // 设置文字Font
        Font font = new Font("微软雅黑", Font.BOLD, 17);
        g.setFont(font);
        // 写标题
        g.drawString(title,150,30);
        // 写数量
        Font font1 = new Font("微软雅黑", Font.BOLD, 15);
        g.setFont(font1);
        g.drawString(num,310,30);
        // 写持票人
        Font font2 = new Font("宋体", Font.PLAIN, 16);
        g.setFont(font2);
        g.drawString(nickname,75,82);
        // 写影院
        g.drawString(cinema,75,114);
        // 写电影名称
        g.drawString(movie,75,142);
        // 写电影场次
        g.drawString(date,75,170);
        // 释放资源
        g.dispose();
        // 生成图片
        ImageIO.write(buffImg, "JPG", os);

    }
}
