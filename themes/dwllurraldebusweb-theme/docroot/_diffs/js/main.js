AUI().ready(
	'liferay-hudcrumbs', 'liferay-navigation-interaction', 'liferay-sign-in-modal',
	function(A) {	
		var signIn = A.one('#sign-in');		
		if (signIn && signIn.getData('redirect') !== 'true') {	
			signIn.plug(Liferay.SignInModal);
		}
	}
);


