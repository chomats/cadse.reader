package fr.imag.adele.cadse.readser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Dictionary;

import javax.management.RuntimeErrorException;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.BundleListener;
import org.osgi.framework.Filter;
import org.osgi.framework.FrameworkListener;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;

import fr.imag.adele.cadse.readser.MainBundle;

public class MainBundleContext implements BundleContext {

	@Override
	public void addBundleListener(BundleListener listener) {
	}

	@Override
	public void addFrameworkListener(FrameworkListener listener) {
		
	}

	@Override
	public void addServiceListener(ServiceListener listener) {
		
	}

	@Override
	public void addServiceListener(ServiceListener listener, String filter)
			throws InvalidSyntaxException {
		
	}

	@Override
	public Filter createFilter(String filter) throws InvalidSyntaxException {
		return null;
	}

	@Override
	public ServiceReference[] getAllServiceReferences(String clazz,
			String filter) throws InvalidSyntaxException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bundle getBundle() {
		return new MainBundle(this, "Main");
	}

	@Override
	public Bundle getBundle(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bundle[] getBundles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File getDataFile(String filename) {
		try {
			return File.createTempFile("temp", filename);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String getProperty(String key) {
		return null;
	}

	@Override
	public Object getService(ServiceReference reference) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceReference getServiceReference(String clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceReference[] getServiceReferences(String clazz, String filter)
			throws InvalidSyntaxException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bundle installBundle(String location) throws BundleException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bundle installBundle(String location, InputStream input)
			throws BundleException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceRegistration registerService(String[] clazzes,
			Object service, Dictionary properties) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceRegistration registerService(String clazz, Object service,
			Dictionary properties) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeBundleListener(BundleListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeFrameworkListener(FrameworkListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeServiceListener(ServiceListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean ungetService(ServiceReference reference) {
		// TODO Auto-generated method stub
		return false;
	}

}
