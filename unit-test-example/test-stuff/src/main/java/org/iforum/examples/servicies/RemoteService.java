package org.iforum.examples.servicies;

/**
 * ������ ��� ������ � ��������� web ��������.
 * 
 * @author igor.ch
 * 
 */
public interface RemoteService {

	/**
	 * ��������� ������ �� ��������� ���-������
	 * 
	 * @param data
	 */
	public void sendDataToRemoteService(WorkData data);
}