/**
 * 
 */
package fr.imag.adele.cadse.readser;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import fr.imag.adele.melusine.as.findmodel.CheckModel;
import fr.imag.adele.melusine.as.findmodel.IFindModel;
import fr.imag.adele.melusine.as.findmodel.ModelEntry;

final class MainFindModel implements IFindModel {
	MainModelEntry cadsegModel = new MainModelEntry();
	
	class MainModelEntry implements ModelEntry {

		private String _domainName;
		private String _name;

		@Override
		public String getDomainName() {
			return _domainName;
		}

		@Override
		public URL getEntry(String path) throws IOException {
			if (path.endsWith("model/cadse.xml")) {
				return getClass().getClassLoader().getResource("cadse-cadseg.xml");
			}
			return getClass().getClassLoader().getResource(path);
		}

		@Override
		public File getFile() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		@Override
		public String getName() {
			return _name;
		}

		@Override
		public ModelEntry getSubEntry(String path) {
			throw new UnsupportedOperationException();
		}

		@Override
		public ModelEntry[] list() {
			throw new UnsupportedOperationException();
		}
		
	}
	
	@Override
	public ModelEntry findQualifiedModel(String domainName,
			String qualifiedModelName) {
		cadsegModel._domainName = domainName;
		cadsegModel._name = "Model.Workspace.CadseG";
		return cadsegModel;
	}

	@Override
	public ModelEntry findModelEntry(String domainName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ModelEntry[] findModelEntries(String domainName, CheckModel check) {
		cadsegModel._domainName = "Workspace";
		cadsegModel._name = "Model.Workspace.CadseG";
		return new ModelEntry[] { cadsegModel };
	}

	@Override
	public ModelEntry[] findModelEntries(String domainName) {
		MainModelEntry cadsegModel = new MainModelEntry();
		cadsegModel._domainName = domainName;
		cadsegModel._name = "Model.Workspace.CadseG";
		return new ModelEntry[] { cadsegModel };
	}
}