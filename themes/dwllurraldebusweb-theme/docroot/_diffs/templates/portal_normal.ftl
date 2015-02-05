<!DOCTYPE html>
<#include init />
<html class="${root_css_class}"  dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">
<head>
    <meta charset="utf-8">
    <title><@liferay.language key="lurraldebus"/></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link href='http://fonts.googleapis.com/css?family=Fira+Sans:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    
    <script src="${javascript_folder}/jquery-1.11.0.min.js" type="text/javascript" ></script>
    <script src="${javascript_folder}/lodash-2.4.1.min.js" type="text/javascript" ></script>
    <script src="${javascript_folder}/responsive-tabs-2.3.2.js" type="text/javascript" ></script>
    <script src="${javascript_folder}/underscore.string-2.3.3.min.js" type="text/javascript" ></script>
    <script src="${javascript_folder}/selectize-0.9.0.min.js" type="text/javascript" ></script>
    <script src="${javascript_folder}/custom.js" type="text/javascript" ></script> 
    <script src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
        
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->
    <!-- Fav y touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="/assets/ico/apple-touch-icon-57-precomposed.png">
    <link rel="shortcut icon" href="/assets/ico/favicon.png">
	${theme.include(top_head_include)}<!--No quitar, es el menu superior del portal-->
</head>

<body class="${css_class}">

<a href="#main-content" id="skip-to-content"><@liferay.language key="skip-to-content" /></a>

${theme.include(body_top_include)}

<#if is_signed_in>
	<@liferay.dockbar />
</#if>
<body> 		
	<#include "${full_templates_path}/top.ftl" />  
 
    <!--layout Portlets-->
    <div id="content">
		<#if selectable>
			${theme.include(content_include)}
		<#else>
			${portletDisplay.recycle()}

			${portletDisplay.setTitle(the_title)}

			${theme.wrapPortlet("portlet.ftl", content_include)}
		</#if>
	</div>  

    <#include "${full_templates_path}/footer.ftl" />  

	${theme.include(body_bottom_include)}
	
	${theme.include(bottom_include)}
	
	
	 <script type="text/javascript">
	    $(document).ready(function () {		
			$('#lineasSelectId').selectize({
				sortField: 'text',
			    onChange: function(articleId) {
			        if (!articleId.length) return;		
					openContentByArticleId(articleId);
			    }
			});
			

			
			$('.accordion-toggle').click(function() {
            	if($(this).hasClass('collapsed')) {
                	$('.accordion-toggle').not(this).addClass('collapsed');
            	}
       		 });
	    });
</script>
</body>
</html>