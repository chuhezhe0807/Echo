package com.greate.community.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: MybatisConfig
 * Package: com.greate.community.config
 * Description:
 *      Mapper扫描配置与其他配置分开，所以重新写了一个Mybatis配置类
 *
 * @Author Chuhezhe
 * @Create 2024/12/2 22:42
 * @Version 1.0
 */
@Configuration
@MapperScan({"com.greate.community.dao"})
public class MybatisConfig {
}
