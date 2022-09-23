package villagerbrine.wynncraftchatswitcher.Chat.Commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static villagerbrine.wynncraftchatswitcher.Chat.MessageSenderListener.*;
import static villagerbrine.wynncraftchatswitcher.WynnCraftChatSwitcher.getMinecraftServer;

public class ChatCommand implements ICommand {
    @Override
    public String getName() {
        return "chat";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "chat";
    }

    @Override
    public List<String> getAliases() {
        List<String> list = new ArrayList<>();
        list.add("chat");
        return list;
    }
    /**
     * Switches Prefix for Message Starter
     */
    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (getMinecraftServer("wynncraft")) {
            if (args[0].equals("g")) {
                chatMessageStarter = "/g";
                chatShowMessage(ChatFormatting.GREEN + "You have switched to " + ChatFormatting.DARK_GREEN + "Guild Chat" + ChatFormatting.GREEN + ".");
            } else if (args[0].equals("p")) {
                chatMessageStarter = "/p";
                chatShowMessage(ChatFormatting.GREEN + "You have switched to " + ChatFormatting.GOLD + "Party Chat" + ChatFormatting.GREEN + ".");
            } else if (args[0].equals("a")) {
                chatMessageStarter = "";
                chatShowMessage(ChatFormatting.GREEN + "You have switched to " + ChatFormatting.AQUA + "Normal Chat" + ChatFormatting.GREEN + ".");
            } else {
                chatShowMessage(ChatFormatting.RED + "You did not put in a applicable argument!");
            }
        }
        else {
            String string = "/chat";
            for (String arg : args) {
                string = string + " " + arg;
            }
            chatSendMessage.add(string);
        }

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
