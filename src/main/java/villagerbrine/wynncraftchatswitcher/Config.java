package villagerbrine.wynncraftchatswitcher;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraftforge.common.config.Configuration;


import static villagerbrine.wynncraftchatswitcher.WynnCraftChatSwitcher.chatconfig;

public class chatConfig {
    public static String guildTypeUsing = "one";
    public static String partyMessage = ChatFormatting.BLUE + "Party" + ChatFormatting.WHITE + " > "+ " {NAME}" + ChatFormatting.RESET + ": " + "{MESSAGE}";
    public static String guildMessage = ChatFormatting.DARK_GREEN + "Guild" + ChatFormatting.WHITE + " > " + "{RANK}" + " " +  "{NAME}" + ChatFormatting.RESET + ": " + "{MESSAGE}";
    public static String recruitTypeOne = ChatFormatting.GREEN + "[RECRUIT]";
    public static String recruiterTypeOne = ChatFormatting.AQUA + "[RECRUITER]";
    public static String captainTypeOne = ChatFormatting.BLUE + "[CAPTN]";
    public static String strategistTypeOne = ChatFormatting.DARK_BLUE + "[STRAT]";
    public static String chiefTypeOne = ChatFormatting.LIGHT_PURPLE + "[CHIEF]";
    public static String leaderTypeOne = ChatFormatting.DARK_PURPLE + "[LEADER]";
    public static String recruitTypeTwo = ChatFormatting.GREEN + "\u2727";
    public static String recruiterTypeTwo = ChatFormatting.AQUA + "\u272e";
    public static String captainTypeTwo = ChatFormatting.BLUE + "\u2732";
    public static String strategistTypeTwo = ChatFormatting.DARK_BLUE + "\u22C8";
    public static String chiefTypeTwo = ChatFormatting.LIGHT_PURPLE + "\u2748";
    public static String leaderTypeTwo = ChatFormatting.DARK_PURPLE + "\u2742";
    public static void loadChatConfig() {
        chatconfig.get(Configuration.CATEGORY_GENERAL,"partyMessage", partyMessage);
        chatconfig.get(Configuration.CATEGORY_GENERAL,"guildTypeUsing", guildTypeUsing);
        chatconfig.get(Configuration.CATEGORY_GENERAL,"guildMessage", guildMessage);
        chatconfig.get(Configuration.CATEGORY_GENERAL, "recruitTypeOne", recruitTypeOne);
        chatconfig.get(Configuration.CATEGORY_GENERAL, "recruitTypeTwo", recruitTypeTwo);
        chatconfig.get(Configuration.CATEGORY_GENERAL, "recruiterTypeOne", recruiterTypeOne);
        chatconfig.get(Configuration.CATEGORY_GENERAL, "recruiterTypeTwo", recruiterTypeTwo);
        chatconfig.get(Configuration.CATEGORY_GENERAL, "captainTypeOne", captainTypeOne);
        chatconfig.get(Configuration.CATEGORY_GENERAL, "captainTypeTwo", captainTypeTwo);
        chatconfig.get(Configuration.CATEGORY_GENERAL, "strategistTypeOne", strategistTypeOne);
        chatconfig.get(Configuration.CATEGORY_GENERAL, "strategistTypeTwo", strategistTypeTwo);
        chatconfig.get(Configuration.CATEGORY_GENERAL, "chiefTypeOne", chiefTypeOne);
        chatconfig.get(Configuration.CATEGORY_GENERAL, "chiefTypeTwo", chiefTypeTwo);
        chatconfig.get(Configuration.CATEGORY_GENERAL, "leaderTypeOne", leaderTypeOne);
        chatconfig.get(Configuration.CATEGORY_GENERAL, "leaderTypeTwo", leaderTypeTwo);
    }

}
