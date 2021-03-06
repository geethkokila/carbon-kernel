/*
 *  Copyright (c) 2005-2013, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */

package org.wso2.carbon.identity.config;


public final class IdentityServiceConfig {

	private BootstrapRealmConfig bootstrapRealmConfig;
	private ClaimManagerConfig claimManagerConfig;
	private AuthorizationStoreManagerConfig authorizationStoreManagerConfig;
	private IdentityStoreManagerConfig identityStoreManagerConfig;

	/**
	 * 
	 * 
	 * @param bootstrapRealmConfig
	 * @param claimManagerConfig
	 * @param authorizationStoreManagerConfig
	 * @param identityStoreManagerConfig
	 */
	public IdentityServiceConfig(BootstrapRealmConfig bootstrapRealmConfig,
			ClaimManagerConfig claimManagerConfig,
			AuthorizationStoreManagerConfig authorizationStoreManagerConfig,
			IdentityStoreManagerConfig identityStoreManagerConfig) {
		this.bootstrapRealmConfig = bootstrapRealmConfig;
		this.claimManagerConfig = claimManagerConfig;
		this.authorizationStoreManagerConfig = authorizationStoreManagerConfig;
		this.identityStoreManagerConfig = identityStoreManagerConfig;
	}

	/**
	 * 
	 * @return
	 */
	public BootstrapRealmConfig getBootstrapRealmConfig() {
		return bootstrapRealmConfig;
	}

	/**
	 * 
	 * @return
	 */
	public ClaimManagerConfig getClaimManagerConfig() {
		return claimManagerConfig;
	}

	/**
	 * 
	 * @return
	 */
	public AuthorizationStoreManagerConfig getAuthorizationStoreManagerConfig() {
		return authorizationStoreManagerConfig;
	}

	/**
	 * 
	 * @return
	 */
	public IdentityStoreManagerConfig getIdentityStoreManagerConfig() {
		return identityStoreManagerConfig;
	}

}