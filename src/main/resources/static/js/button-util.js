/**
 * This JS used to manage the general javaScript module for the FOCUS application
 */

var ButtonUtil = function () {

    /*********************************************************************
     * Home Button With URL
     *********************************************************************/
    var getHomeBtnWithURL = function (mappingPrefix, id) {
        var modalId = "modal_" + mappingPrefix.replace(/\//g, '_') + "_" + id;

        var htmlBtn =  '<div class="btn-group">'+
          '  <button type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="dropdown-toggle btn btn-primary btn-sm"><i class="fa fa-cog"></i></button>'+
          '  <div tabindex="-1" aria-hidden="true" role="menu" class="dropdown-menu">'+
        '    <a type="button" href="../' + mappingPrefix + '/edit?id=' + id + '" tabindex="0" class="dropdown-item"><i class="fa fa-edit"></i> Edit</a>'+
           ' <button type="button" data-toggle="modal" data-target="#' + modalId + '" tabindex="-1" class="dropdown-item"><i class="fa fa-times"></i> Delete</button>'+
        '</div>'+
        '</div>'+
        '<div id="' + modalId + '" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="staticModalLabel" aria-hidden="true" data-backdrop="static">' +
           '<div class="modal-dialog modal-sm" role="document">'+
            '<div class="modal-content">'+
            "<div class='modal-body'><p>Are You Sure? You want to delete ?</p></div>" +
            "<div class='modal-footer'>" +
            "<a data-dismiss='modal' class='btn btn-sm btn-blue'> Cancel </a> " +
            "<a href='../" + mappingPrefix + "/delete?id=" + id + "' type='button' class='btn btn-sm btn-red'> <i class='clip-remove'></i> Delete</a>" +
            "</div>" + "</div>" +
        '</div>'+
        '</div>'
        return htmlBtn;
    };

    /*********************************************************************
     * Edit Button With URL
     *********************************************************************/
    var getEditBtnWithURL = function (mappingPrefix, id, className) {
        var htmlBtn =
            "<div align='center'>" +
            "<div class='btn-group'>" +
            "<a class='btn btn-xs btn-blue dropdown-toggle btn-sm' data-toggle='dropdown' href='#'>" +
            "<i class='fa fa-cog'></i> <span class='caret'></span>" +
            "</a>" +
            "<ul role='menu' class='dropdown-menu pull-right'>" +
            "<li role='presentation'><a onclick='" + className + ".editModal(" + id + ")' type='button' role='menuitem' tabindex='-1'><i class='fa fa-edit'></i> Edit</a></li>" +
            "<li role='presentation'><a href='#" + mappingPrefix + "Delete_" + id + "' data-toggle='modal' role='menuitem' tabindex='-1'><i class='fa fa-times'></i> Remove</a></li>" +
            "</ul>" +
            "</div>" +

            "<div id='"+ mappingPrefix + "Delete_" + id + "'' class='modal fade delete-modal' tabindex='-1' data-backdrop='static' data-keyboard='false' style='display: none;'>" +
      
            "<div class='modal-body'><p>Are You Sure? You want to delete ?</p></div>" +
            "<div class='modal-footer'>" +
            "<a data-dismiss='modal' class='btn btn-sm btn-blue'> Cancel </a> " +
            "<a onclick='" + className + ".deleteModal(" + id + ")' data-dismiss='modal' type='button' class='btn btn-sm btn-red'> <i class='clip-remove'></i> Delete</a>" +
            "</div>" + "</div>" +
            "</div>";
        return htmlBtn;
    };

    /*********************************************************************
     * Edit Delete Button
     *********************************************************************/
    var generateEditDeleteBtnGroup = function (editBtnId, editBtnClass, deleteBtnId, deleteBtnClass) {
        var htmlBtn =
            "<div align='center'>" +
            "<div class='btn-group'>" +
            "<a class='btn btn-xs btn-blue dropdown-toggle btn-sm' data-toggle='dropdown' href='#'>" +
            "<i class='fa fa-cog'></i> <span class='caret'></span>" +
            "</a>" +
            "<ul role='menu' class='dropdown-menu pull-right'>" +
            "<li role='presentation'><a href='#' type='button' class='" + editBtnClass + "' role='menuitem' tabindex='-1' id='" + editBtnId + "'><i class='fa fa-edit'></i> Edit</a></li>" +
            "<li role='presentation'><a href='#model_" + editBtnId + "' data-toggle='modal' role='menuitem' tabindex='-1'><i class='fa fa-times'></i> Remove</a></li>" +
            "</ul>" +
            "</div>" +
            "<div id='model_" + editBtnId + "' class='modal fade' tabindex='-1' data-backdrop='static' data-keyboard='false' style='display: none;'>" +
            "<div class='modal-body'><p>Are You Sure You want to delete ?</p></div>" +
            "<div class='modal-footer'>" +
            "<a data-dismiss='modal' class='btn btn-sm btn-blue'> Cancel </a> " +
            "<button data-dismiss='modal' type='button' id='" + deleteBtnId + "' class='btn btn-sm btn-red " + deleteBtnClass + "'>Delete</button>" +
            "</div>" + "</div>" +
            "</div>";
        return htmlBtn;
    };


    /*********************************************************************
     * Edit Delete Button (From List)
     *********************************************************************/
    
    var getEditDeleteBtnFromList = function (id, moduleObj) {
        var htmlBtn =
            "<div align='center'>" +
            "<div class='btn-group'>" +
            "<a class='btn btn-xs btn-blue dropdown-toggle btn-sm' data-toggle='dropdown' href='#'>" +
            "<i class='fa fa-cog'></i> <span class='caret'></span>" +
            "</a>" +
            "<ul role='menu' class='dropdown-menu pull-right'>" +
            "<li role='presentation'><a href='#' id='" + id + "' onclick='" + moduleObj + ".editListItem(" + id + ")' type='button' role='menuitem' tabindex='-1'><i class='fa fa-edit'></i> Edit</a></li>" +
            "<li role='presentation'><a href='#delete-" + moduleObj + "-" + id + "' data-toggle='modal' role='menuitem' tabindex='-1'><i class='fa fa-times'></i> Remove</a></li>" +
            "</ul>" +
            "</div>" +
            "<div id='delete-" + moduleObj + "-" + id + "' class='modal fade' tabindex='-1' data-backdrop='static' data-keyboard='false' style='display: none;'>" +
            "<div class='modal-body'><p>Are You Sure? You want to delete ?</p></div>" +
            "<div class='modal-footer'>" +
            "<button data-dismiss='modal' class='btn btn-sm btn-blue'> Cancel </button> " +
            "<button onclick='" + moduleObj + ".deleteListItem(" + id + ")' data-dismiss='modal' type='button' class='btn btn-sm btn-red'> <i class='clip-remove'></i> Delete</button>" +
            "</div>" + "</div>" +
            "</div>";
        return htmlBtn;
    };    
    

    /*********************************************************************
     * Common Edit Button
     *********************************************************************/
    
    var getCommonBtnEdit = function (mappingPrefix, id) {
        var linkId = "link_" + mappingPrefix.replace(/\./g, '_') + "_" + id;
        var htmlBtn = "<a id='" + linkId + "' onclick='" + mappingPrefix + "(" + id + "); 'class='btn btn-xs btn-teal tooltips' data-placement='top' data-original-title='Edit' >" +
            "<i class='fa fa-edit' ></i></a>\t" 
        return htmlBtn;
    };

    /*********************************************************************
     * Common Delete Button
     *********************************************************************/
    
    var getCommonBtnDelete = function (mappingPrefix, id) {
        var modalId = "modal_" + mappingPrefix.replace(/\./g, '_') + "_" + id;
        var htmlBtn =
            "<a class='btn btn-xs btn-bricky tooltips' type='button' data-toggle='modal' role='menuitem' tabindex='-1' href='#" + modalId + "'>" +

            "<i class='fa fa-times fa fa-white'></i>" +
            "</a>" +
            "<div id='" + modalId + "' class='modal fade delete-center-modal' tabindex='-1' data-backdrop='static' data-keyboard='false' style='display: none; '>" +
            "<div class='modal-body'>" +
            "<p>Are You Sure You Want To Delete?</p>" +
            "</div>" +
            "<div class='modal-footer'>" +
            "<a data-dismiss='modal' class='btn btn-blue btn-sm' > Cancel</a> " +
            "<a data-dismiss='modal' onclick='" + mappingPrefix + "(" + id + ");' class='btn btn-sm btn-red'> Delete</a>" +
            "</div>" ;
           
        return htmlBtn;
    };
    
    /*********************************************************************
     * Common Select Button
     *********************************************************************/
    
    var getCommonBtnSelect = function (mappingPrefix, id, name) {
        var linkId = "link_" + mappingPrefix.replace(/\./g, '_') + "_" + id;
        var htmlBtn = "<a id='" + linkId + "' onclick='" + mappingPrefix + "(\"" + id + "\",\"" + name + "\");' class='btn btn-xs btn-blue tooltips' data-placement='top' data-original-title='Add Value' >" +
            "<i class='fa fa-hand-pointer-o' ></i></a>\t";
        return htmlBtn;
    };
    
    /*********************************************************************
     * Common Download Button
     *********************************************************************/
    
    var getCommonBtnDownload = function (mappingPrefix, id) {
    	var linkId = "link_" + mappingPrefix.replace(/\./g, '_') + "_" + id;
    	var htmlBtn =
    		"<a id='" + linkId + "' onclick='" + mappingPrefix + "(" + id + "); 'class='btn btn-xs btn-teal tooltips' data-placement='top' data-original-title='Download' >" +
    		"<i class='fa fa-edit' ></i></a>\t"
    		return htmlBtn;
    };

    /*********************************************************************
     * Common View Button
     *********************************************************************/
    
    var getCommonBtnView = function (mappingPrefix, id) {
        var linkId = "link_" + mappingPrefix.replace(/\./g, '_') + "_" + id;
        var htmlBtn =
            "<a id='" + linkId + "' onclick='" + mappingPrefix + "(" + id + "); 'class='btn btn-xs btn-success tooltips' data-placement='top' data-original-title='View' >" +
            "<i class='clip-eye' ></i></a>\t"
        return htmlBtn;
    }; 
    
    var getCommonBtnViewWithMultipleVars = function (mappingPrefix, id, vars) {
    	var linkId = "link_" + mappingPrefix.replace(/\./g, '_') + "_" + id;
    	var htmlBtn = "<a id='" + linkId + "' onclick='" + mappingPrefix + "(";    	
    	for (var i = 0; i < vars.length; i++) {
    		if (i > 0) {
    			htmlBtn = htmlBtn +  ",";
    		}
    		
    		if (vars[i] == "this") {
    			htmlBtn = htmlBtn +  vars[i];
    		} else {
    			htmlBtn = htmlBtn +  "\"" + vars[i] + "\"";
    		}
    		
        };
        
        htmlBtn = htmlBtn + ");' class='btn btn-xs btn-green tooltips' data-dismiss='modal' data-placement='top'  data-original-title='Add Value' ><i class='clip-eye' ></i></a>\t";
        return htmlBtn;
    };

    var getCommonBtnSelectWithMultipleVars = function (mappingPrefix, id, vars) {
        var linkId = "link_" + mappingPrefix.replace(/\./g, '_') + "_" + id;
        var htmlBtn = "<a id='" + linkId + "' onclick='" + mappingPrefix + "(";
        for (var i = 0; i < vars.length; i++) {
            if (i > 0) {
                htmlBtn = htmlBtn + ",";
            }

            if (vars[i] == "this") {
                htmlBtn = htmlBtn + vars[i];
            } else {
                htmlBtn = htmlBtn + "\"" + vars[i] + "\"";
            }
        }
        ;

        htmlBtn = htmlBtn + ");' class='btn btn-xs btn-blue tooltips' data-dismiss='modal' data-placement='top' data-original-title='Add Value' ><i class='fa fa-hand-pointer-o' ></i></a>\t";
        return htmlBtn;
    };

    /*********************************************************************
     * Notification Undo
     *********************************************************************/
    var getBtnDelete = function (mappingPrefix, id) {
        var modalId = "modal_" + mappingPrefix.replace(/\//g, '_') + "_" + id;
        var htmlBtn =
            "<div align='center'>" +
            "<a class='btn btn-sm btn-blue ' type='button' data-toggle='modal' role='menuitem' tabindex='-1' href='#" + modalId + "'>" +
            "<i class='fa fa-trash'></i>" +
            "</a>" +
            "<div id='" + modalId + "' class='modal fade' tabindex='-1' data-backdrop='static' data-keyboard='false' style='display: none;'>" +
            "<div class='modal-body'>" +
            "<p>Are You Sure You Want To Delete?</p>" +
            "</div>" +
            "<div class='modal-footer'>" +
            "<a data-dismiss='modal' class='btn btn-blue btn-sm ' > Cancel</a> " +
            "<a href='../" + mappingPrefix + "/delete?id=" + id + "' class='btn btn-sm btn-blue'> Delete</a>" +
            "</div>" +
            "</div>" +
            "</div>";
        return htmlBtn;
    };


    /*********************************************************************
     * Notification Inbox
     *********************************************************************/
    var getNotificationInbox = function (mappingPrefix, id) {
        var htmlBtn =
            "<div align='center'>" +
            "<div class='btn-group'>" +
            "<a class='btn btn-blue dropdown-toggle btn-xs' data-toggle='dropdown' href='#'> " +
            "<i class='fa fa-cog'></i> <span class='caret'></span>" +
            "</a>" +
            "<ul role='menu' class='dropdown-menu pull-right'> " +
            "<li role='presentation'><a data-toggle='modal' role='menuitem' tabindex='-1' href='#trashModel" + id + "'><i class='fa fa-times'></i> Trash </a></li>" +
            "<li role='presentation'><a data-toggle='modal' role='menuitem' tabindex='-1' href='#deleteModel" + id + "'><i class='clip-remove'></i> Delete </a></li>" +
            "</ul>" +
            "</div>" +

            "<div id='trashModel_"+mappingPrefix+"_" + id + "' class='modal fade' tabindex='-1' data-backdrop='static' data-keyboard='false' style='display: none;'>" +
            "<div class='modal-body'><p>Are You Sure You Want Move To Trash ?</p></div>" +
            "<div class='modal-footer'>" +
            "<a data-dismiss='modal' class='btn btn-sm btn-blue '> Cancel </a> " +
            "<a href='../" + mappingPrefix + "/trashItem?id=" + id + "' class='btn btn-sm btn-blue '> Trash </a>" +
            "</div>" +
            "</div>" +

            "<div id='deleteModel_"+mappingPrefix+"_" + id + "' class='modal fade' tabindex='-1' data-backdrop='static' data-keyboard='false' style='display: none;'>" +
            "<div class='modal-body'><p>Are You Sure You Want To Delete ?</p></div>" +
            "<div class='modal-footer'>" +
            "<a data-dismiss='modal' class='btn btn-sm btn-blue '> Cancel </a> " +
            "<a href='../" + mappingPrefix + "/delete?id=" + id + "' class='btn btn-sm btn-blue '> <i class='clip-remove'></i> Delete </a>" +
            "</div>" +
            "</div>" +

            "</div>"
        return htmlBtn;
    };

    /*********************************************************************
     * Notification Preview
     *********************************************************************/
    var getNotificationPreview = function (id) {
        var htmlBtn =
            "<div align='center'>" +
            "<button class='clsNotificationPreview btn btn-xs btn-blue btn-primary dropdown-toggle ' id='" + id + "' >" +
            "<i class='clip-expand'></i> Preview" +
            "</button>" +
            "</div>";
        return htmlBtn;
    };

    /*********************************************************************
     * Notification Undo
     *********************************************************************/
    var getBtnUndoNotification = function (id) {
        var htmlBtn =
            "<div align='center'>" +
            "<a class='btn btn-sm btn-blue ' data-toggle='modal' role='menuitem' tabindex='-1' href='#modelTrash" + id + "'>" +
            "<i class='clip-undo'></i>" +
            "</a>" +

            "<div id='modelTrash" + id + "' class='modal fade' tabindex='-1' data-backdrop='static' data-keyboard='false' style='display: none;'>" +
            "<div class='modal-body'>" +
            "<p>Do You Sure You want to Reverse?</p>" +
            "</div>" +
            "<div class='modal-footer'>" +
            "<a data-dismiss='modal' class='btn btn-sm btn-blue' > Cancel</a> " +
            "<a href='undoTrashItem?id=" + id + "' class='btn btn-sm btn-blue' >Reverse</a>" +
            "</div>" +
            "</div>" +
            "</div>";
        return htmlBtn;
    };

    /*********************************************************************
     * CMMS Setting Lookup Table Button With URL
     *********************************************************************/
    var getCmmsLookupTableBtnWithURL = function (mappingPrefix, id) {
        var htmlBtn =
            "<div align='center'>" +
            "<div class='btn-group'>" +
            "<a class='btn btn-xs btn-blue dropdown-toggle btn-sm' data-toggle='dropdown' href='#'>" +
            "<i class='fa fa-cog'></i> <span class='caret'></span>" +
            "</a>" +
            "<ul role='menu' class='dropdown-menu pull-right'>" +
            "<li role='presentation'><a href='../" + mappingPrefix + "/edit?id=" + id + "' type='button' role='menuitem' tabindex='-1'><i class='fa fa-edit'></i> Edit</a></li>" +
            "<li role='presentation'><a href='#" + mappingPrefix + "Delete_" + id + "' data-toggle='modal' role='menuitem' tabindex='-1'><i class='fa fa-times'></i> Remove</a></li>" +
            "</ul>" +
            "</div>" +
            "<div id='" + mappingPrefix + "Delete_" + id + "' class='modal fade' tabindex='-1' data-backdrop='static' data-keyboard='false' style='display: none;'>" +
            "<div class='modal-body'><p>Are You Sure? You want to delete ?</p></div>" +
            "<div class='modal-footer'>" +
            "<a data-dismiss='modal' class='btn btn-sm btn-blue'> Cancel </a> " +
            "<a href='../" + mappingPrefix + "/delete?id=" + id + "' type='button' class='btn btn-sm btn-red'> <i class='clip-remove'></i> Delete</a>" +
            "</div>" + "</div>" +
            "</div>";
        return htmlBtn;
    };

    var getCmmsBtnWithFuncs = function (editFunc, removeFunc, id) {
        var htmlBtn =
            "<div align='center'>" +
            "<div class='btn-group'>" +
            "<a class='btn btn-xs btn-blue dropdown-toggle btn-sm' data-toggle='dropdown' href='#'>" +
            "<i class='fa fa-cog'></i> <span class='caret'></span>" +
            "</a>" +
            "<ul role='menu' class='dropdown-menu pull-right'>" +
            "<li role='presentation'><a type='button' role='menuitem' tabindex='-1' onclick='" + editFunc + "(" + id + ")'><i class='fa fa-edit'></i> Edit </a></li>" +
            "<li role='presentation'><a data-toggle='modal' role='menuitem' tabindex='-1' href='#delete_" + id + "'><i class='fa fa-times'></i> Remove </a></li>" +
            "</ul>" +
            "</div>" +
            "<div id='delete_" + id + "' class='modal fade' tabindex='-1' data-backdrop='static' data-keyboard='false' style='display: none;'>" +
            "<div class='modal-body'><p>Are You Sure? You want to delete ?</p></div>" +
            "<div class='modal-footer'>" +
            "<a data-dismiss='modal' class='btn btn-sm btn-blue'> Cancel </a> " +
            "<a data-dismiss='modal' onclick='" + removeFunc + "(" + id + ")' type='button' class='btn btn-sm btn-red'> <i class='clip-remove'></i> Delete</a>" +
            "</div>" +
            "</div>" +
            "</div>";
        return htmlBtn;
    };

    return {

        getHomeBtnWithURL: function (mappingPrefix, id) {
            return getHomeBtnWithURL(mappingPrefix, id);
        },

        getEditBtnWithURL: function (mappingPrefix, id, className) {
            return getEditBtnWithURL(mappingPrefix, id, className);
        },

        getBtnGroup: function (editBtnId, editBtnClass, deleteBtnId, deleteBtnClass) {
            return generateEditDeleteBtnGroup(editBtnId, editBtnClass, deleteBtnId, deleteBtnClass);
        },

        getBtnGroupWithIndex: function (index, editBtnClass, deleteBtnClass) {
            return generateEditDeleteBtnGroup(index, editBtnClass, index, deleteBtnClass);
        },

        getEditDeleteBtnFromList: function (index, moduleObj) {
            return getEditDeleteBtnFromList(index, moduleObj);
        },

        getBtnDelete: function (mappingPrefix, id) {
            return getBtnDelete(mappingPrefix, id);
        },

        getNotificationInbox: function (mappingPrefix, id) {
            return getNotificationInbox(mappingPrefix, id);
        },

        getNotificationPreview: function (id) {
            return getNotificationPreview(id);
        },

        getBtnUndoNotification: function (id) {
            return getBtnUndoNotification(id);
        },

        getCmmsLookupTableBtnWithURL: function (mappingPrefix, id) {
            return getCmmsLookupTableBtnWithURL(mappingPrefix, id);
        },

        getCommonBtnSelect : function (mappingPrefix, id,name){
        	return getCommonBtnSelect(mappingPrefix, id,name)
        },

        getCommonBtnSelectWithMultipleVars: function (mappingPrefix, id, vars) {
            return getCommonBtnSelectWithMultipleVars(mappingPrefix, id, vars)
        },

        getCommonBtnEdit :function (mappingPrefix, id){
        	return getCommonBtnEdit(mappingPrefix, id);
        },

        getCommonBtnDelete: function (mappingPrefix, id) {
        	return getCommonBtnDelete(mappingPrefix, id);
        },
        
        getCommonBtnView: function (mappingPrefix, id) {
        	return getCommonBtnView(mappingPrefix, id);
        },
        
        getCommonBtnViewWithMultipleVars: function (mappingPrefix, id, vars) {
            return getCommonBtnView(mappingPrefix, id, vars);
        },

        getCmmsBtnWithFuncs: function (editFunc, removeFunc, id) {
            return getCmmsBtnWithFuncs(editFunc, removeFunc, id);
        }

    };
}();

