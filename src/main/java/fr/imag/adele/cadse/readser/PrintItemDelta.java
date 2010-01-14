package fr.imag.adele.cadse.readser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import fr.imag.adele.cadse.core.CadseException;
import fr.imag.adele.cadse.core.ItemType;
import fr.imag.adele.cadse.core.LinkType;
import fr.imag.adele.cadse.core.attribute.IAttributeType;
import fr.imag.adele.cadse.core.impl.internal.LogicalWorkspaceTransactionImpl;
import fr.imag.adele.cadse.core.impl.internal.delta.ItemDeltaImpl;
import fr.imag.adele.cadse.core.transaction.delta.ItemDelta;
import fr.imag.adele.cadse.core.transaction.delta.LinkDelta;
import fr.imag.adele.fede.workspace.si.persistence.XMLPersistance;

public class PrintItemDelta extends ItemDeltaImpl {
	
	private String _name;
	private String _qname;
	HashMap<IAttributeType<?> , Object> _atts = new HashMap<IAttributeType<?>, Object>();
	private UUID _id;
	private UUID _type;
	private ItemType _typeObj;
	private ArrayList<LinkDelta> links=  new ArrayList<LinkDelta>();
	
	
	
	public PrintItemDelta(LogicalWorkspaceTransactionImpl lw, UUID id, ItemType typeObj) throws CadseException {
		super(lw, id, typeObj, false);
		_id = id;
		_typeObj = typeObj;
		_type = _typeObj.getId();
		
	}

	@Override
	public UUID getItemTypeId() {
		return _type;
	}

	
	@Override
	public void loadAttribute(IAttributeType<?> key, Object value)
			throws CadseException {
		_atts.put(key, value);
	}
	
	@Override
	public void setName(String shortname, boolean loaded)  {
		_name = shortname;

	}

	@Override
	public void setQualifiedName(String uniqueName, boolean loaded) {
		_qname = uniqueName;
	}
	
	@Override
	public void toString(StringBuilder sb, String tab) {
		try {
			sb.append(tab).append("<item ");
			XMLPersistance.writeXML(sb, "name", _name);
			XMLPersistance.writeXML(sb, "qname", _qname);
			XMLPersistance.writeXML(sb, "id", _id.toString());
			XMLPersistance.writeXML(sb, "type", _type.toString());
			
			sb.append(">\n");
			for (IAttributeType<?> k : _atts.keySet()) {
				sb.append(tab).append("  <attribute ");
				XMLPersistance.writeXML(sb, "id", k.getId().toString());
				XMLPersistance.writeXML(sb, "source-id", k.getSource().getId().toString());
				UUID cadseId = k.getSource().getCadseId();
				if (cadseId != null)
					XMLPersistance.writeXML(sb, "source-cadse-id", cadseId.toString());
				
				XMLPersistance.writeXML(sb, "name", k.getName());
				XMLPersistance.writeXML(sb, "value", _atts.get(k).toString());
				sb.append(" \\>\n");
			}
			
			for (LinkDelta l : links) {
				l.toString(tab+"  ", sb, tab);
			}
			
			sb.append(tab).append("</item>\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@Override
	public String getDisplayName() {
		return _name;
	}

	@Override
	public UUID getId() {
		return _id;
	}

	@Override
	public String getQualifiedName() {
		return _qname;
	}

	@Override
	public String getQualifiedName(boolean recompute) throws CadseException {
		return _qname;
	}

	@Override
	public String getShortName() {
		return getName();
	}

	@Override
	public void setAttribute(IAttributeType<?> att, Object value) {
		_atts.put(att, value);

	}

	@Override
	public LinkDelta loadLink(LinkType linkType, ItemDelta destItem)
			throws CadseException {

		PrintLinkDelta  l = new PrintLinkDelta( linkType, destItem);
		links.add(l);// TODO Auto-generated method stub
		return l;
	}

	@Override
	public LinkDelta loadLink(int linkId, LinkType lt, ItemDelta dest)
			throws CadseException {
		PrintLinkDelta  l = new PrintLinkDelta( lt, dest);
		l.setObjectID(linkId);
		links.add(l);// TODO Auto-generated method stub
		return l;
	}

	@Override
	public void setAttribute(IAttributeType<?> key, Object newCurrentValue,
			boolean loaded) {
		_atts.put(key, newCurrentValue);
	}

	@Override
	public void setReadOnly(boolean readOnly, boolean loaded)
			throws CadseException {
	}
	
}
