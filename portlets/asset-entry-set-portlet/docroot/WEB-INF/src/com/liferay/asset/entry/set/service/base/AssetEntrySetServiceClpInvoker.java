/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.asset.entry.set.service.base;

import com.liferay.asset.entry.set.service.AssetEntrySetServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AssetEntrySetServiceClpInvoker {
	public AssetEntrySetServiceClpInvoker() {
		_methodName48 = "getBeanIdentifier";

		_methodParameterTypes48 = new String[] {  };

		_methodName49 = "setBeanIdentifier";

		_methodParameterTypes49 = new String[] { "java.lang.String" };

		_methodName54 = "addAssetEntrySet";

		_methodParameterTypes54 = new String[] {
				"long", "long", "long", "java.lang.String", "java.io.File",
				"boolean"
			};

		_methodName55 = "addAssetEntrySet";

		_methodParameterTypes55 = new String[] {
				"long", "java.lang.String", "java.io.File", "boolean"
			};

		_methodName56 = "addAssetEntrySet";

		_methodParameterTypes56 = new String[] {
				"java.lang.String", "java.io.File", "boolean"
			};

		_methodName57 = "getNewAssetEntrySets";

		_methodParameterTypes57 = new String[] { "long", "long", "int", "int" };

		_methodName58 = "getOldAssetEntrySets";

		_methodParameterTypes58 = new String[] { "long", "long", "int", "int" };

		_methodName59 = "likeAssetEntrySet";

		_methodParameterTypes59 = new String[] { "long" };

		_methodName60 = "unlikeAssetEntrySet";

		_methodParameterTypes60 = new String[] { "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return AssetEntrySetServiceUtil.getBeanIdentifier();
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			AssetEntrySetServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return AssetEntrySetServiceUtil.addAssetEntrySet(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.io.File)arguments[4],
				((Boolean)arguments[5]).booleanValue());
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			return AssetEntrySetServiceUtil.addAssetEntrySet(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.io.File)arguments[2],
				((Boolean)arguments[3]).booleanValue());
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return AssetEntrySetServiceUtil.addAssetEntrySet((java.lang.String)arguments[0],
				(java.io.File)arguments[1],
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			return AssetEntrySetServiceUtil.getNewAssetEntrySets(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return AssetEntrySetServiceUtil.getOldAssetEntrySets(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			return AssetEntrySetServiceUtil.likeAssetEntrySet(((Long)arguments[0]).longValue());
		}

		if (_methodName60.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
			return AssetEntrySetServiceUtil.unlikeAssetEntrySet(((Long)arguments[0]).longValue());
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName55;
	private String[] _methodParameterTypes55;
	private String _methodName56;
	private String[] _methodParameterTypes56;
	private String _methodName57;
	private String[] _methodParameterTypes57;
	private String _methodName58;
	private String[] _methodParameterTypes58;
	private String _methodName59;
	private String[] _methodParameterTypes59;
	private String _methodName60;
	private String[] _methodParameterTypes60;
}