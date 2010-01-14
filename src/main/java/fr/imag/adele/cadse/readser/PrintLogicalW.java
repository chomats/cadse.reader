/**
 * 
 */
package fr.imag.adele.cadse.readser;

import java.util.UUID;

import fr.imag.adele.cadse.core.CadseException;
import fr.imag.adele.cadse.core.ItemType;
import fr.imag.adele.cadse.core.impl.internal.LogicalWorkspaceImpl;
import fr.imag.adele.cadse.core.impl.internal.LogicalWorkspaceTransactionImpl;
import fr.imag.adele.cadse.core.transaction.LogicalWorkspaceTransactionListener;
import fr.imag.adele.cadse.core.transaction.delta.ItemDelta;

final class PrintLogicalW extends LogicalWorkspaceTransactionImpl {

	

	public PrintLogicalW(LogicalWorkspaceImpl base,
			LogicalWorkspaceTransactionListener[] workspaceLogiqueCopyListeners) {
		super(base, workspaceLogiqueCopyListeners);
	}



	public ItemDelta loadItem(UUID id, ItemType type) throws CadseException {
		return new PrintItemDelta(this, id, type);
	}

}