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

import java.io.IOException;
import java.util.Collection;

import fr.imag.adele.cadse.core.CadseError;
import fr.imag.adele.cadse.core.CadseException;
import java.util.UUID;
import fr.imag.adele.cadse.core.Item;
import fr.imag.adele.cadse.core.ItemType;
import fr.imag.adele.cadse.core.Link;
import fr.imag.adele.cadse.core.LinkType;
import fr.imag.adele.cadse.core.attribute.IAttributeType;
import fr.imag.adele.cadse.core.transaction.delta.CreateOperation;
import fr.imag.adele.cadse.core.transaction.delta.DeleteOperation;
import fr.imag.adele.cadse.core.transaction.delta.ItemDelta;
import fr.imag.adele.cadse.core.transaction.delta.LinkDelta;
import fr.imag.adele.cadse.core.transaction.delta.OperationType;
import fr.imag.adele.cadse.core.transaction.delta.SetAttributeOperation;
import fr.imag.adele.cadse.core.transaction.delta.WLWCOperation;
import fr.imag.adele.cadse.core.transaction.LogicalWorkspaceTransaction;
import fr.imag.adele.fede.workspace.si.persistence.XMLPersistance;

public class PrintLinkDelta implements LinkDelta {

	private LinkType _linkType;
	private ItemDelta _destItem;
	private String _info;
	private int _version;

	public PrintLinkDelta(LinkType linkType, ItemDelta destItem) {
		_linkType = linkType;
		_destItem = destItem;
	}

	@Override
	public void addCompatibleVersions(int... versions) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changeDestination(Item att) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clearCompatibleVersions() {
		// TODO Auto-generated method stub

	}


	@Override
	public void delete(DeleteOperation options) throws CadseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() throws CadseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() throws CadseException {
		// TODO Auto-generated method stub

	}

	@Override
	public IAttributeType<?> getAttributeType(
			SetAttributeOperation setAttributeOperation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Link getBaseLink() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getCompatibleVersions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemDelta getDestination() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemDelta getDestination(boolean resolved) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID getDestinationId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDestinationName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemDelta getDestinationOperation() throws CadseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDestinationQualifiedName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDestinationShortName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemType getDestinationType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHandleIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LinkDelta getInverseLink() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemDelta getItemOperationParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLinkTypeName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemDelta getResolvedDestination() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemDelta getSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID getSourceId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemDelta getSourceOperation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isAggregation() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAnnotation() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isComposition() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCreatedLink() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDerived() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isHidden() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLinkResolved() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMappingLink() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOther() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPart() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isReadOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRequire() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRuntime() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void moveAfter(Link link) throws CadseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveBefore(Link link) throws CadseException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean mustDeleteDestination() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mustDeleteSource() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean resolve() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void restore() throws CadseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHidden(boolean hidden) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setIndex(int index, boolean loaded) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setInfo(String info) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setInfo(String info, boolean loaded) {
		_info = info;

	}

	@Override
	public void setReadOnly(boolean readOnly) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setVersion(int version) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setVersion(int version, boolean loaded) {
		_version = version;
	}

	@Override
	public void toString(String begin, StringBuilder sb, String tab) {
		sb.append(begin);
		
		sb.append("<link");
		try {
			XMLPersistance.writeXML(sb, "type", _linkType.getName());
			XMLPersistance.writeXML(sb, "type-id", _linkType.getId().toString());
			
			if (_info != null)
				XMLPersistance.writeXML(sb, "info", _info);
			sb.append(" version=\"").append(_version).append("\"");
			sb.append(" dest-name=\"").append(_destItem.getName()).append("\"");
			sb.append(" dest-qname=\"").append(_destItem.getQualifiedName()).append("\"");
			sb.append(" dest-type=\"").append(_destItem.getItemTypeId()).append("\"");
			sb.append(" dest-id=\"").append(_destItem.getId()).append("\"");
			
			sb.append("\\>\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public LinkType getLinkType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void commitDelete() throws CadseException {
		// TODO Auto-generated method stub

	}


	@Override
	public CreateOperation getCreateOperation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteOperation getDeleteOperation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<SetAttributeOperation> getSetAttributeOperation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAdded() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDeleted() {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public UUID getOperationId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperationType getOperationType() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public OperationType getParentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LogicalWorkspaceTransaction getWorkingCopy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLoaded() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isModified() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addInParent() throws CadseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeInParent() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLoaded(boolean loaded) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(SetAttributeOperation setAttributeOperation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(SetAttributeOperation setAttributeOperation, boolean check) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCreateOperation(CreateOperation createItemOperation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDeleteOperation(DeleteOperation deleteItemOperation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addError(String msg, Object... args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addError(CadseError e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean commitSetAttribute(IAttributeType<?> type, String key,
			Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAttribute(IAttributeType<?> key, Object v, Object oldValue,
			boolean loaded) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setObjectID(int linkId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UUID getDestinationCadseId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getLinkAttributeOwner(IAttributeType<T> attDef) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID getSourceCadseId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInterCadseLink() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UUID getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getObjectId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setUUID(long uuidMsb, long uuidLsb) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setUUID(UUID uuid) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public <T> T getAttribute(IAttributeType<T> key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getAttribute(IAttributeType<T> key, boolean returnDefault) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getAttributeWithDefaultValue(IAttributeType<T> att,
			T defaultValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SetAttributeOperation getSetAttributeOperation(IAttributeType<?> key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WLWCOperation getParentOperDelta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAttribute(IAttributeType<?> key, Object v) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented method");
	}


	@Override
	public <T extends fr.imag.adele.cadse.objectadapter.ObjectAdapter<T>> T[] adapts(
			Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> void addAdapter(
			fr.imag.adele.cadse.objectadapter.ObjectAdapter<T> adapt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> void removeAdapter(
			fr.imag.adele.cadse.objectadapter.ObjectAdapter<T> adapt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends fr.imag.adele.cadse.objectadapter.ObjectAdapter<T>> T adapt(
			Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

}
