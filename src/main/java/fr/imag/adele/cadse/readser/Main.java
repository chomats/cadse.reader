package fr.imag.adele.cadse.readser;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.osgi.framework.BundleContext;



import fr.imag.adele.cadse.core.CadseException;
import fr.imag.adele.cadse.core.impl.internal.CadseDomainImpl;
import fr.imag.adele.cadse.core.transaction.LogicalWorkspaceTransactionListener;
import fr.imag.adele.cadse.core.transaction.delta.ItemDelta;
import fr.imag.adele.fede.workspace.si.persistence.Persistence;
import fr.imag.adele.fede.workspace.si.initmodel.InitModel;
import fr.imag.adele.teamwork.db.ModelVersionDBService2;
import fr.imag.adele.cadse.workspace.si.defaultclassreferencer.DefaultClassReferencer;
import fr.imag.adele.teamwork.db.impl.ModelVersionDBImpl2;
import fr.imag.adele.teamwork.db.impl.ModelVersionDBImpl2;
import fr.imag.adele.cadse.cadseg.managers.mc.MC_StringToJavaElementManager;

public class Main {
	
	
	public static void main(String[] args) {
		Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).setLevel(Level.OFF);
		Logger.getLogger("SI.Workspace.InitModel").setLevel(Level.OFF);
		Logger.getLogger("CU.Workspace.Workspace").setLevel(Level.OFF);
		Logger.getLogger("icon").setLevel(Level.OFF);
		Logger.getLogger("CU.Workspace.EventsManager").setLevel(Level.OFF);
		
		java.io.File dir = new java.io.File(args[0]);
		StringBuilder sb = new StringBuilder();
		Persistence p  = new Persistence();
		InitModel initModel = new InitModel();
		initModel.classReferencer = new DefaultClassReferencer();
		CadseDomainImpl cadseDomainImpl = new CadseDomainImpl();
		cadseDomainImpl._initModelService = initModel;
		MainPlatform mainPlatform = new MainPlatform();
		mainPlatform._bundleContext = new MainBundleContext();
		ModelVersionDBImpl2 modelVersionDBImpl2 = new ModelVersionDBImpl2(mainPlatform._bundleContext);
		cadseDomainImpl._modelDB2Service = modelVersionDBImpl2;
		initModel.workspaceCU = cadseDomainImpl;
		initModel.platformService = mainPlatform;
		initModel.findModel = new MainFindModel();
		
		
		cadseDomainImpl.start();
		modelVersionDBImpl2.start();
		try {
			initModel.loadCadses();
			LogicalWorkspaceTransactionListener[] dd = new LogicalWorkspaceTransactionListener[0];
			PrintLogicalW wl = new PrintLogicalW(cadseDomainImpl.getLogicalWorkspace(), dd );
			if (args.length == 1) {
				File[] ser = dir.listFiles();
				for (int i = 0; i < ser.length; i++) {
					if (ser[i].getName().endsWith(".ser")) {
						try {
							ItemDelta loadedItem = p.loadFromPersistence(wl, ser[i].toURL());
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
					p.loadFromPersistence(wl, new File(dir, args[i]+".ser").toURL()).toString(sb, "");
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
			cadseDomainImpl.stop();
		}
	}
}
