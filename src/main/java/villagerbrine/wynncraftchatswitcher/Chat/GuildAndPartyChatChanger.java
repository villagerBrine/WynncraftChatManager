package villagerbrine.wynncraftchatswitcher.Chat;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static villagerbrine.wynncraftchatswitcher.WynnCraftChatSwitcher.*;
import static villagerbrine.wynncraftchatswitcher.WynnCraftChatSwitcher.chatconfig;
import static villagerbrine.wynncraftchatswitcher.chatConfig.guildMessage;
import static villagerbrine.wynncraftchatswitcher.chatConfig.partyMessage;

public class GuildAndPartyChatChanger {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void changeGuildChatAndPartyChat(ClientChatReceivedEvent event) {
        String star = "\u2605";
        if (getMinecraftServer("wynncraft")) {
            int rank = 0;
            String formatted = event.getMessage().getFormattedText();
            if (formatted.startsWith("§3[")) {
                formatted = ChatFormatting.stripFormatting(formatted);
                String[] splitFormatted = formatted.split("]", 2);
                if (!formatted.contains("INFO")) {
                    splitFormatted[0] = splitFormatted[0].replace("[", "");
                    for (int i = 0; i < splitFormatted.length; i++) {
                        if (( String.valueOf(splitFormatted[0].charAt(i)).equals(star))) {
                            rank += 1;
                        }
                    }
                    splitFormatted[0] = (splitFormatted[0]).replace(star, "");
                    String receivedMessage = chatconfig.get(Configuration.CATEGORY_GENERAL, "guildMessage", guildMessage).getString().replace("{NAME}", splitFormatted[0]);
                    receivedMessage = receivedMessage.replace("{MESSAGE}", splitFormatted[1]);
                    receivedMessage = receivedMessage.replace("{RANK}", integerStringHashMap().get(rank));
                    event.setMessage(new TextComponentString(receivedMessage));
                }
            } else {
                if (formatted.startsWith("§7[§e")) {
                    ChatFormatting.stripFormatting(formatted);
                    String[] splitFormatted = formatted.split("]", 2);
                    splitFormatted[0] = splitFormatted[0].replace("[", "");
                    String receivedMessage = chatconfig.get(Configuration.CATEGORY_GENERAL,"partyMessage", partyMessage).getString().replace("{NAME}", splitFormatted[0]);
                    receivedMessage = receivedMessage.replace("{MESSAGE}", splitFormatted[1]);
                    event.setMessage(new TextComponentString(receivedMessage));
                }
            }
        }
    }
}
