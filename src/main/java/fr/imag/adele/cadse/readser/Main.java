/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 * Copyright (C) 2006-2010 Adele Team/LIG/Grenoble University, France
 */
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
