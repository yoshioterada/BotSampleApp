/*
 * Copyright 2017 Yoshio Terada
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yoshio3;

import com.yoshio3.rest.entities.bot.MessageFromBotFrameWork;
import java.util.logging.Logger;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Bot MessageReceiver This class receive the message from Cliant Application
 * like Web, Skype, FaceBook, Slack and so on. After receviced the message, it
 * pass the message to the LUIS and caluculate the most possible pattern.
 *
 * @author Yoshio Terada
 */
@Path("message")
public class BotMessageReceiver {

    private final static Logger LOGGER = Logger.getLogger(BotMessageReceiver.class.getName());

    /**
     * GET Action for debug
     *
     * In order to handle the message from clients, this methos is the entry
     * pont of this class.
     *
     * @return {@code Response} You received the message, you have to send back
     * to the "ACCEPTED" response to the client. And concurrently, you need to
     * operate somethings.
     */    
    @GET
    public Response get() {
        return Response.ok("Hello World", MediaType.TEXT_PLAIN).status(Response.Status.ACCEPTED).build();
    }

    /**
     * GET Action
     *
     * In order to handle the message from clients, this methos is the entry
     * pont of this class.
     *
     * @param message messages from the clients
     * @return {@code Response} You received the message, you have to send back
     * to the "ACCEPTED" response to the client. And concurrently, you need to
     * operate somethings.
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(String message) {
        if (message != null) {
            JsonbConfig nillableConfig = new JsonbConfig()
                    .withNullValues(true);
            Jsonb jsonb = JsonbBuilder.create(nillableConfig);
            MessageFromBotFrameWork fromJson = jsonb.fromJson(message, MessageFromBotFrameWork.class);
            System.out.println(fromJson);
        }
        return Response.ok().status(Response.Status.ACCEPTED).build();
    }
}
