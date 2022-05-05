package com.inbox.app.service;

import com.inbox.app.folders.Folder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class FolderService {
    public List<Folder> fetchDefaultFolder(String userId){
        return Arrays.asList(new Folder(userId,"Inbox","white"),
                new Folder(userId,"Sent Items","green"),
                new Folder(userId,"Important","red")
                );
    }
}
