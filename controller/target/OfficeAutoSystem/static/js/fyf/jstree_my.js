<!--jsTree start-->
$(document).ready(function(){
    var userRootFolderId = $('#userRootFolderId').attr('value');
    $('#using_json')
        .jstree({
            'core': {
                'data': {
                    'url': '/file/getMyData',
                    'data': function (node) {
                        return {
                            'folderId': node.id === '#' ? userRootFolderId : node.id
                        };
                    }
                },
                'force_text': true,
                'check_callback': true,
                'themes': {
                    'responsive': false
                }
            },
            'plugins': ['state', 'types','dnd', 'contextmenu', 'wholerow'],
            'contextmenu': {
                'items': function (node) {
                    var items = {
                        'createItem': {
                            'label': '创建文件夹',
                            'action': function (node) {
                                createItemAction(node);
                            }
                        },
                        'deleteItem': {
                            'label': '删除',
                            'action': function (node) {
                                deleteItemAction(node);
                            }
                        },
                        'renameItem': {
                            'label': '重命名',
                            'action': function(node) {
                                renameItemAction(node);
                            }
                        },
                        'downloadItem': {
                            'label': '下载',
                            'action': function (node) {
                                downloadItemAction(node);
                            }
                        }
                    };

                    if(node.type === 'folder' && node.children.length != 0) {
                        delete items.deleteItem;
                    } else if(node.type === 'folder' && node.children.length == 0) {
                        return items;
                    } else {
                        delete items.createItem;
                    }
                    return items;
                }
            },
            'types' : {
                'default' : {
                    'icon' : 'fas fa-file'
                },
                'folder' : {
                    'icon' : 'fa fa-folder'
                },
                'html' : {
                    'icon' : 'fa fa-file-code-o'
                },
                'svg' : {
                    'icon' : 'fa fa-file-picture-o'
                },
                'css' : {
                    'icon' : 'fa fa-file-code-o'
                },
                'img' : {
                    'icon' : 'far fa-file-image'
                },
                'png' : {
                    'icon' : 'far fa-file-image'
                },
                'jpeg' : {
                    'icon' : 'far fa-file-image'
                },
                'jpg' : {
                    'icon' : 'far fa-file-image'
                },
                'js' : {
                    'icon' : 'fa fa-file-text-o'
                },
                'xls': {
                    'icon' : 'far fa-file-excel'
                },
                'docx': {
                    'icon' : 'fas fa-file-word'
                },
                'ppt' : {
                    'icon': 'fas fa-file-powerpoint'
                },
                'pptx' : {
                    'icon': 'fas fa-file-powerpoint'
                },
                'zip': {
                    'icon' : 'fa fa-archive'
                },
                'pdf': {
                    'icon' : 'fa fa-file-pdf'
                },
                'md' : {
                    'icon' : 'fas fa-file-code'
                }

            }
        });



    // $(document).on('dnd_move.vakata.jstree',function (e,data) {
    //     console.log("scroll");
    // });
    //
    // $(document).on('dnd_stop.vakata.jstree',function (e,data) {
    //     console.log(data);
    // });

    function createItemAction (node) {
        var tree = getTreeRef();
        var selectedNode = tree.get_selected();
        if(!selectedNode.length) { return false; }
        selectedNode = selectedNode[0];

        var folder = {
            id: null,
            name: "新建文件夹",
            text: "新建文件夹",
            preFolderId: selectedNode
        };

        $.ajax({
            type: 'POST',
            url: '/file/addPrivateFolder',
            data: folder,
            success: function(resp) {
                JSON.stringify(resp);
                folder.id = resp.id;
                folder.type = "folder";
                var newNode = tree.create_node(selectedNode, folder);
                console.log(newNode);
            }
        });

    }

    function renameItemAction(node) {
        var tree = getTreeRef();
        var selectedNode = tree.get_selected();
        if(!selectedNode.length) { return false; }
        selectedNode = selectedNode[0];

        //判断是文件还是文件夹
        var treeNode = tree.get_node(selectedNode);
        if(treeNode.type === 'folder') {
            tree.edit(selectedNode,'',function(node,status) {
                if(status) {
                    $.ajax({
                        type: 'GET',
                        url: '/file/renamefolder',
                        data: {
                            id: treeNode.id,
                            name: node.text
                        },
                        success: function(resp) {
                            JSON.stringify(resp);
                            if(!resp.isSuccess) {
                                alert(resp.message);
                            }
                        }
                    });
                }
            });
        } else {
            tree.edit(selectedNode,'',function(node,status) {
                if(status) {
                    $.ajax({
                        type: 'GET',
                        url: '/file/renamefile',
                        data: {
                            id: treeNode.id,
                            name: node.text
                        },
                        success: function(resp) {
                            JSON.stringify(resp);
                            if(!resp.isSuccess) {
                                alert(resp.message);
                            }
                        }
                    });
                }
            });
        }


    }

    function deleteItemAction(node) {
        var tree = getTreeRef();
        var selectedNodes = tree.get_selected();
        if(!selectedNodes.length) { return false; }

        if($.isArray(selectedNodes)) {
            for(var i = 0;i < selectedNodes.length;i++) {
                var treeNode = tree.get_node(selectedNodes[i]);
                //判断是文件还是文件夹
                if(treeNode.type === 'folder' && treeNode.children.length == 0) {
                    $.ajax({
                        type: 'GET',
                        url: '/file/deletefolder',
                        data: {
                            id: treeNode.id
                        },
                        success: function(resp) {
                            JSON.stringify(resp);
                            if(!resp.isSuccess) {
                                alert(resp.message);
                            } else {
                                tree.delete_node(tree.get_node(resp.id));
                            }
                        }
                    });
                } else {
                    $.ajax({
                        type: 'GET',
                        url: '/file/deletefile',
                        data: {
                            id: treeNode.id
                        },
                        success: function(resp) {
                            JSON.stringify(resp);
                            if(!resp.isSuccess) {
                                alert(resp.message);
                            } else {
                                tree.delete_node(tree.get_node(resp.id));
                            }
                        }
                    });
                }
            }
        }

    }

    function downloadItemAction(node) {
        var tree = getTreeRef();
        var selectedNodes = tree.get_selected();
        if(!selectedNodes.length) { return false; }

        var treeNode = tree.get_node(selectedNodes[0]);
        window.open(treeNode.original.foreignChain,'_blank')
    }

    function getTreeRef() {
        return $('#using_json').jstree(true);
    }

});
