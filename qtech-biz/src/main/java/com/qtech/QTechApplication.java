package com.qtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动程序
 *
 * @author qtech
 */
@SpringBootApplication
public class QTechApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(QTechApplication.class, args);
        System.out.println("丘钛用量控制系统启动成功！");
    }
}
