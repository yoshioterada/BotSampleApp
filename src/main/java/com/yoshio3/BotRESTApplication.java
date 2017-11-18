/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yoshio3;

import com.yoshio3.rest.entities.bot.BotObjectMapperProvider;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author yoterada
 */
@ApplicationPath("/rest")
public class BotRESTApplication extends ResourceConfig {

    public BotRESTApplication() {
        packages(BotRESTApplication.class.getPackage().getName());
        super.register(BotObjectMapperProvider.class);
        super.register(JacksonFeature.class);
    }
}
