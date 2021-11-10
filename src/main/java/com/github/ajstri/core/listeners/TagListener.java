/*
 *  Copyright 2021 scorchedE.C.H.O
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.github.ajstri.core.listeners;

import com.github.ajstri.core.Main;
import com.github.ajstri.utilities.MessageUtilities;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

/**
 *  TagListener class of The Royal Palace project
 *
 * @author scorchedE.C.H.O
 * @since October 2021
 */
public class TagListener extends ListenerAdapter {

    final User botMention = Main.getApi().getSelfUser();
    String args;

    @Override
    @SuppressWarnings("ConstantConditions")
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {

        // Check if message or author is null
        if (!event.getMessage().equals(null) && event.getAuthor() != null) {
            // Check if message mentions the bot
            if (event.getMessage().getMentionedUsers().contains(botMention)) {

                args = event.getMessage().getContentRaw().replace(botMention.getAsMention(), "");

                // Check if they are asking for prefix
                if (args.contains("prefix")) {
                    event.getChannel().sendMessage(event.getAuthor().getAsMention() + ", the prefix is " + Main.getConfig().getPrefix()).queue();
                }
                // Check if they are asking for information
                else if (args.contains("info")) {
                    event.getChannel().sendMessageEmbeds(MessageUtilities.embedCoreInfo().build()).queue();
                }
            }
        }
    }
}