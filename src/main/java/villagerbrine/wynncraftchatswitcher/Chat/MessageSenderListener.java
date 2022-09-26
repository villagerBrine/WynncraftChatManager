package villagerbrine.wynncraftchatswitcher.Chat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import scala.collection.parallel.ParIterableLike;
import villagerbrine.wynncraftchatswitcher.WynnCraftChatSwitcher;

import static villagerbrine.wynncraftchatswitcher.WynnCraftChatSwitcher.*;
import static villagerbrine.wynncraftchatswitcher.chatConfig.guildMessage;
import static villagerbrine.wynncraftchatswitcher.chatConfig.partyMessage;


public class MessageSenderListener {
    public static List<String> chatSendMessage = new ArrayList();
    public static String chatMessageStarter = "";
    private Integer tick = 0;

    public MessageSenderListener() {
    }
    @SubscribeEvent(
            priority = EventPriority.HIGHEST
    )
    public void tickEvent(TickEvent.ClientTickEvent event) {

        if (chatSendMessage.size() != 0) {
            if (this.tick == 5) {
                this.tick = 0;
                Minecraft.getMinecraft().player.sendChatMessage(chatSendMessage.get(0));
                chatSendMessage.remove(0);
            } else {
                this.tick = this.tick + 1;
            }
        }
    }
    @SubscribeEvent
    public void setChatMessage(ClientChatEvent event) {
        if (!(event.getMessage().charAt(0) == '/')) {
            event.setMessage(chatMessageStarter + " " + event.getMessage());
        }
    }
    public static void chatShowMessage(String string) {
        Minecraft.getMinecraft().player.sendMessage(new TextComponentString("[" + ChatFormatting.RED + "ChatSwitcher" + ChatFormatting.RESET + "]: " + string));
    }
    @SubscribeEvent
    public void configChange(ConfigChangedEvent event) {
        if (event.getModID().equals(WynnCraftChatSwitcher.MOD_ID)) {
            System.out.println(WynnCraftChatSwitcher.MOD_ID + ": Configuration changed");
            ConfigManager.sync(WynnCraftChatSwitcher.MOD_ID, Config.Type.INSTANCE);
        }
    }
}
