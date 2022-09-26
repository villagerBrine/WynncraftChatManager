package villagerbrine.wynncraftchatswitcher;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod;
import villagerbrine.wynncraftchatswitcher.Chat.Commands.*;
import villagerbrine.wynncraftchatswitcher.Chat.GuildAndPartyChatChanger;
import villagerbrine.wynncraftchatswitcher.Chat.MessageSenderListener;

import java.io.File;
import java.util.HashMap;

import static villagerbrine.wynncraftchatswitcher.Config.*;
import static villagerbrine.wynncraftchatswitcher.chatConfig.*;


@Mod(
        modid = WynnCraftChatSwitcher.MOD_ID,
        name = WynnCraftChatSwitcher.MOD_NAME,
        version = WynnCraftChatSwitcher.VERSION
)
public class WynnCraftChatSwitcher {

    public static final String MOD_ID = "wynncraftchatswitcher";
    public static final String MOD_NAME = "WynnCraftChatSwitcher";
    public static final String VERSION = "BETA-1.0";
    public static String toggled = guildTypeUsing;
    private static final String configFile = "chatSwitcher.config";
    private static final String chatConfigFile = "chat.config";
    public static Configuration chatconfig;
    public static Configuration config;


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
        config = new Configuration(new File("mods/WynnCraftChatSwitcher", configFile));
        loadConfig();
        try {
            config.load();
        } catch (Exception e) {
            System.out.println("ChatSwitcher could not get config!");
        } finally {
            config.save();
        }
        if (config.get(Configuration.CATEGORY_GENERAL,"toggleHypixelChatCommands", toggleHypixelCommands).getBoolean()) {
            ClientCommandHandler.instance.registerCommand(new PartyChatCommand());
            ClientCommandHandler.instance.registerCommand(new ChatCommand());
            ClientCommandHandler.instance.registerCommand(new GoToAllChat());
            ClientCommandHandler.instance.registerCommand(new GuildChatCommand());
            ClientCommandHandler.instance.registerCommand(new PartyLeaveChatCommand());
        }
        if (config.get(Configuration.CATEGORY_GENERAL,"toggleCustomGuildAndPartyChat", toggleChat).getBoolean()) {
            ClientCommandHandler.instance.registerCommand(new ChangeConfigRankCommand());
            ClientCommandHandler.instance.registerCommand(new SwitchGuildMessageRanksCommand());
            ClientCommandHandler.instance.registerCommand(new ReloadConfig());
            MinecraftForge.EVENT_BUS.register(new GuildAndPartyChatChanger());
        }
        MinecraftForge.EVENT_BUS.register(new MessageSenderListener());
        chatconfig = new Configuration(new File("mods/WynnCraftChatSwitcher", chatConfigFile));
        loadChatConfig();
        try {
            chatconfig.load();
        } catch (Exception e) {
            System.out.println("ChatSwitcher could not get chat config!");
        } finally {
            chatconfig.save();
        }
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
    public static HashMap<Integer, String> integerStringHashMap() {
        HashMap<Integer, String> rankMap = new HashMap<>();
        rankMap.put(0, "null");
        if (toggled.equals("one")) {
            rankMap.put(0, chatconfig.get(Configuration.CATEGORY_GENERAL,"recruitTypeOne", recruitTypeOne).getString());
            rankMap.put(1, chatconfig.get(Configuration.CATEGORY_GENERAL,"recruiterTypeOne", recruiterTypeOne).getString());
            rankMap.put(2, chatconfig.get(Configuration.CATEGORY_GENERAL,"captainTypeOne", captainTypeOne).getString());
            rankMap.put(3, chatconfig.get(Configuration.CATEGORY_GENERAL,"strategistTypeOne", strategistTypeOne).getString());
            rankMap.put(4, chatconfig.get(Configuration.CATEGORY_GENERAL,"chiefTypeOne", chiefTypeOne).getString());
            rankMap.put(5, chatconfig.get(Configuration.CATEGORY_GENERAL,"leaderTypeOne", leaderTypeOne).getString());
        }
        if (toggled.equals("two")) {
            rankMap.put(0, chatconfig.get(Configuration.CATEGORY_GENERAL,"recruitTypeTwo", recruitTypeTwo).getString());
            rankMap.put(1, chatconfig.get(Configuration.CATEGORY_GENERAL,"recruiterTypeTwo", recruiterTypeTwo).getString());
            rankMap.put(2, chatconfig.get(Configuration.CATEGORY_GENERAL,"captainTypeTwo", captainTypeTwo).getString());
            rankMap.put(3, chatconfig.get(Configuration.CATEGORY_GENERAL,"strategistTypeTwo", strategistTypeTwo).getString());
            rankMap.put(4, chatconfig.get(Configuration.CATEGORY_GENERAL,"chiefTypeTwo", chiefTypeTwo).getString());
            rankMap.put(5, chatconfig.get(Configuration.CATEGORY_GENERAL,"leaderTypeTwo", leaderTypeTwo).getString());
        }
        return rankMap;
    }

}
