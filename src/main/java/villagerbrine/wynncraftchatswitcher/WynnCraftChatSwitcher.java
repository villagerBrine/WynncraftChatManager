package villagerbrine.wynncraftchatswitcher;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod;
import villagerbrine.wynncraftchatswitcher.Chat.Commands.*;
import villagerbrine.wynncraftchatswitcher.Chat.MessageSenderListener;

import javax.security.auth.login.Configuration;
import java.io.File;
import java.util.HashMap;

@Mod(
        modid = WynnCraftChatSwitcher.MOD_ID,
        name = WynnCraftChatSwitcher.MOD_NAME,
        version = WynnCraftChatSwitcher.VERSION
)
public class WynnCraftChatSwitcher {

    public static final String MOD_ID = "wynncraftchatswitcher";
    public static final String MOD_NAME = "WynnCraftChatSwitcher";
    public static final String VERSION = "1.0";

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static WynnCraftChatSwitcher INSTANCE;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new PartyChatCommand());
        ClientCommandHandler.instance.registerCommand(new ChatCommand());
        ClientCommandHandler.instance.registerCommand(new GoToAllChat());
        ClientCommandHandler.instance.registerCommand(new GuildChatCommand());
        MinecraftForge.EVENT_BUS.register(new MessageSenderListener());
    }

    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }
    public static boolean getMinecraftServer(String ip) {
        if (Minecraft.getMinecraft().getCurrentServerData() != null) {
            return Minecraft.getMinecraft().getCurrentServerData().serverIP.toLowerCase().contains(ip);
        }
        return false;
    }

}
