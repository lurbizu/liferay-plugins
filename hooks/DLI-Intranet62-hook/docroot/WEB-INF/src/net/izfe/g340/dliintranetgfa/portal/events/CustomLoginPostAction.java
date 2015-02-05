package net.izfe.g340.dliintranetgfa.portal.events;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.izfe.g340.dliintranetgfa.portal.events.exceptions.NoSuchCustomFieldException;

import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.model.UserGroup;
import com.liferay.portal.service.UserGroupLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.expando.model.ExpandoValue;
import com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil;

public class CustomLoginPostAction extends Action {

	Log _log = LogFactoryUtil.getLog(this.getClass());
	Map<String, String> langs;
	Map<String, String> centros;

	public CustomLoginPostAction() {
		super();
		initLangMap();
		initCentros();
	}

	@Override
	public void run(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws ActionException {
		_log.debug("CustomLoginPostAction");
		//2014-08-07 : Se decide que el cambio de idioma en el portal de mantenga, 
		//			   no hay que cambiarlo en cada login.
		//updateUserLang(httpServletRequest);
		updateUserDept(httpServletRequest);
	}

	private void updateUserLang(HttpServletRequest httpServletRequest) {
		try {
			User user = PortalUtil.getUser(httpServletRequest);
			String lang = getUserCustomField(user, _custom_field_user_lang);
			String langId = langs.get(lang.toLowerCase());
			if (langId != null) {
				user.setLanguageId(langId);
				UserLocalServiceUtil.updateUser(user);
			} else {
				_log.debug("No hay idioma asociado a codigo " + lang);
			}

		} catch (NoSuchCustomFieldException e) {
			_log.error("Error obteniendo idioma del usuario logueado", e);
		} catch (Exception e) {
			_log.error("Error actualizando idioma del usuario logueado", e);
		}
	}

	private void updateUserDept(HttpServletRequest httpServletRequest) {
		try {
			User user = PortalUtil.getUser(httpServletRequest);
			String dept = getUserCustomField(user, _custom_field_user_dept);
			String centro = getUserCustomField(user, _custom_field_user_Centro);
			String nombreGrupoDestino = calcularNombreGrupo(centro, dept);

			List<UserGroup> userGroups = UserGroupLocalServiceUtil
					.getUserGroups(PortalUtil.getDefaultCompanyId());

			for (UserGroup userGroup : userGroups) {
				String userGroupName = userGroup.getName();
				if (esGrupoGestionado(userGroupName)) {
					if (UserLocalServiceUtil.hasUserGroupUser(
							userGroup.getUserGroupId(), user.getUserId())) {
						if (!userGroupName.equals(nombreGrupoDestino)) {
							// Quitar al usuario del departamento
							UserGroupLocalServiceUtil.deleteUserUserGroup(
									user.getUserId(),
									userGroup.getUserGroupId());
						}
					} else {
						if (userGroupName.equals(nombreGrupoDestino)) {
							// a�adir usuario al departamento
							UserGroupLocalServiceUtil.addUserUserGroup(
									user.getUserId(),
									userGroup.getUserGroupId());
						}
					}
				}
			}

		} catch (NoSuchCustomFieldException e) {
			_log.error("Error obteniendo departamento del usuario logueado", e);
		} catch (Exception e) {
			_log.error("Error actualizando departamento del usuario logueado",
					e);
		}
	}

	private String calcularNombreGrupo(String centro, String dept) {
		if (_cod_centro_gfa.equals(centro)) {
			return _dept_user_group_prefix + dept;
		} else
			return centros.get(centro);
	}

	private boolean esGrupoGestionado(String userGroupName) {
		return StringUtils.startsWith(userGroupName, _dept_user_group_prefix)
				|| userGroupName.equals(_nombre_centro_izfe)
				|| userGroupName.equals(_nombre_centro_invitados);
	}

	private String getUserCustomField(User user, String customFieldName)
			throws NoSuchCustomFieldException {
		ExpandoValue expandoValue;
		try {
			expandoValue = ExpandoValueLocalServiceUtil.getValue(
					PortalUtil.getDefaultCompanyId(), User.class.getName(),
					"CUSTOM_FIELDS", customFieldName, user.getPrimaryKey());
			return expandoValue.getString();
		} catch (Exception e) {
			throw new NoSuchCustomFieldException();
		}
	}

	private void initLangMap() {
		langs = new HashMap<String, String>();
		langs.put("e", "eu_ES");
		langs.put("c", "es_ES");
	}

	private void initCentros() {
		centros = new HashMap<String, String>();
		centros.put(_cod_centro_invitados, _nombre_centro_invitados);
		centros.put(_cod_centro_gfa, _nombre_centro_gfa);
		centros.put(_cod_centro_izfe, _nombre_centro_izfe);
	}

	private static final String _custom_field_user_lang = "IZFE-Idioma";
	private static final String _custom_field_user_dept = "IZFE-Departamento";
	private static final String _custom_field_user_Centro = "IZFE-Centro";
	private static final String _dept_user_group_prefix = "DEP_";

	private static final String _cod_centro_invitados = "0";
	private static final String _cod_centro_izfe = "104";
	private static final String _cod_centro_gfa = "100";

	private static final String _nombre_centro_invitados = "Invitados";
	private static final String _nombre_centro_izfe = "IZFE";
	private static final String _nombre_centro_gfa = "GFA";
}
