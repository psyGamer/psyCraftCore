package de.psyCraft.Core;

import com.onarandombox.MultiverseCore.MultiverseCore;
import de.psyCraft.Core.api.game.TestServer;
import de.psyCraft.Core.api.registry.ServerRegistry;
import de.psyCraft.Core.core.commands.*;
import de.psyCraft.Core.core.hub.listeners.HubClickListener;
import de.psyCraft.Core.core.hub.listeners.HubInteractionListener;
import de.psyCraft.Core.core.hub.listeners.HubJoinListener;
import de.psyCraft.Core.util.inventory.AnvilEventInventory;
import de.psyCraft.Core.util.inventory.BaseInventory;
import de.psyCraft.Core.util.inventory.EventInventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class PsyCraftCore extends JavaPlugin {
	
	public static final String prefix = "&#0FFA04psyCraft";
	
	
	private static PsyCraftCore instance;
	private static MultiverseCore multiverseCore;
	
	private static Logger logger;
	
	public static PsyCraftCore getInstance() {
		return instance;
	}
	
	public static MultiverseCore getMultiverseCore() {
		return multiverseCore;
	}
	
	public static Logger logger() {
		return logger;
	}
	
	@Override
	public void onEnable() {
		instance = this;
		
		multiverseCore = (MultiverseCore) getServer().getPluginManager().getPlugin("Multiverse-Core");
		
		logger = getLogger();
		
		ServerRegistry.registerServer(TestServer.class, 0);
		
		register();
	}
	
	private void register() {
		registerCommands();
		registerListeners(getServer().getPluginManager());
	}
	
	private void registerCommands() {
		getCommand("npc").setExecutor(new NpcCommand(this));
		getCommand("remove").setExecutor(new RemoveCommand(this));
		getCommand("head").setExecutor(new Skull());
		getCommand("open").setExecutor(new OpenCommand());
		getCommand("server").setExecutor(new ServrCommand());
		getCommand("reset").setExecutor(new ResetCommand());

//		new ServerCommand();
		
	}
	
	private void registerListeners(PluginManager manager) {
		manager.registerEvents(new HubClickListener(), this);
		manager.registerEvents(new HubInteractionListener(), this);
		manager.registerEvents(new HubJoinListener(), this);
		
		manager.registerEvents(new BaseInventory.InventoryListener(), this);
		manager.registerEvents(new EventInventory.ClickListener(), this);
		manager.registerEvents(new AnvilEventInventory.ClickListener(), this);
	}
	
	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}
}
