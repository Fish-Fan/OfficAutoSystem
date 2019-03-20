package com.fanyank.serviceImpl;

import com.fanyank.mapper.FileMapper;
import com.fanyank.mapper.FolderMapper;
import com.fanyank.pojo.File;
import com.fanyank.pojo.Folder;
import com.fanyank.service.FileSystemService;
import com.fanyank.serviceImpl.processor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileSystemServiceImpl implements FileSystemService {
    @Autowired
    private FolderMapper folderMapper;
    @Autowired
    private FileMapper fileMapper;

    @Override
    public Folder getRootFolder() {
        return folderMapper.getRootFolder();
    }

    @Override
    public Folder getUserRootFolder(Integer userId) {
        return folderMapper.getUserRootFolder(userId);
    }

    @Override
    public Folder getFolderById(Integer folderId) {
        return folderMapper.selectByPrimaryKey(folderId);
    }

    @Override
    public void addFolder(Folder folder) {
        folderMapper.insert(folder);
    }

    @Override
    public void addFile(File file) {
        fileMapper.insert(file);
    }

    @Override
    public void deleteFolder(Folder folder) {
        folderMapper.deleteByPrimaryKey(folder.getId());
    }

    @Override
    public void deleteFile(File file) {
        fileMapper.deleteByPrimaryKey(file.getId());
    }

    @Override
    public String operateTreeNode(String operation, Integer targetId) {
        TreeNodeProcessor processor = getTreeNodeProcessor(operation);
        return processor.processorNode(targetId);
    }

    public TreeNodeProcessor getTreeNodeProcessor(String operation) {
        switch (operation) {
            case "get_node":
                return new GetDataTreeNodeProcessor();
            case "delete_node":
                return new DeleteTreeNodeProcessor();
            case "create_node":
                return new CreateTreeNodeProcessor();
            case "rename_node":
                return new RenameTreeNodeProcessor();
            case "move_node":
                return new MoveTreeNodeProcessor();
            case "copy_node":
                return new CopyTreeNodeProcessor();
            default:
                return new CopyTreeNodeProcessor();
        }
    }
}
