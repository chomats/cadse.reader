package fr.imag.adele.cadse.readser;

import java.io.File;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.imag.adele.cadse.core.CadseException;
import fr.imag.adele.cadse.core.transaction.LogicalWorkspaceTransactionListener;
import fr.imag.adele.cadse.core.transaction.delta.ItemDelta;
import fr.imag.adele.cadse.embedded.EmbeddedCadse;

public class Main {
	
	
	public static void main(String[] args) {
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).setLevel(Level.OFF);
		Logger.getLogger("SI.Workspace.InitModel").setLevel(Level.OFF);
		Logger.getLogger("CU.Workspace.Workspace").setLevel(Level.OFF);
		Logger.getLogger("icon").setLevel(Level.OFF);
		Logger.getLogger("CU.Workspace.EventsManager").setLevel(Level.OFF);
		
		java.io.File dir = new java.io.File(args[0]);
		StringBuilder sb = new StringBuilder();
		
		EmbeddedCadse cadse = new EmbeddedCadse(false);
		
		try {
			cadse.start();
			LogicalWorkspaceTransactionListener[] dd = new LogicalWorkspaceTransactionListener[0];
			PrintLogicalW wl = new PrintLogicalW(cadse.getCadseDomain().getLogicalWorkspace(), dd );
			if (args.length == 1) {
				File[] ser = dir.listFiles();
				for (int i = 0; i < ser.length; i++) {
					if (ser[i].getName().endsWith(".ser")) {
						try {
							ItemDelta loadedItem = cadse.getPersistence().loadFromPersistence(wl, ser[i].toURL());
							if (loadedItem != null)
								loadedItem.toString(sb, "");
						} catch (MalformedURLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (CadseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			for (int i = 1; i < args.length; i++) {
				try {
					cadse.getPersistence().loadFromPersistence(wl, new File(dir, args[i]+".ser").toURL()).toString(sb, "");
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (CadseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(sb.toString());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			cadse.stop();
		}
	}
}
