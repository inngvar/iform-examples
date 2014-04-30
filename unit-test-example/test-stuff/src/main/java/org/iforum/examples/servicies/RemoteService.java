package org.iforum.examples.servicies;

/**
 * —ервис дл€ работы с удаленным web сервисом.
 * 
 * @author igor.ch
 * 
 */
public interface RemoteService {

	/**
	 * ¬ыполнить запрос на удаленный веб-сервис
	 * 
	 * @param data
	 */
	public void sendDataToRemoteService(WorkData data);
}