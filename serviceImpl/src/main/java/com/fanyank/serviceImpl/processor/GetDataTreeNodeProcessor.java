package com.fanyank.serviceImpl.processor;

import com.fanyank.dto.FileTreeNodeDto;
import com.fanyank.pojo.File;
import com.fanyank.pojo.Folder;
import com.fanyank.serviceImpl.FileSystemServiceImpl;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 获取节点数据
 */
@Component
public class GetDataTreeNodeProcessor implements TreeNodeProcessor {
    @Autowired
    private FileSystemServiceImpl fileSystemService;


    @Override
    public String processorNode(Integer targetId) {
        Folder folder = fileSystemService.getFolderById(targetId);
        List<File> fileList = folder.getFiles();
        List<Folder> folderList = folder.getFolders();

        List<FileTreeNodeDto> list = new ArrayList<>();
        for(File file : fileList) {
            FileTreeNodeDto node = new FileTreeNodeDto();
            node.setChildren(false);
            node.setId(file.getId()+10);
            node.setText(file.getName());
            list.add(node);
        }
        for(Folder folder1 : folderList) {
            FileTreeNodeDto node = new FileTreeNodeDto();
            node.setChildren(true);
            node.setId(folder1.getId());
            node.setText(folder1.getName());
            list.add(node);
        }
        Gson gson = new Gson();
        return gson.toJson(list);
    }
}
