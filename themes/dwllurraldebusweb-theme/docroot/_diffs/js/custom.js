//Usar plantillas de Lodash estilo Mustache
_.templateSettings = {
    'interpolate': /{{([\s\S]+?)}}/g
};
//Integrar underscore.string en Lodash
_.mixin(_.string.exports());
	


