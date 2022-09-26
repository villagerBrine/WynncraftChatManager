package villagerbrine.wynncraftchatswitcher.Chat.Commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.config.Configuration;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static villagerbrine.wynncraftchatswitcher.Chat.MessageSenderListener.chatSendMessage;
import static villagerbrine.wynncraftchatswitcher.Chat.MessageSenderListener.chatShowMessage;
import static villagerbrine.wynncraftchatswitcher.WynnCraftChatSwitcher.chatconfig;
import static villagerbrine.wynncraftchatswitcher.WynnCraftChatSwitcher.toggled;
import static villagerbrine.wynncraftchatswitcher.chatConfig.guildTypeUsing;

public class SwitchGuildMessageRanksCommand implements ICommand {
    @Override
    public String getName() {
        return "RankToggle";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "RankToggle";
    }

    @Override
    public List<String> getAliases() {
        List<String> list = new ArrayList<>();
        list.add("rt");
        return list;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (toggled.equals("one")) {
            toggled = "two";
        } else if (toggled.equals("two")) {
            toggled = "one";
        }
        chatconfig.get(Configuration.CATEGORY_GENERAL, "guildTypeUsing", guildTypeUsing).set(toggled);
        chatShowMessage(ChatFormatting.GREEN + "You have toggled to guild rank type " + ChatFormatting.GOLD + toggled + ChatFormatting.GREEN + "!");
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }
}
