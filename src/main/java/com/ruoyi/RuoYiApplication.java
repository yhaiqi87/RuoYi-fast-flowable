package com.ruoyi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 *
 * @author ruoyi
 */
@Slf4j
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class RuoYiApplication
{
    public static void main(String[] args)
    {
        long l1 = System.currentTimeMillis();
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(RuoYiApplication.class, args);
        // log.info("(♥◠‿◠)ﾉﾞ  若依启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
        //         " .-------.       ____     __        \n" +
        //         " |  _ _   \\      \\   \\   /  /    \n" +
        //         " | ( ' )  |       \\  _. /  '       \n" +
        //         " |(_ o _) /        _( )_ .'         \n" +
        //         " | (_,_).' __  ___(_ o _)'          \n" +
        //         " |  |\\ \\  |  ||   |(_,_)'         \n" +
        //         " |  | \\ `'   /|   `-'  /           \n" +
        //         " |  |  \\    /  \\      /           \n" +
        //         " ''-'   `'-'    `-..-'              ");
        log.info("========================================");
        log.info("================启动成功，================耗时{}ms",System.currentTimeMillis()-l1);
        log.info("========================================");
    }
}
